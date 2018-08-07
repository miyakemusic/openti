package openti.test;

import jp.silverbullet.handlers.RegisterAccess;
import openti.AbstractUserSimulator;
import openti.SimRegisterControl;
import openti.UserRegisterControl;

public class SimOtdr extends AbstractUserSimulator {
	private OtdrHardware otdr = new OtdrHardware() {
		@Override
		protected void onCompleted() {
			SimOtdr.this.updateBlockData(UserRegisterControl.ADDR_OTDRTRACEDATA, otdr.getData());
			SimOtdr.this.triggerInterrupt();
		}
	};
	private SimRegisterControl regControl;
	
	public SimOtdr(RegisterAccess registerAccess) {
		regControl = new SimRegisterControl(registerAccess);
	}


	@Override
	protected void writeBlock(long address, byte[] data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_InterruptStatus_InterruptStatus() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_TEMP_MONITOR_TEMP_MONITOR() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Motordrivestart_stop_s_osa_em_drv_stop_mode(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Motordrivestart_stop_s_osa_em_drv_stop(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Motordrivestart_stop_s_osa_em_drv_start(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_Motordrivestart_stop_Motordrivestart_stop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_MotorPosition_MotorPosition() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Targetposition_s_osa_em_target_pos(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_Targetposition_Targetposition() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Targetacceleration_s_osa_em_target_acc_up(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_Targetacceleration_Targetacceleration() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Targetacceleration_Duringdeceleration__s_osa_em_target_acc_dn(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_Targetacceleration_Duringdeceleration__Targetacceleration_Duringdeceleration_() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Targetvelocity_s_osa_em_target_vel(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_Targetvelocity_Targetvelocity() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Maxacceleration_s_osa_em_max_acc(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_Maxacceleration_Maxacceleration() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Maxvelocity_Maxvelocity(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_Maxvelocity_Maxvelocity() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_Encodersignal1forDebug1_Encodersignal1forDebug1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Encodersignal1forDebug2_s_osa_em_poscnt_rst(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_Encodersignal1forDebug2_Encodersignal1forDebug2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_PhotoInterrupterdetection_s_osa_pi1_edge_sel(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_PhotoInterrupterdetection_s_osa_pi2_edge_sel(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_PhotoInterrupterdetection_s_osa_pi1_ignore(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_PhotoInterrupterdetection_s_osa_pi2_ignore(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_PhotoInterrupterdetection_PhotoInterrupterdetection() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_MotorPositionatorigin_MotorPositionatorigin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Motorstepsatinitialrotorposition_s_osa_em_halledge_sel(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_Motorstepsatinitialrotorposition_Motorstepsatinitialrotorposition() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_PIDfilterreset_s_osa_em_pid_reset(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_PIDfilterreset_PIDfilterreset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_PIDProportionalitycoefficient_s_osa_pid_proportion14_0(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_PIDProportionalitycoefficient_PIDProportionalitycoefficient() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_PIDIntegralcoefficient_s_osa_pid_integration14_0(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_PIDIntegralcoefficient_PIDIntegralcoefficient() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_PIDDifferentialcoefficient_s_osa_pid_differential14_0(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_PIDDifferentialcoefficient_PIDDifferentialcoefficient() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_PIDDiffsamplinginterval_s_osa_pid_diff_interval14_0(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_PIDDiffsamplinginterval_PIDDiffsamplinginterval() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_PIDIntegrallimit_Clippingbitwidth_s_osa_pid_intv_clip4_0(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_PIDIntegrallimit_Clippingbitwidth_s_osa_pid_int_limit10_0(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_PIDIntegrallimit_Clippingbitwidth_PIDIntegrallimit_Clippingbitwidth() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_PIDscalingfactor_s_osa_pid_intv_sfactor4_0(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_PIDscalingfactor_s_osa_em_pid_pr_sfactor5_0(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_PIDscalingfactor_s_osa_em_pid_int_sfactor5_0(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_PIDscalingfactor_s_osa_em_pid_diff_sfactor5_0(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_PIDscalingfactor_PIDscalingfactor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_MotorDrivesetting_s_osa_em_hall_set2_0(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_MotorDrivesetting_s_osa_em_hall_sel(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_MotorDrivesetting_s_osa_em_drvpat_sel(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_MotorDrivesetting_MotorDrivesetting() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Emergencythreshold_s_osa_em_emergency_ignore(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Emergencythreshold_s_osa_em_emergency_intvl(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Emergencythreshold_s_osa_em_emergency_th17_0(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_Emergencythreshold_Emergencythreshold() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Hallsensororder_s_hall_sensor_not(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Hallsensororder_s_hall_sensor_order2_0(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_Hallsensororder_Hallsensororder() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_PWMmanualsetting1_s_osa_pwm_manual_sel(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_PWMmanualsetting1_s_osa_pwm_manual_u9_0(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_PWMmanualsetting1_PWMmanualsetting1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_PWMmanualsetting2_s_osa_pwm_manual_v9_0(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_PWMmanualsetting2_s_osa_pwm_manual_w9_0(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_PWMmanualsetting2_PWMmanualsetting2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_PWMdutylimitforDebug_s_osa_pwm_duty_limit10_0(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_PWMdutylimitforDebug_PWMdutylimitforDebug() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_EyeDiagram_data(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_EyeDiagram_EyeDiagram() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Samplingstart_s_osa_smp_mode(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Samplingstart_s_osa_smp_start(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_Samplingstart_Samplingstart() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Samplingstartposition_s_osa_smp_start_pos(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_Samplingstartposition_Samplingstartposition() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Samplingpointnum_s_osa_smp_num(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_Samplingpointnum_Samplingpointnum() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Rangesetting_s_osa_p_init_range(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Rangesetting_s_osa_s_init_range(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Rangesetting_s_osa_range_manual_sel(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Rangesetting_s_osa_p_range_set(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Rangesetting_s_osa_s_range_set(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_Rangesetting_Rangesetting() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Range0Offset_s_osa_smp_p_offset0(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Range0Offset_s_osa_smp_s_offset0(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_Range0Offset_Range0Offset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Range1Offset_s_osa_smp_p_offset1(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Range1Offset_s_osa_smp_s_offset1(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_Range1Offset_Range1Offset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Range2Offset_s_osa_smp_p_offset2(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Range2Offset_s_osa_smp_s_offset2(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_Range2Offset_Range2Offset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Range3Offset_s_osa_smp_p_offset3(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Range3Offset_s_osa_smp_s_offset3(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_Range3Offset_Range3Offset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Range4Offset_s_osa_smp_p_offset4(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Range4Offset_s_osa_smp_s_offset4(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_Range4Offset_Range4Offset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Range0UpThreshold_s_osa_smp_p_upth0(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Range0UpThreshold_s_osa_smp_s_upth0(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_Range0UpThreshold_Range0UpThreshold() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Range1UpThreshold_s_osa_smp_p_upth1(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Range1UpThreshold_s_osa_smp_s_upth1(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_Range1UpThreshold_Range1UpThreshold() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Range1DownThreshold_s_osa_smp_p_dwnth1(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Range1DownThreshold_s_osa_smp_s_dwnth1(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_Range1DownThreshold_Range1DownThreshold() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Range2UpThreshold_s_osa_smp_p_upth2(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Range2UpThreshold_s_osa_smp_s_upth2(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_Range2UpThreshold_Range2UpThreshold() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Range2DownThreshold_s_osa_smp_p_dwnth2(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Range2DownThreshold_s_osa_smp_s_dwnth2(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_Range2DownThreshold_Range2DownThreshold() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Range3UpThreshold_s_osa_smp_p_upth3(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Range3UpThreshold_s_osa_smp_s_upth3(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_Range3UpThreshold_Range3UpThreshold() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Range3DownThreshold_s_osa_smp_p_dwnth3(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Range3DownThreshold_s_osa_smp_s_dwnth3(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_Range3DownThreshold_Range3DownThreshold() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Range4DownThreshold_s_osa_smp_p_dwnth4(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Range4DownThreshold_s_osa_smp_s_dwnth4(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_Range4DownThreshold_Range4DownThreshold() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_OSARAMreadflag_d_osa_dpram_rd_flg(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_OSARAMreadflag_OSARAMreadflag() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_EEPROM_I2C_OSACalibROM__s_osa_eeprom_cmd3(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_EEPROM_I2C_OSACalibROM__s_osa_eeprom_cmd2(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_EEPROM_I2C_OSACalibROM__s_osa_eeprom_cmd1(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_EEPROM_I2C_OSACalibROM__s_osa_eeprom_cmd0(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_EEPROM_I2C_OSACalibROM__s_osa_eeprom_wdata(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_EEPROM_I2C_OSACalibROM__EEPROM_I2C_OSACalibROM_() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_NewRegister_newbit(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_NewRegister_NewRegister() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_OSCControl_Trigger(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_OSCControl_DataClear(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_OSCControl_Start_Stop(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_OSCControl_OSCControl() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_PPGControl_Start_Stop(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_PPGControl_PPGControl() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_EDControl_BitRate(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_EDControl_EDControl() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_PPGBitrate_BitRate(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_PPGBitrate_PPGBitrate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Sinusoidalcalibdata_s_osa_em_sinecalib_u(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Sinusoidalcalibdata_s_osa_em_sinecalib_v(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write_Sinusoidalcalibdata_s_osa_em_sinecalib_w(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_Sinusoidalcalibdata_Sinusoidalcalibdata() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_OSARAMData_OSARAMData() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void write_OTDRTestControl_TestStart(int value) {
		if (value == 1) {
			this.otdr.start();
		}
		else {
			
		}
	}


	@Override
	public void read_OTDRTestControl_OTDRTestControl() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void read_Dummy_Dummy() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void write_OTDRTraceData_OTDRTraceData(int value) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void read_OTDRTraceData_OTDRTraceData() {
		// TODO Auto-generated method stub
		
	}

}
