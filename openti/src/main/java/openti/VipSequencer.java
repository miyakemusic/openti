package openti;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import org.apache.commons.codec.binary.Base64;

import jp.silverbullet.core.SbDateTime;
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
//			String base64 = Base64.encodeBase64String(bytes);
			try {
//				model.getEasyAccessInterface().requestChange(Silverbullet.ID_VIPIMAGE, "data:image/png;base64," + base64, String.valueOf(System.currentTimeMillis()));
				model.getEasyAccessInterface().requestChange(SilverbulletID.ID_VIPIMAGE, new ImageProperty(bytes), String.valueOf(System.currentTimeMillis()));
			} catch (RequestRejectedException e) {
				e.printStackTrace();
			}
		}

		@Override
		protected void onComplete() {
			try {
				model.getEasyAccessInterface().requestChange(SilverbulletID.ID_VIPCONTROL, SilverbulletID.ID_VIPCONTROL_STOP);
				if (Math.random() < 0.5) {
					model.getEasyAccessInterface().requestChange(SilverbulletID.ID_VIPSTATUS, SilverbulletID.ID_VIPSTATUS_PASS);
				}
				else {
					model.getEasyAccessInterface().requestChange(SilverbulletID.ID_VIPSTATUS, SilverbulletID.ID_VIPSTATUS_FAIL);
				}
			} catch (RequestRejectedException e) {
				e.printStackTrace();
			}	
		}

		@Override
		protected void onStart() {
			try {
				model.getEasyAccessInterface().requestChange(SilverbulletID.ID_VIPSTATUS, SilverbulletID.ID_VIPSTATUS_TESTING);
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
		properties.setTestTime(new SbDateTime().string());
		if (properties.getVipcontrol().compareTo(EnumVipcontrol.ID_VIPCONTROL_START) == 0) {
			vipSim.start();
		}
		else if (properties.getVipcontrol().compareTo(EnumVipcontrol.ID_VIPCONTROL_STOP) == 0) {
			vipSim.stop();
		}
	}

	@Override
	public List<String> targetIds() {
		return Arrays.asList(SilverbulletID.ID_VIPCONTROL);
	}


}
