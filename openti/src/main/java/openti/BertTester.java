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

public class BertTester implements UserSequencer {

	@Override
	public void handle(SvHandlerModel model, Map<String, List<ChangedItemValue>> changed)
			throws RequestRejectedException {
		
		new ActionManager(model, changed) {
			@Override
			protected void handle(Id id, List<ChangedItemValue> list, UserEasyAccess properties) {
				if (id.getId().equals(ID.ID_START_ACTION) && list.get(0).getElement().equals(DependencySpec.Value)) {
					try {
						startTest(model);
					} catch (RequestRejectedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if (id.getId().equals(ID.ID_STOP_ACTION)) {
					
				}
			}

		};
		
	}

	private void startTest(SvHandlerModel model) throws RequestRejectedException, InterruptedException {
		UserEasyAccess properties = new UserEasyAccess(model.getEasyAccessInterface());
		
		properties.setBertsState(EnumBertsState.ID_BERTS_STATE_PREPARE_TEST);
		
		Thread.sleep(1000);
		
		properties.setBertsState(EnumBertsState.ID_BERTS_STATE_TESING);
		
		Thread.sleep(1000);
	
		properties.setBertsState(EnumBertsState.ID_BERTS_STATE_ANALYZING);
		
		Thread.sleep(1000);
		
		properties.setBertsState(EnumBertsState.ID_BERTS_STATE_SAVING_FILE);
		
		Thread.sleep(1000);
		properties.setBertsState(EnumBertsState.ID_BERTS_STATE_IDLE);
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
