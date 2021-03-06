package openti;

import java.util.Arrays;
import java.util.Base64;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import jp.silverbullet.core.dependency2.ChangedItemValue;
import jp.silverbullet.core.dependency2.DependencySpec;
import jp.silverbullet.core.dependency2.Id;
import jp.silverbullet.core.dependency2.RequestRejectedException;
import jp.silverbullet.core.property2.RuntimeProperty;
import jp.silverbullet.core.sequncer.SvHandlerModel;
import jp.silverbullet.core.sequncer.Utils;
import openti.SilverbulletUserEasyAccess.EnumOscTestcontrol;
import openti.SilverbulletUserRegister.OSCILLO_TEST;

public class Oscillo {

	private boolean stop;
	public void doOscillo(Map<String, List<ChangedItemValue>> changed, SilverbulletUserEasyAccess properties, SilverbulletUserRegister registers,
			SvHandlerModel model) {
		
		if (Utils.compareValue(changed, ID.ID_OSC_TESTCONTROL, ID.ID_OSC_TESTCONTROL_START)) {
//		if (properties.getOscTestcontrol().compareTo(EnumOscTestcontrol.ID_OSC_TESTCONTROL_START) == 0) {	
			registers.oscillo_test.set(OSCILLO_TEST.TRGPOS, properties.getOscTrigger().intValue()).write();
			registers.oscillo_test.set(OSCILLO_TEST.TEST, 0x01).write();
			registers.waitInterrupt();
			
			new Thread() {
				@Override
				public void run() {
					stop = false;
					while (!stop) {
						System.currentTimeMillis();
						try {					  
							byte[] bytes = registers.eyediagram.read();
							byte[] b = Base64.getEncoder().encode(bytes);
							String base64 = "data:image/png;base64," + new String(b);
							
							try {
								model.getEasyAccessInterface().requestChange(new Id(ID.ID_OSC_EYEDIAGRAM), base64,String.valueOf(Calendar.getInstance().getTime().getTime()));
							} catch (RequestRejectedException e) {
								e.printStackTrace();
							}				
							
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						} 
					}
				}
			}.start();
			
		}
		else if (Utils.compareValue(changed, ID.ID_OSC_TESTCONTROL, ID.ID_OSC_TESTCONTROL_STOP)) {
//		else if (properties.getOscTestcontrol().compareTo(EnumOscTestcontrol.ID_OSC_TESTCONTROL_STOP) == 0) {	
			registers.oscillo_test.set(OSCILLO_TEST.TEST, 0x00).write();
			stop = true;
		}
	}
	public List<String> getIds() {
		return Arrays.asList(ID.ID_OSC_TESTCONTROL, ID.ID_OSC_TRIGGER);
	}

}
