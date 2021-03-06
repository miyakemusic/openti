package openti;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import jp.silverbullet.core.SbDateTime;
import jp.silverbullet.core.dependency2.ChangedItemValue;
import jp.silverbullet.core.dependency2.Id;
import jp.silverbullet.core.dependency2.RequestRejectedException;
import jp.silverbullet.core.sequncer.SvHandlerModel;
import jp.silverbullet.core.sequncer.UserSequencer;
import openti.SilverbulletUserEasyAccess.EnumLsEnabled;
import openti.SilverbulletUserEasyAccess.EnumOltsPassfail;

public class OltsSequencer implements UserSequencer {
	private Olts olts = new Olts() {
		@Override
		protected void onUpdate(String value) {
			try {
				properties.setPmPower(value);
				properties.setOltsPassfail(EnumOltsPassfail.ID_OLTS_PASSFAIL_PASS);
			} catch (RequestRejectedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	};
	private SilverbulletUserEasyAccess properties;
	
	@Override
	public void handle(SvHandlerModel model, Map<String, List<ChangedItemValue>> changed, Id sourceId)
			throws RequestRejectedException {
		properties = new SilverbulletUserEasyAccess(model.getEasyAccessInterface());
		
		if (properties.getLsEnabled().equals(EnumLsEnabled.ID_LS_ENABLED_ON)) {
			properties.setTestTime(new SbDateTime().string());
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
