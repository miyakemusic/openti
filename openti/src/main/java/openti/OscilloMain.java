package openti;

import java.util.List;
import java.util.Map;

import jp.silverbullet.core.dependency2.ChangedItemValue;
import jp.silverbullet.core.dependency2.RequestRejectedException;
import jp.silverbullet.core.register2.RegisterAccessor;
import jp.silverbullet.core.sequncer.SvHandlerModel;
import openti.test.SimHardware;

public class OscilloMain extends AbstractIndependentMain {
	private UserEasyAccess properties;
	private UserRegister registers;
	private Oscillo oscillo = new Oscillo();
	
	public OscilloMain(String host, String port, String username, String application, String deviceName, boolean headless) {
		super(host, port, username, application, deviceName, headless);
	}

	public static void main(String[] args) {
		try {
			new OscilloMain(args[0],args[1], args[2], args[3], args[4], args[5].equals("true"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected List<String> getTargetIds() {
		return oscillo.getIds();
	}

	@Override
	protected RegisterAccessor getRegisterAccessor() {
		return new SimHardware();
	}
	
	@Override
	protected void init(SvHandlerModel model) {
		properties = new UserEasyAccess(model.getEasyAccessInterface());
		registers = new UserRegister(model.getRegisterAccessor());		
	}
	
	@Override
	protected void handle(Map<String, List<ChangedItemValue>> changed)
			throws RequestRejectedException {

		oscillo.doOscillo(changed, properties, registers, getModel());
	}

}