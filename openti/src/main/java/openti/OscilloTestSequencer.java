package openti;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.core.util.Base64;

import jp.silverbullet.dependency2.ChangedItemValue;
import jp.silverbullet.dependency2.RequestRejectedException;
import jp.silverbullet.sequncer.SvHandlerModel;
import jp.silverbullet.sequncer.UserSequencer;
import openti.UserEasyAccess.EnumOscTestcontrol;
import openti.UserEasyAccess.EnumOtdrTestcontrol;
import openti.UserRegister.OSCILLO_TEST;
import openti.UserRegister.TEST_CONTROL;

public class OscilloTestSequencer implements UserSequencer {

	@Override
	public void handle(SvHandlerModel model, Map<String, List<ChangedItemValue>> changed)
			throws RequestRejectedException {
		UserEasyAccess properties = new UserEasyAccess(model.getEasyAccessInterface());
		UserRegister registers = new UserRegister(model.getRegisterAccessor());

		if (properties.getOscTestcontrol().compareTo(EnumOscTestcontrol.ID_OSC_TESTCONTROL_START) == 0) {			
			registers.oscillo_test.set(OSCILLO_TEST.TEST, 0x01).write();
			registers.waitInterrupt();
			
			String base64 = new String(Base64.encode(registers.eyediagram.read()));
			model.getEasyAccessInterface().requestChange(ID.ID_OSC_EYEDIAGRAM, base64);
		}
	}

	@Override
	public List<String> targetIds() {
		return Arrays.asList(ID.ID_OSC_TESTCONTROL);
	}

}
