package openti.server;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import openti.ValueChangeListener;

public 	class SyncObject {
	private Map<String, String> map = new HashMap<>();
	private StandaloneTesterModel testerModel;
	private ValueChangeListener listener;
	
	public SyncObject(StandaloneTesterModel model) {
		this.testerModel = model;

		listener = new ValueChangeListener() {
			@Override
			public void onUpdate(String message) {
				Set<String> remove = new HashSet<>();
				for (String id : map.keySet()) {
					if (testerModel.getValue(id).equals(map.get(id))) {
						remove.add(id);							
					}
				}
				if (remove.size() > 0) {
					synchronized(SyncObject.this) {
						SyncObject.this.notify();
					}	
				}
				for (String id : remove) {
					map.remove(id);
				}
			}
		};
		
		testerModel.addValueChangeListener(listener);
	}
	public void register(String id, String value) {
		map.put(id, value);
	}
	public void terminate() {
		this.testerModel.removeValueChangeListener(listener);
	}

	
}