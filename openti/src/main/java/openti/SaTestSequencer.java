package openti;

import java.util.List;
import java.util.Map;

import jp.silverbullet.core.dependency2.ChangedItemValue;
import jp.silverbullet.core.dependency2.Id;
import jp.silverbullet.core.dependency2.RequestRejectedException;
import jp.silverbullet.core.sequncer.SvHandlerModel;
import jp.silverbullet.core.sequncer.UserSequencer;
import openti.AnotherUserEasyAccess.EnumStart;

public class SaTestSequencer implements UserSequencer {
	abstract class Sa {
		private Object sync = new Object();
		private boolean stop = false;
		public Sa() {
			new Thread() {

				@Override
				public void run() {
					while(true) {
						synchronized(sync) {
							try {
								sync.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						
						stop = false;
						while(!stop) {
							onUpdate(Math.random());
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
				
			}.start();
		}
		protected abstract void onUpdate(double random);
		public void start() {
			synchronized(sync) {
				sync.notify();
			}
		}
		public void stop() {
			this.stop = true;
		}
	}
	
	private Sa sa  = new Sa() {
		@Override
		protected void onUpdate(double random) {
			try {
				properties.setResult((long)(random*100));
			} catch (RequestRejectedException e) {
				e.printStackTrace();
			}
		}
	};
	private AnotherUserEasyAccess properties;
	
	@Override
	public void handle(SvHandlerModel model, Map<String, List<ChangedItemValue>> changed, Id sourceId)
			throws RequestRejectedException {
		
		this.properties = new AnotherUserEasyAccess(model.getEasyAccessInterface());
		AnotherUserRegister registers = new AnotherUserRegister(model.getRegisterAccessor());
		
		if (properties.getStart().equals(EnumStart.ID_START_START)) {
			sa.start();
		}
		else if (properties.getStart().equals(EnumStart.ID_START_STOP)) {
			sa.stop();
		}
	}

	@Override
	public List<String> targetIds() {
		// TODO Auto-generated method stub
		return null;
	}

}
