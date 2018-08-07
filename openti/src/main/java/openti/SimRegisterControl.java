package openti;
import jp.silverbullet.handlers.RegisterAccess;
import jp.silverbullet.handlers.InterruptHandler;
import javafx.application.Platform;
public class SimRegisterControl {
    public static int ADDR_INTERRUPTSTATUS = 0x0010;
    public static int BIT_INTERRUPTSTATUS_INTR_STATE_NEXT_BOARD = 28;
    public static int BIT_INTERRUPTSTATUS_INTER_STATE_OSA_LDCUR = 20;
    public static int BIT_INTERRUPTSTATUS_INTER_STATE_OSA_EMERGE = 16;
    public static int BIT_INTERRUPTSTATUS_INTER_STATE_OSA_EM = 12;
    public static int BIT_INTERRUPTSTATUS_INTR_STATE_OSA_MEAS = 8;
    public static int BIT_INTERRUPTSTATUS_INTER_STATE_OSA_PI1 = 4;
    public static int BIT_INTERRUPTSTATUS_INTR_STATE_OSA_PI2 = 0;
    public static int ADDR_OTDRTESTCONTROL = 0x0011;
    public static int BIT_OTDRTESTCONTROL_TESTSTART = 0;
    public static int ADDR_DUMMY = 0x12;
    public static int ADDR_TEMP_MONITOR = 0x0084;
    public static int BIT_TEMP_MONITOR_D_TEMP_ALARM = 28;
    public static int ADDR_MOTORDRIVESTART_STOP = 0x0400;
    public static int BIT_MOTORDRIVESTART_STOP_D_OSA_EM_DRV_END = 20;
    public static int BIT_MOTORDRIVESTART_STOP_D_OSA_EM_DRV_BUSY = 16;
    public static int BIT_MOTORDRIVESTART_STOP_S_OSA_EM_DRV_STOP_MODE = 12;
    public static int BIT_MOTORDRIVESTART_STOP_S_OSA_EM_DRV_STOP = 8;
    public static int BIT_MOTORDRIVESTART_STOP_S_OSA_EM_DRV_START = 0;
    public static int ADDR_MOTORPOSITION = 0x0401;
    public static int ADDR_TARGETPOSITION = 0x0402;
    public static int ADDR_TARGETACCELERATION = 0x0403;
    public static int ADDR_TARGETACCELERATION_DURINGDECELERATION_ = 0x0404;
    public static int ADDR_TARGETVELOCITY = 0x0405;
    public static int ADDR_MAXACCELERATION = 0x0406;
    public static int ADDR_MAXVELOCITY = 0x0407;
    public static int ADDR_ENCODERSIGNAL1FORDEBUG1 = 0x0420;
    public static int ADDR_ENCODERSIGNAL1FORDEBUG2 = 0x0420;
    public static int BIT_ENCODERSIGNAL1FORDEBUG2_D_OSA_EM_PHASE_ERR = 28;
    public static int BIT_ENCODERSIGNAL1FORDEBUG2_S_OSA_EM_POSCNT_RST = 0;
    public static int ADDR_PHOTOINTERRUPTERDETECTION = 0x0424;
    public static int BIT_PHOTOINTERRUPTERDETECTION_D_OSA_PI1_DET = 28;
    public static int BIT_PHOTOINTERRUPTERDETECTION_D_OSA_PI2_DET = 24;
    public static int BIT_PHOTOINTERRUPTERDETECTION_S_OSA_PI1_EDGE_SEL = 20;
    public static int BIT_PHOTOINTERRUPTERDETECTION_S_OSA_PI2_EDGE_SEL = 16;
    public static int BIT_PHOTOINTERRUPTERDETECTION_S_OSA_PI1_IGNORE = 4;
    public static int BIT_PHOTOINTERRUPTERDETECTION_S_OSA_PI2_IGNORE = 0;
    public static int ADDR_MOTORPOSITIONATORIGIN = 0x0425;
    public static int ADDR_MOTORSTEPSATINITIALROTORPOSITION = 0x0426;
    public static int BIT_MOTORSTEPSATINITIALROTORPOSITION_S_OSA_EM_HALLEDGE_SEL = 16;
    public static int ADDR_PIDFILTERRESET = 0x0440;
    public static int BIT_PIDFILTERRESET_S_OSA_EM_PID_RESET = 0;
    public static int ADDR_PIDPROPORTIONALITYCOEFFICIENT = 0x0444;
    public static int ADDR_PIDINTEGRALCOEFFICIENT = 0x0445;
    public static int ADDR_PIDDIFFERENTIALCOEFFICIENT = 0x0446;
    public static int ADDR_PIDDIFFSAMPLINGINTERVAL = 0x0447;
    public static int ADDR_PIDINTEGRALLIMIT_CLIPPINGBITWIDTH = 0x0448;
    public static int ADDR_PIDSCALINGFACTOR = 0x0449;
    public static int ADDR_MOTORDRIVESETTING = 0x0460;
    public static int BIT_MOTORDRIVESETTING_S_OSA_EM_HALL_SEL = 20;
    public static int BIT_MOTORDRIVESETTING_S_OSA_EM_DRVPAT_SEL = 16;
    public static int BIT_MOTORDRIVESETTING_D_HALL_1 = 8;
    public static int BIT_MOTORDRIVESETTING_D_HALL_2 = 4;
    public static int BIT_MOTORDRIVESETTING_D_HALL_3 = 0;
    public static int ADDR_EMERGENCYTHRESHOLD = 0x0461;
    public static int BIT_EMERGENCYTHRESHOLD_S_OSA_EM_EMERGENCY_IGNORE = 28;
    public static int BIT_EMERGENCYTHRESHOLD_S_OSA_EM_EMERGENCY_INTVL = 24;
    public static int ADDR_HALLSENSORORDER = 0x0462;
    public static int BIT_HALLSENSORORDER_S_HALL_SENSOR_NOT = 4;
    public static int ADDR_PWMMANUALSETTING1 = 0x0463;
    public static int BIT_PWMMANUALSETTING1_S_OSA_PWM_MANUAL_SEL = 16;
    public static int ADDR_PWMMANUALSETTING2 = 0x0464;
    public static int ADDR_PWMDUTYLIMITFORDEBUG = 0x0465;
    public static int ADDR_EYEDIAGRAM = 0x1000;
    public static int ADDR_SAMPLINGSTART = 0x1400;
    public static int BIT_SAMPLINGSTART_S_OSA_SMP_MODE = 4;
    public static int BIT_SAMPLINGSTART_S_OSA_SMP_START = 0;
    public static int ADDR_SAMPLINGSTARTPOSITION = 0x1401;
    public static int ADDR_SAMPLINGPOINTNUM = 0x1402;
    public static int ADDR_RANGESETTING = 0x1420;
    public static int BIT_RANGESETTING_S_OSA_RANGE_MANUAL_SEL = 8;
    public static int ADDR_RANGE0OFFSET = 0x1440;
    public static int ADDR_RANGE1OFFSET = 0x1441;
    public static int ADDR_RANGE2OFFSET = 0x1442;
    public static int ADDR_RANGE3OFFSET = 0x1443;
    public static int ADDR_RANGE4OFFSET = 0x1444;
    public static int ADDR_RANGE0UPTHRESHOLD = 0x1460;
    public static int ADDR_RANGE1UPTHRESHOLD = 0x1462;
    public static int ADDR_RANGE1DOWNTHRESHOLD = 0x1463;
    public static int ADDR_RANGE2UPTHRESHOLD = 0x1464;
    public static int ADDR_RANGE2DOWNTHRESHOLD = 0x1465;
    public static int ADDR_RANGE3UPTHRESHOLD = 0x1466;
    public static int ADDR_RANGE3DOWNTHRESHOLD = 0x1467;
    public static int ADDR_RANGE4DOWNTHRESHOLD = 0x1469;
    public static int ADDR_OSARAMREADFLAG = 0x1480;
    public static int BIT_OSARAMREADFLAG_D_OSA_DPRAM_RD_FLG = 0;
    public static int ADDR_EEPROM_I2C_OSACALIBROM_ = 0x1600;
    public static int BIT_EEPROM_I2C_OSACALIBROM__S_OSA_EEPROM_CMD3 = 11;
    public static int BIT_EEPROM_I2C_OSACALIBROM__S_OSA_EEPROM_CMD2 = 10;
    public static int BIT_EEPROM_I2C_OSACALIBROM__S_OSA_EEPROM_CMD1 = 9;
    public static int BIT_EEPROM_I2C_OSACALIBROM__S_OSA_EEPROM_CMD0 = 8;
    public static int ADDR_NEWREGISTER = 0x1601;
    public static int ADDR_OSCCONTROL = 0x3000;
    public static int ADDR_PPGCONTROL = 0x3004;
    public static int ADDR_EDCONTROL = 0x3008;
    public static int ADDR_PPGBITRATE = 0x3010;
    public static int ADDR_SINUSOIDALCALIBDATA = 0x03FFC;
    public static int ADDR_OTDRTRACEDATA = 0x7000;
    public static int ADDR_OSARAMDATA = 0x8000;
    private RegisterAccess registerAccess = null;
    public RegisterAccess getRegisterAccess() {
    	return registerAccess;
    }
    public SimRegisterControl(RegisterAccess registerAccess2) {
         this.registerAccess = registerAccess2;
    }
    private Object lock = new Object();
    public void waitIntrrupt() {
    InterruptHandler interruptHandler = new InterruptHandler() {
        @Override
        public void onTrigger() {
            synchronized(lock) {
    	        lock.notifyAll();
            }
        }  
    };
    this.registerAccess.addInterruptHandler(interruptHandler);
    try {
       synchronized(lock) {
           lock.wait();
           Platform.runLater(new Runnable() {
              @Override
              public void run() {
           	   registerAccess.removeInteruptHandler(interruptHandler);
              }
           });
      }
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    }
    public class InterruptStatus{
    /**
    *   Interrupt from next board in stack:
    **/
        public boolean get_Intr_state_next_board() {
    	    return readIoBoolean(ADDR_INTERRUPTSTATUS, 28);
        }
    /**
    *   Interrupt from next board in stack:
    **/
        public void set_Intr_state_next_board(boolean value) {
            writeIo(ADDR_INTERRUPTSTATUS, value, 28);
        }
    /**
    *   Interrupt from OSA block: LD過電流、自動消灯
    **/
        public boolean get_Inter_state_osa_ldcur() {
    	    return readIoBoolean(ADDR_INTERRUPTSTATUS, 20);
        }
    /**
    *   Interrupt from OSA block: LD過電流、自動消灯
    **/
        public void set_Inter_state_osa_ldcur(boolean value) {
            writeIo(ADDR_INTERRUPTSTATUS, value, 20);
        }
    /**
    *   Interrupt from OSA block: モータ暴走、緊急停止
    **/
        public boolean get_Inter_state_osa_emerge() {
    	    return readIoBoolean(ADDR_INTERRUPTSTATUS, 16);
        }
    /**
    *   Interrupt from OSA block: モータ暴走、緊急停止
    **/
        public void set_Inter_state_osa_emerge(boolean value) {
            writeIo(ADDR_INTERRUPTSTATUS, value, 16);
        }
    /**
    *   Interrupt from OSA block: モータ移動完了
    **/
        public boolean get_Inter_state_osa_em() {
    	    return readIoBoolean(ADDR_INTERRUPTSTATUS, 12);
        }
    /**
    *   Interrupt from OSA block: モータ移動完了
    **/
        public void set_Inter_state_osa_em(boolean value) {
            writeIo(ADDR_INTERRUPTSTATUS, value, 12);
        }
    /**
    *   Interrupt from OSA block: 測定データリード要求
    **/
        public boolean get_Intr_state_osa_meas() {
    	    return readIoBoolean(ADDR_INTERRUPTSTATUS, 8);
        }
    /**
    *   Interrupt from OSA block: 測定データリード要求
    **/
        public void set_Intr_state_osa_meas(boolean value) {
            writeIo(ADDR_INTERRUPTSTATUS, value, 8);
        }
    /**
    *   Interrupt from OSA block: フォトインタラプタ1割り込み
    **/
        public boolean get_Inter_state_osa_pi1() {
    	    return readIoBoolean(ADDR_INTERRUPTSTATUS, 4);
        }
    /**
    *   Interrupt from OSA block: フォトインタラプタ1割り込み
    **/
        public void set_Inter_state_osa_pi1(boolean value) {
            writeIo(ADDR_INTERRUPTSTATUS, value, 4);
        }
    /**
    *   Interrupt from OSA block: フォトインタラプタ2割り込み
    **/
        public boolean get_Intr_state_osa_pi2() {
    	    return readIoBoolean(ADDR_INTERRUPTSTATUS, 0);
        }
    /**
    *   Interrupt from OSA block: フォトインタラプタ2割り込み
    **/
        public void set_Intr_state_osa_pi2(boolean value) {
            writeIo(ADDR_INTERRUPTSTATUS, value, 0);
        }
    }
    public InterruptStatus interruptStatus = new InterruptStatus();
    public class OtdrTestControl{
    /**
    *   new bit
    **/
        public boolean get_TestStart() {
    	    return readIoBoolean(ADDR_OTDRTESTCONTROL, 0);
        }
    /**
    *   new bit
    **/
        public void set_TestStart(boolean value) {
            writeIo(ADDR_OTDRTESTCONTROL, value, 0);
        }
    }
    public OtdrTestControl otdrTestControl = new OtdrTestControl();
    public class Dummy{
    }
    public Dummy dummy = new Dummy();
    public class TempMonitor{
    /**
    *   温度アラーム表示(FPGA処理)
    **/
        public boolean get_d_temp_alarm() {
    	    return readIoBoolean(ADDR_TEMP_MONITOR, 28);
        }
    /**
    *   温度アラーム表示(FPGA処理)
    **/
        public void set_d_temp_alarm(boolean value) {
            writeIo(ADDR_TEMP_MONITOR, value, 28);
        }
    /**
    *   温度センサの読み値
    *   read_data[13:0] X 0.03125 [degC]負数は2の補数表現となる。
    **/
        public float get_d_temp_data() {
    	    return readIoInteger(ADDR_TEMP_MONITOR, 12,0);
        }
    /**
    *   温度センサの読み値
    *   read_data[13:0] X 0.03125 [degC]負数は2の補数表現となる。
    **/
        public void set_d_temp_data(float value) {
            writeIo(ADDR_TEMP_MONITOR, value, 0, 12);
        }
    }
    public TempMonitor tempMonitor = new TempMonitor();
    public class MotorDriveStartStop{
    /**
    *   エンコーダモータ移動完了ステータス
    *   割り込みと同時に1に遷移するが、
    *   割り込みクリアされても値を保持する。
    *   次の駆動スタート時にクリアされる。
    **/
        public boolean get_d_osa_em_drv_end() {
    	    return readIoBoolean(ADDR_MOTORDRIVESTART_STOP, 20);
        }
    /**
    *   エンコーダモータ移動完了ステータス
    *   割り込みと同時に1に遷移するが、
    *   割り込みクリアされても値を保持する。
    *   次の駆動スタート時にクリアされる。
    **/
        public void set_d_osa_em_drv_end(boolean value) {
            writeIo(ADDR_MOTORDRIVESTART_STOP, value, 20);
        }
    /**
    *   エンコーダモータ駆動中ステータス
    **/
        public boolean get_d_osa_em_drv_busy() {
    	    return readIoBoolean(ADDR_MOTORDRIVESTART_STOP, 16);
        }
    /**
    *   エンコーダモータ駆動中ステータス
    **/
        public void set_d_osa_em_drv_busy(boolean value) {
            writeIo(ADDR_MOTORDRIVESTART_STOP, value, 16);
        }
    /**
    *   エンコーダモータ駆動停止方法(マニュアル)
    **/
        public boolean get_s_osa_em_drv_stop_mode() {
    	    return readIoBoolean(ADDR_MOTORDRIVESTART_STOP, 12);
        }
    /**
    *   エンコーダモータ駆動停止方法(マニュアル)
    **/
        public void set_s_osa_em_drv_stop_mode(boolean value) {
            writeIo(ADDR_MOTORDRIVESTART_STOP, value, 12);
        }
    /**
    *   エンコーダモータ駆動停止(マニュアル)
    **/
        public boolean get_s_osa_em_drv_stop() {
    	    return readIoBoolean(ADDR_MOTORDRIVESTART_STOP, 8);
        }
    /**
    *   エンコーダモータ駆動停止(マニュアル)
    **/
        public void set_s_osa_em_drv_stop(boolean value) {
            writeIo(ADDR_MOTORDRIVESTART_STOP, value, 8);
        }
    /**
    *   エンコーダモータ駆動スタート。
    *   0→1の遷移でモータ駆動を開始する。
    *   駆動終了時にFPGAがセルフクリアする。
    **/
        public boolean get_s_osa_em_drv_start() {
    	    return readIoBoolean(ADDR_MOTORDRIVESTART_STOP, 0);
        }
    /**
    *   エンコーダモータ駆動スタート。
    *   0→1の遷移でモータ駆動を開始する。
    *   駆動終了時にFPGAがセルフクリアする。
    **/
        public void set_s_osa_em_drv_start(boolean value) {
            writeIo(ADDR_MOTORDRIVESTART_STOP, value, 0);
        }
    }
    public MotorDriveStartStop motorDriveStartStop = new MotorDriveStartStop();
    public class MotorPosition{
    /**
    *   エンコーダモータ現在位置
    **/
        public int get_d_osa_em_pos() {
    	    return readIoInteger(ADDR_MOTORPOSITION, 19,0);
        }
    /**
    *   エンコーダモータ現在位置
    **/
        public void set_d_osa_em_pos(int value) {
            writeIo(ADDR_MOTORPOSITION, value, 0, 19);
        }
    }
    public MotorPosition motorPosition = new MotorPosition();
    public class TargetPosition{
    /**
    *   エンコーダモータ最終目標位置設定設定範囲：
    *   1(h) – 1F_FFFF(h), +/-1,048,575
    **/
        public int get_s_osa_em_target_pos() {
    	    return readIoInteger(ADDR_TARGETPOSITION, 19,0);
        }
    /**
    *   エンコーダモータ最終目標位置設定設定範囲：
    *   1(h) – 1F_FFFF(h), +/-1,048,575
    **/
        public void set_s_osa_em_target_pos(int value) {
            writeIo(ADDR_TARGETPOSITION, value, 0, 19);
        }
    }
    public TargetPosition targetPosition = new TargetPosition();
    public class TargetAcceleration{
    /**
    *   エンコーダモータ目標加速度 (加速時)
    **/
        public int get_s_osa_em_target_acc_up() {
    	    return readIoInteger(ADDR_TARGETACCELERATION, 30,0);
        }
    /**
    *   エンコーダモータ目標加速度 (加速時)
    **/
        public void set_s_osa_em_target_acc_up(int value) {
            writeIo(ADDR_TARGETACCELERATION, value, 0, 30);
        }
    }
    public TargetAcceleration targetAcceleration = new TargetAcceleration();
    public class TargetAccelerationDuringDeceleration{
    /**
    *   エンコーダモータ目標加速度 (減速時)
    *   設定範囲：0(d) – 1,073,741,823(d)  /216/sample2
    **/
        public int get_s_osa_em_target_acc_dn() {
    	    return readIoInteger(ADDR_TARGETACCELERATION_DURINGDECELERATION_, 30,0);
        }
    /**
    *   エンコーダモータ目標加速度 (減速時)
    *   設定範囲：0(d) – 1,073,741,823(d)  /216/sample2
    **/
        public void set_s_osa_em_target_acc_dn(int value) {
            writeIo(ADDR_TARGETACCELERATION_DURINGDECELERATION_, value, 0, 30);
        }
    }
    public TargetAccelerationDuringDeceleration targetAccelerationDuringDeceleration = new TargetAccelerationDuringDeceleration();
    public class TargetVelocity{
    /**
    *   エンコーダモータ目標速度
    *   設定範囲：0(d) – 1,073,741,823(d)  /216/sample
    **/
        public int get_s_osa_em_target_vel() {
    	    return readIoInteger(ADDR_TARGETVELOCITY, 30,0);
        }
    /**
    *   エンコーダモータ目標速度
    *   設定範囲：0(d) – 1,073,741,823(d)  /216/sample
    **/
        public void set_s_osa_em_target_vel(int value) {
            writeIo(ADDR_TARGETVELOCITY, value, 0, 30);
        }
    }
    public TargetVelocity targetVelocity = new TargetVelocity();
    public class MaxAcceleration{
    /**
    *   エンコーダモータ最大加速度
    *   設定範囲：0(d) – 1,073,741,823(d)  /216/sample2
    **/
        public int get_s_osa_em_max_acc() {
    	    return readIoInteger(ADDR_MAXACCELERATION, 30,0);
        }
    /**
    *   エンコーダモータ最大加速度
    *   設定範囲：0(d) – 1,073,741,823(d)  /216/sample2
    **/
        public void set_s_osa_em_max_acc(int value) {
            writeIo(ADDR_MAXACCELERATION, value, 0, 30);
        }
    }
    public MaxAcceleration maxAcceleration = new MaxAcceleration();
    public class MaxVelocity{
    /**
    *   エンコーダモータ最大速度
    *   設定範囲：0(d) – 1,073,741,823(d)  /216/sample
    **/
        public int get_Maxvelocity() {
    	    return readIoInteger(ADDR_MAXVELOCITY, 30,0);
        }
    /**
    *   エンコーダモータ最大速度
    *   設定範囲：0(d) – 1,073,741,823(d)  /216/sample
    **/
        public void set_Maxvelocity(int value) {
            writeIo(ADDR_MAXVELOCITY, value, 0, 30);
        }
    }
    public MaxVelocity maxVelocity = new MaxVelocity();
    public class EncoderSignal1ForDebug1{
    }
    public EncoderSignal1ForDebug1 encoderSignal1ForDebug1 = new EncoderSignal1ForDebug1();
    public class EncoderSignal1ForDebug2{
    /**
    *   エンコーダ位相パターンエラー ステータス
    **/
        public boolean get_d_osa_em_phase_err() {
    	    return readIoBoolean(ADDR_ENCODERSIGNAL1FORDEBUG2, 28);
        }
    /**
    *   エンコーダ位相パターンエラー ステータス
    **/
        public void set_d_osa_em_phase_err(boolean value) {
            writeIo(ADDR_ENCODERSIGNAL1FORDEBUG2, value, 28);
        }
    /**
    *   エンコーダ位相パターンエラー カウント
    *   モータ駆動中のエラー発生回数
    *   駆動スタートで0クリア
    **/
        public int get_d_osa_em_phaseerr_cnt() {
    	    return readIoInteger(ADDR_ENCODERSIGNAL1FORDEBUG2, 22,16);
        }
    /**
    *   エンコーダ位相パターンエラー カウント
    *   モータ駆動中のエラー発生回数
    *   駆動スタートで0クリア
    **/
        public void set_d_osa_em_phaseerr_cnt(int value) {
            writeIo(ADDR_ENCODERSIGNAL1FORDEBUG2, value, 16, 22);
        }
    /**
    *   モータ位置情報カウンタリセット (全bitクリア)
    **/
        public boolean get_s_osa_em_poscnt_rst() {
    	    return readIoBoolean(ADDR_ENCODERSIGNAL1FORDEBUG2, 0);
        }
    /**
    *   モータ位置情報カウンタリセット (全bitクリア)
    **/
        public void set_s_osa_em_poscnt_rst(boolean value) {
            writeIo(ADDR_ENCODERSIGNAL1FORDEBUG2, value, 0);
        }
    }
    public EncoderSignal1ForDebug2 encoderSignal1ForDebug2 = new EncoderSignal1ForDebug2();
    public class PhotoInterrupterDetection{
    /**
    *   フォトインタラプタ1検出状態
    **/
        public boolean get_d_osa_pi1_det() {
    	    return readIoBoolean(ADDR_PHOTOINTERRUPTERDETECTION, 28);
        }
    /**
    *   フォトインタラプタ1検出状態
    **/
        public void set_d_osa_pi1_det(boolean value) {
            writeIo(ADDR_PHOTOINTERRUPTERDETECTION, value, 28);
        }
    /**
    *   フォトインタラプタ2検出状態
    **/
        public boolean get_d_osa_pi2_det() {
    	    return readIoBoolean(ADDR_PHOTOINTERRUPTERDETECTION, 24);
        }
    /**
    *   フォトインタラプタ2検出状態
    **/
        public void set_d_osa_pi2_det(boolean value) {
            writeIo(ADDR_PHOTOINTERRUPTERDETECTION, value, 24);
        }
    /**
    *   フォトインタラプタ1 検出エッジ
    **/
        public boolean get_s_osa_pi1_edge_sel() {
    	    return readIoBoolean(ADDR_PHOTOINTERRUPTERDETECTION, 20);
        }
    /**
    *   フォトインタラプタ1 検出エッジ
    **/
        public void set_s_osa_pi1_edge_sel(boolean value) {
            writeIo(ADDR_PHOTOINTERRUPTERDETECTION, value, 20);
        }
    /**
    *   フォトインタラプタ2 検出エッジ
    **/
        public boolean get_s_osa_pi2_edge_sel() {
    	    return readIoBoolean(ADDR_PHOTOINTERRUPTERDETECTION, 16);
        }
    /**
    *   フォトインタラプタ2 検出エッジ
    **/
        public void set_s_osa_pi2_edge_sel(boolean value) {
            writeIo(ADDR_PHOTOINTERRUPTERDETECTION, value, 16);
        }
    /**
    *   フォトインタラプタ1 無効化
    **/
        public boolean get_s_osa_pi1_ignore() {
    	    return readIoBoolean(ADDR_PHOTOINTERRUPTERDETECTION, 4);
        }
    /**
    *   フォトインタラプタ1 無効化
    **/
        public void set_s_osa_pi1_ignore(boolean value) {
            writeIo(ADDR_PHOTOINTERRUPTERDETECTION, value, 4);
        }
    /**
    *   フォトインタラプタ2 無効化
    **/
        public boolean get_s_osa_pi2_ignore() {
    	    return readIoBoolean(ADDR_PHOTOINTERRUPTERDETECTION, 0);
        }
    /**
    *   フォトインタラプタ2 無効化
    **/
        public void set_s_osa_pi2_ignore(boolean value) {
            writeIo(ADDR_PHOTOINTERRUPTERDETECTION, value, 0);
        }
    }
    public PhotoInterrupterDetection photoInterrupterDetection = new PhotoInterrupterDetection();
    public class MotorPositionAtOrigin{
    /**
    *   原点位置 エンコーダモータカウント値
    **/
        public int get_d_osa_em_origin_pos20_0() {
    	    return readIoInteger(ADDR_MOTORPOSITIONATORIGIN, 19,0);
        }
    /**
    *   原点位置 エンコーダモータカウント値
    **/
        public void set_d_osa_em_origin_pos20_0(int value) {
            writeIo(ADDR_MOTORPOSITIONATORIGIN, value, 0, 19);
        }
    }
    public MotorPositionAtOrigin motorPositionAtOrigin = new MotorPositionAtOrigin();
    public class MotorStepsAtInitialRotorPosition{
    /**
    *   ロータ初期位置のホールセンサ信号検出エッジ
    **/
        public boolean get_s_osa_em_halledge_sel() {
    	    return readIoBoolean(ADDR_MOTORSTEPSATINITIALROTORPOSITION, 16);
        }
    /**
    *   ロータ初期位置のホールセンサ信号検出エッジ
    **/
        public void set_s_osa_em_halledge_sel(boolean value) {
            writeIo(ADDR_MOTORSTEPSATINITIALROTORPOSITION, value, 16);
        }
    /**
    *   ロータ初期位置(0°) モータステップ数
    **/
        public int get_d_osa_em_initrotor_pos10_0() {
    	    return readIoInteger(ADDR_MOTORSTEPSATINITIALROTORPOSITION, 9,0);
        }
    /**
    *   ロータ初期位置(0°) モータステップ数
    **/
        public void set_d_osa_em_initrotor_pos10_0(int value) {
            writeIo(ADDR_MOTORSTEPSATINITIALROTORPOSITION, value, 0, 9);
        }
    }
    public MotorStepsAtInitialRotorPosition motorStepsAtInitialRotorPosition = new MotorStepsAtInitialRotorPosition();
    public class PidFilterReset{
    /**
    *   PIDフィルタ リセット
    **/
        public boolean get_s_osa_em_pid_reset() {
    	    return readIoBoolean(ADDR_PIDFILTERRESET, 0);
        }
    /**
    *   PIDフィルタ リセット
    **/
        public void set_s_osa_em_pid_reset(boolean value) {
            writeIo(ADDR_PIDFILTERRESET, value, 0);
        }
    }
    public PidFilterReset pidFilterReset = new PidFilterReset();
    public class PidProportionalityCoefficient{
    /**
    *   PIDフィルタ 比例係数
    **/
        public int get_s_osa_pid_proportion14_0() {
    	    return readIoInteger(ADDR_PIDPROPORTIONALITYCOEFFICIENT, 13,0);
        }
    /**
    *   PIDフィルタ 比例係数
    **/
        public void set_s_osa_pid_proportion14_0(int value) {
            writeIo(ADDR_PIDPROPORTIONALITYCOEFFICIENT, value, 0, 13);
        }
    }
    public PidProportionalityCoefficient pidProportionalityCoefficient = new PidProportionalityCoefficient();
    public class PidIntegralCoefficient{
    /**
    *   PIDフィルタ 積分係数
    **/
        public int get_s_osa_pid_integration14_0() {
    	    return readIoInteger(ADDR_PIDINTEGRALCOEFFICIENT, 13,0);
        }
    /**
    *   PIDフィルタ 積分係数
    **/
        public void set_s_osa_pid_integration14_0(int value) {
            writeIo(ADDR_PIDINTEGRALCOEFFICIENT, value, 0, 13);
        }
    }
    public PidIntegralCoefficient pidIntegralCoefficient = new PidIntegralCoefficient();
    public class PidDifferentialCoefficient{
    /**
    *   PIDフィルタ 微分係数
    **/
        public int get_s_osa_pid_differential14_0() {
    	    return readIoInteger(ADDR_PIDDIFFERENTIALCOEFFICIENT, 13,0);
        }
    /**
    *   PIDフィルタ 微分係数
    **/
        public void set_s_osa_pid_differential14_0(int value) {
            writeIo(ADDR_PIDDIFFERENTIALCOEFFICIENT, value, 0, 13);
        }
    }
    public PidDifferentialCoefficient pidDifferentialCoefficient = new PidDifferentialCoefficient();
    public class PidDiffSamplingInterval{
    /**
    *   PIDフィルタ 微分サンプリング間隔
    **/
        public int get_s_osa_pid_diff_interval14_0() {
    	    return readIoInteger(ADDR_PIDDIFFSAMPLINGINTERVAL, 13,0);
        }
    /**
    *   PIDフィルタ 微分サンプリング間隔
    **/
        public void set_s_osa_pid_diff_interval14_0(int value) {
            writeIo(ADDR_PIDDIFFSAMPLINGINTERVAL, value, 0, 13);
        }
    }
    public PidDiffSamplingInterval pidDiffSamplingInterval = new PidDiffSamplingInterval();
    public class PidIntegralLimitClippingBitWidth{
    /**
    *    PIDフィルタ 積分値計算ビット幅
    **/
        public int get_s_osa_pid_intv_clip4_0() {
    	    return readIoInteger(ADDR_PIDINTEGRALLIMIT_CLIPPINGBITWIDTH, 19,16);
        }
    /**
    *    PIDフィルタ 積分値計算ビット幅
    **/
        public void set_s_osa_pid_intv_clip4_0(int value) {
            writeIo(ADDR_PIDINTEGRALLIMIT_CLIPPINGBITWIDTH, value, 16, 19);
        }
    /**
    *   PIDフィルタ 積分項リミット値
    **/
        public int get_s_osa_pid_int_limit10_0() {
    	    return readIoInteger(ADDR_PIDINTEGRALLIMIT_CLIPPINGBITWIDTH, 9,0);
        }
    /**
    *   PIDフィルタ 積分項リミット値
    **/
        public void set_s_osa_pid_int_limit10_0(int value) {
            writeIo(ADDR_PIDINTEGRALLIMIT_CLIPPINGBITWIDTH, value, 0, 9);
        }
    }
    public PidIntegralLimitClippingBitWidth pidIntegralLimitClippingBitWidth = new PidIntegralLimitClippingBitWidth();
    public class PidScalingFactor{
    /**
    *   PIDフィルタ 積分値計算スケーリングファクタ
    **/
        public int get_s_osa_pid_intv_sfactor4_0() {
    	    return readIoInteger(ADDR_PIDSCALINGFACTOR, 27,24);
        }
    /**
    *   PIDフィルタ 積分値計算スケーリングファクタ
    **/
        public void set_s_osa_pid_intv_sfactor4_0(int value) {
            writeIo(ADDR_PIDSCALINGFACTOR, value, 24, 27);
        }
    /**
    *   PIDフィルタ 比例項計算スケーリングファクタ
    **/
        public int get_s_osa_em_pid_pr_sfactor5_0() {
    	    return readIoInteger(ADDR_PIDSCALINGFACTOR, 20,16);
        }
    /**
    *   PIDフィルタ 比例項計算スケーリングファクタ
    **/
        public void set_s_osa_em_pid_pr_sfactor5_0(int value) {
            writeIo(ADDR_PIDSCALINGFACTOR, value, 16, 20);
        }
    /**
    *   PIDフィルタ 積分項計算スケーリングファクタ
    **/
        public int get_s_osa_em_pid_int_sfactor5_0() {
    	    return readIoInteger(ADDR_PIDSCALINGFACTOR, 12,8);
        }
    /**
    *   PIDフィルタ 積分項計算スケーリングファクタ
    **/
        public void set_s_osa_em_pid_int_sfactor5_0(int value) {
            writeIo(ADDR_PIDSCALINGFACTOR, value, 8, 12);
        }
    /**
    *   PIDフィルタ 微分項計算スケーリングファクタ
    **/
        public int get_s_osa_em_pid_diff_sfactor5_0() {
    	    return readIoInteger(ADDR_PIDSCALINGFACTOR, 4,0);
        }
    /**
    *   PIDフィルタ 微分項計算スケーリングファクタ
    **/
        public void set_s_osa_em_pid_diff_sfactor5_0(int value) {
            writeIo(ADDR_PIDSCALINGFACTOR, value, 0, 4);
        }
    }
    public PidScalingFactor pidScalingFactor = new PidScalingFactor();
    public class MotorDriveSetting{
    /**
    *   ホールセンサ マニュアル設定値
    **/
        public int get_s_osa_em_hall_set2_0() {
    	    return readIoInteger(ADDR_MOTORDRIVESETTING, 25,24);
        }
    /**
    *   ホールセンサ マニュアル設定値
    **/
        public void set_s_osa_em_hall_set2_0(int value) {
            writeIo(ADDR_MOTORDRIVESETTING, value, 24, 25);
        }
    /**
    *   ホールセンサ信号入力選択
    **/
        public boolean get_s_osa_em_hall_sel() {
    	    return readIoBoolean(ADDR_MOTORDRIVESETTING, 20);
        }
    /**
    *   ホールセンサ信号入力選択
    **/
        public void set_s_osa_em_hall_sel(boolean value) {
            writeIo(ADDR_MOTORDRIVESETTING, value, 20);
        }
    /**
    *   エンコーダモータ 駆動方法選択
    **/
        public boolean get_s_osa_em_drvpat_sel() {
    	    return readIoBoolean(ADDR_MOTORDRIVESETTING, 16);
        }
    /**
    *   エンコーダモータ 駆動方法選択
    **/
        public void set_s_osa_em_drvpat_sel(boolean value) {
            writeIo(ADDR_MOTORDRIVESETTING, value, 16);
        }
    /**
    *   ホールセンサ1情報(1:検出、0:未検出)
    **/
        public boolean get_d_hall_1() {
    	    return readIoBoolean(ADDR_MOTORDRIVESETTING, 8);
        }
    /**
    *   ホールセンサ1情報(1:検出、0:未検出)
    **/
        public void set_d_hall_1(boolean value) {
            writeIo(ADDR_MOTORDRIVESETTING, value, 8);
        }
    /**
    *   ホールセンサ2情報(1:検出、0:未検出)
    **/
        public boolean get_d_hall_2() {
    	    return readIoBoolean(ADDR_MOTORDRIVESETTING, 4);
        }
    /**
    *   ホールセンサ2情報(1:検出、0:未検出)
    **/
        public void set_d_hall_2(boolean value) {
            writeIo(ADDR_MOTORDRIVESETTING, value, 4);
        }
    /**
    *   ホールセンサ3情報(1:検出、0:未検出)
    **/
        public boolean get_d_hall_3() {
    	    return readIoBoolean(ADDR_MOTORDRIVESETTING, 0);
        }
    /**
    *   ホールセンサ3情報(1:検出、0:未検出)
    **/
        public void set_d_hall_3(boolean value) {
            writeIo(ADDR_MOTORDRIVESETTING, value, 0);
        }
    }
    public MotorDriveSetting motorDriveSetting = new MotorDriveSetting();
    public class EmergencyThreshold{
    /**
    *    エンコーダモータ 暴走防止無効
    **/
        public boolean get_s_osa_em_emergency_ignore() {
    	    return readIoBoolean(ADDR_EMERGENCYTHRESHOLD, 28);
        }
    /**
    *    エンコーダモータ 暴走防止無効
    **/
        public void set_s_osa_em_emergency_ignore(boolean value) {
            writeIo(ADDR_EMERGENCYTHRESHOLD, value, 28);
        }
    /**
    *    暴走防止回路 サンプリング周期設定
    **/
        public boolean get_s_osa_em_emergency_intvl() {
    	    return readIoBoolean(ADDR_EMERGENCYTHRESHOLD, 24);
        }
    /**
    *    暴走防止回路 サンプリング周期設定
    **/
        public void set_s_osa_em_emergency_intvl(boolean value) {
            writeIo(ADDR_EMERGENCYTHRESHOLD, value, 24);
        }
    /**
    *   エンコーダモータ 暴走防止閾値
    **/
        public int get_s_osa_em_emergency_th17_0() {
    	    return readIoInteger(ADDR_EMERGENCYTHRESHOLD, 16,0);
        }
    /**
    *   エンコーダモータ 暴走防止閾値
    **/
        public void set_s_osa_em_emergency_th17_0(int value) {
            writeIo(ADDR_EMERGENCYTHRESHOLD, value, 0, 16);
        }
    }
    public EmergencyThreshold emergencyThreshold = new EmergencyThreshold();
    public class HallSensorOrder{
    /**
    *   ホールセンサ1～3の論理を反転
    **/
        public boolean get_s_hall_sensor_not() {
    	    return readIoBoolean(ADDR_HALLSENSORORDER, 4);
        }
    /**
    *   ホールセンサ1～3の論理を反転
    **/
        public void set_s_hall_sensor_not(boolean value) {
            writeIo(ADDR_HALLSENSORORDER, value, 4);
        }
    /**
    *   ホールセンサ1～3の順番を組み替え
    **/
        public int get_s_hall_sensor_order2_0() {
    	    return readIoInteger(ADDR_HALLSENSORORDER, 1,0);
        }
    /**
    *   ホールセンサ1～3の順番を組み替え
    **/
        public void set_s_hall_sensor_order2_0(int value) {
            writeIo(ADDR_HALLSENSORORDER, value, 0, 1);
        }
    }
    public HallSensorOrder hallSensorOrder = new HallSensorOrder();
    public class PwmManualSetting1{
    /**
    *   PWM信号マニュアル選択
    **/
        public boolean get_s_osa_pwm_manual_sel() {
    	    return readIoBoolean(ADDR_PWMMANUALSETTING1, 16);
        }
    /**
    *   PWM信号マニュアル選択
    **/
        public void set_s_osa_pwm_manual_sel(boolean value) {
            writeIo(ADDR_PWMMANUALSETTING1, value, 16);
        }
    /**
    *   PWM信号マニュアル設定値 (U相)
    **/
        public int get_s_osa_pwm_manual_u9_0() {
    	    return readIoInteger(ADDR_PWMMANUALSETTING1, 8,0);
        }
    /**
    *   PWM信号マニュアル設定値 (U相)
    **/
        public void set_s_osa_pwm_manual_u9_0(int value) {
            writeIo(ADDR_PWMMANUALSETTING1, value, 0, 8);
        }
    }
    public PwmManualSetting1 pwmManualSetting1 = new PwmManualSetting1();
    public class PwmManualSetting2{
    /**
    *   PWM信号マニュアル設定値 (V相)
    **/
        public int get_s_osa_pwm_manual_v9_0() {
    	    return readIoInteger(ADDR_PWMMANUALSETTING2, 24,16);
        }
    /**
    *   PWM信号マニュアル設定値 (V相)
    **/
        public void set_s_osa_pwm_manual_v9_0(int value) {
            writeIo(ADDR_PWMMANUALSETTING2, value, 16, 24);
        }
    /**
    *   PWM信号マニュアル設定値 (W相)
    **/
        public int get_s_osa_pwm_manual_w9_0() {
    	    return readIoInteger(ADDR_PWMMANUALSETTING2, 8,0);
        }
    /**
    *   PWM信号マニュアル設定値 (W相)
    **/
        public void set_s_osa_pwm_manual_w9_0(int value) {
            writeIo(ADDR_PWMMANUALSETTING2, value, 0, 8);
        }
    }
    public PwmManualSetting2 pwmManualSetting2 = new PwmManualSetting2();
    public class PwmDutyLimitForDebug{
    /**
    *   PWM duty (dsig値)の上限設定値
    **/
        public int get_s_osa_pwm_duty_limit10_0() {
    	    return readIoInteger(ADDR_PWMDUTYLIMITFORDEBUG, 9,0);
        }
    /**
    *   PWM duty (dsig値)の上限設定値
    **/
        public void set_s_osa_pwm_duty_limit10_0(int value) {
            writeIo(ADDR_PWMDUTYLIMITFORDEBUG, value, 0, 9);
        }
    }
    public PwmDutyLimitForDebug pwmDutyLimitForDebug = new PwmDutyLimitForDebug();
    public class SamplingStart{
    /**
    *   サンプリングモード設定
    **/
        public boolean get_s_osa_smp_mode() {
    	    return readIoBoolean(ADDR_SAMPLINGSTART, 4);
        }
    /**
    *   サンプリングモード設定
    **/
        public void set_s_osa_smp_mode(boolean value) {
            writeIo(ADDR_SAMPLINGSTART, value, 4);
        }
    /**
    *   OSAサンプリングスタート信号
    **/
        public boolean get_s_osa_smp_start() {
    	    return readIoBoolean(ADDR_SAMPLINGSTART, 0);
        }
    /**
    *   OSAサンプリングスタート信号
    **/
        public void set_s_osa_smp_start(boolean value) {
            writeIo(ADDR_SAMPLINGSTART, value, 0);
        }
    }
    public SamplingStart samplingStart = new SamplingStart();
    public class SamplingStartPosition{
    /**
    *   サンプリング開始位置。
    **/
        public int get_s_osa_smp_start_pos() {
    	    return readIoInteger(ADDR_SAMPLINGSTARTPOSITION, 19,0);
        }
    /**
    *   サンプリング開始位置。
    **/
        public void set_s_osa_smp_start_pos(int value) {
            writeIo(ADDR_SAMPLINGSTARTPOSITION, value, 0, 19);
        }
    }
    public SamplingStartPosition samplingStartPosition = new SamplingStartPosition();
    public class SamplingPointNum{
    /**
    *   サンプリングポイント数。
    **/
        public int get_s_osa_smp_num() {
    	    return readIoInteger(ADDR_SAMPLINGPOINTNUM, 16,0);
        }
    /**
    *   サンプリングポイント数。
    **/
        public void set_s_osa_smp_num(int value) {
            writeIo(ADDR_SAMPLINGPOINTNUM, value, 0, 16);
        }
    }
    public SamplingPointNum samplingPointNum = new SamplingPointNum();
    public class RangeSetting{
    /**
    *   初期レンジ設定 (P波)。オートレンジ設定時のみ有効。
    **/
        public int get_s_osa_p_init_range() {
    	    return readIoInteger(ADDR_RANGESETTING, 21,20);
        }
    /**
    *   初期レンジ設定 (P波)。オートレンジ設定時のみ有効。
    **/
        public void set_s_osa_p_init_range(int value) {
            writeIo(ADDR_RANGESETTING, value, 20, 21);
        }
    /**
    *   初期レンジ設定 (S波)。オートレンジ設定時のみ有効。
    **/
        public int get_s_osa_s_init_range() {
    	    return readIoInteger(ADDR_RANGESETTING, 17,16);
        }
    /**
    *   初期レンジ設定 (S波)。オートレンジ設定時のみ有効。
    **/
        public void set_s_osa_s_init_range(int value) {
            writeIo(ADDR_RANGESETTING, value, 16, 17);
        }
    /**
    *   レンジ マニュアル設定モードに切り替え。 
    **/
        public boolean get_s_osa_range_manual_sel() {
    	    return readIoBoolean(ADDR_RANGESETTING, 8);
        }
    /**
    *   レンジ マニュアル設定モードに切り替え。 
    **/
        public void set_s_osa_range_manual_sel(boolean value) {
            writeIo(ADDR_RANGESETTING, value, 8);
        }
    /**
    *   レンジ設定 (P波)。レンジマニュアル設定時のみ有効。
    **/
        public int get_s_osa_p_range_set() {
    	    return readIoInteger(ADDR_RANGESETTING, 5,4);
        }
    /**
    *   レンジ設定 (P波)。レンジマニュアル設定時のみ有効。
    **/
        public void set_s_osa_p_range_set(int value) {
            writeIo(ADDR_RANGESETTING, value, 4, 5);
        }
    /**
    *   レンジ設定 (S波)。レンジマニュアル設定時のみ有効。
    **/
        public int get_s_osa_s_range_set() {
    	    return readIoInteger(ADDR_RANGESETTING, 1,0);
        }
    /**
    *   レンジ設定 (S波)。レンジマニュアル設定時のみ有効。
    **/
        public void set_s_osa_s_range_set(int value) {
            writeIo(ADDR_RANGESETTING, value, 0, 1);
        }
    }
    public RangeSetting rangeSetting = new RangeSetting();
    public class Range0Offset{
    /**
    *   レンジ0のオフセット設定 (P波)
    **/
        public int get_s_osa_smp_p_offset0() {
    	    return readIoInteger(ADDR_RANGE0OFFSET, 30,16);
        }
    /**
    *   レンジ0のオフセット設定 (P波)
    **/
        public void set_s_osa_smp_p_offset0(int value) {
            writeIo(ADDR_RANGE0OFFSET, value, 16, 30);
        }
    /**
    *   レンジ0のオフセット設定 (S波)
    **/
        public int get_s_osa_smp_s_offset0() {
    	    return readIoInteger(ADDR_RANGE0OFFSET, 14,0);
        }
    /**
    *   レンジ0のオフセット設定 (S波)
    **/
        public void set_s_osa_smp_s_offset0(int value) {
            writeIo(ADDR_RANGE0OFFSET, value, 0, 14);
        }
    }
    public Range0Offset range0Offset = new Range0Offset();
    public class Range1Offset{
    /**
    *   レンジ1のオフセット設定 (P波)
    **/
        public int get_s_osa_smp_p_offset1() {
    	    return readIoInteger(ADDR_RANGE1OFFSET, 30,16);
        }
    /**
    *   レンジ1のオフセット設定 (P波)
    **/
        public void set_s_osa_smp_p_offset1(int value) {
            writeIo(ADDR_RANGE1OFFSET, value, 16, 30);
        }
    /**
    *   レンジ1のオフセット設定 (S波)
    **/
        public int get_s_osa_smp_s_offset1() {
    	    return readIoInteger(ADDR_RANGE1OFFSET, 14,0);
        }
    /**
    *   レンジ1のオフセット設定 (S波)
    **/
        public void set_s_osa_smp_s_offset1(int value) {
            writeIo(ADDR_RANGE1OFFSET, value, 0, 14);
        }
    }
    public Range1Offset range1Offset = new Range1Offset();
    public class Range2Offset{
    /**
    *   レンジ2のオフセット設定 (P波)
    **/
        public int get_s_osa_smp_p_offset2() {
    	    return readIoInteger(ADDR_RANGE2OFFSET, 30,16);
        }
    /**
    *   レンジ2のオフセット設定 (P波)
    **/
        public void set_s_osa_smp_p_offset2(int value) {
            writeIo(ADDR_RANGE2OFFSET, value, 16, 30);
        }
    /**
    *   レンジ2のオフセット設定 (S波)
    **/
        public int get_s_osa_smp_s_offset2() {
    	    return readIoInteger(ADDR_RANGE2OFFSET, 14,0);
        }
    /**
    *   レンジ2のオフセット設定 (S波)
    **/
        public void set_s_osa_smp_s_offset2(int value) {
            writeIo(ADDR_RANGE2OFFSET, value, 0, 14);
        }
    }
    public Range2Offset range2Offset = new Range2Offset();
    public class Range3Offset{
    /**
    *   レンジ3のオフセット設定 (P波)
    **/
        public int get_s_osa_smp_p_offset3() {
    	    return readIoInteger(ADDR_RANGE3OFFSET, 30,16);
        }
    /**
    *   レンジ3のオフセット設定 (P波)
    **/
        public void set_s_osa_smp_p_offset3(int value) {
            writeIo(ADDR_RANGE3OFFSET, value, 16, 30);
        }
    /**
    *   レンジ3のオフセット設定 (S波)
    **/
        public int get_s_osa_smp_s_offset3() {
    	    return readIoInteger(ADDR_RANGE3OFFSET, 14,0);
        }
    /**
    *   レンジ3のオフセット設定 (S波)
    **/
        public void set_s_osa_smp_s_offset3(int value) {
            writeIo(ADDR_RANGE3OFFSET, value, 0, 14);
        }
    }
    public Range3Offset range3Offset = new Range3Offset();
    public class Range4Offset{
    /**
    *   レンジ4のオフセット設定 (P波)
    **/
        public int get_s_osa_smp_p_offset4() {
    	    return readIoInteger(ADDR_RANGE4OFFSET, 30,16);
        }
    /**
    *   レンジ4のオフセット設定 (P波)
    **/
        public void set_s_osa_smp_p_offset4(int value) {
            writeIo(ADDR_RANGE4OFFSET, value, 16, 30);
        }
    /**
    *   レンジ4のオフセット設定 (S波)
    **/
        public int get_s_osa_smp_s_offset4() {
    	    return readIoInteger(ADDR_RANGE4OFFSET, 14,0);
        }
    /**
    *   レンジ4のオフセット設定 (S波)
    **/
        public void set_s_osa_smp_s_offset4(int value) {
            writeIo(ADDR_RANGE4OFFSET, value, 0, 14);
        }
    }
    public Range4Offset range4Offset = new Range4Offset();
    public class Range0UpThreshold{
    /**
    *   レンジ0 Up (レンジ0→1)切替え閾値 (P波)
    **/
        public int get_s_osa_smp_p_upth0() {
    	    return readIoInteger(ADDR_RANGE0UPTHRESHOLD, 30,16);
        }
    /**
    *   レンジ0 Up (レンジ0→1)切替え閾値 (P波)
    **/
        public void set_s_osa_smp_p_upth0(int value) {
            writeIo(ADDR_RANGE0UPTHRESHOLD, value, 16, 30);
        }
    /**
    *   レンジ0 Up (レンジ0→1)切替え閾値 (S波)
    **/
        public int get_s_osa_smp_s_upth0() {
    	    return readIoInteger(ADDR_RANGE0UPTHRESHOLD, 14,0);
        }
    /**
    *   レンジ0 Up (レンジ0→1)切替え閾値 (S波)
    **/
        public void set_s_osa_smp_s_upth0(int value) {
            writeIo(ADDR_RANGE0UPTHRESHOLD, value, 0, 14);
        }
    }
    public Range0UpThreshold range0UpThreshold = new Range0UpThreshold();
    public class Range1UpThreshold{
    /**
    *   レンジ1 Up (レンジ1→2)切替え閾値 (P波)
    **/
        public int get_s_osa_smp_p_upth1() {
    	    return readIoInteger(ADDR_RANGE1UPTHRESHOLD, 30,16);
        }
    /**
    *   レンジ1 Up (レンジ1→2)切替え閾値 (P波)
    **/
        public void set_s_osa_smp_p_upth1(int value) {
            writeIo(ADDR_RANGE1UPTHRESHOLD, value, 16, 30);
        }
    /**
    *   レンジ1 Up (レンジ1→2)切替え閾値 (S波)
    **/
        public int get_s_osa_smp_s_upth1() {
    	    return readIoInteger(ADDR_RANGE1UPTHRESHOLD, 14,0);
        }
    /**
    *   レンジ1 Up (レンジ1→2)切替え閾値 (S波)
    **/
        public void set_s_osa_smp_s_upth1(int value) {
            writeIo(ADDR_RANGE1UPTHRESHOLD, value, 0, 14);
        }
    }
    public Range1UpThreshold range1UpThreshold = new Range1UpThreshold();
    public class Range1DownThreshold{
    /**
    *   レンジ1 Down (レンジ1→0)切替え閾値 (P波)
    **/
        public int get_s_osa_smp_p_dwnth1() {
    	    return readIoInteger(ADDR_RANGE1DOWNTHRESHOLD, 30,16);
        }
    /**
    *   レンジ1 Down (レンジ1→0)切替え閾値 (P波)
    **/
        public void set_s_osa_smp_p_dwnth1(int value) {
            writeIo(ADDR_RANGE1DOWNTHRESHOLD, value, 16, 30);
        }
    /**
    *   レンジ1 Down (レンジ1→0)切替え閾値 (S波)
    **/
        public int get_s_osa_smp_s_dwnth1() {
    	    return readIoInteger(ADDR_RANGE1DOWNTHRESHOLD, 14,0);
        }
    /**
    *   レンジ1 Down (レンジ1→0)切替え閾値 (S波)
    **/
        public void set_s_osa_smp_s_dwnth1(int value) {
            writeIo(ADDR_RANGE1DOWNTHRESHOLD, value, 0, 14);
        }
    }
    public Range1DownThreshold range1DownThreshold = new Range1DownThreshold();
    public class Range2UpThreshold{
    /**
    *   レンジ2 Up (レンジ2→3)切替え閾値 (P波)
    **/
        public int get_s_osa_smp_p_upth2() {
    	    return readIoInteger(ADDR_RANGE2UPTHRESHOLD, 30,16);
        }
    /**
    *   レンジ2 Up (レンジ2→3)切替え閾値 (P波)
    **/
        public void set_s_osa_smp_p_upth2(int value) {
            writeIo(ADDR_RANGE2UPTHRESHOLD, value, 16, 30);
        }
    /**
    *   レンジ2 Up (レンジ2→3)切替え閾値 (S波)
    **/
        public int get_s_osa_smp_s_upth2() {
    	    return readIoInteger(ADDR_RANGE2UPTHRESHOLD, 14,0);
        }
    /**
    *   レンジ2 Up (レンジ2→3)切替え閾値 (S波)
    **/
        public void set_s_osa_smp_s_upth2(int value) {
            writeIo(ADDR_RANGE2UPTHRESHOLD, value, 0, 14);
        }
    }
    public Range2UpThreshold range2UpThreshold = new Range2UpThreshold();
    public class Range2DownThreshold{
    /**
    *   レンジ2 Down (レンジ2→1)切替え閾値 (P波)
    **/
        public int get_s_osa_smp_p_dwnth2() {
    	    return readIoInteger(ADDR_RANGE2DOWNTHRESHOLD, 30,16);
        }
    /**
    *   レンジ2 Down (レンジ2→1)切替え閾値 (P波)
    **/
        public void set_s_osa_smp_p_dwnth2(int value) {
            writeIo(ADDR_RANGE2DOWNTHRESHOLD, value, 16, 30);
        }
    /**
    *   レンジ2 Down (レンジ2→1)切替え閾値 (S波)
    **/
        public int get_s_osa_smp_s_dwnth2() {
    	    return readIoInteger(ADDR_RANGE2DOWNTHRESHOLD, 14,0);
        }
    /**
    *   レンジ2 Down (レンジ2→1)切替え閾値 (S波)
    **/
        public void set_s_osa_smp_s_dwnth2(int value) {
            writeIo(ADDR_RANGE2DOWNTHRESHOLD, value, 0, 14);
        }
    }
    public Range2DownThreshold range2DownThreshold = new Range2DownThreshold();
    public class Range3UpThreshold{
    /**
    *   レンジ3 Up (レンジ3→4)切替え閾値 (P波)
    **/
        public int get_s_osa_smp_p_upth3() {
    	    return readIoInteger(ADDR_RANGE3UPTHRESHOLD, 30,16);
        }
    /**
    *   レンジ3 Up (レンジ3→4)切替え閾値 (P波)
    **/
        public void set_s_osa_smp_p_upth3(int value) {
            writeIo(ADDR_RANGE3UPTHRESHOLD, value, 16, 30);
        }
    /**
    *   レンジ3 Up (レンジ3→4)切替え閾値 (S波)
    **/
        public int get_s_osa_smp_s_upth3() {
    	    return readIoInteger(ADDR_RANGE3UPTHRESHOLD, 14,0);
        }
    /**
    *   レンジ3 Up (レンジ3→4)切替え閾値 (S波)
    **/
        public void set_s_osa_smp_s_upth3(int value) {
            writeIo(ADDR_RANGE3UPTHRESHOLD, value, 0, 14);
        }
    }
    public Range3UpThreshold range3UpThreshold = new Range3UpThreshold();
    public class Range3DownThreshold{
    /**
    *   レンジ3 Down (レンジ3→2)切替え閾値 (P波)
    **/
        public int get_s_osa_smp_p_dwnth3() {
    	    return readIoInteger(ADDR_RANGE3DOWNTHRESHOLD, 30,16);
        }
    /**
    *   レンジ3 Down (レンジ3→2)切替え閾値 (P波)
    **/
        public void set_s_osa_smp_p_dwnth3(int value) {
            writeIo(ADDR_RANGE3DOWNTHRESHOLD, value, 16, 30);
        }
    /**
    *   レンジ3 Down (レンジ3→2)切替え閾値 (S波)
    **/
        public int get_s_osa_smp_s_dwnth3() {
    	    return readIoInteger(ADDR_RANGE3DOWNTHRESHOLD, 14,0);
        }
    /**
    *   レンジ3 Down (レンジ3→2)切替え閾値 (S波)
    **/
        public void set_s_osa_smp_s_dwnth3(int value) {
            writeIo(ADDR_RANGE3DOWNTHRESHOLD, value, 0, 14);
        }
    }
    public Range3DownThreshold range3DownThreshold = new Range3DownThreshold();
    public class Range4DownThreshold{
    /**
    *   レンジ4 Down (レンジ4→3)切替え閾値 (P波)
    **/
        public int get_s_osa_smp_p_dwnth4() {
    	    return readIoInteger(ADDR_RANGE4DOWNTHRESHOLD, 30,16);
        }
    /**
    *   レンジ4 Down (レンジ4→3)切替え閾値 (P波)
    **/
        public void set_s_osa_smp_p_dwnth4(int value) {
            writeIo(ADDR_RANGE4DOWNTHRESHOLD, value, 16, 30);
        }
    /**
    *   レンジ4 Down (レンジ4→3)切替え閾値 (S波)
    **/
        public int get_s_osa_smp_s_dwnth4() {
    	    return readIoInteger(ADDR_RANGE4DOWNTHRESHOLD, 14,0);
        }
    /**
    *   レンジ4 Down (レンジ4→3)切替え閾値 (S波)
    **/
        public void set_s_osa_smp_s_dwnth4(int value) {
            writeIo(ADDR_RANGE4DOWNTHRESHOLD, value, 0, 14);
        }
    }
    public Range4DownThreshold range4DownThreshold = new Range4DownThreshold();
    public class OsaRamReadFlag{
    /**
    *   OSA Data RAMリードフラグ信号
    **/
        public boolean get_d_osa_dpram_rd_flg() {
    	    return readIoBoolean(ADDR_OSARAMREADFLAG, 0);
        }
    /**
    *   OSA Data RAMリードフラグ信号
    **/
        public void set_d_osa_dpram_rd_flg(boolean value) {
            writeIo(ADDR_OSARAMREADFLAG, value, 0);
        }
    }
    public OsaRamReadFlag osaRamReadFlag = new OsaRamReadFlag();
    public class EepromI2cOsaCalibRom{
    /**
    *   when set performs a read0x01
    **/
        public boolean get_s_osa_eeprom_cmd3() {
    	    return readIoBoolean(ADDR_EEPROM_I2C_OSACALIBROM_, 11);
        }
    /**
    *   when set performs a read0x01
    **/
        public void set_s_osa_eeprom_cmd3(boolean value) {
            writeIo(ADDR_EEPROM_I2C_OSACALIBROM_, value, 11);
        }
    /**
    *   when set initiates a start or “continue” transfer
    **/
        public boolean get_s_osa_eeprom_cmd2() {
    	    return readIoBoolean(ADDR_EEPROM_I2C_OSACALIBROM_, 10);
        }
    /**
    *   when set initiates a start or “continue” transfer
    **/
        public void set_s_osa_eeprom_cmd2(boolean value) {
            writeIo(ADDR_EEPROM_I2C_OSACALIBROM_, value, 10);
        }
    /**
    *   when set terminates the transfer with a stop condition
    **/
        public boolean get_s_osa_eeprom_cmd1() {
    	    return readIoBoolean(ADDR_EEPROM_I2C_OSACALIBROM_, 9);
        }
    /**
    *   when set terminates the transfer with a stop condition
    **/
        public void set_s_osa_eeprom_cmd1(boolean value) {
            writeIo(ADDR_EEPROM_I2C_OSACALIBROM_, value, 9);
        }
    /**
    *   when set initiates a repeated start transfer
    **/
        public boolean get_s_osa_eeprom_cmd0() {
    	    return readIoBoolean(ADDR_EEPROM_I2C_OSACALIBROM_, 8);
        }
    /**
    *   when set initiates a repeated start transfer
    **/
        public void set_s_osa_eeprom_cmd0(boolean value) {
            writeIo(ADDR_EEPROM_I2C_OSACALIBROM_, value, 8);
        }
    /**
    *   Data to be transferred during a command.
    **/
        public int get_s_osa_eeprom_wdata() {
    	    return readIoInteger(ADDR_EEPROM_I2C_OSACALIBROM_, 6,0);
        }
    /**
    *   Data to be transferred during a command.
    **/
        public void set_s_osa_eeprom_wdata(int value) {
            writeIo(ADDR_EEPROM_I2C_OSACALIBROM_, value, 0, 6);
        }
    }
    public EepromI2cOsaCalibRom eepromI2cOsaCalibRom = new EepromI2cOsaCalibRom();
    public class NewRegister{
    /**
    *   new bit
    **/
        public int get_newbit() {
    	    return readIoInteger(ADDR_NEWREGISTER, 31,0);
        }
    /**
    *   new bit
    **/
        public void set_newbit(int value) {
            writeIo(ADDR_NEWREGISTER, value, 0, 31);
        }
    }
    public NewRegister newRegister = new NewRegister();
    public class OscControl{
    /**
    *   Sampling Trigger
    **/
        public int get_Trigger() {
    	    return readIoInteger(ADDR_OSCCONTROL, 31,16);
        }
    /**
    *   Sampling Trigger
    **/
        public void set_Trigger(int value) {
            writeIo(ADDR_OSCCONTROL, value, 16, 31);
        }
    /**
    *   Clear
    **/
        public int get_DataClear() {
    	    return readIoInteger(ADDR_OSCCONTROL, 7,4);
        }
    /**
    *   Clear
    **/
        public void set_DataClear(int value) {
            writeIo(ADDR_OSCCONTROL, value, 4, 7);
        }
    /**
    *   Start
    **/
        public int get_Start_Stop() {
    	    return readIoInteger(ADDR_OSCCONTROL, 3,0);
        }
    /**
    *   Start
    **/
        public void set_Start_Stop(int value) {
            writeIo(ADDR_OSCCONTROL, value, 0, 3);
        }
    }
    public OscControl oscControl = new OscControl();
    public class PpgControl{
    /**
    *   Description
    **/
        public int get_Start_Stop() {
    	    return readIoInteger(ADDR_PPGCONTROL, 3,0);
        }
    /**
    *   Description
    **/
        public void set_Start_Stop(int value) {
            writeIo(ADDR_PPGCONTROL, value, 0, 3);
        }
    }
    public PpgControl ppgControl = new PpgControl();
    public class EdControl{
    /**
    *   Description
    **/
        public int get_BitRate() {
    	    return readIoInteger(ADDR_EDCONTROL, 14,0);
        }
    /**
    *   Description
    **/
        public void set_BitRate(int value) {
            writeIo(ADDR_EDCONTROL, value, 0, 14);
        }
    }
    public EdControl edControl = new EdControl();
    public class PpgBitrate{
    /**
    *   Description
    **/
        public int get_BitRate() {
    	    return readIoInteger(ADDR_PPGBITRATE, 30,0);
        }
    /**
    *   Description
    **/
        public void set_BitRate(int value) {
            writeIo(ADDR_PPGBITRATE, value, 0, 30);
        }
    }
    public PpgBitrate ppgBitrate = new PpgBitrate();
    public class SinusoidalCalibData{
    /**
    *   正弦波整流補正データ (U相)
    **/
        public int get_s_osa_em_sinecalib_u() {
    	    return readIoInteger(ADDR_SINUSOIDALCALIBDATA, 22,16);
        }
    /**
    *   正弦波整流補正データ (U相)
    **/
        public void set_s_osa_em_sinecalib_u(int value) {
            writeIo(ADDR_SINUSOIDALCALIBDATA, value, 16, 22);
        }
    /**
    *   正弦波整流補正データ (V相)
    **/
        public int get_s_osa_em_sinecalib_v() {
    	    return readIoInteger(ADDR_SINUSOIDALCALIBDATA, 14,8);
        }
    /**
    *   正弦波整流補正データ (V相)
    **/
        public void set_s_osa_em_sinecalib_v(int value) {
            writeIo(ADDR_SINUSOIDALCALIBDATA, value, 8, 14);
        }
    /**
    *   正弦波整流補正データ (W相)
    **/
        public int get_s_osa_em_sinecalib_w() {
    	    return readIoInteger(ADDR_SINUSOIDALCALIBDATA, 6,0);
        }
    /**
    *   正弦波整流補正データ (W相)
    **/
        public void set_s_osa_em_sinecalib_w(int value) {
            writeIo(ADDR_SINUSOIDALCALIBDATA, value, 0, 6);
        }
    }
    public SinusoidalCalibData sinusoidalCalibData = new SinusoidalCalibData();
    public class OtdrTraceData{
    /**
    *   new bit
    **/
        public int get_OTDRTraceData() {
    	    return readIoInteger(ADDR_OTDRTRACEDATA, 31,0);
        }
    /**
    *   new bit
    **/
        public void set_OTDRTraceData(int value) {
            writeIo(ADDR_OTDRTRACEDATA, value, 0, 31);
        }
    }
    public OtdrTraceData otdrTraceData = new OtdrTraceData();
    private boolean readIoBoolean(long address, int bit) {
        return registerAccess.readIoBoolean(address, bit);
    }
    private int readIoInteger(long address, int bitFrom, int bitTo) {
        return registerAccess.readIoInteger(address, bitFrom, bitTo);
    }
    private void writeIo(long address, boolean value, int bit) {
        registerAccess.writeIo(address, value, bit);
    }
    private void writeIo(long address, int value, int bitFrom, int bitTo) {
        registerAccess.writeIo(address, value, bitFrom, bitTo);
    }
    private void writeIo(long address, float value, int bitFrom, int bitTo) {
        registerAccess.writeIo(address, value, bitFrom, bitTo);
    }
}
