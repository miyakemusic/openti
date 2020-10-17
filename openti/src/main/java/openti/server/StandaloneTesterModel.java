package openti.server;

import openti.ValueChangeListener;

public interface StandaloneTesterModel {

	void requestChange(String id, String value);

	String getValue(String id);

	void addValueChangeListener(ValueChangeListener valueChangeListener);

	void removeValueChangeListener(ValueChangeListener listener);


}
