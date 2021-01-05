package openti.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.api.services.drive.model.File;

import jp.silverbullet.core.dependency2.ChangedItemValue;
import jp.silverbullet.core.dependency2.RequestRejectedException;
import jp.silverbullet.core.register2.RegisterAccessor;
import jp.silverbullet.core.sequncer.SvHandlerModel;
import jp.silverbullet.dev.MessageObject;
import openti.AbstractIndependentMain;

public class NullAbstractIndependentMain extends AbstractIndependentMain {

	public NullAbstractIndependentMain(String host, String port, String userid, String password, String application, String deviceName,
			boolean headless) {
		super(host, port, userid, password, application, deviceName, headless);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected List<File> getPendingFiles() {
		return new ArrayList<File>();
	}

	
	@Override
	public void changeValue(String id, String value) {
	}

	@Override
	public void changeBlob(String id, Object value, String name) {
	}

	@Override
	protected void handle(Map<String, List<ChangedItemValue>> changed) throws RequestRejectedException {
		// TODO Auto-generated method stub

	}

	@Override
	protected List<String> getTargetIds() {
		return new ArrayList<String>();
	}

	@Override
	protected RegisterAccessor getRegisterAccessor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void init(SvHandlerModel model) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initialize(String deviceName) {

	}

	@Override
	protected void onMessage(MessageObject message2) {
		// TODO Auto-generated method stub
		
	}

}
