package openti.server;

import java.util.Arrays;
import java.util.List;

import jp.silverbullet.core.sequncer.UserSequencer;
import openti.SaTestSequencer;

public class SocketServerWireless {
	public static void main(String[] arg) {
		List<UserSequencer> sequencers = Arrays.asList(new SaTestSequencer());
		new SocketServer(arg[0], arg[1], arg[2], arg[3], sequencers);
	}
}
