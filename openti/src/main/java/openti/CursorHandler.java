package openti;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import jp.silverbullet.core.dependency2.ChangedItemValue;
import jp.silverbullet.core.dependency2.Id;
import jp.silverbullet.core.dependency2.RequestRejectedException;
import jp.silverbullet.core.sequncer.SvHandlerModel;
import jp.silverbullet.core.sequncer.UserSequencer;

public class CursorHandler implements UserSequencer {

	@Override
	public void handle(SvHandlerModel model, Map<String, List<ChangedItemValue>> changed, Id sourceId)
			throws RequestRejectedException {
		SilverbulletUserEasyAccess properties = new SilverbulletUserEasyAccess(model.getEasyAccessInterface());

		double step = 0.1;
		for (String id : changed.keySet()) {
			String id2 = id.split("#")[0];
			if (id2.equals(ID.ID_CURSOR_A_UP)) {
				properties.setCursorA(properties.getCursorA() + step);
			}
			else if (id2.equals(ID.ID_CURSOR_A_DOWN)) {
				properties.setCursorA(properties.getCursorA() - step);
			}
			else if (id2.equals(ID.ID_CURSOR_B_UP)) {
				properties.setCursorB(properties.getCursorB() + step);
			}
			else if (id2.equals(ID.ID_CURSOR_B_DOWN)) {
				properties.setCursorB(properties.getCursorB() - step);
			}
		}
	}

	@Override
	public List<String> targetIds() {
		return Arrays.asList(ID.ID_CURSOR_A_UP, ID.ID_CURSOR_A_DOWN, ID.ID_CURSOR_B_DOWN, ID.ID_CURSOR_B_UP);
	}

}
