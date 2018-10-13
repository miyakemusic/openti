package openti;
import jp.silverbullet.handlers.RegisterAccess;
import jp.silverbullet.register.RegisterControl;
public class UserRegisterControl extends RegisterControl {
    public static int ADDR_OTDRTESTCONTROL = 0x00;
    public static int BIT_OTDRTESTCONTROL_TESTSTART = 0;
    public static int ADDR_OTDRHARDKEYS = 0x00001;
    public static int BIT_OTDRHARDKEYS_SETUP = 4;
    public static int BIT_OTDRHARDKEYS_LOAD = 3;
    public static int BIT_OTDRHARDKEYS_SAVE = 2;
    public static int BIT_OTDRHARDKEYS_REALTIME = 1;
    public static int BIT_OTDRHARDKEYS_AVERAGE = 0;
    public static int ADDR_TRANSPORTTESTCONTROL = 0x2;
    public static int ADDR_OTDRINTERRUPTSTATUS = 0x00010;
    public static int BIT_OTDRINTERRUPTSTATUS_ERROROCCURS = 1;
    public static int BIT_OTDRINTERRUPTSTATUS_TRACEDATAREADY = 0;
    public static int ADDR_ADDROTDRTRACEDATA = 0x00020;
    public static int ADDR_ADDREYEDIAGRAM = 0x21;
    public static int ADDR_OSCCONTROL = 0x22;
    public static int BIT_OSCCONTROL_DATACLEAR = 2;
    public static int BIT_OSCCONTROL_TRIGGER = 1;
    public static int BIT_OSCCONTROL_STARTSTOP = 0;
    public static int ADDR_PPGCONTROL = 0x23;
    public static int BIT_PPGCONTROL_STARTSTOP = 1;
    public static int BIT_PPGCONTROL_TESTPATTERN = 0;
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
    public class OtdrHardKeys{
    /**
    *   new bit
    **/
        public boolean get_Setup() {
    	    return readIoBoolean(ADDR_OTDRHARDKEYS, 4);
        }
    /**
    *   new bit
    **/
        public void set_Setup(boolean value) {
            writeIo(ADDR_OTDRHARDKEYS, value, 4);
        }
    /**
    *   new bit
    **/
        public boolean get_Load() {
    	    return readIoBoolean(ADDR_OTDRHARDKEYS, 3);
        }
    /**
    *   new bit
    **/
        public void set_Load(boolean value) {
            writeIo(ADDR_OTDRHARDKEYS, value, 3);
        }
    /**
    *   new bit
    **/
        public boolean get_Save() {
    	    return readIoBoolean(ADDR_OTDRHARDKEYS, 2);
        }
    /**
    *   new bit
    **/
        public void set_Save(boolean value) {
            writeIo(ADDR_OTDRHARDKEYS, value, 2);
        }
    /**
    *   new bit
    **/
        public boolean get_Realtime() {
    	    return readIoBoolean(ADDR_OTDRHARDKEYS, 1);
        }
    /**
    *   new bit
    **/
        public void set_Realtime(boolean value) {
            writeIo(ADDR_OTDRHARDKEYS, value, 1);
        }
    /**
    *   new bit
    **/
        public boolean get_Average() {
    	    return readIoBoolean(ADDR_OTDRHARDKEYS, 0);
        }
    /**
    *   new bit
    **/
        public void set_Average(boolean value) {
            writeIo(ADDR_OTDRHARDKEYS, value, 0);
        }
    }
    public OtdrHardKeys otdrHardKeys = new OtdrHardKeys();
    public class TransportTestControl{
    }
    public TransportTestControl transportTestControl = new TransportTestControl();
    public class OtdrInterruptStatus{
    /**
    *   new bit
    **/
        public boolean get_erroroccurs() {
    	    return readIoBoolean(ADDR_OTDRINTERRUPTSTATUS, 1);
        }
    /**
    *   new bit
    **/
        public void set_erroroccurs(boolean value) {
            writeIo(ADDR_OTDRINTERRUPTSTATUS, value, 1);
        }
    /**
    *   new bit
    **/
        public boolean get_tracedataready() {
    	    return readIoBoolean(ADDR_OTDRINTERRUPTSTATUS, 0);
        }
    /**
    *   new bit
    **/
        public void set_tracedataready(boolean value) {
            writeIo(ADDR_OTDRINTERRUPTSTATUS, value, 0);
        }
    }
    public OtdrInterruptStatus otdrInterruptStatus = new OtdrInterruptStatus();
    public class AddrEyediagram{
    /**
    *   new bit
    **/
        public int get_data() {
    	    return readIoInteger(ADDR_ADDREYEDIAGRAM, 31,0);
        }
    /**
    *   new bit
    **/
        public void set_data(int value) {
            writeIo(ADDR_ADDREYEDIAGRAM, value, 0, 31);
        }
    }
    public AddrEyediagram addrEyediagram = new AddrEyediagram();
    public class Osccontrol{
    /**
    *   new bit
    **/
        public boolean get_DataClear() {
    	    return readIoBoolean(ADDR_OSCCONTROL, 2);
        }
    /**
    *   new bit
    **/
        public void set_DataClear(boolean value) {
            writeIo(ADDR_OSCCONTROL, value, 2);
        }
    /**
    *   new bit
    **/
        public boolean get_Trigger() {
    	    return readIoBoolean(ADDR_OSCCONTROL, 1);
        }
    /**
    *   new bit
    **/
        public void set_Trigger(boolean value) {
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
    public Osccontrol osccontrol = new Osccontrol();
    public class Ppgcontrol{
    /**
    *   new bit
    **/
        public int get_BitRate() {
    	    return readIoInteger(ADDR_PPGCONTROL, 3,2);
        }
    /**
    *   new bit
    **/
        public void set_BitRate(int value) {
            writeIo(ADDR_PPGCONTROL, value, 2, 3);
        }
    /**
    *   new bit
    **/
        public boolean get_StartStop() {
    	    return readIoBoolean(ADDR_PPGCONTROL, 1);
        }
    /**
    *   new bit
    **/
        public void set_StartStop(boolean value) {
            writeIo(ADDR_PPGCONTROL, value, 1);
        }
    /**
    *   new bit
    **/
        public boolean get_TestPattern() {
    	    return readIoBoolean(ADDR_PPGCONTROL, 0);
        }
    /**
    *   new bit
    **/
        public void set_TestPattern(boolean value) {
            writeIo(ADDR_PPGCONTROL, value, 0);
        }
    }
    public Ppgcontrol ppgcontrol = new Ppgcontrol();
}
