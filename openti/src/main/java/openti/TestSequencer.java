package openti;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import jp.silverbullet.ChangedItemValue;
import jp.silverbullet.dependency.engine.RequestRejectedException;
import jp.silverbullet.handlers.SvHandlerModel;
import jp.silverbullet.property.ChartContent;
import jp.silverbullet.web.JsTableContent;
import openti.UserEasyAccess.EnumStartStop;
import openti.UserEasyAccess.EnumTest;
import openti.UserEasyAccess.EnumTestaction;

public class TestSequencer {
	private boolean stopRequested;

	public void handle(SvHandlerModel model, Map<String, List<ChangedItemValue>> changed) {
		UserEasyAccess easy = new UserEasyAccess(model.getEasyAccessModel());

//		if (easy.getStartStop().compareTo(EnumStartStop.ID_START_STOP_STOP) == 0) {
//		if (easy.getTest().compareTo(EnumTest.ID_TEST_DO_START) == 0) {
		if (easy.getTestaction().compareTo(EnumTestaction.ID_TESTACTION_START) == 0) {
			
			UserRegisterControl register = new UserRegisterControl(model.getRegisterAccess());

			stopRequested = false;
//			SvProperty trace = model.getProperty(ID.ID_TRACE);
			ChartContent chartContent = new ChartContent();
			chartContent.setXmin("0");
			chartContent.setXmax("100");
			chartContent.setYmin("-200");
			chartContent.setYmax("200");
			
			register.motorDriveStartStop.set_s_osa_em_drv_stop_mode(true);
			
			long average = easy.getAveragetime();
			for (int loop = 0; loop < average; loop++) {
				register.otdrTestControl.set_TestStart(true);
				register.waitIntrrupt();
				byte[] data = register.getRegisterAccess().readBlock(UserRegisterControl.ADDR_OTDRTRACEDATA, 25001*2);
				
				if (stopRequested) {
					break;
				}
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				short[] shorts = new short[data.length/2];
				// to turn bytes to shorts as either big endian or little endian. 
				ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(shorts);
				
				
				int points = shorts.length;
				String[] y = new String[points];
				double step = (double)shorts.length / (double)points;
				for (int i = 0; i < points; i++) {
					y[i] = String.valueOf(shorts[(int)(i * step)]);
				}
				chartContent.setY(y);
				
				JsTableContent tableContent = new JsTableContent();
				tableContent.setHeaders(Arrays.asList("Distance [nm]", "Loss [dB]", "Refl. [dB]", "dB/km [dB]", "Cum. [dB]"));
				
				points = 10;		
				
				for (int i = 0; i < points; i++) {
					double wave = Math.random() * 10;
					double level = Math.random() * 10;

					List<String> line = Arrays.asList(
							String.format("%.3f", wave), 
							String.format("%.2f", level),
							String.format("%.3f", wave), 
							String.format("%.2f", level),
							String.format("%.3f", wave)
							);
					tableContent.addRow(line);
				}
				register.otdrTestControl.set_TestStart(false);
//				try {
//					easy.setTraceDistancerange(model.getProperty(ID.ID_DISTANCERANGE).getSelectedListTitle() + model.getProperty(ID.ID_DISTANCERANGE).getUnit());
//					easy.setTracePulsewidth(model.getProperty(ID.ID_PULSEWIDTH).getSelectedListTitle() + model.getProperty(ID.ID_PULSEWIDTH).getUnit());
//					model.requestChange(ID.ID_TRACE, new ObjectMapper().writeValueAsString(chartContent));
//					model.requestChange(ID.ID_TABLE, new ObjectMapper().writeValueAsString(tableContent));
//					easy.setSpliceLoss(Math.random());
//					easy.setReflectance(Math.random()-30);
//					//easy.setTeststate(EnumTeststate.ID);
//				} catch (JsonGenerationException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (JsonMappingException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (RequestRejectedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			}
			register.motorDriveStartStop.set_s_osa_em_drv_stop_mode(false);
			easy.setTestaction(EnumTestaction.ID_TESTACTION_STOP);
		}
		else {
			stopRequested = true;
		}
	}
}

