package openti;

import jp.silverbullet.javafx.BuilderFx;

public class OpenTiApplication extends BuilderFx {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	protected String getBackupFilename() {
		return "ti_back.zip";
	}
}
