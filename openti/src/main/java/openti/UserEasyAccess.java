package openti;
import jp.silverbullet.handlers.EasyAccessModel;
public class UserEasyAccess {
    private EasyAccessModel model;
    public UserEasyAccess(EasyAccessModel model2) {
        this.model = model2;
    }
    public enum EnumOtdrTestcontrol{
        ID_OTDR_TESTCONTROL_START,
        ID_OTDR_TESTCONTROL_STOP,
    };
    public void setOtdrTestcontrol(EnumOtdrTestcontrol value) {
        model.requestChange(ID.ID_OTDR_TESTCONTROL, value.toString());
    }
    public EnumOtdrTestcontrol getOtdrTestcontrol() {
        return EnumOtdrTestcontrol.valueOf(model.getProperty(ID.ID_OTDR_TESTCONTROL).getCurrentValue());
    }
    public void setOtdrAverage(long value) {
        model.requestChange(ID.ID_OTDR_AVERAGE, String.valueOf(value));
    }
    public long getOtdrAverage() {
        return Long.valueOf(model.getProperty(ID.ID_OTDR_AVERAGE).getCurrentValue());
    }
    public void setOtdrTable(String value) {
        model.requestChange(ID.ID_OTDR_TABLE, value);
    }
    public String getOtdrTable() {
        return model.getProperty(ID.ID_OTDR_TABLE).getCurrentValue();
    }
    public enum EnumOtdrError{
        ID_OTDR_ERROR_NONE,
        ID_OTDR_ERROR_HARDWARE,
    };
    public void setOtdrError(EnumOtdrError value) {
        model.requestChange(ID.ID_OTDR_ERROR, value.toString());
    }
    public EnumOtdrError getOtdrError() {
        return EnumOtdrError.valueOf(model.getProperty(ID.ID_OTDR_ERROR).getCurrentValue());
    }
    public enum EnumOtdrCollectionMode{
        ID_OTDR_COLLECTION_MODE_AVERAGE,
        ID_OTDR_COLLECTION_MODE_REALTIME,
    };
    public void setOtdrCollectionMode(EnumOtdrCollectionMode value) {
        model.requestChange(ID.ID_OTDR_COLLECTION_MODE, value.toString());
    }
    public EnumOtdrCollectionMode getOtdrCollectionMode() {
        return EnumOtdrCollectionMode.valueOf(model.getProperty(ID.ID_OTDR_COLLECTION_MODE).getCurrentValue());
    }
    public void setOtdrAverageResult(long value) {
        model.requestChange(ID.ID_OTDR_AVERAGE_RESULT, String.valueOf(value));
    }
    public long getOtdrAverageResult() {
        return Long.valueOf(model.getProperty(ID.ID_OTDR_AVERAGE_RESULT).getCurrentValue());
    }
}
