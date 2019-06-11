package openti;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import jp.silverbullet.dependency2.ChangedItemValue;
import jp.silverbullet.dependency2.RequestRejectedException;
import jp.silverbullet.sequncer.SvHandlerModel;
import jp.silverbullet.sequncer.UserSequencer;
import openti.UserEasyAccess.EnumLogin;

public class SystemManager implements UserSequencer {

	@Override
	public void handle(SvHandlerModel model, Map<String, List<ChangedItemValue>> changed)
			throws RequestRejectedException {

		UserEasyAccess properties = new UserEasyAccess(model.getEasyAccessInterface());
		UserRegister registers = new UserRegister(model.getRegisterAccessor());

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

	@Override
	public boolean isAsync() {
		// TODO Auto-generated method stub
		return false;
	}

}