package openti;
import java.util.BitSet;
import jp.silverbullet.register.SvSimulator;
abstract public class AbstractUserSimulator extends SvSimulator {
    public void write_otdrtestcontrol_teststart(int value) {};
    public void read_otdrtestcontrol_otdrtestcontrol() {};
    public void read_Dummy_Dummy() {};
    public void write_otdrhardkey_setup(int value) {};
    public void write_otdrhardkey_loa(int value) {};
    public void write_otdrhardkey_save(int value) {};
    public void write_otdrhardkey_realtime(int value) {};
    public void write_otdrhardkey_average(int value) {};
    public void read_otdrhardkey_otdrhardkey() {};
    public void write_otdrinterruptstatus_traceready(int value) {};
    public void write_otdrinterruptstatus_erroroccurs(int value) {};
    public void read_otdrinterruptstatus_otdrinterruptstatus() {};
    public void read_otdrtracedata_otdrtracedata() {};
    public void read_eyediagram_eyediagram() {};
    public void write_PPGControl_BitRate(int value) {};
    public void write_PPGControl_StartStop(int value) {};
    public void write_PPGControl_TestPattern(int value) {};
    public void read_PPGControl_PPGControl() {};
    public void write_OSCControl_trigger(int value) {};
    public void write_OSCControl_dataclear(int value) {};
    public void write_OSCControl_startstop(int value) {};
    public void read_OSCControl_OSCControl() {};
	public void writeIo(long address, BitSet data, BitSet mask) {
		if (address == SimRegisterControl.ADDR_OTDRTESTCONTROL) {
			if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_otdrtestcontrol_teststart(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_DUMMY) {
		}
		else if (address == SimRegisterControl.ADDR_OTDRHARDKEY) {
			if (mask.get(4)) {
				int value = getValue(4, data, mask);
				write_otdrhardkey_setup(value);
			}
			else if (mask.get(3)) {
				int value = getValue(3, data, mask);
				write_otdrhardkey_loa(value);
			}
			else if (mask.get(2)) {
				int value = getValue(2, data, mask);
				write_otdrhardkey_save(value);
			}
			else if (mask.get(1)) {
				int value = getValue(1, data, mask);
				write_otdrhardkey_realtime(value);
			}
			else if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_otdrhardkey_average(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_OTDRINTERRUPTSTATUS) {
			if (mask.get(1)) {
				int value = getValue(1, data, mask);
				write_otdrinterruptstatus_traceready(value);
			}
			else if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_otdrinterruptstatus_erroroccurs(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_OTDRTRACEDATA) {
		}
		else if (address == SimRegisterControl.ADDR_EYEDIAGRAM) {
		}
		else if (address == SimRegisterControl.ADDR_PPGCONTROL) {
			if (mask.get(4)) {
				int value = getValue(4, data, mask);
				write_PPGControl_BitRate(value);
			}
			else if (mask.get(2)) {
				int value = getValue(2, data, mask);
				write_PPGControl_StartStop(value);
			}
			else if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_PPGControl_TestPattern(value);
			}
		}
		else if (address == SimRegisterControl.ADDR_OSCCONTROL) {
			if (mask.get(2)) {
				int value = getValue(2, data, mask);
				write_OSCControl_trigger(value);
			}
			else if (mask.get(1)) {
				int value = getValue(1, data, mask);
				write_OSCControl_dataclear(value);
			}
			else if (mask.get(0)) {
				int value = getValue(0, data, mask);
				write_OSCControl_startstop(value);
			}
		}
	}
	public void readIo(long address) {
		if (address == SimRegisterControl.ADDR_OTDRTESTCONTROL) {
				read_otdrtestcontrol_otdrtestcontrol();
		}
		else if (address == SimRegisterControl.ADDR_DUMMY) {
				read_Dummy_Dummy();
		}
		else if (address == SimRegisterControl.ADDR_OTDRHARDKEY) {
				read_otdrhardkey_otdrhardkey();
		}
		else if (address == SimRegisterControl.ADDR_OTDRINTERRUPTSTATUS) {
				read_otdrinterruptstatus_otdrinterruptstatus();
		}
		else if (address == SimRegisterControl.ADDR_OTDRTRACEDATA) {
				read_otdrtracedata_otdrtracedata();
		}
		else if (address == SimRegisterControl.ADDR_EYEDIAGRAM) {
				read_eyediagram_eyediagram();
		}
		else if (address == SimRegisterControl.ADDR_PPGCONTROL) {
				read_PPGControl_PPGControl();
		}
		else if (address == SimRegisterControl.ADDR_OSCCONTROL) {
				read_OSCControl_OSCControl();
		}
	}
}
