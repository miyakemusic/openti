package openti;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.BiMap;
import com.sun.jersey.core.util.Base64;

import jp.silverbullet.dependency2.ChangedItemValue;
import jp.silverbullet.dependency2.RequestRejectedException;
import jp.silverbullet.sequncer.SvHandlerModel;
import jp.silverbullet.sequncer.UserSequencer;
import openti.UserEasyAccess.EnumOscTestcontrol;
import openti.UserEasyAccess.EnumOtdrTestcontrol;
import openti.UserRegister.OSCILLO_TEST;
import openti.UserRegister.TEST_CONTROL;
import openti.test.EyeImage;

public class OscilloTestSequencer implements UserSequencer {

	private boolean stop;

	@Override
	public void handle(SvHandlerModel model, Map<String, List<ChangedItemValue>> changed)
			throws RequestRejectedException {
		UserEasyAccess properties = new UserEasyAccess(model.getEasyAccessInterface());
		UserRegister registers = new UserRegister(model.getRegisterAccessor());

		if (properties.getOscTestcontrol().compareTo(EnumOscTestcontrol.ID_OSC_TESTCONTROL_START) == 0) {	
//			registers.oscillo_test.set(OSCILLO_TEST.TEST, 0x00).write();
			registers.oscillo_test.set(OSCILLO_TEST.TRGPOS, properties.getOscTrigger().intValue()).write();
			registers.oscillo_test.set(OSCILLO_TEST.TEST, 0x01).write();
			registers.waitInterrupt();
			
			new Thread() {

				@Override
				public void run() {
					stop = false;
					while (!stop) {
						try {					  
							byte[] b = Base64.encode(registers.eyediagram.read());
							String base64 = "data:image/png;base64," + new String(b);
							try {
								model.getEasyAccessInterface().requestChange(ID.ID_OSC_EYEDIAGRAM, base64);
							} catch (RequestRejectedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
					}
				}
				
			}.start();
			

		}
		else {
			registers.oscillo_test.set(OSCILLO_TEST.TEST, 0x00).write();
			stop = true;
		}
	}

	@Override
	public List<String> targetIds() {
		return Arrays.asList(ID.ID_OSC_TESTCONTROL, ID.ID_OSC_TRIGGER);
	}

}
