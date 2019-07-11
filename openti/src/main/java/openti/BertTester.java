package openti;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import jp.silverbullet.dependency2.ChangedItemValue;
import jp.silverbullet.dependency2.DependencySpec;
import jp.silverbullet.dependency2.Id;
import jp.silverbullet.dependency2.RequestRejectedException;
import jp.silverbullet.sequncer.SvHandlerModel;
import jp.silverbullet.sequncer.UserSequencer;
import openti.UserEasyAccess.EnumBertsState;
import openti.UserRegister.ED;
import openti.UserRegister.PPG;

public class BertTester implements UserSequencer {

	private boolean stopRequest = false;
	private boolean running = false;
	@Override
	public void handle(SvHandlerModel model, Map<String, List<ChangedItemValue>> changed)
			throws RequestRejectedException {
		
		new ActionManager(model, changed) {
			@Override
			protected void handle(Id id, List<ChangedItemValue> list, UserEasyAccess properties) {
				if (id.getId().equals(ID.ID_START_ACTION) && list.get(0).getElement().equals(DependencySpec.Value)) {
					if (running) {
						waitStop();
					}
					try {
						startTest(model);
					} catch (RequestRejectedException e) {
						e.printStackTrace();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				else if (id.getId().equals(ID.ID_STOP_ACTION)) {
					stopRequest = true;
				}
			}

		};
		
	}

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

	private void startTest(SvHandlerModel model) throws RequestRejectedException, InterruptedException {
		UserEasyAccess properties = new UserEasyAccess(model.getEasyAccessInterface());
		UserRegister registers = new UserRegister(model.getRegisterAccessor());
		stopRequest = false;
		running = true;
		
		try {
			properties.setBertsState(EnumBertsState.ID_BERTS_STATE_PREPARE_TEST);
			registers.ppg.set(PPG.START_STOP, 1).write();
			registers.ed.set(ED.START_STOP, 1).write();
			
			sleep();
			properties.setBertsState(EnumBertsState.ID_BERTS_STATE_TESING);
			
			sleep();
			registers.ppg.set(PPG.START_STOP, 0).write();
			registers.ed.set(ED.START_STOP, 0).write();			
			properties.setBertsState(EnumBertsState.ID_BERTS_STATE_ANALYZING);
			
			sleep();
			
			properties.setBertsState(EnumBertsState.ID_BERTS_STATE_SAVING_FILE);
		
			sleep();
		} catch (Exception e) {

		}
		finally {
			Thread.sleep(1000);
			properties.setBertsState(EnumBertsState.ID_BERTS_STATE_IDLE);	
			running = false;
			synchronized(sync) {
				sync.notify();
			}
		}

	}

	private void sleep() throws InterruptedException, Exception {
		Thread.sleep(1000);
		if (stopRequest) {
			throw new Exception();
		}
	}
	
	@Override
	public List<String> targetIds() {
		return Arrays.asList(ID.ID_START_ACTION, ID.ID_STOP_ACTION);
	}

	@Override
	public boolean isAsync() {
		return true;
	}

}
