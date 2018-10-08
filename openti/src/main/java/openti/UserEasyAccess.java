package openti;
import jp.silverbullet.handlers.EasyAccessModel;
public class UserEasyAccess {
    private EasyAccessModel model;
    public UserEasyAccess(EasyAccessModel model2) {
        this.model = model2;
    }
    public enum EnumOscTestcontrol{
        ID_OSC_TESTCONTROL_START,
        ID_OSC_TESTCONTROL_STOP,
    };
    public void setOscTestcontrol(EnumOscTestcontrol value) {
        model.requestChange(ID.ID_OSC_TESTCONTROL, value.toString());
    }
    public EnumOscTestcontrol getOscTestcontrol() {
        return EnumOscTestcontrol.valueOf(model.getProperty(ID.ID_OSC_TESTCONTROL).getCurrentValue());
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
    public void setOtdrTable(String value) {
        model.requestChange(ID.ID_OTDR_TABLE, value);
    }
    public String getOtdrTable() {
        return model.getProperty(ID.ID_OTDR_TABLE).getCurrentValue();
    }
    public enum EnumApplication{
        ID_APPLICATION_OTDR,
        ID_APPLICATION_SQA,
    };
    public void setApplication(EnumApplication value) {
        model.requestChange(ID.ID_APPLICATION, value.toString());
    }
    public EnumApplication getApplication() {
        return EnumApplication.valueOf(model.getProperty(ID.ID_APPLICATION).getCurrentValue());
    }
    public enum EnumOtdrError{
        ID_OTDR_ERROR_NOERROR,
        ID_OTDR_ERROR_HARDWARE,
    };
    public void setOtdrError(EnumOtdrError value) {
        model.requestChange(ID.ID_OTDR_ERROR, value.toString());
    }
    public EnumOtdrError getOtdrError() {
        return EnumOtdrError.valueOf(model.getProperty(ID.ID_OTDR_ERROR).getCurrentValue());
    }
    public enum EnumOtdrPulsewidth{
        ID_OTDR_PULSEWIDTH_1NS,
        ID_OTDR_PULSEWIDTH_10NS,
        ID_OTDR_PULSEWIDTH_20NS,
        ID_OTDR_PULSEWIDTH_50NS,
        ID_OTDR_PULSEWIDTH_100NS,
        ID_OTDR_PULSEWIDTH_500NS,
    };
    public void setOtdrPulsewidth(EnumOtdrPulsewidth value) {
        model.requestChange(ID.ID_OTDR_PULSEWIDTH, value.toString());
    }
    public EnumOtdrPulsewidth getOtdrPulsewidth() {
        return EnumOtdrPulsewidth.valueOf(model.getProperty(ID.ID_OTDR_PULSEWIDTH).getCurrentValue());
    }
    public void setOtdrAveragetime(long value) {
        model.requestChange(ID.ID_OTDR_AVERAGETIME, String.valueOf(value));
    }
    public long getOtdrAveragetime() {
        return Long.valueOf(model.getProperty(ID.ID_OTDR_AVERAGETIME).getCurrentValue());
    }
    public enum EnumOtdrTestMode{
        ID_OTDR_TEST_MODE_AUTO,
        ID_OTDR_TEST_MODE_MANUAL,
    };
    public void setOtdrTestMode(EnumOtdrTestMode value) {
        model.requestChange(ID.ID_OTDR_TEST_MODE, value.toString());
    }
    public EnumOtdrTestMode getOtdrTestMode() {
        return EnumOtdrTestMode.valueOf(model.getProperty(ID.ID_OTDR_TEST_MODE).getCurrentValue());
    }
    public enum EnumOtdrDistancerange{
        ID_OTDR_DISTANCERANGE_1KM,
        ID_OTDR_DISTANCERANGE_10KM,
        ID_OTDR_DISTANCERANGE_20KM,
        ID_OTDR_DISTANCERANGE_50KM,
        ID_OTDR_DISTANCERANGE_100KM,
    };
    public void setOtdrDistancerange(EnumOtdrDistancerange value) {
        model.requestChange(ID.ID_OTDR_DISTANCERANGE, value.toString());
    }
    public EnumOtdrDistancerange getOtdrDistancerange() {
        return EnumOtdrDistancerange.valueOf(model.getProperty(ID.ID_OTDR_DISTANCERANGE).getCurrentValue());
    }
}
