package openti;

import java.util.Arrays;
import java.util.List;

import jp.silverbullet.BuilderModelImpl;
import jp.silverbullet.SilverBulletServer;
import jp.silverbullet.StaticInstances;
import jp.silverbullet.register2.RegisterAccessor;
import jp.silverbullet.sequncer.UserSequencer;
import jp.silverbullet.web.ui.part2.Layout;
import jp.silverbullet.web.ui.part2.Pane;
import jp.silverbullet.web.ui.part2.UiBuilder;
import jp.silverbullet.web.ui.part2.WidgetGeneratorHelper;
import jp.silverbullet.web.ui.part2.UiBuilder.PropertyField;
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
	protected RegisterAccessor getHardwareAccessor(BuilderModelImpl model) {
		return new RealHardwareAccessor(model.getRegisterSpecHolder());
	}
	@Override
	protected List<UserSequencer> getUserSequencers(BuilderModelImpl model) {
		return Arrays.asList(new TestSequencer(), new OscilloTestSequencer(), 
				new SystemManager(), new FileManager(), new BertTester1(), new BertTester2());
	}
//	@Override
	protected UiBuilder getUi2() {
		UiBuilder builder = new UiBuilder();
		return getDesignSimple(builder);
	}
	private UiBuilder getDesignSimple(UiBuilder builder) {
		Pane pane = builder.getRootPane();
		pane.css("width", "800").css("height", "600").css("top", "150px").css("border-style", "dashed").css("border-width", "1px");
//		pane.createButton(ID.ID_APPLICATION);
//		return builder;
		return builder;
	}

}
