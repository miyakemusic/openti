package openti;

import java.util.Arrays;
import java.util.List;

import jp.silverbullet.BuilderModelImpl;
import jp.silverbullet.SilverBulletServer;
import jp.silverbullet.register2.RegisterAccessor;
import jp.silverbullet.sequncer.UserSequencer;
import openti.test.SimBrokenHardware;
import openti.test.SimHardware;

public class Main extends SilverBulletServer {
	public static void main(String arg[]) {
		new Main().start(arg[0]);
	}
	@Override
	protected String getDefaultFilename() {
		return "ti_back.zip"; 
	}

	@Override
	protected void onStart(BuilderModelImpl model) {		
		new BackgroundThread(model).start();
	}
	@Override
	protected List<RegisterAccessor> getSimulators() {
		return Arrays.asList(new SimHardware(), new SimBrokenHardware());
	}
		
	@Override
	protected String getBaseFolderAndPackage() {
		return "src/main/java;openti";
	}
	@Override
	protected RegisterAccessor getHardwareAccessor(BuilderModelImpl model) {
		return new RealHardwareAccessor(model.getRegisterSpecHolder());
	}
	@Override
	protected List<UserSequencer> getUserSequencers(BuilderModelImpl model) {
		return Arrays.asList(new TestSequencer());
	}
	@Override
	protected int getInstanceCount() {
		return 1;
	}

}
