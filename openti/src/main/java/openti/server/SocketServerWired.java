package openti.server;

import java.util.Arrays;
import java.util.List;

import jp.silverbullet.core.sequncer.UserSequencer;
import openti.OltsSequencer;
import openti.OscilloTestSequencer;
import openti.TestSequencer;
import openti.VipSequencer;

public class SocketServerWired {
	public static void main(String[] arg) {
		List<UserSequencer> sequencers = Arrays.asList(new TestSequencer(), new OscilloTestSequencer(), new VipSequencer(), new OltsSequencer());
		new SocketServer(arg[0], arg[1], arg[2], arg[3], sequencers);
	}
}
