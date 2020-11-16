package openti;

import java.util.List;
import java.util.Map;

import jp.silverbullet.core.dependency2.ChangedItemValue;
import jp.silverbullet.core.dependency2.Id;
import jp.silverbullet.core.dependency2.RequestRejectedException;
import jp.silverbullet.core.sequncer.SvHandlerModel;
import jp.silverbullet.core.sequncer.UserSequencer;

public class SaTestSequencer implements UserSequencer {

	@Override
	public void handle(SvHandlerModel model, Map<String, List<ChangedItemValue>> changed, Id sourceId)
			throws RequestRejectedException {
		
		AnotherUserEasyAccess properties = new AnotherUserEasyAccess(model.getEasyAccessInterface());
		AnotherUserRegister registers = new AnotherUserRegister(model.getRegisterAccessor());
		
		
	}

	@Override
	public List<String> targetIds() {
		// TODO Auto-generated method stub
		return null;
	}

}
