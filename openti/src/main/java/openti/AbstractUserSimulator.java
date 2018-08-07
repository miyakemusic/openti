package openti;
import java.util.BitSet;
import jp.silverbullet.register.SvSimulator;
abstract public class AbstractUserSimulator extends SvSimulator {
    abstract public void read_InterruptStatus_InterruptStatus();
    abstract public void write_OTDRTestControl_TestStart(int value);
    abstract public void read_OTDRTestControl_OTDRTestControl();
    abstract public void read_Dummy_Dummy();
    abstract public void read_TEMP_MONITOR_TEMP_MONITOR();
    abstract public void write_Motordrivestart_stop_s_osa_em_drv_stop_mode(int value);
    abstract public void write_Motordrivestart_stop_s_osa_em_drv_stop(int value);
    abstract public void write_Motordrivestart_stop_s_osa_em_drv_start(int value);
    abstract public void read_Motordrivestart_stop_Motordrivestart_stop();
    abstract public void read_MotorPosition_MotorPosition();
    abstract public void write_Targetposition_s_osa_em_target_pos(int value);
    abstract public void read_Targetposition_Targetposition();
    abstract public void write_Targetacceleration_s_osa_em_target_acc_up(int value);
    abstract public void read_Targetacceleration_Targetacceleration();
    abstract public void write_Targetacceleration_Duringdeceleration__s_osa_em_target_acc_dn(int value);
    abstract public void read_Targetacceleration_Duringdeceleration__Targetacceleration_Duringdeceleration_();
    abstract public void write_Targetvelocity_s_osa_em_target_vel(int value);
    abstract public void read_Targetvelocity_Targetvelocity();
    abstract public void write_Maxacceleration_s_osa_em_max_acc(int value);
    abstract public void read_Maxacceleration_Maxacceleration();
    abstract public void write_Maxvelocity_Maxvelocity(int value);
    abstract public void read_Maxvelocity_Maxvelocity();
    abstract public void read_Encodersignal1forDebug1_Encodersignal1forDebug1();
    abstract public void write_Encodersignal1forDebug2_s_osa_em_poscnt_rst(int value);
    abstract public void read_Encodersignal1forDebug2_Encodersignal1forDebug2();
    abstract public void write_PhotoInterrupterdetection_s_osa_pi1_edge_sel(int value);
    abstract public void write_PhotoInterrupterdetection_s_osa_pi2_edge_sel(int value);
    abstract public void write_PhotoInterrupterdetection_s_osa_pi1_ignore(int value);
    abstract public void write_PhotoInterrupterdetection_s_osa_pi2_ignore(int value);
    abstract public void read_PhotoInterrupterdetection_PhotoInterrupterdetection();
    abstract public void read_MotorPositionatorigin_MotorPositionatorigin();
    abstract public void write_Motorstepsatinitialrotorposition_s_osa_em_halledge_sel(int value);
    abstract public void read_Motorstepsatinitialrotorposition_Motorstepsatinitialrotorposition();
    abstract public void write_PIDfilterreset_s_osa_em_pid_reset(int value);
    abstract public void read_PIDfilterreset_PIDfilterreset();
    abstract public void write_PIDProportionalitycoefficient_s_osa_pid_proportion14_0(int value);
    abstract public void read_PIDProportionalitycoefficient_PIDProportionalitycoefficient();
    abstract public void write_PIDIntegralcoefficient_s_osa_pid_integration14_0(int value);
    abstract public void read_PIDIntegralcoefficient_PIDIntegralcoefficient();
    abstract public void write_PIDDifferentialcoefficient_s_osa_pid_differential14_0(int value);
    abstract public void read_PIDDifferentialcoefficient_PIDDifferentialcoefficient();
    abstract public void write_PIDDiffsamplinginterval_s_osa_pid_diff_interval14_0(int value);
    abstract public void read_PIDDiffsamplinginterval_PIDDiffsamplinginterval();
    abstract public void write_PIDIntegrallimit_Clippingbitwidth_s_osa_pid_intv_clip4_0(int value);
    abstract public void write_PIDIntegrallimit_Clippingbitwidth_s_osa_pid_int_limit10_0(int value);
    abstract public void read_PIDIntegrallimit_Clippingbitwidth_PIDIntegrallimit_Clippingbitwidth();
    abstract public void write_PIDscalingfactor_s_osa_pid_intv_sfactor4_0(int value);
    abstract public void write_PIDscalingfactor_s_osa_em_pid_pr_sfactor5_0(int value);
    abstract public void write_PIDscalingfactor_s_osa_em_pid_int_sfactor5_0(int value);
    abstract public void write_PIDscalingfactor_s_osa_em_pid_diff_sfactor5_0(int value);
    abstract public void read_PIDscalingfactor_PIDscalingfactor();
    abstract public void write_MotorDrivesetting_s_osa_em_hall_set2_0(int value);
    abstract public void write_MotorDrivesetting_s_osa_em_hall_sel(int value);
    abstract public void write_MotorDrivesetting_s_osa_em_drvpat_sel(int value);
    abstract public void read_MotorDrivesetting_MotorDrivesetting();
    abstract public void write_Emergencythreshold_s_osa_em_emergency_ignore(int value);
    abstract public void write_Emergencythreshold_s_osa_em_emergency_intvl(int value);
    abstract public void write_Emergencythreshold_s_osa_em_emergency_th17_0(int value);
    abstract public void read_Emergencythreshold_Emergencythreshold();
    abstract public void write_Hallsensororder_s_hall_sensor_not(int value);
    abstract public void write_Hallsensororder_s_hall_sensor_order2_0(int value);
    abstract public void read_Hallsensororder_Hallsensororder();
    abstract public void write_PWMmanualsetting1_s_osa_pwm_manual_sel(int value);
    abstract public void write_PWMmanualsetting1_s_osa_pwm_manual_u9_0(int value);
    abstract public void read_PWMmanualsetting1_PWMmanualsetting1();
    abstract public void write_PWMmanualsetting2_s_osa_pwm_manual_v9_0(int value);
    abstract public void write_PWMmanualsetting2_s_osa_pwm_manual_w9_0(int value);
    abstract public void read_PWMmanualsetting2_PWMmanualsetting2();
    abstract public void write_PWMdutylimitforDebug_s_osa_pwm_duty_limit10_0(int value);
    abstract public void read_PWMdutylimitforDebug_PWMdutylimitforDebug();
    abstract public void write_EyeDiagram_data(int value);
    abstract public void read_EyeDiagram_EyeDiagram();
    abstract public void write_Samplingstart_s_osa_smp_mode(int value);
    abstract public void write_Samplingstart_s_osa_smp_start(int value);
    abstract public void read_Samplingstart_Samplingstart();
    abstract public void write_Samplingstartposition_s_osa_smp_start_pos(int value);
    abstract public void read_Samplingstartposition_Samplingstartposition();
    abstract public void write_Samplingpointnum_s_osa_smp_num(int value);
    abstract public void read_Samplingpointnum_Samplingpointnum();
    abstract public void write_Rangesetting_s_osa_p_init_range(int value);
    abstract public void write_Rangesetting_s_osa_s_init_range(int value);
    abstract public void write_Rangesetting_s_osa_range_manual_sel(int value);
    abstract public void write_Rangesetting_s_osa_p_range_set(int value);
    abstract public void write_Rangesetting_s_osa_s_range_set(int value);
    abstract public void read_Rangesetting_Rangesetting();
    abstract public void write_Range0Offset_s_osa_smp_p_offset0(int value);
    abstract public void write_Range0Offset_s_osa_smp_s_offset0(int value);
    abstract public void read_Range0Offset_Range0Offset();
    abstract public void write_Range1Offset_s_osa_smp_p_offset1(int value);
    abstract public void write_Range1Offset_s_osa_smp_s_offset1(int value);
    abstract public void read_Range1Offset_Range1Offset();
    abstract public void write_Range2Offset_s_osa_smp_p_offset2(int value);
    abstract public void write_Range2Offset_s_osa_smp_s_offset2(int value);
    abstract public void read_Range2Offset_Range2Offset();
    abstract public void write_Range3Offset_s_osa_smp_p_offset3(int value);
    abstract public void write_Range3Offset_s_osa_smp_s_offset3(int value);
    abstract public void read_Range3Offset_Range3Offset();
    abstract public void write_Range4Offset_s_osa_smp_p_offset4(int value);
    abstract public void write_Range4Offset_s_osa_smp_s_offset4(int value);
    abstract public void read_Range4Offset_Range4Offset();
    abstract public void write_Range0UpThreshold_s_osa_smp_p_upth0(int value);
    abstract public void write_Range0UpThreshold_s_osa_smp_s_upth0(int value);
    abstract public void read_Range0UpThreshold_Range0UpThreshold();
    abstract public void write_Range1UpThreshold_s_osa_smp_p_upth1(int value);
    abstract public void write_Range1UpThreshold_s_osa_smp_s_upth1(int value);
    abstract public void read_Range1UpThreshold_Range1UpThreshold();
    abstract public void write_Range1DownThreshold_s_osa_smp_p_dwnth1(int value);
    abstract public void write_Range1DownThreshold_s_osa_smp_s_dwnth1(int value);
    abstract public void read_Range1DownThreshold_Range1DownThreshold();
    abstract public void write_Range2UpThreshold_s_osa_smp_p_upth2(int value);
    abstract public void write_Range2UpThreshold_s_osa_smp_s_upth2(int value);
    abstract public void read_Range2UpThreshold_Range2UpThreshold();
    abstract public void write_Range2DownThreshold_s_osa_smp_p_dwnth2(int value);
    abstract public void write_Range2DownThreshold_s_osa_smp_s_dwnth2(int value);
    abstract public void read_Range2DownThreshold_Range2DownThreshold();
    abstract public void write_Range3UpThreshold_s_osa_smp_p_upth3(int value);
    abstract public void write_Range3UpThreshold_s_osa_smp_s_upth3(int value);
    abstract public void read_Range3UpThreshold_Range3UpThreshold();
    abstract public void write_Range3DownThreshold_s_osa_smp_p_dwnth3(int value);
    abstract public void write_Range3DownThreshold_s_osa_smp_s_dwnth3(int value);
    abstract public void read_Range3DownThreshold_Range3DownThreshold();
    abstract public void write_Range4DownThreshold_s_osa_smp_p_dwnth4(int value);
    abstract public void write_Range4DownThreshold_s_osa_smp_s_dwnth4(int value);
    abstract public void read_Range4DownThreshold_Range4DownThreshold();
    abstract public void write_OSARAMreadflag_d_osa_dpram_rd_flg(int value);
    abstract public void read_OSARAMreadflag_OSARAMreadflag();
    abstract public void write_EEPROM_I2C_OSACalibROM__s_osa_eeprom_cmd3(int value);
    abstract public void write_EEPROM_I2C_OSACalibROM__s_osa_eeprom_cmd2(int value);
    abstract public void write_EEPROM_I2C_OSACalibROM__s_osa_eeprom_cmd1(int value);
    abstract public void write_EEPROM_I2C_OSACalibROM__s_osa_eeprom_cmd0(int value);
    abstract public void write_EEPROM_I2C_OSACalibROM__s_osa_eeprom_wdata(int value);
    abstract public void read_EEPROM_I2C_OSACalibROM__EEPROM_I2C_OSACalibROM_();
    abstract public void write_NewRegister_newbit(int value);
    abstract public void read_NewRegister_NewRegister();
    abstract public void write_OSCControl_Trigger(int value);
    abstract public void write_OSCControl_DataClear(int value);
    abstract public void write_OSCControl_Start_Stop(int value);
    abstract public void read_OSCControl_OSCControl();
    abstract public void write_PPGControl_Start_Stop(int value);
    abstract public void read_PPGControl_PPGControl();
    abstract public void write_EDControl_BitRate(int value);
    abstract public void read_EDControl_EDControl();
    abstract public void write_PPGBitrate_BitRate(int value);
    abstract public void read_PPGBitrate_PPGBitrate();
    abstract public void write_Sinusoidalcalibdata_s_osa_em_sinecalib_u(int value);
    abstract public void write_Sinusoidalcalibdata_s_osa_em_sinecalib_v(int value);
    abstract public void write_Sinusoidalcalibdata_s_osa_em_sinecalib_w(int value);
    abstract public void read_Sinusoidalcalibdata_Sinusoidalcalibdata();
    abstract public void write_OTDRTraceData_OTDRTraceData(int value);
    abstract public void read_OTDRTraceData_OTDRTraceData();
    abstract public void read_OSARAMData_OSARAMData();
	public void writeIo(long address, BitSet data, BitSet mask) {
		if (address == SimRegisterControl.ADDR_INTERRUPTSTATUS) {
		}
		else if (address == SimRegisterControl.ADDR_OTDRTESTCONTROL) {
			if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_OTDRTestControl_TestStart(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_DUMMY) {
		}
		else if (address == SimRegisterControl.ADDR_TEMP_MONITOR) {
		}
		else if (address == SimRegisterControl.ADDR_MOTORDRIVESTART_STOP) {
			if (mask.get(12)) {
				int value = getValue(12, data, mask);
				write_Motordrivestart_stop_s_osa_em_drv_stop_mode(value);
			}
			else if (mask.get(8)) {
				int value = getValue(8, data, mask);
				write_Motordrivestart_stop_s_osa_em_drv_stop(value);
			}
			else if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_Motordrivestart_stop_s_osa_em_drv_start(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_MOTORPOSITION) {
		}
		else if (address == SimRegisterControl.ADDR_TARGETPOSITION) {
			if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_Targetposition_s_osa_em_target_pos(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_TARGETACCELERATION) {
			if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_Targetacceleration_s_osa_em_target_acc_up(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_TARGETACCELERATION_DURINGDECELERATION_) {
			if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_Targetacceleration_Duringdeceleration__s_osa_em_target_acc_dn(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_TARGETVELOCITY) {
			if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_Targetvelocity_s_osa_em_target_vel(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_MAXACCELERATION) {
			if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_Maxacceleration_s_osa_em_max_acc(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_MAXVELOCITY) {
			if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_Maxvelocity_Maxvelocity(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_ENCODERSIGNAL1FORDEBUG2) {
		}
		else if (address == SimRegisterControl.ADDR_ENCODERSIGNAL1FORDEBUG2) {
			if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_Encodersignal1forDebug2_s_osa_em_poscnt_rst(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_PHOTOINTERRUPTERDETECTION) {
			if (mask.get(20)) {
				int value = getValue(20, data, mask);
				write_PhotoInterrupterdetection_s_osa_pi1_edge_sel(value);
			}
			else if (mask.get(16)) {
				int value = getValue(16, data, mask);
				write_PhotoInterrupterdetection_s_osa_pi2_edge_sel(value);
			}
			else if (mask.get(4)) {
				int value = getValue(4, data, mask);
				write_PhotoInterrupterdetection_s_osa_pi1_ignore(value);
			}
			else if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_PhotoInterrupterdetection_s_osa_pi2_ignore(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_MOTORPOSITIONATORIGIN) {
		}
		else if (address == SimRegisterControl.ADDR_MOTORSTEPSATINITIALROTORPOSITION) {
			if (mask.get(16)) {
				int value = getValue(16, data, mask);
				write_Motorstepsatinitialrotorposition_s_osa_em_halledge_sel(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_PIDFILTERRESET) {
			if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_PIDfilterreset_s_osa_em_pid_reset(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_PIDPROPORTIONALITYCOEFFICIENT) {
			if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_PIDProportionalitycoefficient_s_osa_pid_proportion14_0(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_PIDINTEGRALCOEFFICIENT) {
			if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_PIDIntegralcoefficient_s_osa_pid_integration14_0(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_PIDDIFFERENTIALCOEFFICIENT) {
			if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_PIDDifferentialcoefficient_s_osa_pid_differential14_0(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_PIDDIFFSAMPLINGINTERVAL) {
			if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_PIDDiffsamplinginterval_s_osa_pid_diff_interval14_0(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_PIDINTEGRALLIMIT_CLIPPINGBITWIDTH) {
			if (mask.get(16)) {
				int value = getValue(16, data, mask);
				write_PIDIntegrallimit_Clippingbitwidth_s_osa_pid_intv_clip4_0(value);
			}
			else if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_PIDIntegrallimit_Clippingbitwidth_s_osa_pid_int_limit10_0(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_PIDSCALINGFACTOR) {
			if (mask.get(24)) {
				int value = getValue(24, data, mask);
				write_PIDscalingfactor_s_osa_pid_intv_sfactor4_0(value);
			}
			else if (mask.get(16)) {
				int value = getValue(16, data, mask);
				write_PIDscalingfactor_s_osa_em_pid_pr_sfactor5_0(value);
			}
			else if (mask.get(8)) {
				int value = getValue(8, data, mask);
				write_PIDscalingfactor_s_osa_em_pid_int_sfactor5_0(value);
			}
			else if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_PIDscalingfactor_s_osa_em_pid_diff_sfactor5_0(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_MOTORDRIVESETTING) {
			if (mask.get(24)) {
				int value = getValue(24, data, mask);
				write_MotorDrivesetting_s_osa_em_hall_set2_0(value);
			}
			else if (mask.get(20)) {
				int value = getValue(20, data, mask);
				write_MotorDrivesetting_s_osa_em_hall_sel(value);
			}
			else if (mask.get(16)) {
				int value = getValue(16, data, mask);
				write_MotorDrivesetting_s_osa_em_drvpat_sel(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_EMERGENCYTHRESHOLD) {
			if (mask.get(28)) {
				int value = getValue(28, data, mask);
				write_Emergencythreshold_s_osa_em_emergency_ignore(value);
			}
			else if (mask.get(24)) {
				int value = getValue(24, data, mask);
				write_Emergencythreshold_s_osa_em_emergency_intvl(value);
			}
			else if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_Emergencythreshold_s_osa_em_emergency_th17_0(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_HALLSENSORORDER) {
			if (mask.get(4)) {
				int value = getValue(4, data, mask);
				write_Hallsensororder_s_hall_sensor_not(value);
			}
			else if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_Hallsensororder_s_hall_sensor_order2_0(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_PWMMANUALSETTING1) {
			if (mask.get(16)) {
				int value = getValue(16, data, mask);
				write_PWMmanualsetting1_s_osa_pwm_manual_sel(value);
			}
			else if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_PWMmanualsetting1_s_osa_pwm_manual_u9_0(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_PWMMANUALSETTING2) {
			if (mask.get(16)) {
				int value = getValue(16, data, mask);
				write_PWMmanualsetting2_s_osa_pwm_manual_v9_0(value);
			}
			else if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_PWMmanualsetting2_s_osa_pwm_manual_w9_0(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_PWMDUTYLIMITFORDEBUG) {
			if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_PWMdutylimitforDebug_s_osa_pwm_duty_limit10_0(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_EYEDIAGRAM) {
			if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_EyeDiagram_data(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_SAMPLINGSTART) {
			if (mask.get(4)) {
				int value = getValue(4, data, mask);
				write_Samplingstart_s_osa_smp_mode(value);
			}
			else if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_Samplingstart_s_osa_smp_start(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_SAMPLINGSTARTPOSITION) {
			if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_Samplingstartposition_s_osa_smp_start_pos(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_SAMPLINGPOINTNUM) {
			if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_Samplingpointnum_s_osa_smp_num(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_RANGESETTING) {
			if (mask.get(20)) {
				int value = getValue(20, data, mask);
				write_Rangesetting_s_osa_p_init_range(value);
			}
			else if (mask.get(16)) {
				int value = getValue(16, data, mask);
				write_Rangesetting_s_osa_s_init_range(value);
			}
			else if (mask.get(8)) {
				int value = getValue(8, data, mask);
				write_Rangesetting_s_osa_range_manual_sel(value);
			}
			else if (mask.get(4)) {
				int value = getValue(4, data, mask);
				write_Rangesetting_s_osa_p_range_set(value);
			}
			else if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_Rangesetting_s_osa_s_range_set(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_RANGE0OFFSET) {
			if (mask.get(16)) {
				int value = getValue(16, data, mask);
				write_Range0Offset_s_osa_smp_p_offset0(value);
			}
			else if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_Range0Offset_s_osa_smp_s_offset0(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_RANGE1OFFSET) {
			if (mask.get(16)) {
				int value = getValue(16, data, mask);
				write_Range1Offset_s_osa_smp_p_offset1(value);
			}
			else if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_Range1Offset_s_osa_smp_s_offset1(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_RANGE2OFFSET) {
			if (mask.get(16)) {
				int value = getValue(16, data, mask);
				write_Range2Offset_s_osa_smp_p_offset2(value);
			}
			else if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_Range2Offset_s_osa_smp_s_offset2(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_RANGE3OFFSET) {
			if (mask.get(16)) {
				int value = getValue(16, data, mask);
				write_Range3Offset_s_osa_smp_p_offset3(value);
			}
			else if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_Range3Offset_s_osa_smp_s_offset3(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_RANGE4OFFSET) {
			if (mask.get(16)) {
				int value = getValue(16, data, mask);
				write_Range4Offset_s_osa_smp_p_offset4(value);
			}
			else if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_Range4Offset_s_osa_smp_s_offset4(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_RANGE0UPTHRESHOLD) {
			if (mask.get(16)) {
				int value = getValue(16, data, mask);
				write_Range0UpThreshold_s_osa_smp_p_upth0(value);
			}
			else if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_Range0UpThreshold_s_osa_smp_s_upth0(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_RANGE1UPTHRESHOLD) {
			if (mask.get(16)) {
				int value = getValue(16, data, mask);
				write_Range1UpThreshold_s_osa_smp_p_upth1(value);
			}
			else if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_Range1UpThreshold_s_osa_smp_s_upth1(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_RANGE1DOWNTHRESHOLD) {
			if (mask.get(16)) {
				int value = getValue(16, data, mask);
				write_Range1DownThreshold_s_osa_smp_p_dwnth1(value);
			}
			else if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_Range1DownThreshold_s_osa_smp_s_dwnth1(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_RANGE2UPTHRESHOLD) {
			if (mask.get(16)) {
				int value = getValue(16, data, mask);
				write_Range2UpThreshold_s_osa_smp_p_upth2(value);
			}
			else if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_Range2UpThreshold_s_osa_smp_s_upth2(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_RANGE2DOWNTHRESHOLD) {
			if (mask.get(16)) {
				int value = getValue(16, data, mask);
				write_Range2DownThreshold_s_osa_smp_p_dwnth2(value);
			}
			else if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_Range2DownThreshold_s_osa_smp_s_dwnth2(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_RANGE3UPTHRESHOLD) {
			if (mask.get(16)) {
				int value = getValue(16, data, mask);
				write_Range3UpThreshold_s_osa_smp_p_upth3(value);
			}
			else if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_Range3UpThreshold_s_osa_smp_s_upth3(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_RANGE3DOWNTHRESHOLD) {
			if (mask.get(16)) {
				int value = getValue(16, data, mask);
				write_Range3DownThreshold_s_osa_smp_p_dwnth3(value);
			}
			else if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_Range3DownThreshold_s_osa_smp_s_dwnth3(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_RANGE4DOWNTHRESHOLD) {
			if (mask.get(16)) {
				int value = getValue(16, data, mask);
				write_Range4DownThreshold_s_osa_smp_p_dwnth4(value);
			}
			else if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_Range4DownThreshold_s_osa_smp_s_dwnth4(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_OSARAMREADFLAG) {
			if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_OSARAMreadflag_d_osa_dpram_rd_flg(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_EEPROM_I2C_OSACALIBROM_) {
			if (mask.get(11)) {
				int value = getValue(11, data, mask);
				write_EEPROM_I2C_OSACalibROM__s_osa_eeprom_cmd3(value);
			}
			else if (mask.get(10)) {
				int value = getValue(10, data, mask);
				write_EEPROM_I2C_OSACalibROM__s_osa_eeprom_cmd2(value);
			}
			else if (mask.get(9)) {
				int value = getValue(9, data, mask);
				write_EEPROM_I2C_OSACalibROM__s_osa_eeprom_cmd1(value);
			}
			else if (mask.get(8)) {
				int value = getValue(8, data, mask);
				write_EEPROM_I2C_OSACalibROM__s_osa_eeprom_cmd0(value);
			}
			else if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_EEPROM_I2C_OSACalibROM__s_osa_eeprom_wdata(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_NEWREGISTER) {
			if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_NewRegister_newbit(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_OSCCONTROL) {
			if (mask.get(16)) {
				int value = getValue(16, data, mask);
				write_OSCControl_Trigger(value);
			}
			else if (mask.get(4)) {
				int value = getValue(4, data, mask);
				write_OSCControl_DataClear(value);
			}
			else if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_OSCControl_Start_Stop(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_PPGCONTROL) {
			if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_PPGControl_Start_Stop(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_EDCONTROL) {
			if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_EDControl_BitRate(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_PPGBITRATE) {
			if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_PPGBitrate_BitRate(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_SINUSOIDALCALIBDATA) {
			if (mask.get(16)) {
				int value = getValue(16, data, mask);
				write_Sinusoidalcalibdata_s_osa_em_sinecalib_u(value);
			}
			else if (mask.get(8)) {
				int value = getValue(8, data, mask);
				write_Sinusoidalcalibdata_s_osa_em_sinecalib_v(value);
			}
			else if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_Sinusoidalcalibdata_s_osa_em_sinecalib_w(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_OTDRTRACEDATA) {
			if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_OTDRTraceData_OTDRTraceData(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_OSARAMDATA) {
		}
	}
	public void readIo(long address) {
		if (address == SimRegisterControl.ADDR_INTERRUPTSTATUS) {
				read_InterruptStatus_InterruptStatus();
		}
		else if (address == SimRegisterControl.ADDR_OTDRTESTCONTROL) {
				read_OTDRTestControl_OTDRTestControl();
		}
		else if (address == SimRegisterControl.ADDR_DUMMY) {
				read_Dummy_Dummy();
		}
		else if (address == SimRegisterControl.ADDR_TEMP_MONITOR) {
				read_TEMP_MONITOR_TEMP_MONITOR();
		}
		else if (address == SimRegisterControl.ADDR_MOTORDRIVESTART_STOP) {
				read_Motordrivestart_stop_Motordrivestart_stop();
		}
		else if (address == SimRegisterControl.ADDR_MOTORPOSITION) {
				read_MotorPosition_MotorPosition();
		}
		else if (address == SimRegisterControl.ADDR_TARGETPOSITION) {
				read_Targetposition_Targetposition();
		}
		else if (address == SimRegisterControl.ADDR_TARGETACCELERATION) {
				read_Targetacceleration_Targetacceleration();
		}
		else if (address == SimRegisterControl.ADDR_TARGETACCELERATION_DURINGDECELERATION_) {
				read_Targetacceleration_Duringdeceleration__Targetacceleration_Duringdeceleration_();
		}
		else if (address == SimRegisterControl.ADDR_TARGETVELOCITY) {
				read_Targetvelocity_Targetvelocity();
		}
		else if (address == SimRegisterControl.ADDR_MAXACCELERATION) {
				read_Maxacceleration_Maxacceleration();
		}
		else if (address == SimRegisterControl.ADDR_MAXVELOCITY) {
				read_Maxvelocity_Maxvelocity();
		}
		else if (address == SimRegisterControl.ADDR_ENCODERSIGNAL1FORDEBUG2) {
				read_Encodersignal1forDebug1_Encodersignal1forDebug1();
		}
		else if (address == SimRegisterControl.ADDR_ENCODERSIGNAL1FORDEBUG2) {
				read_Encodersignal1forDebug2_Encodersignal1forDebug2();
		}
		else if (address == SimRegisterControl.ADDR_PHOTOINTERRUPTERDETECTION) {
				read_PhotoInterrupterdetection_PhotoInterrupterdetection();
		}
		else if (address == SimRegisterControl.ADDR_MOTORPOSITIONATORIGIN) {
				read_MotorPositionatorigin_MotorPositionatorigin();
		}
		else if (address == SimRegisterControl.ADDR_MOTORSTEPSATINITIALROTORPOSITION) {
				read_Motorstepsatinitialrotorposition_Motorstepsatinitialrotorposition();
		}
		else if (address == SimRegisterControl.ADDR_PIDFILTERRESET) {
				read_PIDfilterreset_PIDfilterreset();
		}
		else if (address == SimRegisterControl.ADDR_PIDPROPORTIONALITYCOEFFICIENT) {
				read_PIDProportionalitycoefficient_PIDProportionalitycoefficient();
		}
		else if (address == SimRegisterControl.ADDR_PIDINTEGRALCOEFFICIENT) {
				read_PIDIntegralcoefficient_PIDIntegralcoefficient();
		}
		else if (address == SimRegisterControl.ADDR_PIDDIFFERENTIALCOEFFICIENT) {
				read_PIDDifferentialcoefficient_PIDDifferentialcoefficient();
		}
		else if (address == SimRegisterControl.ADDR_PIDDIFFSAMPLINGINTERVAL) {
				read_PIDDiffsamplinginterval_PIDDiffsamplinginterval();
		}
		else if (address == SimRegisterControl.ADDR_PIDINTEGRALLIMIT_CLIPPINGBITWIDTH) {
				read_PIDIntegrallimit_Clippingbitwidth_PIDIntegrallimit_Clippingbitwidth();
		}
		else if (address == SimRegisterControl.ADDR_PIDSCALINGFACTOR) {
				read_PIDscalingfactor_PIDscalingfactor();
		}
		else if (address == SimRegisterControl.ADDR_MOTORDRIVESETTING) {
				read_MotorDrivesetting_MotorDrivesetting();
		}
		else if (address == SimRegisterControl.ADDR_EMERGENCYTHRESHOLD) {
				read_Emergencythreshold_Emergencythreshold();
		}
		else if (address == SimRegisterControl.ADDR_HALLSENSORORDER) {
				read_Hallsensororder_Hallsensororder();
		}
		else if (address == SimRegisterControl.ADDR_PWMMANUALSETTING1) {
				read_PWMmanualsetting1_PWMmanualsetting1();
		}
		else if (address == SimRegisterControl.ADDR_PWMMANUALSETTING2) {
				read_PWMmanualsetting2_PWMmanualsetting2();
		}
		else if (address == SimRegisterControl.ADDR_PWMDUTYLIMITFORDEBUG) {
				read_PWMdutylimitforDebug_PWMdutylimitforDebug();
		}
		else if (address == SimRegisterControl.ADDR_EYEDIAGRAM) {
				read_EyeDiagram_EyeDiagram();
		}
		else if (address == SimRegisterControl.ADDR_SAMPLINGSTART) {
				read_Samplingstart_Samplingstart();
		}
		else if (address == SimRegisterControl.ADDR_SAMPLINGSTARTPOSITION) {
				read_Samplingstartposition_Samplingstartposition();
		}
		else if (address == SimRegisterControl.ADDR_SAMPLINGPOINTNUM) {
				read_Samplingpointnum_Samplingpointnum();
		}
		else if (address == SimRegisterControl.ADDR_RANGESETTING) {
				read_Rangesetting_Rangesetting();
		}
		else if (address == SimRegisterControl.ADDR_RANGE0OFFSET) {
				read_Range0Offset_Range0Offset();
		}
		else if (address == SimRegisterControl.ADDR_RANGE1OFFSET) {
				read_Range1Offset_Range1Offset();
		}
		else if (address == SimRegisterControl.ADDR_RANGE2OFFSET) {
				read_Range2Offset_Range2Offset();
		}
		else if (address == SimRegisterControl.ADDR_RANGE3OFFSET) {
				read_Range3Offset_Range3Offset();
		}
		else if (address == SimRegisterControl.ADDR_RANGE4OFFSET) {
				read_Range4Offset_Range4Offset();
		}
		else if (address == SimRegisterControl.ADDR_RANGE0UPTHRESHOLD) {
				read_Range0UpThreshold_Range0UpThreshold();
		}
		else if (address == SimRegisterControl.ADDR_RANGE1UPTHRESHOLD) {
				read_Range1UpThreshold_Range1UpThreshold();
		}
		else if (address == SimRegisterControl.ADDR_RANGE1DOWNTHRESHOLD) {
				read_Range1DownThreshold_Range1DownThreshold();
		}
		else if (address == SimRegisterControl.ADDR_RANGE2UPTHRESHOLD) {
				read_Range2UpThreshold_Range2UpThreshold();
		}
		else if (address == SimRegisterControl.ADDR_RANGE2DOWNTHRESHOLD) {
				read_Range2DownThreshold_Range2DownThreshold();
		}
		else if (address == SimRegisterControl.ADDR_RANGE3UPTHRESHOLD) {
				read_Range3UpThreshold_Range3UpThreshold();
		}
		else if (address == SimRegisterControl.ADDR_RANGE3DOWNTHRESHOLD) {
				read_Range3DownThreshold_Range3DownThreshold();
		}
		else if (address == SimRegisterControl.ADDR_RANGE4DOWNTHRESHOLD) {
				read_Range4DownThreshold_Range4DownThreshold();
		}
		else if (address == SimRegisterControl.ADDR_OSARAMREADFLAG) {
				read_OSARAMreadflag_OSARAMreadflag();
		}
		else if (address == SimRegisterControl.ADDR_EEPROM_I2C_OSACALIBROM_) {
				read_EEPROM_I2C_OSACalibROM__EEPROM_I2C_OSACalibROM_();
		}
		else if (address == SimRegisterControl.ADDR_NEWREGISTER) {
				read_NewRegister_NewRegister();
		}
		else if (address == SimRegisterControl.ADDR_OSCCONTROL) {
				read_OSCControl_OSCControl();
		}
		else if (address == SimRegisterControl.ADDR_PPGCONTROL) {
				read_PPGControl_PPGControl();
		}
		else if (address == SimRegisterControl.ADDR_EDCONTROL) {
				read_EDControl_EDControl();
		}
		else if (address == SimRegisterControl.ADDR_PPGBITRATE) {
				read_PPGBitrate_PPGBitrate();
		}
		else if (address == SimRegisterControl.ADDR_SINUSOIDALCALIBDATA) {
				read_Sinusoidalcalibdata_Sinusoidalcalibdata();
		}
		else if (address == SimRegisterControl.ADDR_OTDRTRACEDATA) {
				read_OTDRTraceData_OTDRTraceData();
		}
		else if (address == SimRegisterControl.ADDR_OSARAMDATA) {
				read_OSARAMData_OSARAMData();
		}
	}
}
