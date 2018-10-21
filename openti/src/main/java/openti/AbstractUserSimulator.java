package openti;
import java.util.BitSet;
import jp.silverbullet.register.SvSimulator;
abstract public class AbstractUserSimulator extends SvSimulator {
    public void write_otdrtestcontrol_teststart(int value) {};
    public void read_otdrtestcontrol_otdrtestcontrol() {};
    public void write_Hardkey_Setup(int value) {};
    public void write_Hardkey_Load(int value) {};
    public void write_Hardkey_Save(int value) {};
    public void write_Hardkey_Realtime(int value) {};
    public void write_Hardkey_Average(int value) {};
    public void read_Hardkey_Hardkey() {};
    public void read_OTDRdeummhy_OTDRdeummhy() {};
    public void write_otdrinterruptstatus_erroroccurs(int value) {};
    public void write_otdrinterruptstatus_tracedataready(int value) {};
    public void read_otdrinterruptstatus_otdrinterruptstatus() {};
    public void write_addrotdrtracedata_data(int value) {};
    public void read_addrotdrtracedata_addrotdrtracedata() {};
    public void write_addreyediagram_data(int value) {};
    public void read_addreyediagram_addreyediagram() {};
    public void write_OSCControl_DataClear(int value) {};
    public void write_OSCControl_Trigger(int value) {};
    public void write_OSCControl_startstop(int value) {};
    public void read_OSCControl_OSCControl() {};
    public void write_PPGControl_BitRate(int value) {};
    public void write_PPGControl_StartStop(int value) {};
    public void write_PPGControl_TestPattern(int value) {};
    public void read_PPGControl_PPGControl() {};
	public void writeIo(long address, BitSet data, BitSet mask) {
		if (address == SimRegisterControl.ADDR_OTDRTESTCONTROL) {
			if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_otdrtestcontrol_teststart(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_HARDKEY) {
			if (mask.get(4)) {
				int value = getValue(4, data, mask);
				write_Hardkey_Setup(value);
			}
			else if (mask.get(3)) {
				int value = getValue(3, data, mask);
				write_Hardkey_Load(value);
			}
			else if (mask.get(2)) {
				int value = getValue(2, data, mask);
				write_Hardkey_Save(value);
			}
			else if (mask.get(1)) {
				int value = getValue(1, data, mask);
				write_Hardkey_Realtime(value);
			}
			else if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_Hardkey_Average(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_OTDRDEUMMHY) {
		}
		else if (address == SimRegisterControl.ADDR_OTDRINTERRUPTSTATUS) {
			if (mask.get(1)) {
				int value = getValue(1, data, mask);
				write_otdrinterruptstatus_erroroccurs(value);
			}
			else if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_otdrinterruptstatus_tracedataready(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_ADDROTDRTRACEDATA) {
			if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_addrotdrtracedata_data(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_ADDREYEDIAGRAM) {
			if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_addreyediagram_data(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_OSCCONTROL) {
			if (mask.get(2)) {
				int value = getValue(2, data, mask);
				write_OSCControl_DataClear(value);
			}
			else if (mask.get(1)) {
				int value = getValue(1, data, mask);
				write_OSCControl_Trigger(value);
			}
			else if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_OSCControl_startstop(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_PPGCONTROL) {
			if (mask.get(2)) {
				int value = getValue(2, data, mask);
				write_PPGControl_BitRate(value);
			}
			else if (mask.get(1)) {
				int value = getValue(1, data, mask);
				write_PPGControl_StartStop(value);
			}
			else if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_PPGControl_TestPattern(value);
			}
		}
	}
	public void readIo(long address) {
		if (address == SimRegisterControl.ADDR_OTDRTESTCONTROL) {
				read_otdrtestcontrol_otdrtestcontrol();
		}
		else if (address == SimRegisterControl.ADDR_HARDKEY) {
				read_Hardkey_Hardkey();
		}
		else if (address == SimRegisterControl.ADDR_OTDRDEUMMHY) {
				read_OTDRdeummhy_OTDRdeummhy();
		}
		else if (address == SimRegisterControl.ADDR_OTDRINTERRUPTSTATUS) {
				read_otdrinterruptstatus_otdrinterruptstatus();
		}
		else if (address == SimRegisterControl.ADDR_ADDROTDRTRACEDATA) {
				read_addrotdrtracedata_addrotdrtracedata();
		}
		else if (address == SimRegisterControl.ADDR_ADDREYEDIAGRAM) {
				read_addreyediagram_addreyediagram();
		}
		else if (address == SimRegisterControl.ADDR_OSCCONTROL) {
				read_OSCControl_OSCControl();
		}
		else if (address == SimRegisterControl.ADDR_PPGCONTROL) {
				read_PPGControl_PPGControl();
		}
	}
}
