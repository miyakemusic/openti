package openti;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.silverbullet.core.dependency2.ChangedItemValue;
import jp.silverbullet.core.dependency2.RequestRejectedException;
import jp.silverbullet.core.register2.RegisterAccessor;
import jp.silverbullet.core.sequncer.SvHandlerModel;
import openti.test.SimHardware;

public class OtdrOscillo extends AbstractIndependentMain {
	private Otdr otdr = new Otdr();
	private Oscillo oscillo = new Oscillo();
	private UserEasyAccess properties;
	private UserRegister registers;
	
	public OtdrOscillo(String host, String port, String deviceName) {
		super(host, port, "miyake_otdr", deviceName);
	}

	public static void main(String[] args) {
		try {
			new OtdrOscillo(args[0],args[1], args[2]);
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
		properties = new UserEasyAccess(model.getEasyAccessInterface());
		registers = new UserRegister(model.getRegisterAccessor());	
	}

}
