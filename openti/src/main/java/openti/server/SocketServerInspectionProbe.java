package openti.server;

import java.util.Arrays;
import java.util.List;

import jp.silverbullet.core.sequncer.UserSequencer;
import openti.VipSequencer;

public class SocketServerInspectionProbe {
	public static void main(String[] arg) {
		
		List<UserSequencer> sequencers = Arrays.asList(new VipSequencer());
		new SocketServer(arg[0], sequencers);	
	}

}
