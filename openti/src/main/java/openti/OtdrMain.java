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

	public OtdrMain(String host, String port, String application, String deviceName) {
		super(host, port, application, deviceName);
		
	}

	public static void main(String[] args) {
		new OtdrMain(args[0], args[1], "miyake_otdr", args[2]);
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


