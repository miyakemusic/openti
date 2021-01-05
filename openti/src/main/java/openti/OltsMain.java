package openti;

import java.util.List;
import java.util.Map;

import jp.silverbullet.core.dependency2.ChangedItemValue;
import jp.silverbullet.core.dependency2.Id;
import jp.silverbullet.core.dependency2.RequestRejectedException;
import jp.silverbullet.core.register2.RegisterAccessor;
import jp.silverbullet.core.sequncer.SvHandlerModel;
import jp.silverbullet.core.sequncer.Utils;
import jp.silverbullet.dev.MessageObject;

public class OltsMain extends AbstractIndependentMain {
	public static void main(String[] args) {
		new OltsMain(args[0], args[1], args[2], "password", args[3], args[4], args[5].equals("true"));
	}
	
	
	private Olts olts = new Olts() {

		@Override
		protected void onUpdate(String value) {
			try {
				getModel().getEasyAccessInterface().requestChange(new Id(ID.ID_PM_POWER), value);
			} catch (RequestRejectedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	};
	
	
	public OltsMain(String host, String port, String userid, String password, String application, String deviceName, boolean headless) {
		super(host, port, userid, password, application, deviceName, headless);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void handle(Map<String, List<ChangedItemValue>> changed) throws RequestRejectedException {
		if (Utils.compareValue(changed, ID.ID_LS_ENABLED, ID.ID_LS_ENABLED_ON)) {
			olts.start();
		}
		else if (Utils.compareValue(changed, ID.ID_LS_ENABLED, ID.ID_LS_ENABLED_OFF)) {
			olts.stop();
		}
	}

	@Override
	protected List<String> getTargetIds() {
		return olts.targetIds();
	}

	@Override
	protected RegisterAccessor getRegisterAccessor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void init(SvHandlerModel model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onMessage(MessageObject obj) {
		// TODO Auto-generated method stub
		
	}

}
