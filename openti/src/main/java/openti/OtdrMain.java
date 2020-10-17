package openti;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import jp.silverbullet.core.dependency2.ChangedItemValue;
import jp.silverbullet.core.dependency2.RequestRejectedException;
import jp.silverbullet.core.register2.RegisterAccessor;
import jp.silverbullet.core.sequncer.SvHandlerModel;
import openti.test.SimHardware;

public class OtdrMain extends AbstractIndependentMain {
	private Otdr otdr = new Otdr();

	public OtdrMain(String host, String port, String username, String application, String deviceName, boolean headless) {
		super(host, port, username, application, deviceName, headless);
	}

	public static void main(String[] args) {
		new OtdrMain(args[0], args[1], args[2], args[3], args[4], args[5].equals("true"));
	}
	
	private UserEasyAccess properties;
	private UserRegister registers;
	
	@Override
	protected List<String> getTargetIds() {
		return otdr.getIds();
	}

	@Override
	protected RegisterAccessor getRegisterAccessor() {
		return new SimHardware();
	}

	@Override
	protected void handle(Map<String, List<ChangedItemValue>> changed) throws RequestRejectedException {
		otdr.doOtdr(changed,properties, registers, getModel());		
	}



	@Override
	protected void init(SvHandlerModel model) {
		properties = new UserEasyAccess(model.getEasyAccessInterface());
		registers = new UserRegister(model.getRegisterAccessor());	
	}
}


