package openti;

import java.util.Arrays;
import java.util.Base64;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import jp.silverbullet.core.dependency2.ChangedItemValue;
import jp.silverbullet.core.dependency2.RequestRejectedException;
import jp.silverbullet.core.register2.RegisterAccessor;
import jp.silverbullet.core.sequncer.SvHandlerModel;
import openti.UserEasyAccess.EnumOscTestcontrol;
import openti.UserRegister.OSCILLO_TEST;
import openti.test.SimHardware;

public class OscilloMain extends AbstractIndependentMain {

	public OscilloMain(String host, String port) {
		super(host, port);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		try {
			new OscilloMain(args[0],args[1]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private boolean stop;
	
	@Override
	protected List<String> getTargetIds() {
		return Arrays.asList(ID.ID_OSC_TESTCONTROL, ID.ID_OSC_TRIGGER);
	}

	@Override
	protected RegisterAccessor getRegisterAccessor() {
		return new SimHardware();
	}
	
	private int count = 0;
	private UserEasyAccess properties;
	private UserRegister registers;
	
	@Override
	protected void init(SvHandlerModel model) {
		properties = new UserEasyAccess(model.getEasyAccessInterface());
		registers = new UserRegister(model.getRegisterAccessor());		
	}
	
	@Override
	protected void handle(Map<String, List<ChangedItemValue>> changed)
			throws RequestRejectedException {

		if (properties.getOscTestcontrol().compareTo(EnumOscTestcontrol.ID_OSC_TESTCONTROL_START) == 0) {	
//			registers.oscillo_test.set(OSCILLO_TEST.TEST, 0x00).write();
			registers.oscillo_test.set(OSCILLO_TEST.TRGPOS, properties.getOscTrigger().intValue()).write();
			registers.oscillo_test.set(OSCILLO_TEST.TEST, 0x01).write();
			registers.waitInterrupt();
			
			new Thread() {

				@Override
				public void run() {
					stop = false;
					count = 0;
					while (!stop) {
						long startTim = System.currentTimeMillis();
						try {					  
							byte[] bytes = registers.eyediagram.read();
							//System.out.println("update " + String.valueOf(System.currentTimeMillis() - startTim));
							byte[] b = Base64.getEncoder().encode(bytes);
							String base64 = "data:image/png;base64," + new String(b);
							
							try {
								getModel().getEasyAccessInterface().requestChange(ID.ID_OSC_EYEDIAGRAM, base64,String.valueOf(Calendar.getInstance().getTime().getTime()));
								//model.getEasyAccessInterface().requestChange(ID.ID_OSC_EYEDIAGRAM, base64);
								//model.getEasyAccessInterface().requestChange(ID.ID_AVERAGE_RESULT, String.valueOf(count++));
							} catch (RequestRejectedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							
							Thread.sleep(100);
							//System.out.println("update " + String.valueOf(System.currentTimeMillis() - startTim));
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
					}
				}
				
			}.start();
			

		}
		else if (properties.getOscTestcontrol().compareTo(EnumOscTestcontrol.ID_OSC_TESTCONTROL_STOP) == 0) {	
			registers.oscillo_test.set(OSCILLO_TEST.TEST, 0x00).write();
			stop = true;
		}
	}

	@Override
	protected String getApplication() {
		return "miyake_otdr";
	}

}
