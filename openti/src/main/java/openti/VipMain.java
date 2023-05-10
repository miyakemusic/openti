package openti;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;

import jp.silverbullet.core.dependency2.ChangedItemValue;
import jp.silverbullet.core.dependency2.RequestRejectedException;
import jp.silverbullet.core.register2.RegisterAccessor;
import jp.silverbullet.core.sequncer.SvHandlerModel;
import jp.silverbullet.core.sequncer.Utils;
import jp.silverbullet.dev.MessageObject;

public class VipMain extends AbstractIndependentMain {
	public static void main(String[] args) {
//		try {
//			new VipMain(args[0],args[1], args[2], args[3], args[4], args[5].equals("true"));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
	
	private VipSimulator vipSim = new VipSimulator() {
		@Override
		protected void onUpdate(byte[] bytes) {
			String base64 = "data:image/png;base64," + Base64.encodeBase64String(bytes);
			
			try {
				getModel().getEasyAccessInterface().requestChange(ID.ID_VIPIMAGE, base64, String.valueOf(Calendar.getInstance().getTime().getTime()));
			} catch (RequestRejectedException e) {
				e.printStackTrace();
			}	

		}

		@Override
		protected void onComplete() {
			try {
				getModel().getEasyAccessInterface().requestChange(ID.ID_VIPCONTROL, ID.ID_VIPCONTROL_STOP);
				if (Math.random() < 0.5) {
					getModel().getEasyAccessInterface().requestChange(ID.ID_VIPSTATUS, ID.ID_VIPSTATUS_PASS);
				}
				else {
					getModel().getEasyAccessInterface().requestChange(ID.ID_VIPSTATUS, ID.ID_VIPSTATUS_FAIL);
				}
			} catch (RequestRejectedException e) {
				e.printStackTrace();
			}				
		}

		@Override
		protected void onStart() {
			try {
				getModel().getEasyAccessInterface().requestChange(ID.ID_VIPSTATUS, ID.ID_VIPSTATUS_TESTING);
			} catch (RequestRejectedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	};
	
	public VipMain(String protocol, String host, String port, String userid, String application, String deviceName, boolean headless) {
		super(protocol, host, port, userid, "password" ,application, deviceName, "", headless);
	}

	@Override
	protected void handle(Map<String, List<ChangedItemValue>> changed) throws RequestRejectedException {
		if (Utils.compareValue(changed, ID.ID_VIPCONTROL, ID.ID_VIPCONTROL_START)) {
			vipSim.start();
		}
		else if (Utils.compareValue(changed, ID.ID_VIPCONTROL, ID.ID_VIPCONTROL_STOP)) {
			vipSim.stop();
		}
	}

	@Override
	protected List<String> getTargetIds() {
		return Arrays.asList(ID.ID_VIPCONTROL);
	}

	@Override
	protected RegisterAccessor getRegisterAccessor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void init(SvHandlerModel model) {
		
	}

	@Override
	protected void onMessage(MessageObject message2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onCloseMessage(String messageId) {
		// TODO Auto-generated method stub
		
	}

}
