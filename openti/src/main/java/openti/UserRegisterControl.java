package openti;
import jp.silverbullet.handlers.RegisterAccess;
import jp.silverbullet.register.RegisterControl;
public class UserRegisterControl extends RegisterControl {
    public static int ADDR_OTDRTESTCONTROL = 0x00;
    public static int BIT_OTDRTESTCONTROL_TESTSTART = 0;
    public static int ADDR_HARDKEY = 0x00001;
    public static int BIT_HARDKEY_SETUP = 4;
    public static int BIT_HARDKEY_LOAD = 3;
    public static int BIT_HARDKEY_SAVE = 2;
    public static int BIT_HARDKEY_REALTIME = 1;
    public static int BIT_HARDKEY_AVERAGE = 0;
    public static int ADDR_OTDRDEUMMHY = 0x2;
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
    public static int ADDR_NEWREGTHU4 = 0x27;
    public static int ADDR_NEWREGTH555 = 0x2b;
    public static int ADDR_NEWREGTH00 = 0x2f;
    public static int ADDR_NEWREGTHU000 = 0x33;
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
        public int read_duration() {
    	    return readIoInteger(ADDR_OTDRTESTCONTROL, 24,21);
        }
        public int read_and_reset_duration() {
    	    int ret = readIoInteger(ADDR_OTDRTESTCONTROL, 24,21);
             write_duration(0);
    	    return ret;
        }
    /**
    *   new bit
    **/
        public void write_duration(int value) {
            writeIo(ADDR_OTDRTESTCONTROL, value, 21, 24);
        }
    /**
    *   new bit
    **/
        public int read_points() {
    	    return readIoInteger(ADDR_OTDRTESTCONTROL, 20,13);
        }
        public int read_and_reset_points() {
    	    int ret = readIoInteger(ADDR_OTDRTESTCONTROL, 20,13);
             write_points(0);
    	    return ret;
        }
    /**
    *   new bit
    **/
        public void write_points(int value) {
            writeIo(ADDR_OTDRTESTCONTROL, value, 13, 20);
        }
    /**
    *   new bit
    **/
        public int read_power() {
    	    return readIoInteger(ADDR_OTDRTESTCONTROL, 12,9);
        }
        public int read_and_reset_power() {
    	    int ret = readIoInteger(ADDR_OTDRTESTCONTROL, 12,9);
             write_power(0);
    	    return ret;
        }
    /**
    *   new bit
    **/
        public void write_power(int value) {
            writeIo(ADDR_OTDRTESTCONTROL, value, 9, 12);
        }
    /**
    *   new bit
    **/
        public int read_range() {
    	    return readIoInteger(ADDR_OTDRTESTCONTROL, 8,5);
        }
        public int read_and_reset_range() {
    	    int ret = readIoInteger(ADDR_OTDRTESTCONTROL, 8,5);
             write_range(0);
    	    return ret;
        }
    /**
    *   new bit
    **/
        public void write_range(int value) {
            writeIo(ADDR_OTDRTESTCONTROL, value, 5, 8);
        }
    /**
    *   new bit
    **/
        public int read_pulse() {
    	    return readIoInteger(ADDR_OTDRTESTCONTROL, 4,1);
        }
        public int read_and_reset_pulse() {
    	    int ret = readIoInteger(ADDR_OTDRTESTCONTROL, 4,1);
             write_pulse(0);
    	    return ret;
        }
    /**
    *   new bit
    **/
        public void write_pulse(int value) {
            writeIo(ADDR_OTDRTESTCONTROL, value, 1, 4);
        }
    /**
    *   new bit
    **/
        public boolean read_teststart() {
    	    return readIoBoolean(ADDR_OTDRTESTCONTROL, 0);
        }
        public boolean read_and_reset_teststart() {
    	    boolean ret = readIoBoolean(ADDR_OTDRTESTCONTROL, 0);
             write_teststart(false);
    	    return ret;
        }
    /**
    *   new bit
    **/
        public void write_teststart(boolean value) {
            writeIo(ADDR_OTDRTESTCONTROL, value, 0);
        }
    }
    public OtdrTestControl otdrTestControl = new OtdrTestControl();
    public class Hardkey{
    /**
    *   new bit
    **/
        public boolean read_Setup() {
    	    return readIoBoolean(ADDR_HARDKEY, 4);
        }
        public boolean read_and_reset_Setup() {
    	    boolean ret = readIoBoolean(ADDR_HARDKEY, 4);
             write_Setup(false);
    	    return ret;
        }
    /**
    *   new bit
    **/
        public void write_Setup(boolean value) {
            writeIo(ADDR_HARDKEY, value, 4);
        }
    /**
    *   new bit
    **/
        public boolean read_Load() {
    	    return readIoBoolean(ADDR_HARDKEY, 3);
        }
        public boolean read_and_reset_Load() {
    	    boolean ret = readIoBoolean(ADDR_HARDKEY, 3);
             write_Load(false);
    	    return ret;
        }
    /**
    *   new bit
    **/
        public void write_Load(boolean value) {
            writeIo(ADDR_HARDKEY, value, 3);
        }
    /**
    *   new bit
    **/
        public boolean read_Save() {
    	    return readIoBoolean(ADDR_HARDKEY, 2);
        }
        public boolean read_and_reset_Save() {
    	    boolean ret = readIoBoolean(ADDR_HARDKEY, 2);
             write_Save(false);
    	    return ret;
        }
    /**
    *   new bit
    **/
        public void write_Save(boolean value) {
            writeIo(ADDR_HARDKEY, value, 2);
        }
    /**
    *   new bit
    **/
        public boolean read_Realtime() {
    	    return readIoBoolean(ADDR_HARDKEY, 1);
        }
        public boolean read_and_reset_Realtime() {
    	    boolean ret = readIoBoolean(ADDR_HARDKEY, 1);
             write_Realtime(false);
    	    return ret;
        }
    /**
    *   new bit
    **/
        public void write_Realtime(boolean value) {
            writeIo(ADDR_HARDKEY, value, 1);
        }
    /**
    *   new bit
    **/
        public boolean read_Average() {
    	    return readIoBoolean(ADDR_HARDKEY, 0);
        }
        public boolean read_and_reset_Average() {
    	    boolean ret = readIoBoolean(ADDR_HARDKEY, 0);
             write_Average(false);
    	    return ret;
        }
    /**
    *   new bit
    **/
        public void write_Average(boolean value) {
            writeIo(ADDR_HARDKEY, value, 0);
        }
    }
    public Hardkey hardkey = new Hardkey();
    public class OtdrDeummhy{
    }
    public OtdrDeummhy otdrDeummhy = new OtdrDeummhy();
    public class OtdrInterruptStatus{
    /**
    *   new bit
    **/
        public boolean read_erroroccurs() {
    	    return readIoBoolean(ADDR_OTDRINTERRUPTSTATUS, 1);
        }
        public boolean read_and_reset_erroroccurs() {
    	    boolean ret = readIoBoolean(ADDR_OTDRINTERRUPTSTATUS, 1);
             write_erroroccurs(false);
    	    return ret;
        }
    /**
    *   new bit
    **/
        public void write_erroroccurs(boolean value) {
            writeIo(ADDR_OTDRINTERRUPTSTATUS, value, 1);
        }
    /**
    *   new bit
    **/
        public boolean read_tracedataready() {
    	    return readIoBoolean(ADDR_OTDRINTERRUPTSTATUS, 0);
        }
        public boolean read_and_reset_tracedataready() {
    	    boolean ret = readIoBoolean(ADDR_OTDRINTERRUPTSTATUS, 0);
             write_tracedataready(false);
    	    return ret;
        }
    /**
    *   new bit
    **/
        public void write_tracedataready(boolean value) {
            writeIo(ADDR_OTDRINTERRUPTSTATUS, value, 0);
        }
    }
    public OtdrInterruptStatus otdrInterruptStatus = new OtdrInterruptStatus();
    public class AddrEyediagram{
    /**
    *   new bit
    **/
        public int read_data() {
    	    return readIoInteger(ADDR_ADDREYEDIAGRAM, 31,0);
        }
        public int read_and_reset_data() {
    	    int ret = readIoInteger(ADDR_ADDREYEDIAGRAM, 31,0);
             write_data(0);
    	    return ret;
        }
    /**
    *   new bit
    **/
        public void write_data(int value) {
            writeIo(ADDR_ADDREYEDIAGRAM, value, 0, 31);
        }
    }
    public AddrEyediagram addrEyediagram = new AddrEyediagram();
    public class Osccontrol{
    /**
    *   new bit
    **/
        public boolean read_DataClear() {
    	    return readIoBoolean(ADDR_OSCCONTROL, 2);
        }
        public boolean read_and_reset_DataClear() {
    	    boolean ret = readIoBoolean(ADDR_OSCCONTROL, 2);
             write_DataClear(false);
    	    return ret;
        }
    /**
    *   new bit
    **/
        public void write_DataClear(boolean value) {
            writeIo(ADDR_OSCCONTROL, value, 2);
        }
    /**
    *   new bit
    **/
        public boolean read_Trigger() {
    	    return readIoBoolean(ADDR_OSCCONTROL, 1);
        }
        public boolean read_and_reset_Trigger() {
    	    boolean ret = readIoBoolean(ADDR_OSCCONTROL, 1);
             write_Trigger(false);
    	    return ret;
        }
    /**
    *   new bit
    **/
        public void write_Trigger(boolean value) {
            writeIo(ADDR_OSCCONTROL, value, 1);
        }
    /**
    *   new bit
    **/
        public boolean read_startstop() {
    	    return readIoBoolean(ADDR_OSCCONTROL, 0);
        }
        public boolean read_and_reset_startstop() {
    	    boolean ret = readIoBoolean(ADDR_OSCCONTROL, 0);
             write_startstop(false);
    	    return ret;
        }
    /**
    *   new bit
    **/
        public void write_startstop(boolean value) {
            writeIo(ADDR_OSCCONTROL, value, 0);
        }
    }
    public Osccontrol osccontrol = new Osccontrol();
    public class Ppgcontrol{
    /**
    *   new bit
    **/
        public int read_BitRate() {
    	    return readIoInteger(ADDR_PPGCONTROL, 3,2);
        }
        public int read_and_reset_BitRate() {
    	    int ret = readIoInteger(ADDR_PPGCONTROL, 3,2);
             write_BitRate(0);
    	    return ret;
        }
    /**
    *   new bit
    **/
        public void write_BitRate(int value) {
            writeIo(ADDR_PPGCONTROL, value, 2, 3);
        }
    /**
    *   new bit
    **/
        public boolean read_StartStop() {
    	    return readIoBoolean(ADDR_PPGCONTROL, 1);
        }
        public boolean read_and_reset_StartStop() {
    	    boolean ret = readIoBoolean(ADDR_PPGCONTROL, 1);
             write_StartStop(false);
    	    return ret;
        }
    /**
    *   new bit
    **/
        public void write_StartStop(boolean value) {
            writeIo(ADDR_PPGCONTROL, value, 1);
        }
    /**
    *   new bit
    **/
        public boolean read_TestPattern() {
    	    return readIoBoolean(ADDR_PPGCONTROL, 0);
        }
        public boolean read_and_reset_TestPattern() {
    	    boolean ret = readIoBoolean(ADDR_PPGCONTROL, 0);
             write_TestPattern(false);
    	    return ret;
        }
    /**
    *   new bit
    **/
        public void write_TestPattern(boolean value) {
            writeIo(ADDR_PPGCONTROL, value, 0);
        }
    }
    public Ppgcontrol ppgcontrol = new Ppgcontrol();
    public class Newregthu4{
    }
    public Newregthu4 newregthu4 = new Newregthu4();
    public class Newregth555{
    }
    public Newregth555 newregth555 = new Newregth555();
    public class Newregth00{
    }
    public Newregth00 newregth00 = new Newregth00();
    public class Newregthu000{
    }
    public Newregthu000 newregthu000 = new Newregthu000();
}
