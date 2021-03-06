package openti;

import java.util.List;
import java.util.Map;

import jp.silverbullet.core.KeyValue;
import jp.silverbullet.core.dependency2.ChangedItemValue;
import jp.silverbullet.core.dependency2.DependencySpec;
import jp.silverbullet.core.dependency2.Id;
import jp.silverbullet.core.dependency2.RequestRejectedException;
import jp.silverbullet.core.sequncer.SvHandlerModel;
import jp.silverbullet.core.sequncer.UserSequencer;
import openti.SilverbulletUserRegister.ED;
import openti.SilverbulletUserRegister.PPG;

abstract class ChangeSelector {
	abstract void handle(Id id, String value);
	
	public ChangeSelector(SvHandlerModel model, Map<String, List<ChangedItemValue>> changed, List<String> targetIds) {
		for (String id : changed.keySet()) {
			List<ChangedItemValue> values = changed.get(id);
			Id id2 = new Id(id);
			if (targetIds.contains(id2.getId())) {
				for (ChangedItemValue v : values) {
					if (v.getElement().equals(DependencySpec.Value)) {
						handle(id2, v.getValue());
					}
				}
			}
		}
	}
}

public abstract class BertTester implements UserSequencer {

	private boolean stopRequest = false;
	private boolean running = false;
	
	@Override
	public void handle(SvHandlerModel model, Map<String, List<ChangedItemValue>> changed, Id sourceId)
			throws RequestRejectedException {
		
//		System.out.println("BertTester");
		new ChangeSelector(model, changed, this.targetIds()) {
			@Override
			void handle(Id id, String value) {
				for (KeyValue startCond : startIds()) {
					if (id.getId().equals(startCond.getKey()) && (value.equals(startCond.getValue())|| startCond.getValue().isEmpty())) {
						startTest(model);	
					}
				}
				for (KeyValue stopCond : stopIds()) {
					if (id.getId().equals(stopCond.getKey()) && (value.equals(stopCond.getValue())|| stopCond.getValue().isEmpty())) {
						stopRequest = true;
					}					
				}	
			}
		};		
	}
	
	abstract protected List<KeyValue> startIds();
	abstract protected List<KeyValue> stopIds();

	private Object sync = new Object();
	protected void waitStop() {
		this.stopRequest = true;
		synchronized(sync) {
			try {
				sync.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private Object startTrigger = new Object();
	private SilverbulletUserEasyAccess properties;
	private SilverbulletUserRegister registers;
	private boolean restart = false;
	
	public BertTester() {
		new Thread() {
			@Override
			public void run() {
				loop();
			} 
			
		}.start();
	}
	public void loop () {
		while (true) {
			if (restart) {
				restart = false;
			}
			else {
				waitStartTrigger();
			}
		
			stopRequest = false;
			running = true;
			
			try {
				//properties.setBertsState(EnumBertsState.ID_BERTS_STATE_PREPARE_TEST);
				onPreparing(properties);
				registers.ppg.set(PPG.START_STOP, 1).write();
				registers.ed.set(ED.START_STOP, 1).write();
				
				sleep();
				//properties.setBertsState(EnumBertsState.ID_BERTS_STATE_TESING);
				onTesting(properties);
				
				sleep();
				registers.ppg.set(PPG.START_STOP, 0).write();
				registers.ed.set(ED.START_STOP, 0).write();			
				//properties.setBertsState(EnumBertsState.ID_BERTS_STATE_ANALYZING);
				onAnalyzing(properties);
				
				sleep();
				
				//properties.setBertsState(EnumBertsState.ID_BERTS_STATE_SAVING_FILE);
				onSavingFile(properties);
			
				sleep();
			} catch (Exception e) {

			}
			finally {
				try {
					onIdle(properties);
				} catch (RequestRejectedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//properties.setBertsState(EnumBertsState.ID_BERTS_STATE_IDLE);	
				running = false;
				synchronized(sync) {
					sync.notify();
				}
			}		
		}
	}

	private void waitStartTrigger() {
		synchronized(startTrigger) {
			try {
				startTrigger.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void startTest(SvHandlerModel model) {
		if (properties == null) {
			properties = new SilverbulletUserEasyAccess(model.getEasyAccessInterface());
			registers = new SilverbulletUserRegister(model.getRegisterAccessor());
		}
		
		synchronized(startTrigger) {
			startTrigger.notify();
		}
		
		if (this.running) {
			this.stopRequest = true;
//			this.waitStop();
			restart = true;
		}
	}

	protected abstract void onIdle(SilverbulletUserEasyAccess properties) throws RequestRejectedException;

	protected abstract void onSavingFile(SilverbulletUserEasyAccess properties) throws RequestRejectedException;

	protected abstract void onAnalyzing(SilverbulletUserEasyAccess properties) throws RequestRejectedException;

	protected abstract void onTesting(SilverbulletUserEasyAccess properties) throws RequestRejectedException;

	protected abstract void onPreparing(SilverbulletUserEasyAccess properties) throws RequestRejectedException;

	private void sleep() throws InterruptedException, Exception {
		Thread.sleep(1000);
		if (stopRequest) {
			throw new Exception();
		}
	}
}
