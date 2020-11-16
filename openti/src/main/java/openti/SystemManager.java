package openti;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import jp.silverbullet.core.dependency2.ChangedItemValue;
import jp.silverbullet.core.dependency2.Id;
import jp.silverbullet.core.dependency2.RequestRejectedException;
import jp.silverbullet.core.sequncer.SvHandlerModel;
import jp.silverbullet.core.sequncer.UserSequencer;
import openti.SilverbulletUserEasyAccess.EnumLogin;

public class SystemManager implements UserSequencer {

	@Override
	public void handle(SvHandlerModel model, Map<String, List<ChangedItemValue>> changed, Id sourceId)
			throws RequestRejectedException {

		SilverbulletUserEasyAccess properties = new SilverbulletUserEasyAccess(model.getEasyAccessInterface());
		SilverbulletUserRegister registers = new SilverbulletUserRegister(model.getRegisterAccessor());

		if (properties.getLogin().compareTo(EnumLogin.ID_LOGIN_LOGIN) == 0) {
			if (properties.getUsername().equals("miyakemusic")) {
				if (properties.getPassword().equals("marijuana")) {
					properties.setLoginMessage("Hello " + properties.getUsername() + ":Logged In");
					
					return;
				}
			}
			
			properties.setLogin(EnumLogin.ID_LOGIN_LOGOUT);
			properties.setLoginMessage("Login failed!!!");
		}
		
	}

	@Override
	public List<String> targetIds() {
		return Arrays.asList(ID.ID_LOGIN);
	}

}
