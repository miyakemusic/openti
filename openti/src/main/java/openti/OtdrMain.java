package openti;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jp.silverbullet.core.dependency2.ChangedItemValue;
import jp.silverbullet.core.dependency2.RequestRejectedException;
import jp.silverbullet.core.property2.ChartContent;
import jp.silverbullet.core.property2.JsTableContent;
import jp.silverbullet.core.register2.RegisterAccessor;
import jp.silverbullet.core.sequncer.SvHandlerModel;
import openti.UserEasyAccess.EnumCollecmode;
import openti.UserEasyAccess.EnumDistancerange;
import openti.UserEasyAccess.EnumOtdrTestcontrol;
import openti.UserEasyAccess.EnumPulsewidth;
import openti.UserRegister.TEST_CONFIG1;
import openti.UserRegister.TEST_CONTROL;
import openti.UserRegister.TEST_SETUP;
import openti.test.SimHardware;

public class OtdrMain extends AbstractIndependentMain {
	public OtdrMain(String host, String port) {
		super(host, port);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		new OtdrMain(args[0], args[1]);
	}
	
	private boolean stopRequested;
	private UserEasyAccess properties;
	private UserRegister registers;
	
	@Override
	protected List<String> getTargetIds() {
		return Arrays.asList(ID.ID_OTDR_TESTCONTROL);
	}

	@Override
	protected RegisterAccessor getRegisterAccessor() {
		return new SimHardware();
	}

	@Override
	protected void handle(Map<String, List<ChangedItemValue>> changed) throws RequestRejectedException {
		
		if (properties.getOtdrTestcontrol().compareTo(EnumOtdrTestcontrol.ID_OTDR_TESTCONTROL_START) == 0) {			
			stopRequested = false;
			
			if (properties.getCollecmode().compareTo(EnumCollecmode.ID_COLLECMODE_OPTIMIZED) == 0) {
				
			}
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
				
				ChartContent chartContent = new ChartContent();
				chartContent.setXmin("0");
				chartContent.setXmax("100");
				chartContent.setYmin("-200");
				chartContent.setYmax("200");	
				chartContent.setY(y);
				
				JsTableContent tableContent = new JsTableContent();
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
					getModel().getEasyAccessInterface().requestChange(ID.ID_TRACE, chartContent, String.valueOf(Calendar.getInstance().getTime().getTime()));
					getModel().getEasyAccessInterface().requestChange(ID.ID_TABLE, new ObjectMapper().writeValueAsString(tableContent));
					properties.setLoss(Math.random() * 10.0 + 10.0);
				} catch (JsonGenerationException e) {
					e.printStackTrace();
				} catch (JsonMappingException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
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
					Thread.sleep(10);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			properties.setOtdrTestcontrol(EnumOtdrTestcontrol.ID_OTDR_TESTCONTROL_STOP);
		}
		else if (properties.getOtdrTestcontrol().compareTo(EnumOtdrTestcontrol.ID_OTDR_TESTCONTROL_STOP) == 0) {	
			this.stopRequested = true;
		//	properties.setOtdrTestcontrol(EnumOtdrTestcontrol.ID_OTDR_TESTCONTROL_STOP);
		}
		
	}

	@Override
	protected void init(SvHandlerModel model) {
		properties = new UserEasyAccess(model.getEasyAccessInterface());
		registers = new UserRegister(model.getRegisterAccessor());	
	}

	
}
