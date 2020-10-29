package openti;


import java.util.List;
import java.util.Map;

import jp.silverbullet.core.dependency2.ChangedItemValue;
import jp.silverbullet.core.dependency2.RequestRejectedException;
import jp.silverbullet.core.sequncer.SvHandlerModel;
import jp.silverbullet.core.sequncer.UserSequencer;
import openti.UserEasyAccess.EnumLsEnabled;

public class OltsSequencer implements UserSequencer {
	private Olts olts = new Olts() {
		@Override
		protected void onUpdate(String value) {
			try {
				properties.setPmPower(value);
			} catch (RequestRejectedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	};
	private UserEasyAccess properties;
	
	@Override
	public void handle(SvHandlerModel model, Map<String, List<ChangedItemValue>> changed)
			throws RequestRejectedException {
		properties = new UserEasyAccess(model.getEasyAccessInterface());
		
		if (properties.getLsEnabled().equals(EnumLsEnabled.ID_LS_ENABLED_ON)) {
			olts.start();
		}
		else if (properties.getLsEnabled().equals(EnumLsEnabled.ID_LS_ENABLED_OFF)) {
			olts.stop();
		}
	}

	@Override
	public List<String> targetIds() {
		return olts.targetIds();
	}

}
