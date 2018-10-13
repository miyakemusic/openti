package openti;
import jp.silverbullet.handlers.RegisterAccess;
import jp.silverbullet.register.RegisterControl;
public class UserRegisterControl extends RegisterControl {
    public static int ADDR_OTDRTESTCONTROL = 0x000001;
    public static int BIT_OTDRTESTCONTROL_TESTSTART = 0;
    public static int ADDR_DUMMY = 0x1;
    public static int ADDR_OTDRHARDKEY = 0x000002;
    public static int BIT_OTDRHARDKEY_SETUP = 4;
    public static int BIT_OTDRHARDKEY_LOA = 3;
    public static int BIT_OTDRHARDKEY_SAVE = 2;
    public static int BIT_OTDRHARDKEY_REALTIME = 1;
    public static int BIT_OTDRHARDKEY_AVERAGE = 0;
    public static int ADDR_OTDRINTERRUPTSTATUS = 0x000003;
    public static int BIT_OTDRINTERRUPTSTATUS_TRACEREADY = 1;
    public static int BIT_OTDRINTERRUPTSTATUS_ERROROCCURS = 0;
    public static int ADDR_OTDRTRACEDATA = 0x00010;
    public static int ADDR_EYEDIAGRAM = 0x000100;
    public static int ADDR_PPGCONTROL = 0x102;
    public static int ADDR_OSCCONTROL = 0x000101;
    public static int BIT_OSCCONTROL_TRIGGER = 2;
    public static int BIT_OSCCONTROL_DATACLEAR = 1;
    public static int BIT_OSCCONTROL_STARTSTOP = 0;
    private RegisterAccess registerAccess = null;
    public RegisterAccess getRegisterAccess() {
    	return registerAccess;
    }
    public UserRegisterControl(RegisterAccess registerAccess2) {
         super(registerAccess2);
         this.registerAccess = registerAccess2;
    }
    public class OtdrTestControl{
    /**
    *   new bit
    **/
        public boolean get_teststart() {
    	    return readIoBoolean(ADDR_OTDRTESTCONTROL, 0);
        }
    /**
    *   new bit
    **/
        public void set_teststart(boolean value) {
            writeIo(ADDR_OTDRTESTCONTROL, value, 0);
        }
    }
    public OtdrTestControl otdrTestControl = new OtdrTestControl();
    public class Dummy{
    }
    public Dummy dummy = new Dummy();
    public class OtdrHardkey{
    /**
    *   new bit
    **/
        public boolean get_setup() {
    	    return readIoBoolean(ADDR_OTDRHARDKEY, 4);
        }
    /**
    *   new bit
    **/
        public void set_setup(boolean value) {
            writeIo(ADDR_OTDRHARDKEY, value, 4);
        }
    /**
    *   new bit
    **/
        public boolean get_loa() {
    	    return readIoBoolean(ADDR_OTDRHARDKEY, 3);
        }
    /**
    *   new bit
    **/
        public void set_loa(boolean value) {
            writeIo(ADDR_OTDRHARDKEY, value, 3);
        }
    /**
    *   new bit
    **/
        public boolean get_save() {
    	    return readIoBoolean(ADDR_OTDRHARDKEY, 2);
        }
    /**
    *   new bit
    **/
        public void set_save(boolean value) {
            writeIo(ADDR_OTDRHARDKEY, value, 2);
        }
    /**
    *   new bit
    **/
        public boolean get_realtime() {
    	    return readIoBoolean(ADDR_OTDRHARDKEY, 1);
        }
    /**
    *   new bit
    **/
        public void set_realtime(boolean value) {
            writeIo(ADDR_OTDRHARDKEY, value, 1);
        }
    /**
    *   new bit
    **/
        public boolean get_average() {
    	    return readIoBoolean(ADDR_OTDRHARDKEY, 0);
        }
    /**
    *   new bit
    **/
        public void set_average(boolean value) {
            writeIo(ADDR_OTDRHARDKEY, value, 0);
        }
    }
    public OtdrHardkey otdrHardkey = new OtdrHardkey();
    public class OtdrInterruptStatus{
    /**
    *   new bit
    **/
        public boolean get_traceready() {
    	    return readIoBoolean(ADDR_OTDRINTERRUPTSTATUS, 1);
        }
    /**
    *   new bit
    **/
        public void set_traceready(boolean value) {
            writeIo(ADDR_OTDRINTERRUPTSTATUS, value, 1);
        }
    /**
    *   new bit
    **/
        public boolean get_erroroccurs() {
    	    return readIoBoolean(ADDR_OTDRINTERRUPTSTATUS, 0);
        }
    /**
    *   new bit
    **/
        public void set_erroroccurs(boolean value) {
            writeIo(ADDR_OTDRINTERRUPTSTATUS, value, 0);
        }
    }
    public OtdrInterruptStatus otdrInterruptStatus = new OtdrInterruptStatus();
    public class EyeDiagram{
    }
    public EyeDiagram eyeDiagram = new EyeDiagram();
    public class PpgControl{
    /**
    *   new bit
    **/
        public int get_BitRate() {
    	    return readIoInteger(ADDR_PPGCONTROL, 5,4);
        }
    /**
    *   new bit
    **/
        public void set_BitRate(int value) {
            writeIo(ADDR_PPGCONTROL, value, 4, 5);
        }
    /**
    *   new bit
    **/
        public int get_StartStop() {
    	    return readIoInteger(ADDR_PPGCONTROL, 3,2);
        }
    /**
    *   new bit
    **/
        public void set_StartStop(int value) {
            writeIo(ADDR_PPGCONTROL, value, 2, 3);
        }
    /**
    *   new bit
    **/
        public int get_TestPattern() {
    	    return readIoInteger(ADDR_PPGCONTROL, 1,0);
        }
    /**
    *   new bit
    **/
        public void set_TestPattern(int value) {
            writeIo(ADDR_PPGCONTROL, value, 0, 1);
        }
    }
    public PpgControl ppgControl = new PpgControl();
    public class OscControl{
    /**
    *   new bit
    **/
        public boolean get_trigger() {
    	    return readIoBoolean(ADDR_OSCCONTROL, 2);
        }
    /**
    *   new bit
    **/
        public void set_trigger(boolean value) {
            writeIo(ADDR_OSCCONTROL, value, 2);
        }
    /**
    *   new bit
    **/
        public boolean get_dataclear() {
    	    return readIoBoolean(ADDR_OSCCONTROL, 1);
        }
    /**
    *   new bit
    **/
        public void set_dataclear(boolean value) {
            writeIo(ADDR_OSCCONTROL, value, 1);
        }
    /**
    *   new bit
    **/
        public boolean get_startstop() {
    	    return readIoBoolean(ADDR_OSCCONTROL, 0);
        }
    /**
    *   new bit
    **/
        public void set_startstop(boolean value) {
            writeIo(ADDR_OSCCONTROL, value, 0);
        }
    }
    public OscControl oscControl = new OscControl();
}
