package openti;

import jp.silverbullet.SilverBulletServer;

public class Main extends SilverBulletServer {
	public static void main(String arg[]) {
		new Main().start();
	}
	@Override
	protected String getDefaultFilename() {
		return "ti_back.zip";
	}
	@Override
	protected String getUserPath() {
		return this.getClass().getName().replace("." + this.getClass().getSimpleName(), "");
	}

}
