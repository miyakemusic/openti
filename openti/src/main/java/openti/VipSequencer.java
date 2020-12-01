package openti;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.apache.commons.codec.binary.Base64;
import jp.silverbullet.core.dependency2.ChangedItemValue;
import jp.silverbullet.core.dependency2.Id;
import jp.silverbullet.core.dependency2.RequestRejectedException;
import jp.silverbullet.core.property2.ImageProperty;
import jp.silverbullet.core.sequncer.SvHandlerModel;
import jp.silverbullet.core.sequncer.UserSequencer;
import openti.SilverbulletUserEasyAccess.EnumVipcontrol;

public class VipSequencer implements UserSequencer {
	private SvHandlerModel model;
	
	private VipSimulator vipSim = new VipSimulator() {

		@Override
		protected void onUpdate(byte[] bytes) {
			String base64 = Base64.encodeBase64String(bytes);
			try {
//				model.getEasyAccessInterface().requestChange(ID.ID_VIPIMAGE, "data:image/png;base64," + base64, String.valueOf(System.currentTimeMillis()));
				model.getEasyAccessInterface().requestChange(ID.ID_VIPIMAGE, new ImageProperty(bytes), String.valueOf(System.currentTimeMillis()));
			} catch (RequestRejectedException e) {
				e.printStackTrace();
			}
		}

		@Override
		protected void onComplete() {
			try {
				model.getEasyAccessInterface().requestChange(ID.ID_VIPCONTROL, ID.ID_VIPCONTROL_STOP);
				if (Math.random() < 0.5) {
					model.getEasyAccessInterface().requestChange(ID.ID_VIPSTATUS, ID.ID_VIPSTATUS_PASS);
				}
				else {
					model.getEasyAccessInterface().requestChange(ID.ID_VIPSTATUS, ID.ID_VIPSTATUS_FAIL);
				}
			} catch (RequestRejectedException e) {
				e.printStackTrace();
			}	
		}

		@Override
		protected void onStart() {
			try {
				model.getEasyAccessInterface().requestChange(ID.ID_VIPSTATUS, ID.ID_VIPSTATUS_TESTING);
			} catch (RequestRejectedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	};
	
	
	@Override
	public void handle(SvHandlerModel model, Map<String, List<ChangedItemValue>> changed, Id sourceId)
			throws RequestRejectedException {

		this.model = model;
		SilverbulletUserEasyAccess properties = new SilverbulletUserEasyAccess(model.getEasyAccessInterface());
		SilverbulletUserRegister registers = new SilverbulletUserRegister(model.getRegisterAccessor());
		
		if (properties.getVipcontrol().compareTo(EnumVipcontrol.ID_VIPCONTROL_START) == 0) {
			vipSim.start();
		}
		else if (properties.getVipcontrol().compareTo(EnumVipcontrol.ID_VIPCONTROL_STOP) == 0) {
			vipSim.stop();
		}
	}

	@Override
	public List<String> targetIds() {
		return Arrays.asList(ID.ID_VIPCONTROL);
	}


}
