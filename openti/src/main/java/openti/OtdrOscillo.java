package openti;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.silverbullet.core.dependency2.ChangedItemValue;
import jp.silverbullet.core.dependency2.RequestRejectedException;
import jp.silverbullet.core.register2.RegisterAccessor;
import jp.silverbullet.core.sequncer.SvHandlerModel;
import jp.silverbullet.dev.MessageObject;
import openti.test.SimHardware;

public class OtdrOscillo extends AbstractIndependentMain {
	private Otdr otdr = new Otdr();
	private Oscillo oscillo = new Oscillo();
	private SilverbulletUserEasyAccess properties;
	private SilverbulletUserRegister registers;
	
	public OtdrOscillo(String host, String port, String username, String application, String deviceName, boolean headless) {
		super(host, port, username, "password", application, deviceName, headless);
	}

	public static void main(String[] args) {
		try {
			new OtdrOscillo(args[0],args[1], args[2], args[3], args[4], args[5].equals("true"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void handle(Map<String, List<ChangedItemValue>> changed) throws RequestRejectedException {
		otdr.doOtdr(changed, properties, registers, getModel());
		oscillo.doOscillo(changed, properties, registers, getModel());
	}

	@Override
	protected List<String> getTargetIds() {
		List<String> ret = new ArrayList<>();
		ret.addAll(otdr.getIds());
		ret.addAll(oscillo.getIds());
		return ret;
	}

	@Override
	protected RegisterAccessor getRegisterAccessor() {
		return new SimHardware();
	}

	@Override
	protected void init(SvHandlerModel model) {
		properties = new SilverbulletUserEasyAccess(model.getEasyAccessInterface());
		registers = new SilverbulletUserRegister(model.getRegisterAccessor());	
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
