package openti;

import java.util.Arrays;
import java.util.List;

import jp.silverbullet.BuilderModelImpl;
import jp.silverbullet.SilverBulletServer;
import jp.silverbullet.StaticInstances;
import jp.silverbullet.register2.RegisterAccessor;
import jp.silverbullet.sequncer.UserSequencer;
import jp.silverbullet.web.ui.part2.Pane;
import jp.silverbullet.web.ui.part2.UiBuilder;
import jp.silverbullet.web.ui.part2.WidgetGeneratorHelper;
import jp.silverbullet.web.ui.part2.UiBuilder.Layout;
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
	protected String getBaseFolderAndPackage() {
		return "src/main/java;openti";
	}
	@Override
	protected RegisterAccessor getHardwareAccessor(BuilderModelImpl model) {
		return new RealHardwareAccessor(model.getRegisterSpecHolder());
	}
	@Override
	protected List<UserSequencer> getUserSequencers(BuilderModelImpl model) {
		return Arrays.asList(new TestSequencer(), new OscilloTestSequencer());
	}
	@Override
	protected UiBuilder getUi() {
		UiBuilder builder = new UiBuilder();
		Pane pane = builder.createPane(UiBuilder.Layout.VERTICAL);
		pane.css("width", "1000").css("height", "1000");
		WidgetGeneratorHelper helper = new WidgetGeneratorHelper(StaticInstances.getInstance().getBuilderModel().getPropertiesHolder2());
		
		Pane applicationPane = pane.createPane(Layout.HORIZONTAL);
		helper.generateToggleButton("ID_APPLICATION", applicationPane).css("width", "100").css("height", "40").css("background-color", "lightgray");
//		applicationPane.createLabel("ID_APPLICATION", PropertyField.VALUE);
		
		//// OTDR
		Pane otdrPane = pane.createPane(Layout.VERTICAL).condition("ID_APPLICATION", "ID_APPLICATION_OTDR");
		otdrPane./*size(1000, 800).*/css("border-width", "1px").css("background-color", "lightgray").css("width", "1000").css("height", "800px");
		
		Pane distPane = otdrPane.createPane(Layout.HORIZONTAL);
		otdrPane.css("padding", "5");
		distPane.createLabel("ID_DISTANCERANGE", PropertyField.TITLE).css("width","150").css("height", "30").css("font-size", "16px").css("font-weight", "bold");
		distPane.createStaticText(":");
		distPane.css("border-width", "1px").css("border-color", "black").css("border-style", "solid");
		helper.generateToggleButton("ID_DISTANCERANGE", distPane).css("width","80").css("height", "30");
		
		Pane pulsePane = otdrPane.createPane(Layout.HORIZONTAL);
		pulsePane.css(distPane.css);
		pulsePane.createLabel("ID_PULSEWIDTH", PropertyField.TITLE).css("width","150").css("height", "30");
		pulsePane.createStaticText(":");
		helper.generateToggleButton("ID_PULSEWIDTH", pulsePane).css("width","80").css("height", "30");
		
		Pane otdrSetupPane = otdrPane.createPane(Layout.HORIZONTAL);
		Pane collectionPane = otdrSetupPane.createPane(Layout.HORIZONTAL).title("ID_COLLECMODE", PropertyField.TITLE);
		helper.generateToggleButton("ID_COLLECMODE", collectionPane).css("margin", "5");
		otdrSetupPane.createButton("ID_OTDR_TESTCONTROL").css("width","100").css("height", "60");
		otdrSetupPane.createButton("ID_COLLECMODE").css("width","130").css("height", "60");
		otdrSetupPane.createComboBox("ID_COLLECMODE").css("font-size", "29px");
		
		Pane averagePane = otdrSetupPane.createPane(Layout.HORIZONTAL);
		averagePane.css("width","250").css("height", "35");
		averagePane.css(distPane.css);
		averagePane.css("font-size", "20px");
		averagePane.createLabel("ID_AVERAGETIME", PropertyField.TITLE);
		averagePane.createStaticText(":");
		averagePane.createTextField("ID_AVERAGETIME", PropertyField.VALUE).css("width","50").css("height", "24");
		averagePane.createLabel("ID_AVERAGE_RESULT", PropertyField.VALUE);
		
		Pane modelPane = otdrPane.createPane(Layout.HORIZONTAL);
		modelPane.css("width", "250");
		helper.generateToggleButton(ID.ID_MODELNAME, modelPane);
		
		helper.generateTitledSetting("ID_OTDR_SAMPLINGPOINTS", otdrPane);
		otdrPane.createChart("ID_TRACE").css("width","600").css("height", "300");
		otdrPane.createTable("ID_TABLE").css("width","600").css("height", "200");
		
		//// SQA
		Pane sqaPane = pane.createPane(Layout.VERTICAL).condition("ID_APPLICATION", "ID_APPLICATION_SQA");
		sqaPane.css("font-size", "24px");
		sqaPane.css(otdrPane.css);
		
		Pane sqaSetupPane = sqaPane.createPane(Layout.HORIZONTAL);
		Pane ppgPane = sqaPane.createPane(Layout.HORIZONTAL).title("Pulse Pattern Generator");
	
		helper.generateTitledSetting("ID_PPG_PATTERN", ppgPane);
		helper.generateTitledSetting("ID_PPG_MODULATION", ppgPane);
		helper.generateTitledSetting("ID_PPG_FREQUENCY", ppgPane);
		
		Pane edPane = sqaPane.createPane(Layout.HORIZONTAL).title("Error Detector");
		helper.generateTitledSetting("ID_ED_PATTERN", edPane);
		helper.generateTitledSetting("ID_ED_MODULATION", edPane);
		helper.generateTitledSetting("ID_ED_FREQUENCY", edPane);
		
		/// OSCILLO
		Pane oscilloPane = pane.createPane(Layout.VERTICAL).condition("ID_APPLICATION", "ID_APPLICATION_OSCILLO");
		oscilloPane.css(otdrPane.css);
//		Pane optionPane = sqaPane.createPane(Layout.HORIZONTAL);
//		optionPane.createCheckBox("ID_OPTION_001").size(300, 20).position(10, 10);
//		optionPane.createToggleButton("ID_OPTION_001").size(100, 50).position(10, 10).css("line-height", "25px");;
//		optionPane.createButton("ID_OPTION_001").size(100, 50).position(10, 10).css("line-height", "25px");;
		oscilloPane.createButton("ID_OSC_TESTCONTROL").css("width","100").css("height", "50").css("line-height", "25px");
		Pane triggerPane = oscilloPane.createPane(Layout.VERTICAL).title("ID_OSC_TRIGGER", PropertyField.TITLE);
		triggerPane.createTextField("ID_OSC_TRIGGER", PropertyField.VALUE);
		triggerPane.createSlider("ID_OSC_TRIGGER");//.size(500, 30);
		oscilloPane.createImage("ID_OSC_EYEDIAGRAM").css("width","1000").css("height", "600");
		return builder;

	}
}
