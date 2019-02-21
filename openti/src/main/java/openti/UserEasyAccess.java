package openti;
import jp.silverbullet.dependency2.RequestRejectedException;
import jp.silverbullet.sequncer.EasyAccessInterface;
public class UserEasyAccess {
    private EasyAccessInterface model;
    public UserEasyAccess(EasyAccessInterface model2) {
        this.model = model2;
    }
    public enum EnumApplication{
        ID_APPLICATION_OTDR,
        ID_APPLICATION_SQA,
    };
    public void setApplication(EnumApplication value) throws RequestRejectedException {
        model.requestChange(ID.ID_APPLICATION, value.toString());
    }
    public EnumApplication getApplication() {
        return EnumApplication.valueOf(model.getProperty(ID.ID_APPLICATION).getCurrentValue());
    }
    public enum EnumPulsewidth{
        ID_PULSEWIDTH_1NS,
        ID_PULSEWIDTH_10NS,
        ID_PULSEWIDTH_20NS,
        ID_PULSEWIDTH_50NS,
        ID_PULSEWIDTH_100NS,
        ID_PULSEWIDTH_500NS,
    };
    public void setPulsewidth(EnumPulsewidth value) throws RequestRejectedException {
        model.requestChange(ID.ID_PULSEWIDTH, value.toString());
    }
    public EnumPulsewidth getPulsewidth() {
        return EnumPulsewidth.valueOf(model.getProperty(ID.ID_PULSEWIDTH).getCurrentValue());
    }
    public enum EnumDistancerange{
        ID_DISTANCERANGE_1KM,
        ID_DISTANCERANGE_10KM,
        ID_DISTANCERANGE_20KM,
        ID_DISTANCERANGE_50KM,
        ID_DISTANCERANGE_100KM,
        ID_DISTANCERANGE_200KM,
    };
    public void setDistancerange(EnumDistancerange value) throws RequestRejectedException {
        model.requestChange(ID.ID_DISTANCERANGE, value.toString());
    }
    public EnumDistancerange getDistancerange() {
        return EnumDistancerange.valueOf(model.getProperty(ID.ID_DISTANCERANGE).getCurrentValue());
    }
    public void setDistancerange(EnumDistancerange value, int index) throws RequestRejectedException {
        model.requestChange(ID.ID_DISTANCERANGE, index, value.toString());
    }
    public EnumDistancerange getDistancerange(int index) {
        return EnumDistancerange.valueOf(model.getProperty(ID.ID_DISTANCERANGE + "#" + index).getCurrentValue());
    }
    public void setTable(String value) throws RequestRejectedException {
        model.requestChange(ID.ID_TABLE, String.valueOf(value));
    }
    public String getTable() {
        return String.valueOf(model.getProperty(ID.ID_TABLE).getCurrentValue());
    }
    public enum EnumOtdrTestcontrol{
        ID_OTDR_TESTCONTROL_START,
        ID_OTDR_TESTCONTROL_STOP,
    };
    public void setOtdrTestcontrol(EnumOtdrTestcontrol value) throws RequestRejectedException {
        model.requestChange(ID.ID_OTDR_TESTCONTROL, value.toString());
    }
    public EnumOtdrTestcontrol getOtdrTestcontrol() {
        return EnumOtdrTestcontrol.valueOf(model.getProperty(ID.ID_OTDR_TESTCONTROL).getCurrentValue());
    }
    public void setAveragetime(Long value) throws RequestRejectedException {
        model.requestChange(ID.ID_AVERAGETIME, String.valueOf(value));
    }
    public Long getAveragetime() {
        return Long.valueOf(model.getProperty(ID.ID_AVERAGETIME).getCurrentValue());
    }
    public enum EnumOscTestcontrol{
        ID_OSC_TESTCONTROL_START,
        ID_OSC_TESTCONTROL_STOP,
    };
    public void setOscTestcontrol(EnumOscTestcontrol value) throws RequestRejectedException {
        model.requestChange(ID.ID_OSC_TESTCONTROL, value.toString());
    }
    public EnumOscTestcontrol getOscTestcontrol() {
        return EnumOscTestcontrol.valueOf(model.getProperty(ID.ID_OSC_TESTCONTROL).getCurrentValue());
    }
    public enum EnumError{
        ID_ERROR_NOERROR,
        ID_ERROR_HARDWARE,
    };
    public void setError(EnumError value) throws RequestRejectedException {
        model.requestChange(ID.ID_ERROR, value.toString());
    }
    public EnumError getError() {
        return EnumError.valueOf(model.getProperty(ID.ID_ERROR).getCurrentValue());
    }
    public enum EnumTestMode{
        ID_TEST_MODE_AUTO,
        ID_TEST_MODE_MANUAL,
    };
    public void setTestMode(EnumTestMode value) throws RequestRejectedException {
        model.requestChange(ID.ID_TEST_MODE, value.toString());
    }
    public EnumTestMode getTestMode() {
        return EnumTestMode.valueOf(model.getProperty(ID.ID_TEST_MODE).getCurrentValue());
    }
    public void setAverageResult(Long value) throws RequestRejectedException {
        model.requestChange(ID.ID_AVERAGE_RESULT, String.valueOf(value));
    }
    public Long getAverageResult() {
        return Long.valueOf(model.getProperty(ID.ID_AVERAGE_RESULT).getCurrentValue());
    }
    public enum EnumCollecmode{
        ID_COLLECMODE_AVERAGE,
        ID_COLLECMODE_REALTIME,
    };
    public void setCollecmode(EnumCollecmode value) throws RequestRejectedException {
        model.requestChange(ID.ID_COLLECMODE, value.toString());
    }
    public EnumCollecmode getCollecmode() {
        return EnumCollecmode.valueOf(model.getProperty(ID.ID_COLLECMODE).getCurrentValue());
    }
    public enum EnumModelname{
        ID_MODELNAME_P1000A,
        ID_MODELNAME_P2000B,
    };
    public void setModelname(EnumModelname value) throws RequestRejectedException {
        model.requestChange(ID.ID_MODELNAME, value.toString());
    }
    public EnumModelname getModelname() {
        return EnumModelname.valueOf(model.getProperty(ID.ID_MODELNAME).getCurrentValue());
    }
    public void setOption001(Boolean value) throws RequestRejectedException {
        model.requestChange(ID.ID_OPTION_001, String.valueOf(value));
    }
    public Boolean getOption001() {
        return Boolean.valueOf(model.getProperty(ID.ID_OPTION_001).getCurrentValue());
    }
    public void setOption002(Boolean value) throws RequestRejectedException {
        model.requestChange(ID.ID_OPTION_002, String.valueOf(value));
    }
    public Boolean getOption002() {
        return Boolean.valueOf(model.getProperty(ID.ID_OPTION_002).getCurrentValue());
    }
    public void setOption003(Boolean value) throws RequestRejectedException {
        model.requestChange(ID.ID_OPTION_003, String.valueOf(value));
    }
    public Boolean getOption003() {
        return Boolean.valueOf(model.getProperty(ID.ID_OPTION_003).getCurrentValue());
    }
    public void setLoss(Double value) throws RequestRejectedException {
        model.requestChange(ID.ID_LOSS, String.valueOf(value));
    }
    public Double getLoss() {
        return Double.valueOf(model.getProperty(ID.ID_LOSS).getCurrentValue());
    }
    public void setFatalerror(Boolean value) throws RequestRejectedException {
        model.requestChange(ID.ID_FATALERROR, String.valueOf(value));
    }
    public Boolean getFatalerror() {
        return Boolean.valueOf(model.getProperty(ID.ID_FATALERROR).getCurrentValue());
    }
}
