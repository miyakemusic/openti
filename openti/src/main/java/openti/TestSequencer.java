package openti;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jp.silverbullet.core.SbDateTime;
import jp.silverbullet.core.dependency2.ChangedItemValue;
import jp.silverbullet.core.dependency2.Id;
import jp.silverbullet.core.dependency2.RequestRejectedException;
import jp.silverbullet.core.property2.ChartProperty;
import jp.silverbullet.core.sequncer.SvHandlerModel;
import jp.silverbullet.core.sequncer.UserSequencer;
import jp.silverbullet.core.property2.TableProperty;
import openti.SilverbulletUserEasyAccess.EnumCollecmode;
import openti.SilverbulletUserEasyAccess.EnumDistancerange;
import openti.SilverbulletUserEasyAccess.EnumOtdrTestcontrol;
import openti.SilverbulletUserEasyAccess.EnumPulsewidth;
import openti.SilverbulletUserRegister.TEST_CONFIG1;
import openti.SilverbulletUserRegister.TEST_CONTROL;
import openti.SilverbulletUserRegister.TEST_SETUP;

public class TestSequencer implements UserSequencer {
	private boolean stopRequested;

	@Override
	public void handle(SvHandlerModel model, Map<String, List<ChangedItemValue>> changed, Id sourceId) throws RequestRejectedException {
		new Thread() {
			@Override
			public void run() {
				try {
					handleAsync(model, changed);
				} catch (RequestRejectedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.start();
	}
	/* (non-Javadoc)
	 * @see openti.UserSequencer#handle(jp.silverbullet.handlers.SvHandlerModel, java.util.Map)
	 */

	public void handleAsync(SvHandlerModel model, Map<String, List<ChangedItemValue>> changed) throws RequestRejectedException {
		SilverbulletUserEasyAccess properties = new SilverbulletUserEasyAccess(model.getEasyAccessInterface());
		SilverbulletUserRegister registers = new SilverbulletUserRegister(model.getRegisterAccessor());
		
		if (properties.getOtdrTestcontrol().compareTo(EnumOtdrTestcontrol.ID_OTDR_TESTCONTROL_START) == 0) {			
			stopRequested = false;
					
			properties.setTestTime(new SbDateTime().string());
			long average = properties.getAveragetime().intValue();
			boolean newFlag = true;
			for (long loop = 0; loop < average; loop++) {
				try {
					Thread.sleep(50);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				
				long startTime = System.nanoTime();
				registers.test_control.set(TEST_CONTROL.STA, 0x01).write();
				
//				regiseters.otdrTestControl.write_teststart(true);
				registers.waitInterrupt();
				
				properties.setAverageResult(loop+1);
				if (properties.getFatalerror()) {
					return;
				}
				byte[] data = registers.data.read();
				int sampling = properties.getOtdrSamplingpoints().intValue();
				registers.test_setup.set(TEST_SETUP.DURATION, 5).set(TEST_SETUP.POINTS, sampling).write();
				
				int range = Arrays.asList(EnumDistancerange.values()).indexOf(properties.getDistancerange());
				int pulse = Arrays.asList(EnumPulsewidth.values()).indexOf(properties.getPulsewidth());
				
				range = (int)(Math.random() * 10);
				pulse = range + 1;
				registers.test_config1.set(TEST_CONFIG1.DISTANCE, range).set(TEST_CONFIG1.PULSE, pulse).write();
//				regiseters.otdrTestControl.write_duration((int)(Math.random() * 3));
//				regiseters.otdrTestControl.write_points((int)(Math.random() * 1000));
//				regiseters.otdrTestControl.write_pulse((int)(Math.random() * 3));
//				regiseters.otdrTestControl.write_power((int)(Math.random() * 3));
//				regiseters.otdrTestControl.write_range((int)(Math.random() * 30));
//				
//				if (regiseters.otdrInterruptStatus.read_and_reset_erroroccurs()) {
//					properties.setError(EnumError.ID_ERROR_HARDWARE);
//					regiseters.otdrTestControl.write_teststart(false);
//					break;
//				}
//				else if (regiseters.otdrInterruptStatus.read_and_reset_tracedataready()) {
//					byte[] data = regiseters.getRegisterAccess().readBlock(UserRegisterControl.ADDR_ADDROTDRTRACEDATA, 25001*2);
					
//					try {
//						Files.write(Paths.get("data.bin"), data);
//					} catch (IOException e2) {
//						e2.printStackTrace();
//					}

					if (stopRequested) {
						break;
					}

					
					short[] shorts = new short[data.length/2];
					// to turn bytes to shorts as either big endian or little endian. 
					ByteBuffer.wrap(data).order(ByteOrder.BIG_ENDIAN).asShortBuffer().get(shorts);
					
					int points = shorts.length;
					String[] y = new String[points];
					double step = (double)shorts.length / (double)points;
					for (int i = 0; i < points; i++) {
						y[i] = String.valueOf(shorts[(int)(i * step)]);
					}
					
					ChartProperty chartContent = new ChartProperty();
					chartContent.setXmin("0");
					chartContent.setXmax("100");
					chartContent.setYmin("-200");
					chartContent.setYmax("200");	
					chartContent.setY(y);
					
					TableProperty tableContent = new TableProperty();
//					tableContent.structureChanged = newFlag;
					newFlag = false;
					tableContent.headers = Arrays.asList("Element", "F1A", "F2A", "F3A", "F5A", "F6A", "F7A", "Total");
					
					points = 10;		
					
					for (int i = 0; i < points; i++) {
						double wave = Math.random() * 10;
						double level = Math.random() * 10;

						List<String> line = Arrays.asList(
								"E" + i + "D",
								String.format("%.3f", wave), 
								String.format("%.2f", level),
								String.format("%.3f", wave), 
								String.format("%.2f", level),
								String.format("%.3f", wave),
								String.format("%.3f", wave),
								String.format("%.3f", wave*4 + level*2)
								);
						tableContent.addRow(line);
					}
					registers.test_control.set(TEST_CONTROL.STA, 0x00).write();
					try {
						//String url = StaticInstances.getInstance().blobStore.put(ID.ID_TRACE, chartContent);
						model.getEasyAccessInterface().requestChange(new Id(ID.ID_TRACE), chartContent, 
								String.valueOf(Calendar.getInstance().getTime().getTime()));

						model.getEasyAccessInterface().requestChange(ID.ID_TABLE, tableContent, String.valueOf(Calendar.getInstance().getTime().getTime()));
						properties.setLoss(Math.random() * 10.0 + 10.0);
					} catch (RequestRejectedException e) {
						e.printStackTrace();
					}
					if (properties.getCollecmode().equals(EnumCollecmode.ID_COLLECMODE_REALTIME)) {
						loop--;
					}
					else if (properties.getCollecmode().equals(EnumCollecmode.ID_COLLECMODE_AVERAGE)) {
						if (loop == average) {
							break;
						}
					}
					
//					System.out.println(System.nanoTime() - startTime);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
			}
		}
		else {
			this.stopRequested = true;
		}
		properties.setOtdrTestcontrol(EnumOtdrTestcontrol.ID_OTDR_TESTCONTROL_STOP);
	}
	
	@Override
	public List<String> targetIds() {
		return Arrays.asList(ID.ID_OTDR_TESTCONTROL);
	}
}

