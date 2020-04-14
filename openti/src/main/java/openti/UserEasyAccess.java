package openti;
import jp.silverbullet.core.dependency2.RequestRejectedException;
import jp.silverbullet.core.sequncer.EasyAccessInterface;
public class UserEasyAccess {
    private EasyAccessInterface model;
    public UserEasyAccess(EasyAccessInterface model2) {
        this.model = model2;
    }
    public enum EnumApplication{
        ID_APPLICATION_BERTS,
        ID_APPLICATION_CONFIG,
        ID_APPLICATION_FILE_MANAGER,
        ID_APPLICATION_OSA,
        ID_APPLICATION_OSCILLO,
        ID_APPLICATION_OTDR,
        ID_APPLICATION_TOP,
    };
    public void setApplication(EnumApplication value) throws RequestRejectedException {
        model.requestChange(ID.ID_APPLICATION, value.toString());
    }
    public EnumApplication getApplication() {
        return EnumApplication.valueOf(model.getCurrentValue(ID.ID_APPLICATION));
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
        return EnumPulsewidth.valueOf(model.getCurrentValue(ID.ID_PULSEWIDTH));
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
        return EnumDistancerange.valueOf(model.getCurrentValue(ID.ID_DISTANCERANGE));
    }
    public void setTable(String value) throws RequestRejectedException {
        model.requestChange(ID.ID_TABLE, String.valueOf(value));
    }
    public String getTable() {
        return String.valueOf(model.getCurrentValue(ID.ID_TABLE));
    }
    public enum EnumOtdrTestcontrol{
        ID_OTDR_TESTCONTROL_START,
        ID_OTDR_TESTCONTROL_STOP,
    };
    public void setOtdrTestcontrol(EnumOtdrTestcontrol value) throws RequestRejectedException {
        model.requestChange(ID.ID_OTDR_TESTCONTROL, value.toString());
    }
    public EnumOtdrTestcontrol getOtdrTestcontrol() {
        return EnumOtdrTestcontrol.valueOf(model.getCurrentValue(ID.ID_OTDR_TESTCONTROL));
    }
    public void setAveragetime(Long value) throws RequestRejectedException {
        model.requestChange(ID.ID_AVERAGETIME, String.valueOf(value));
    }
    public Long getAveragetime() {
        return Long.valueOf(model.getCurrentValue(ID.ID_AVERAGETIME));
    }
    public enum EnumOscTestcontrol{
        ID_OSC_TESTCONTROL_START,
        ID_OSC_TESTCONTROL_STOP,
    };
    public void setOscTestcontrol(EnumOscTestcontrol value) throws RequestRejectedException {
        model.requestChange(ID.ID_OSC_TESTCONTROL, value.toString());
    }
    public EnumOscTestcontrol getOscTestcontrol() {
        return EnumOscTestcontrol.valueOf(model.getCurrentValue(ID.ID_OSC_TESTCONTROL));
    }
    public enum EnumError{
        ID_ERROR_NOERROR,
        ID_ERROR_HARDWARE,
    };
    public void setError(EnumError value) throws RequestRejectedException {
        model.requestChange(ID.ID_ERROR, value.toString());
    }
    public EnumError getError() {
        return EnumError.valueOf(model.getCurrentValue(ID.ID_ERROR));
    }
    public enum EnumTestMode{
        ID_TEST_MODE_AUTO,
        ID_TEST_MODE_MANUAL,
    };
    public void setTestMode(EnumTestMode value) throws RequestRejectedException {
        model.requestChange(ID.ID_TEST_MODE, value.toString());
    }
    public EnumTestMode getTestMode() {
        return EnumTestMode.valueOf(model.getCurrentValue(ID.ID_TEST_MODE));
    }
    public enum EnumCollecmode{
        ID_COLLECMODE_AVERAGE,
        ID_COLLECMODE_OPTIMIZED,
        ID_COLLECMODE_REALTIME,
    };
    public void setCollecmode(EnumCollecmode value) throws RequestRejectedException {
        model.requestChange(ID.ID_COLLECMODE, value.toString());
    }
    public EnumCollecmode getCollecmode() {
        return EnumCollecmode.valueOf(model.getCurrentValue(ID.ID_COLLECMODE));
    }
    public enum EnumModelname{
        ID_MODELNAME_P1000A,
        ID_MODELNAME_P2000B,
    };
    public void setModelname(EnumModelname value) throws RequestRejectedException {
        model.requestChange(ID.ID_MODELNAME, value.toString());
    }
    public EnumModelname getModelname() {
        return EnumModelname.valueOf(model.getCurrentValue(ID.ID_MODELNAME));
    }
    public void setOption001(Boolean value) throws RequestRejectedException {
        model.requestChange(ID.ID_OPTION_001, String.valueOf(value));
    }
    public Boolean getOption001() {
        return Boolean.valueOf(model.getCurrentValue(ID.ID_OPTION_001));
    }
    public void setOption002(Boolean value) throws RequestRejectedException {
        model.requestChange(ID.ID_OPTION_002, String.valueOf(value));
    }
    public Boolean getOption002() {
        return Boolean.valueOf(model.getCurrentValue(ID.ID_OPTION_002));
    }
    public void setOption003(Boolean value) throws RequestRejectedException {
        model.requestChange(ID.ID_OPTION_003, String.valueOf(value));
    }
    public Boolean getOption003() {
        return Boolean.valueOf(model.getCurrentValue(ID.ID_OPTION_003));
    }
    public void setLoss(Double value) throws RequestRejectedException {
        model.requestChange(ID.ID_LOSS, String.valueOf(value));
    }
    public Double getLoss() {
        return Double.valueOf(model.getCurrentValue(ID.ID_LOSS));
    }
    public void setFatalerror(Boolean value) throws RequestRejectedException {
        model.requestChange(ID.ID_FATALERROR, String.valueOf(value));
    }
    public Boolean getFatalerror() {
        return Boolean.valueOf(model.getCurrentValue(ID.ID_FATALERROR));
    }
    public void setOscTrigger(Long value) throws RequestRejectedException {
        model.requestChange(ID.ID_OSC_TRIGGER, String.valueOf(value));
    }
    public Long getOscTrigger() {
        return Long.valueOf(model.getCurrentValue(ID.ID_OSC_TRIGGER));
    }
    public void setAverageResult(Long value) throws RequestRejectedException {
        model.requestChange(ID.ID_AVERAGE_RESULT, String.valueOf(value));
    }
    public Long getAverageResult() {
        return Long.valueOf(model.getCurrentValue(ID.ID_AVERAGE_RESULT));
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
        return EnumPpgPattern.valueOf(model.getCurrentValue(ID.ID_PPG_PATTERN));
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
        return EnumEdPattern.valueOf(model.getCurrentValue(ID.ID_ED_PATTERN));
    }
    public void setPpgFrequency(Long value) throws RequestRejectedException {
        model.requestChange(ID.ID_PPG_FREQUENCY, String.valueOf(value));
    }
    public Long getPpgFrequency() {
        return Long.valueOf(model.getCurrentValue(ID.ID_PPG_FREQUENCY));
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
        return EnumPpgModulation.valueOf(model.getCurrentValue(ID.ID_PPG_MODULATION));
    }
    public void setEdFrequency(Long value) throws RequestRejectedException {
        model.requestChange(ID.ID_ED_FREQUENCY, String.valueOf(value));
    }
    public Long getEdFrequency() {
        return Long.valueOf(model.getCurrentValue(ID.ID_ED_FREQUENCY));
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
        return EnumEdModulation.valueOf(model.getCurrentValue(ID.ID_ED_MODULATION));
    }
    public void setOtdrSamplingpoints(Long value) throws RequestRejectedException {
        model.requestChange(ID.ID_OTDR_SAMPLINGPOINTS, String.valueOf(value));
    }
    public Long getOtdrSamplingpoints() {
        return Long.valueOf(model.getCurrentValue(ID.ID_OTDR_SAMPLINGPOINTS));
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
        return EnumStatus.valueOf(model.getCurrentValue(ID.ID_STATUS));
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
        return EnumTrigger.valueOf(model.getCurrentValue(ID.ID_TRIGGER));
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
        return EnumTarget.valueOf(model.getCurrentValue(ID.ID_TARGET));
    }
    public enum EnumMode{
        ID_MODE_A,
        ID_MODE_B,
    };
    public void setMode(EnumMode value) throws RequestRejectedException {
        model.requestChange(ID.ID_MODE, value.toString());
    }
    public EnumMode getMode() {
        return EnumMode.valueOf(model.getCurrentValue(ID.ID_MODE));
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
        return EnumBand.valueOf(model.getCurrentValue(ID.ID_BAND));
    }
    public void setStartWavelength(Double value) throws RequestRejectedException {
        model.requestChange(ID.ID_START_WAVELENGTH, String.valueOf(value));
    }
    public Double getStartWavelength() {
        return Double.valueOf(model.getCurrentValue(ID.ID_START_WAVELENGTH));
    }
    public void setStopWavelength(Double value) throws RequestRejectedException {
        model.requestChange(ID.ID_STOP_WAVELENGTH, String.valueOf(value));
    }
    public Double getStopWavelength() {
        return Double.valueOf(model.getCurrentValue(ID.ID_STOP_WAVELENGTH));
    }
    public enum EnumPlace{
        ID_PLACE_HERE,
        ID_PLACE_TOGO,
    };
    public void setPlace(EnumPlace value) throws RequestRejectedException {
        model.requestChange(ID.ID_PLACE, value.toString());
    }
    public EnumPlace getPlace() {
        return EnumPlace.valueOf(model.getCurrentValue(ID.ID_PLACE));
    }
    public void setEdsync(Boolean value) throws RequestRejectedException {
        model.requestChange(ID.ID_EDSYNC, String.valueOf(value));
    }
    public Boolean getEdsync() {
        return Boolean.valueOf(model.getCurrentValue(ID.ID_EDSYNC));
    }
    public void setUsername(String value) throws RequestRejectedException {
        model.requestChange(ID.ID_USERNAME, String.valueOf(value));
    }
    public String getUsername() {
        return String.valueOf(model.getCurrentValue(ID.ID_USERNAME));
    }
    public void setPassword(String value) throws RequestRejectedException {
        model.requestChange(ID.ID_PASSWORD, String.valueOf(value));
    }
    public String getPassword() {
        return String.valueOf(model.getCurrentValue(ID.ID_PASSWORD));
    }
    public enum EnumLogin{
        ID_LOGIN_LOGIN,
        ID_LOGIN_LOGOUT,
    };
    public void setLogin(EnumLogin value) throws RequestRejectedException {
        model.requestChange(ID.ID_LOGIN, value.toString());
    }
    public EnumLogin getLogin() {
        return EnumLogin.valueOf(model.getCurrentValue(ID.ID_LOGIN));
    }
    public void setLoginMessage(String value) throws RequestRejectedException {
        model.requestChange(ID.ID_LOGIN_MESSAGE, String.valueOf(value));
    }
    public String getLoginMessage() {
        return String.valueOf(model.getCurrentValue(ID.ID_LOGIN_MESSAGE));
    }
    public void setSetupdialog(String value) throws RequestRejectedException {
        model.requestChange(ID.ID_SETUPDIALOG, String.valueOf(value));
    }
    public String getSetupdialog() {
        return String.valueOf(model.getCurrentValue(ID.ID_SETUPDIALOG));
    }
    public void setCenterWavelength(Double value) throws RequestRejectedException {
        model.requestChange(ID.ID_CENTER_WAVELENGTH, String.valueOf(value));
    }
    public Double getCenterWavelength() {
        return Double.valueOf(model.getCurrentValue(ID.ID_CENTER_WAVELENGTH));
    }
    public void setSpanWavelength(Double value) throws RequestRejectedException {
        model.requestChange(ID.ID_SPAN_WAVELENGTH, String.valueOf(value));
    }
    public Double getSpanWavelength() {
        return Double.valueOf(model.getCurrentValue(ID.ID_SPAN_WAVELENGTH));
    }
    public void setCursorA(Double value) throws RequestRejectedException {
        model.requestChange(ID.ID_CURSOR_A, String.valueOf(value));
    }
    public Double getCursorA() {
        return Double.valueOf(model.getCurrentValue(ID.ID_CURSOR_A));
    }
    public void setCursorB(Double value) throws RequestRejectedException {
        model.requestChange(ID.ID_CURSOR_B, String.valueOf(value));
    }
    public Double getCursorB() {
        return Double.valueOf(model.getCurrentValue(ID.ID_CURSOR_B));
    }
    public void setWavelengthUpperlimit(Double value) throws RequestRejectedException {
        model.requestChange(ID.ID_WAVELENGTH_UPPERLIMIT, String.valueOf(value));
    }
    public Double getWavelengthUpperlimit() {
        return Double.valueOf(model.getCurrentValue(ID.ID_WAVELENGTH_UPPERLIMIT));
    }
    public void setWavelengthLowerlimit(Double value) throws RequestRejectedException {
        model.requestChange(ID.ID_WAVELENGTH_LOWERLIMIT, String.valueOf(value));
    }
    public Double getWavelengthLowerlimit() {
        return Double.valueOf(model.getCurrentValue(ID.ID_WAVELENGTH_LOWERLIMIT));
    }
    public void setFileList(String value) throws RequestRejectedException {
        model.requestChange(ID.ID_FILE_LIST, String.valueOf(value));
    }
    public String getFileList() {
        return String.valueOf(model.getCurrentValue(ID.ID_FILE_LIST));
    }
    public void setFileFolder(String value) throws RequestRejectedException {
        model.requestChange(ID.ID_FILE_FOLDER, String.valueOf(value));
    }
    public String getFileFolder() {
        return String.valueOf(model.getCurrentValue(ID.ID_FILE_FOLDER));
    }
    public enum EnumFileFilter{
        ID_FILE_FILTER_ALL,
        ID_FILE_FILTER_DLL,
        ID_FILE_FILTER_INI,
        ID_FILE_FILTER_JSON,
        ID_FILE_FILTER_TXT,
        ID_FILE_FILTER_XML,
    };
    public void setFileFilter(EnumFileFilter value) throws RequestRejectedException {
        model.requestChange(ID.ID_FILE_FILTER, value.toString());
    }
    public EnumFileFilter getFileFilter() {
        return EnumFileFilter.valueOf(model.getCurrentValue(ID.ID_FILE_FILTER));
    }
    public void setFileName(String value) throws RequestRejectedException {
        model.requestChange(ID.ID_FILE_NAME, String.valueOf(value));
    }
    public String getFileName() {
        return String.valueOf(model.getCurrentValue(ID.ID_FILE_NAME));
    }
    public void setEdSync(Boolean value) throws RequestRejectedException {
        model.requestChange(ID.ID_ED_SYNC, String.valueOf(value));
    }
    public Boolean getEdSync() {
        return Boolean.valueOf(model.getCurrentValue(ID.ID_ED_SYNC));
    }
    public void setCursorStep(Double value) throws RequestRejectedException {
        model.requestChange(ID.ID_CURSOR_STEP, String.valueOf(value));
    }
    public Double getCursorStep() {
        return Double.valueOf(model.getCurrentValue(ID.ID_CURSOR_STEP));
    }
    public enum EnumBertsState{
        ID_BERTS_STATE_ANALYZING,
        ID_BERTS_STATE_IDLE,
        ID_BERTS_STATE_PREPARE_TEST,
        ID_BERTS_STATE_SAVING_FILE,
        ID_BERTS_STATE_SAVING_FILE_ACTION,
        ID_BERTS_STATE_TESING,
    };
    public void setBertsState(EnumBertsState value) throws RequestRejectedException {
        model.requestChange(ID.ID_BERTS_STATE, value.toString());
    }
    public EnumBertsState getBertsState() {
        return EnumBertsState.valueOf(model.getCurrentValue(ID.ID_BERTS_STATE));
    }
    public enum EnumBertsModule1Teststate{
        ID_BERTS_MODULE1_TESTSTATE_START,
        ID_BERTS_MODULE1_TESTSTATE_STOP,
    };
    public void setBertsModule1Teststate(EnumBertsModule1Teststate value) throws RequestRejectedException {
        model.requestChange(ID.ID_BERTS_MODULE1_TESTSTATE, value.toString());
    }
    public EnumBertsModule1Teststate getBertsModule1Teststate() {
        return EnumBertsModule1Teststate.valueOf(model.getCurrentValue(ID.ID_BERTS_MODULE1_TESTSTATE));
    }
    public enum EnumBertsModule2Teststate{
        ID_BERTS_MODULE2_TESTSTATE_START,
        ID_BERTS_MODULE2_TESTSTATE_STOP,
    };
    public void setBertsModule2Teststate(EnumBertsModule2Teststate value) throws RequestRejectedException {
        model.requestChange(ID.ID_BERTS_MODULE2_TESTSTATE, value.toString());
    }
    public EnumBertsModule2Teststate getBertsModule2Teststate() {
        return EnumBertsModule2Teststate.valueOf(model.getCurrentValue(ID.ID_BERTS_MODULE2_TESTSTATE));
    }
    public enum EnumBertStateModule1{
        ID_BERT_STATE_MODULE1_ANALYZING,
        ID_BERT_STATE_MODULE1_IDLE,
        ID_BERT_STATE_MODULE1_PREPARING,
        ID_BERT_STATE_MODULE1_SAVING,
        ID_BERT_STATE_MODULE1_TESTING,
    };
    public void setBertStateModule1(EnumBertStateModule1 value) throws RequestRejectedException {
        model.requestChange(ID.ID_BERT_STATE_MODULE1, value.toString());
    }
    public EnumBertStateModule1 getBertStateModule1() {
        return EnumBertStateModule1.valueOf(model.getCurrentValue(ID.ID_BERT_STATE_MODULE1));
    }
    public enum EnumBertStateModule2{
        ID_BERT_STATE_MODULE2_ANALYZING,
        ID_BERT_STATE_MODULE2_IDLE,
        ID_BERT_STATE_MODULE2_PREPARING,
        ID_BERT_STATE_MODULE2_SAVING,
        ID_BERT_STATE_MODULE2_TESTING,
    };
    public void setBertStateModule2(EnumBertStateModule2 value) throws RequestRejectedException {
        model.requestChange(ID.ID_BERT_STATE_MODULE2, value.toString());
    }
    public EnumBertStateModule2 getBertStateModule2() {
        return EnumBertStateModule2.valueOf(model.getCurrentValue(ID.ID_BERT_STATE_MODULE2));
    }
    public enum EnumBertsTestControl{
        ID_BERTS_TEST_CONTROL_START,
        ID_BERTS_TEST_CONTROL_STOP,
    };
    public void setBertsTestControl(EnumBertsTestControl value) throws RequestRejectedException {
        model.requestChange(ID.ID_BERTS_TEST_CONTROL, value.toString());
    }
    public EnumBertsTestControl getBertsTestControl() {
        return EnumBertsTestControl.valueOf(model.getCurrentValue(ID.ID_BERTS_TEST_CONTROL));
    }
    public enum EnumStopActionStatus{
        ID_STOP_ACTION_STATUS_DISABLED,
        ID_STOP_ACTION_STATUS_ENABLED,
    };
    public void setStopActionStatus(EnumStopActionStatus value) throws RequestRejectedException {
        model.requestChange(ID.ID_STOP_ACTION_STATUS, value.toString());
    }
    public EnumStopActionStatus getStopActionStatus() {
        return EnumStopActionStatus.valueOf(model.getCurrentValue(ID.ID_STOP_ACTION_STATUS));
    }
}
