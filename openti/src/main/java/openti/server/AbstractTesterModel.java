package openti.server;

import java.util.HashSet;
import java.util.Set;

import openti.ValueChangeListener;

public abstract class AbstractTesterModel implements StandaloneTesterModel {
	protected Set<ValueChangeListener> listeners = new HashSet<>();
	@Override
	public void addValueChangeListener(ValueChangeListener valueChangeListener) {
		this.listeners.add(valueChangeListener);
	}

	@Override
	public void removeValueChangeListener(ValueChangeListener listener) {
		this.listeners.remove(listener);
	}
}
