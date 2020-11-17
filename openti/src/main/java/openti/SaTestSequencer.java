package openti;

import java.util.List;
import java.util.Map;

import jp.silverbullet.core.dependency2.ChangedItemValue;
import jp.silverbullet.core.dependency2.Id;
import jp.silverbullet.core.dependency2.RequestRejectedException;
import jp.silverbullet.core.sequncer.SvHandlerModel;
import jp.silverbullet.core.sequncer.UserSequencer;
import openti.AnotherUserEasyAccess.EnumStart;

public class SaTestSequencer implements UserSequencer {

	private boolean stop = false;
	
	@Override
	public void handle(SvHandlerModel model, Map<String, List<ChangedItemValue>> changed, Id sourceId)
			throws RequestRejectedException {
		
		AnotherUserEasyAccess properties = new AnotherUserEasyAccess(model.getEasyAccessInterface());
		AnotherUserRegister registers = new AnotherUserRegister(model.getRegisterAccessor());
		
		if (properties.getStart().equals(EnumStart.ID_START_START)) {
			stop = false;
			new Thread() {
				@Override
				public void run() {
					while(!stop) {
						
						try {
							properties.setResult((long)(Math.random()*100));
							Thread.sleep(500);
						} catch (InterruptedException | RequestRejectedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}.start();
		}
		else if (properties.getStart().equals(EnumStart.ID_START_STOP)) {
			stop = true;
		}
	}

	@Override
	public List<String> targetIds() {
		// TODO Auto-generated method stub
		return null;
	}

}
