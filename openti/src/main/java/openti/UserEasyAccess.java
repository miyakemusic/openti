package openti;
import jp.silverbullet.dependency2.RequestRejectedException;
import jp.silverbullet.sequncer.EasyAccessInterface;
public class UserEasyAccess {
    private EasyAccessInterface model;
    public UserEasyAccess(EasyAccessInterface model2) {
        this.model = model2;
    }
    public enum EnumApplication{
        ID_APPLICATION_BERTS,
        ID_APPLICATION_CONFIG,
        ID_APPLICATION_OSA,
        ID_APPLICATION_OSCILLO,
        ID_APPLICATION_OTDR,
        ID_APPLICATION_TOP,
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
    public void setOscTrigger(Long value) throws RequestRejectedException {
        model.requestChange(ID.ID_OSC_TRIGGER, String.valueOf(value));
    }
    public Long getOscTrigger() {
        return Long.valueOf(model.getProperty(ID.ID_OSC_TRIGGER).getCurrentValue());
    }
    public void setAverageResult(Long value) throws RequestRejectedException {
        model.requestChange(ID.ID_AVERAGE_RESULT, String.valueOf(value));
    }
    public Long getAverageResult() {
        return Long.valueOf(model.getProperty(ID.ID_AVERAGE_RESULT).getCurrentValue());
    }
    public enum EnumPpgPattern{
        ID_PPG_PATTERN_PRBS15,
        ID_PPG_PATTERN_PRBS23,
        ID_PPG_PATTERN_PRBS9,
    };
    public void setPpgPattern(EnumPpgPattern value) throws RequestRejectedException {
        model.requestChange(ID.ID_PPG_PATTERN, value.toString());
    }
    public EnumPpgPattern getPpgPattern() {
        return EnumPpgPattern.valueOf(model.getProperty(ID.ID_PPG_PATTERN).getCurrentValue());
    }
    public enum EnumEdPattern{
        ID_ED_PATTERN_PRBS15,
        ID_ED_PATTERN_PRBS23,
        ID_ED_PATTERN_PRBS9,
    };
    public void setEdPattern(EnumEdPattern value) throws RequestRejectedException {
        model.requestChange(ID.ID_ED_PATTERN, value.toString());
    }
    public EnumEdPattern getEdPattern() {
        return EnumEdPattern.valueOf(model.getProperty(ID.ID_ED_PATTERN).getCurrentValue());
    }
    public void setPpgFrequency(Long value) throws RequestRejectedException {
        model.requestChange(ID.ID_PPG_FREQUENCY, String.valueOf(value));
    }
    public Long getPpgFrequency() {
        return Long.valueOf(model.getProperty(ID.ID_PPG_FREQUENCY).getCurrentValue());
    }
    public enum EnumPpgModulation{
        ID_PPG_MODULATION_CSRZ,
        ID_PPG_MODULATION_NRZ,
        ID_PPG_MODULATION_PAM4,
        ID_PPG_MODULATION_RZ,
    };
    public void setPpgModulation(EnumPpgModulation value) throws RequestRejectedException {
        model.requestChange(ID.ID_PPG_MODULATION, value.toString());
    }
    public EnumPpgModulation getPpgModulation() {
        return EnumPpgModulation.valueOf(model.getProperty(ID.ID_PPG_MODULATION).getCurrentValue());
    }
    public void setEdFrequency(Long value) throws RequestRejectedException {
        model.requestChange(ID.ID_ED_FREQUENCY, String.valueOf(value));
    }
    public Long getEdFrequency() {
        return Long.valueOf(model.getProperty(ID.ID_ED_FREQUENCY).getCurrentValue());
    }
    public enum EnumEdModulation{
        ID_ED_MODULATION_CSRZ,
        ID_ED_MODULATION_NRZ,
        ID_ED_MODULATION_PAM4,
        ID_ED_MODULATION_RZ,
    };
    public void setEdModulation(EnumEdModulation value) throws RequestRejectedException {
        model.requestChange(ID.ID_ED_MODULATION, value.toString());
    }
    public EnumEdModulation getEdModulation() {
        return EnumEdModulation.valueOf(model.getProperty(ID.ID_ED_MODULATION).getCurrentValue());
    }
    public void setOtdrSamplingpoints(Long value) throws RequestRejectedException {
        model.requestChange(ID.ID_OTDR_SAMPLINGPOINTS, String.valueOf(value));
    }
    public Long getOtdrSamplingpoints() {
        return Long.valueOf(model.getProperty(ID.ID_OTDR_SAMPLINGPOINTS).getCurrentValue());
    }
    public enum EnumStatus{
        ID_STATUS_IDLE,
        ID_STATUS_PRESETTING,
        ID_STATUS_TESTING,
    };
    public void setStatus(EnumStatus value) throws RequestRejectedException {
        model.requestChange(ID.ID_STATUS, value.toString());
    }
    public EnumStatus getStatus() {
        return EnumStatus.valueOf(model.getProperty(ID.ID_STATUS).getCurrentValue());
    }
    public enum EnumTrigger{
        ID_TRIGGER_A,
        ID_TRIGGER_B,
        ID_TRIGGER_C,
        ID_TRIGGER_D,
    };
    public void setTrigger(EnumTrigger value) throws RequestRejectedException {
        model.requestChange(ID.ID_TRIGGER, value.toString());
    }
    public EnumTrigger getTrigger() {
        return EnumTrigger.valueOf(model.getProperty(ID.ID_TRIGGER).getCurrentValue());
    }
    public enum EnumTarget{
        ID_TARGET_A,
        ID_TARGET_B,
        ID_TARGET_C,
        ID_TARGET_D,
    };
    public void setTarget(EnumTarget value) throws RequestRejectedException {
        model.requestChange(ID.ID_TARGET, value.toString());
    }
    public EnumTarget getTarget() {
        return EnumTarget.valueOf(model.getProperty(ID.ID_TARGET).getCurrentValue());
    }
    public enum EnumMode{
        ID_MODE_A,
        ID_MODE_B,
    };
    public void setMode(EnumMode value) throws RequestRejectedException {
        model.requestChange(ID.ID_MODE, value.toString());
    }
    public EnumMode getMode() {
        return EnumMode.valueOf(model.getProperty(ID.ID_MODE).getCurrentValue());
    }
    public enum EnumBand{
        ID_BAND_0S,
        ID_BAND_1C,
        ID_BAND_2L,
        ID_BAND_AUTO,
        ID_BAND_USER,
    };
    public void setBand(EnumBand value) throws RequestRejectedException {
        model.requestChange(ID.ID_BAND, value.toString());
    }
    public EnumBand getBand() {
        return EnumBand.valueOf(model.getProperty(ID.ID_BAND).getCurrentValue());
    }
    public void setStartWavelength(Double value) throws RequestRejectedException {
        model.requestChange(ID.ID_START_WAVELENGTH, String.valueOf(value));
    }
    public Double getStartWavelength() {
        return Double.valueOf(model.getProperty(ID.ID_START_WAVELENGTH).getCurrentValue());
    }
    public void setStopWavelength(Double value) throws RequestRejectedException {
        model.requestChange(ID.ID_STOP_WAVELENGTH, String.valueOf(value));
    }
    public Double getStopWavelength() {
        return Double.valueOf(model.getProperty(ID.ID_STOP_WAVELENGTH).getCurrentValue());
    }
    public enum EnumPlace{
        ID_PLACE_HERE,
        ID_PLACE_TOGO,
    };
    public void setPlace(EnumPlace value) throws RequestRejectedException {
        model.requestChange(ID.ID_PLACE, value.toString());
    }
    public EnumPlace getPlace() {
        return EnumPlace.valueOf(model.getProperty(ID.ID_PLACE).getCurrentValue());
    }
    public void setEdsync(Boolean value) throws RequestRejectedException {
        model.requestChange(ID.ID_EDSYNC, String.valueOf(value));
    }
    public Boolean getEdsync() {
        return Boolean.valueOf(model.getProperty(ID.ID_EDSYNC).getCurrentValue());
    }
    public void setUsername(String value) throws RequestRejectedException {
        model.requestChange(ID.ID_USERNAME, String.valueOf(value));
    }
    public String getUsername() {
        return String.valueOf(model.getProperty(ID.ID_USERNAME).getCurrentValue());
    }
    public void setPassword(String value) throws RequestRejectedException {
        model.requestChange(ID.ID_PASSWORD, String.valueOf(value));
    }
    public String getPassword() {
        return String.valueOf(model.getProperty(ID.ID_PASSWORD).getCurrentValue());
    }
    public enum EnumLogin{
        ID_LOGIN_LOGIN,
        ID_LOGIN_LOGOUT,
    };
    public void setLogin(EnumLogin value) throws RequestRejectedException {
        model.requestChange(ID.ID_LOGIN, value.toString());
    }
    public EnumLogin getLogin() {
        return EnumLogin.valueOf(model.getProperty(ID.ID_LOGIN).getCurrentValue());
    }
    public void setLoginMessage(String value) throws RequestRejectedException {
        model.requestChange(ID.ID_LOGIN_MESSAGE, String.valueOf(value));
    }
    public String getLoginMessage() {
        return String.valueOf(model.getProperty(ID.ID_LOGIN_MESSAGE).getCurrentValue());
    }
    public void setSetupdialog(String value) throws RequestRejectedException {
        model.requestChange(ID.ID_SETUPDIALOG, String.valueOf(value));
    }
    public String getSetupdialog() {
        return String.valueOf(model.getProperty(ID.ID_SETUPDIALOG).getCurrentValue());
    }
    public void setCenterWavelength(Double value) throws RequestRejectedException {
        model.requestChange(ID.ID_CENTER_WAVELENGTH, String.valueOf(value));
    }
    public Double getCenterWavelength() {
        return Double.valueOf(model.getProperty(ID.ID_CENTER_WAVELENGTH).getCurrentValue());
    }
    public void setSpanWavelength(Double value) throws RequestRejectedException {
        model.requestChange(ID.ID_SPAN_WAVELENGTH, String.valueOf(value));
    }
    public Double getSpanWavelength() {
        return Double.valueOf(model.getProperty(ID.ID_SPAN_WAVELENGTH).getCurrentValue());
    }
    public void setCursorA(Double value) throws RequestRejectedException {
        model.requestChange(ID.ID_CURSOR_A, String.valueOf(value));
    }
    public Double getCursorA() {
        return Double.valueOf(model.getProperty(ID.ID_CURSOR_A).getCurrentValue());
    }
    public void setCursorB(Double value) throws RequestRejectedException {
        model.requestChange(ID.ID_CURSOR_B, String.valueOf(value));
    }
    public Double getCursorB() {
        return Double.valueOf(model.getProperty(ID.ID_CURSOR_B).getCurrentValue());
    }
}
