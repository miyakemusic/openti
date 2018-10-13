package openti;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jp.silverbullet.dependency.ChangedItemValue;
import jp.silverbullet.dependency.RequestRejectedException;
import jp.silverbullet.handlers.SvHandlerModel;
import jp.silverbullet.property.ChartContent;
import jp.silverbullet.web.JsTableContent;
import openti.UserEasyAccess.EnumOtdrCollectionMode;
import openti.UserEasyAccess.EnumOtdrError;
import openti.UserEasyAccess.EnumOtdrTestcontrol;

public class TestSequencer {
	private boolean stopRequested;

	public void handle(SvHandlerModel model, Map<String, List<ChangedItemValue>> changed) {
		UserEasyAccess parameters = new UserEasyAccess(model.getEasyAccessModel());

		if (parameters.getOtdrTestcontrol().compareTo(EnumOtdrTestcontrol.ID_OTDR_TESTCONTROL_START) == 0) {
			UserRegisterControl regiseters = new UserRegisterControl(model.getRegisterAccess());
			
			stopRequested = false;
			ChartContent chartContent = new ChartContent();
			chartContent.setXmin("0");
			chartContent.setXmax("100");
			chartContent.setYmin("-200");
			chartContent.setYmax("200");	

			long average = parameters.getOtdrAverage();
			for (int loop = 0; loop < average; loop++) {
				parameters.setOtdrAverageResult(loop+1);
				regiseters.otdrTestControl.set_teststart(true);
				regiseters.waitIntrrupt();
				
				if (regiseters.otdrInterruptStatus.get_erroroccurs()) {
					parameters.setOtdrError(EnumOtdrError.ID_OTDR_ERROR_HARDWARE);
					regiseters.otdrTestControl.set_teststart(false);
					break;
				}
				else if (regiseters.otdrInterruptStatus.get_traceready()) {
					regiseters.otdrInterruptStatus.set_traceready(false);
				}
				byte[] data = regiseters.getRegisterAccess().readBlock(UserRegisterControl.ADDR_OTDRTRACEDATA, 25001*2);
				
				if (stopRequested) {
					break;
				}
				
				try {
					Thread.sleep(200);
				} catch (InterruptedException e1) {
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
				regiseters.otdrTestControl.set_teststart(false);
				try {
					model.requestChange(ID.ID_OTDR_TRACE, new ObjectMapper().writeValueAsString(chartContent));
					model.requestChange(ID.ID_OTDR_TABLE, new ObjectMapper().writeValueAsString(tableContent));
				} catch (JsonGenerationException e) {
					e.printStackTrace();
				} catch (JsonMappingException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (RequestRejectedException e) {
					e.printStackTrace();
				}
				if (parameters.getOtdrCollectionMode().equals(EnumOtdrCollectionMode.ID_OTDR_COLLECTION_MODE_REALTIME)) {
					loop--;
				}
			}
			parameters.setOtdrTestcontrol(EnumOtdrTestcontrol.ID_OTDR_TESTCONTROL_STOP);
		}
		else {
			stopRequested = true;
		}
	}
}

