package openti;
import java.util.BitSet;

import obsolute.register.SvSimulator;
abstract public class AbstractUserSimulator extends SvSimulator {
	public void writeIo(long address, BitSet data, BitSet mask) {
	}
	public void readIo(long address) {
	}
}
