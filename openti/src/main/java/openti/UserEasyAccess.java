package openti;
import jp.silverbullet.handlers.EasyAccessModel;
public class UserEasyAccess {
    private EasyAccessModel model;
    public UserEasyAccess(EasyAccessModel model2) {
        this.model = model2;
    }
    public enum EnumEdPattern{
        ID_ED_PATTERN_PRBS7,
        ID_ED_PATTERN_PRBS8,
        ID_ED_PATTERN_PRBS9,
        ID_ED_PATTERN_PROGRAM,
    };
    public void setEdPattern(EnumEdPattern value) {
        model.requestChange(ID.ID_ED_PATTERN, value.toString());
    }
    public EnumEdPattern getEdPattern() {
        return EnumEdPattern.valueOf(model.getProperty(ID.ID_ED_PATTERN).getCurrentValue());
    }
    public void setOsaNfCal(double value) {
        model.requestChange(ID.ID_OSA_NF_CAL, String.valueOf(value));
    }
    public double getOsaNfCal() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_NF_CAL).getCurrentValue());
    }
    public void setOsaDriftChannelTable(String value) {
        model.requestChange(ID.ID_OSA_DRIFT_CHANNEL_TABLE, value);
    }
    public String getOsaDriftChannelTable() {
        return model.getProperty(ID.ID_OSA_DRIFT_CHANNEL_TABLE).getCurrentValue();
    }
    public void setOsaSummaryOsnrflatness(double value) {
        model.requestChange(ID.ID_OSA_SUMMARY_OSNRFLATNESS, String.valueOf(value));
    }
    public double getOsaSummaryOsnrflatness() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_SUMMARY_OSNRFLATNESS).getCurrentValue());
    }
    public enum EnumOtdrResolution{
        ID_OTDR_RESOLUTION_COARSE,
        ID_OTDR_RESOLUTION_MIDDLE,
        ID_OTDR_RESOLUTION_DENSE,
    };
    public void setOtdrResolution(EnumOtdrResolution value) {
        model.requestChange(ID.ID_OTDR_RESOLUTION, value.toString());
    }
    public EnumOtdrResolution getOtdrResolution() {
        return EnumOtdrResolution.valueOf(model.getProperty(ID.ID_OTDR_RESOLUTION).getCurrentValue());
    }
    public enum EnumOsaBand{
        ID_OSA_BAND_AUTO_DETECT,
        ID_OSA_BAND_O,
        ID_OSA_BAND_E,
        ID_OSA_BAND_S,
        ID_OSA_BAND_C,
        ID_OSA_BAND_L,
        ID_OSA_BAND_CL,
        ID_OSA_BAND_FULL,
        ID_OSA_BAND_USER,
    };
    public void setOsaBand(EnumOsaBand value) {
        model.requestChange(ID.ID_OSA_BAND, value.toString());
    }
    public EnumOsaBand getOsaBand() {
        return EnumOsaBand.valueOf(model.getProperty(ID.ID_OSA_BAND).getCurrentValue());
    }
    public void setOsaInspectionRegILimitBit(long value) {
        model.requestChange(ID.ID_OSA_INSPECTION_REG_I_LIMIT_BIT, String.valueOf(value));
    }
    public long getOsaInspectionRegILimitBit() {
        return Long.valueOf(model.getProperty(ID.ID_OSA_INSPECTION_REG_I_LIMIT_BIT).getCurrentValue());
    }
    public void setOsaAverageCountMax(long value) {
        model.requestChange(ID.ID_OSA_AVERAGE_COUNT_MAX, String.valueOf(value));
    }
    public long getOsaAverageCountMax() {
        return Long.valueOf(model.getProperty(ID.ID_OSA_AVERAGE_COUNT_MAX).getCurrentValue());
    }
    public void setOsaGridChannelWidth(double value) {
        model.requestChange(ID.ID_OSA_GRID_CHANNEL_WIDTH, String.valueOf(value));
    }
    public double getOsaGridChannelWidth() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_GRID_CHANNEL_WIDTH).getCurrentValue());
    }
    public void setOsaGridMultieditCaution(String value) {
        model.requestChange(ID.ID_OSA_GRID_MULTIEDIT_CAUTION, value);
    }
    public String getOsaGridMultieditCaution() {
        return model.getProperty(ID.ID_OSA_GRID_MULTIEDIT_CAUTION).getCurrentValue();
    }
    public enum EnumLang{
        ID_LANG_ENGLISH,
        ID_LANG_JAPANESE,
        ID_LANG_CHINESE,
        ID_LANG_FRENCH,
        ID_LANG_PORTUGUESE,
        ID_LANG_RUSSIAN,
        ID_LANG_SPANISH,
        ID_LANG_GERMAN,
    };
    public void setLang(EnumLang value) {
        model.requestChange(ID.ID_LANG, value.toString());
    }
    public EnumLang getLang() {
        return EnumLang.valueOf(model.getProperty(ID.ID_LANG).getCurrentValue());
    }
    public void setOsaGraphViewrangedbMin(double value) {
        model.requestChange(ID.ID_OSA_GRAPH_VIEWRANGEDB_MIN, String.valueOf(value));
    }
    public double getOsaGraphViewrangedbMin() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_GRAPH_VIEWRANGEDB_MIN).getCurrentValue());
    }
    public enum EnumOtdrDistancerange{
        ID_OTDR_DISTANCE_RANGE_1KM,
        ID_OTDR_DISTANCE_RANGE_5KM,
        ID_OTDR_DISTANCE_RANGE_10KM,
        ID_OTDR_DISTANCE_RANGE_50KM,
    };
    public void setOtdrDistancerange(EnumOtdrDistancerange value) {
        model.requestChange(ID.ID_OTDR_DISTANCERANGE, value.toString());
    }
    public EnumOtdrDistancerange getOtdrDistancerange() {
        return EnumOtdrDistancerange.valueOf(model.getProperty(ID.ID_OTDR_DISTANCERANGE).getCurrentValue());
    }
    public void setSystemFiletitle(String value) {
        model.requestChange(ID.ID_SYSTEM_FILETITLE, value);
    }
    public String getSystemFiletitle() {
        return model.getProperty(ID.ID_SYSTEM_FILETITLE).getCurrentValue();
    }
    public void setOsaSummaryChannelcount(double value) {
        model.requestChange(ID.ID_OSA_SUMMARY_CHANNELCOUNT, String.valueOf(value));
    }
    public double getOsaSummaryChannelcount() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_SUMMARY_CHANNELCOUNT).getCurrentValue());
    }
    public enum EnumOsaNoiseCorrectionMode{
        ID_OSA_NOISE_CORRECTION_MODE_NONE,
        ID_OSA_NOISE_CORRECTION_MODE_ABSOLUTE,
        ID_OSA_NOISE_CORRECTION_MODE_RELATIVE,
    };
    public void setOsaNoiseCorrectionMode(EnumOsaNoiseCorrectionMode value) {
        model.requestChange(ID.ID_OSA_NOISE_CORRECTION_MODE, value.toString());
    }
    public EnumOsaNoiseCorrectionMode getOsaNoiseCorrectionMode() {
        return EnumOsaNoiseCorrectionMode.valueOf(model.getProperty(ID.ID_OSA_NOISE_CORRECTION_MODE).getCurrentValue());
    }
    public void setOsaInspectionMotorEncoderPosition(long value) {
        model.requestChange(ID.ID_OSA_INSPECTION_MOTOR_ENCODER_POSITION, String.valueOf(value));
    }
    public long getOsaInspectionMotorEncoderPosition() {
        return Long.valueOf(model.getProperty(ID.ID_OSA_INSPECTION_MOTOR_ENCODER_POSITION).getCurrentValue());
    }
    public void setOsaOnoffAllOnChannelFilename(String value) {
        model.requestChange(ID.ID_OSA_ONOFF_ALL_ON_CHANNEL_FILENAME, value);
    }
    public String getOsaOnoffAllOnChannelFilename() {
        return model.getProperty(ID.ID_OSA_ONOFF_ALL_ON_CHANNEL_FILENAME).getCurrentValue();
    }
    public void setOsaDriftgraphViewPowerMin(double value) {
        model.requestChange(ID.ID_OSA_DRIFTGRAPH_VIEW_POWER_MIN, String.valueOf(value));
    }
    public double getOsaDriftgraphViewPowerMin() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_DRIFTGRAPH_VIEW_POWER_MIN).getCurrentValue());
    }
    public void setOsaInspectionRegP(long value) {
        model.requestChange(ID.ID_OSA_INSPECTION_REG_P, String.valueOf(value));
    }
    public long getOsaInspectionRegP() {
        return Long.valueOf(model.getProperty(ID.ID_OSA_INSPECTION_REG_P).getCurrentValue());
    }
    public void setOsaEventTableChannelVisualizerSummary(String value) {
        model.requestChange(ID.ID_OSA_EVENT_TABLE_CHANNEL_VISUALIZER_SUMMARY, value);
    }
    public String getOsaEventTableChannelVisualizerSummary() {
        return model.getProperty(ID.ID_OSA_EVENT_TABLE_CHANNEL_VISUALIZER_SUMMARY).getCurrentValue();
    }
    public void setOsaOnoffResultTable(String value) {
        model.requestChange(ID.ID_OSA_ONOFF_RESULT_TABLE, value);
    }
    public String getOsaOnoffResultTable() {
        return model.getProperty(ID.ID_OSA_ONOFF_RESULT_TABLE).getCurrentValue();
    }
    public enum EnumOsaDriftMeasSetupType{
        ID_OSA_DRIFT_MEAS_SETUP_TYPE_NEW,
        ID_OSA_DRIFT_MEAS_SETUP_TYPE_RESUME,
    };
    public void setOsaDriftMeasSetupType(EnumOsaDriftMeasSetupType value) {
        model.requestChange(ID.ID_OSA_DRIFT_MEAS_SETUP_TYPE, value.toString());
    }
    public EnumOsaDriftMeasSetupType getOsaDriftMeasSetupType() {
        return EnumOsaDriftMeasSetupType.valueOf(model.getProperty(ID.ID_OSA_DRIFT_MEAS_SETUP_TYPE).getCurrentValue());
    }
    public void setOsaDriftgraphViewMaxx(double value) {
        model.requestChange(ID.ID_OSA_DRIFTGRAPH_VIEW_MAXX, String.valueOf(value));
    }
    public double getOsaDriftgraphViewMaxx() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_DRIFTGRAPH_VIEW_MAXX).getCurrentValue());
    }
    public void setOsaInspectionRegSfactorD(long value) {
        model.requestChange(ID.ID_OSA_INSPECTION_REG_SFACTOR_D, String.valueOf(value));
    }
    public long getOsaInspectionRegSfactorD() {
        return Long.valueOf(model.getProperty(ID.ID_OSA_INSPECTION_REG_SFACTOR_D).getCurrentValue());
    }
    public void setActiveWaveformControllerVerificationDueDate(String value) {
        model.requestChange(ID.ID_ACTIVE_WAVEFORM_CONTROLLER_VERIFICATION_DUE_DATE, value);
    }
    public String getActiveWaveformControllerVerificationDueDate() {
        return model.getProperty(ID.ID_ACTIVE_WAVEFORM_CONTROLLER_VERIFICATION_DUE_DATE).getCurrentValue();
    }
    public void setOsaDriftgraphViewOsnrMax(double value) {
        model.requestChange(ID.ID_OSA_DRIFTGRAPH_VIEW_OSNR_MAX, String.valueOf(value));
    }
    public double getOsaDriftgraphViewOsnrMax() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_DRIFTGRAPH_VIEW_OSNR_MAX).getCurrentValue());
    }
    public enum EnumMaskType{
        ID_MASK_TYPE_10GBE_FEC,
        ID_MASK_TYPE_10GBE_LAN,
        ID_MASK_TYPE_10GBE_WAN,
    };
    public void setMaskType(EnumMaskType value) {
        model.requestChange(ID.ID_MASK_TYPE, value.toString());
    }
    public EnumMaskType getMaskType() {
        return EnumMaskType.valueOf(model.getProperty(ID.ID_MASK_TYPE).getCurrentValue());
    }
    public void setGraphViewFullscaleMaxydb(double value) {
        model.requestChange(ID.ID_GRAPH_VIEW_FULLSCALE_MAXYDB, String.valueOf(value));
    }
    public double getGraphViewFullscaleMaxydb() {
        return Double.valueOf(model.getProperty(ID.ID_GRAPH_VIEW_FULLSCALE_MAXYDB).getCurrentValue());
    }
    public void setOsaActiveWaveformLevelOffset(double value) {
        model.requestChange(ID.ID_OSA_ACTIVE_WAVEFORM_LEVEL_OFFSET, String.valueOf(value));
    }
    public double getOsaActiveWaveformLevelOffset() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_ACTIVE_WAVEFORM_LEVEL_OFFSET).getCurrentValue());
    }
    public void setOsaInspectionRangeCode(long value) {
        model.requestChange(ID.ID_OSA_INSPECTION_RANGE_CODE, String.valueOf(value));
    }
    public long getOsaInspectionRangeCode() {
        return Long.valueOf(model.getProperty(ID.ID_OSA_INSPECTION_RANGE_CODE).getCurrentValue());
    }
    public enum EnumOsaWavelengthDefinition{
        ID_OSA_WAVELENGTH_DEFINITION_THRESHOLD,
        ID_OSA_WAVELENGTH_DEFINITION_RMS,
    };
    public void setOsaWavelengthDefinition(EnumOsaWavelengthDefinition value) {
        model.requestChange(ID.ID_OSA_WAVELENGTH_DEFINITION, value.toString());
    }
    public EnumOsaWavelengthDefinition getOsaWavelengthDefinition() {
        return EnumOsaWavelengthDefinition.valueOf(model.getProperty(ID.ID_OSA_WAVELENGTH_DEFINITION).getCurrentValue());
    }
    public void setActiveWaveformWaveCalDatetime(String value) {
        model.requestChange(ID.ID_ACTIVE_WAVEFORM_WAVE_CAL_DATETIME, value);
    }
    public String getActiveWaveformWaveCalDatetime() {
        return model.getProperty(ID.ID_ACTIVE_WAVEFORM_WAVE_CAL_DATETIME).getCurrentValue();
    }
    public enum EnumOsaInspectionPolarization{
        ID_OSA_INSPECTION_POLARIZATION_PRIMARY,
        ID_OSA_INSPECTION_POLARIZATION_SLANT,
        ID_OSA_INSPECTION_POLARIZATION_CIRCLE,
    };
    public void setOsaInspectionPolarization(EnumOsaInspectionPolarization value) {
        model.requestChange(ID.ID_OSA_INSPECTION_POLARIZATION, value.toString());
    }
    public EnumOsaInspectionPolarization getOsaInspectionPolarization() {
        return EnumOsaInspectionPolarization.valueOf(model.getProperty(ID.ID_OSA_INSPECTION_POLARIZATION).getCurrentValue());
    }
    public void setOsaAverageCountMaxRepeat(long value) {
        model.requestChange(ID.ID_OSA_AVERAGE_COUNT_MAX_REPEAT, String.valueOf(value));
    }
    public long getOsaAverageCountMaxRepeat() {
        return Long.valueOf(model.getProperty(ID.ID_OSA_AVERAGE_COUNT_MAX_REPEAT).getCurrentValue());
    }
    public enum EnumOsaInspectionLightsource{
        ID_OSA_INSPECTION_LIGHTSOURCE_OFF,
        ID_OSA_INSPECTION_LIGHTSOURCE_ON,
    };
    public void setOsaInspectionLightsource(EnumOsaInspectionLightsource value) {
        model.requestChange(ID.ID_OSA_INSPECTION_LIGHTSOURCE, value.toString());
    }
    public EnumOsaInspectionLightsource getOsaInspectionLightsource() {
        return EnumOsaInspectionLightsource.valueOf(model.getProperty(ID.ID_OSA_INSPECTION_LIGHTSOURCE).getCurrentValue());
    }
    public enum EnumOsaAutosaveTracekindDrift{
        ID_OSA_AUTOSAVE_TRACEKIND_DRIFT_ALL,
        ID_OSA_AUTOSAVE_TRACEKIND_DRIFT_FAIL,
        ID_OSA_AUTOSAVE_TRACEKIND_DRIFT_NONE,
    };
    public void setOsaAutosaveTracekindDrift(EnumOsaAutosaveTracekindDrift value) {
        model.requestChange(ID.ID_OSA_AUTOSAVE_TRACEKIND_DRIFT, value.toString());
    }
    public EnumOsaAutosaveTracekindDrift getOsaAutosaveTracekindDrift() {
        return EnumOsaAutosaveTracekindDrift.valueOf(model.getProperty(ID.ID_OSA_AUTOSAVE_TRACEKIND_DRIFT).getCurrentValue());
    }
    public enum EnumOsaHorizontalUnit{
        ID_OSA_HORIZONTAL_UNIT_NM,
        ID_OSA_HORIZONTAL_UNIT_THZ,
    };
    public void setOsaHorizontalUnit(EnumOsaHorizontalUnit value) {
        model.requestChange(ID.ID_OSA_HORIZONTAL_UNIT, value.toString());
    }
    public EnumOsaHorizontalUnit getOsaHorizontalUnit() {
        return EnumOsaHorizontalUnit.valueOf(model.getProperty(ID.ID_OSA_HORIZONTAL_UNIT).getCurrentValue());
    }
    public void setJobid(String value) {
        model.requestChange(ID.ID_JOBID, value);
    }
    public String getJobid() {
        return model.getProperty(ID.ID_JOBID).getCurrentValue();
    }
    public void setOsaEventTableScpiM(String value) {
        model.requestChange(ID.ID_OSA_EVENT_TABLE_SCPI_M, value);
    }
    public String getOsaEventTableScpiM() {
        return model.getProperty(ID.ID_OSA_EVENT_TABLE_SCPI_M).getCurrentValue();
    }
    public void setResultEthBert(String value) {
        model.requestChange(ID.ID_RESULT_ETH_BERT, value);
    }
    public String getResultEthBert() {
        return model.getProperty(ID.ID_RESULT_ETH_BERT).getCurrentValue();
    }
    public void setActiveWaveformLevelCalDatetime(String value) {
        model.requestChange(ID.ID_ACTIVE_WAVEFORM_LEVEL_CAL_DATETIME, value);
    }
    public String getActiveWaveformLevelCalDatetime() {
        return model.getProperty(ID.ID_ACTIVE_WAVEFORM_LEVEL_CAL_DATETIME).getCurrentValue();
    }
    public enum EnumTableShowDetail{
        ID_TABLE_SHOW_DETAIL_WDM,
        ID_TABLE_SHOW_DETAIL_EDFA,
    };
    public void setTableShowDetail(EnumTableShowDetail value) {
        model.requestChange(ID.ID_TABLE_SHOW_DETAIL, value.toString());
    }
    public EnumTableShowDetail getTableShowDetail() {
        return EnumTableShowDetail.valueOf(model.getProperty(ID.ID_TABLE_SHOW_DETAIL).getCurrentValue());
    }
    public void setOsaSummaryPoutGaintilt(double value) {
        model.requestChange(ID.ID_OSA_SUMMARY_POUT_GAINTILT, String.valueOf(value));
    }
    public double getOsaSummaryPoutGaintilt() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_SUMMARY_POUT_GAINTILT).getCurrentValue());
    }
    public void setActiveWaveformModuleVerificationDate(String value) {
        model.requestChange(ID.ID_ACTIVE_WAVEFORM_MODULE_VERIFICATION_DATE, value);
    }
    public String getActiveWaveformModuleVerificationDate() {
        return model.getProperty(ID.ID_ACTIVE_WAVEFORM_MODULE_VERIFICATION_DATE).getCurrentValue();
    }
    public enum EnumServerstateLabel{
        ID_SERVERSTATE_LABEL_IDLE,
        ID_SERVERSTATE_LABEL_AVERAGING,
        ID_SERVERSTATE_LABEL_MEASURE,
        ID_SERVERSTATE_LABEL_REALTIME,
        ID_SERVERSTATE_LABEL_AUTOMEASURE,
        ID_SERVERSTATE_LABEL_CALIBRATION,
        ID_SERVERSTATE_LABEL_DRIFT_WAITING,
        ID_SERVERSTATE_LABEL_FILE_SAVING,
    };
    public void setServerstateLabel(EnumServerstateLabel value) {
        model.requestChange(ID.ID_SERVERSTATE_LABEL, value.toString());
    }
    public EnumServerstateLabel getServerstateLabel() {
        return EnumServerstateLabel.valueOf(model.getProperty(ID.ID_SERVERSTATE_LABEL).getCurrentValue());
    }
    public void setResultTr(double value) {
        model.requestChange(ID.ID_RESULT_TR, String.valueOf(value));
    }
    public double getResultTr() {
        return Double.valueOf(model.getProperty(ID.ID_RESULT_TR).getCurrentValue());
    }
    public void setOsaDriftNumOfMeas(long value) {
        model.requestChange(ID.ID_OSA_DRIFT_NUM_OF_MEAS, String.valueOf(value));
    }
    public long getOsaDriftNumOfMeas() {
        return Long.valueOf(model.getProperty(ID.ID_OSA_DRIFT_NUM_OF_MEAS).getCurrentValue());
    }
    public enum EnumModelnumber{
        ID_MODELNUMBER_MU100030A,
        ID_MODELNUMBER_MU100031A,
    };
    public void setModelnumber(EnumModelnumber value) {
        model.requestChange(ID.ID_MODELNUMBER, value.toString());
    }
    public EnumModelnumber getModelnumber() {
        return EnumModelnumber.valueOf(model.getProperty(ID.ID_MODELNUMBER).getCurrentValue());
    }
    public void setOsaDebugCalibrateEdge(double value) {
        model.requestChange(ID.ID_OSA_DEBUG_CALIBRATE_EDGE, String.valueOf(value));
    }
    public double getOsaDebugCalibrateEdge() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_DEBUG_CALIBRATE_EDGE).getCurrentValue());
    }
    public void setOsaDebugSimulatorEtalonFilename(String value) {
        model.requestChange(ID.ID_OSA_DEBUG_SIMULATOR_ETALON_FILENAME, value);
    }
    public String getOsaDebugSimulatorEtalonFilename() {
        return model.getProperty(ID.ID_OSA_DEBUG_SIMULATOR_ETALON_FILENAME).getCurrentValue();
    }
    public void setOsaEventTableEdfaVisualizerSummary(String value) {
        model.requestChange(ID.ID_OSA_EVENT_TABLE_EDFA_VISUALIZER_SUMMARY, value);
    }
    public String getOsaEventTableEdfaVisualizerSummary() {
        return model.getProperty(ID.ID_OSA_EVENT_TABLE_EDFA_VISUALIZER_SUMMARY).getCurrentValue();
    }
    public enum EnumMessageCancelWait{
        ID_MESSAGECONTENT_NOMESSAGE,
        ID_MESSAGECONTENT_ZEROSETTING,
        ID_MESSAGECONTENT_NOMESSAGE_DUMMY,
    };
    public void setMessageCancelWait(EnumMessageCancelWait value) {
        model.requestChange(ID.ID_MESSAGE_CANCEL_WAIT, value.toString());
    }
    public EnumMessageCancelWait getMessageCancelWait() {
        return EnumMessageCancelWait.valueOf(model.getProperty(ID.ID_MESSAGE_CANCEL_WAIT).getCurrentValue());
    }
    public void setOsaCenterWavelengthNm(double value) {
        model.requestChange(ID.ID_OSA_CENTER_WAVELENGTH_NM, String.valueOf(value));
    }
    public double getOsaCenterWavelengthNm() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_CENTER_WAVELENGTH_NM).getCurrentValue());
    }
    public enum EnumGraphOperationModePrev{
        ID_GRAPH_OPERATION_MODE_ZOOMIN,
        ID_GRAPH_OPERATION_MODE_ZOOMOUT,
        ID_GRAPH_OPERATION_MODE_VIEWALL,
        ID_GRAPH_OPERATION_MODE_MOVE,
        ID_GRAPH_OPERATION_MODE_CURSOR,
    };
    public void setGraphOperationModePrev(EnumGraphOperationModePrev value) {
        model.requestChange(ID.ID_GRAPH_OPERATION_MODE_PREV, value.toString());
    }
    public EnumGraphOperationModePrev getGraphOperationModePrev() {
        return EnumGraphOperationModePrev.valueOf(model.getProperty(ID.ID_GRAPH_OPERATION_MODE_PREV).getCurrentValue());
    }
    public enum EnumOsaDebugSimulatorType{
        ID_OSA_DEBUG_SIMULATOR_TYPE_LOCAL,
        ID_OSA_DEBUG_SIMULATOR_TYPE_REMOTE,
    };
    public void setOsaDebugSimulatorType(EnumOsaDebugSimulatorType value) {
        model.requestChange(ID.ID_OSA_DEBUG_SIMULATOR_TYPE, value.toString());
    }
    public EnumOsaDebugSimulatorType getOsaDebugSimulatorType() {
        return EnumOsaDebugSimulatorType.valueOf(model.getProperty(ID.ID_OSA_DEBUG_SIMULATOR_TYPE).getCurrentValue());
    }
    public enum EnumOsaOsnrDetectType{
        ID_OSA_OSNR_DETECT_TYPE_POINT,
        ID_OSA_OSNR_DETECT_TYPE_SIGMA,
    };
    public void setOsaOsnrDetectType(EnumOsaOsnrDetectType value) {
        model.requestChange(ID.ID_OSA_OSNR_DETECT_TYPE, value.toString());
    }
    public EnumOsaOsnrDetectType getOsaOsnrDetectType() {
        return EnumOsaOsnrDetectType.valueOf(model.getProperty(ID.ID_OSA_OSNR_DETECT_TYPE).getCurrentValue());
    }
    public void setOsaActiveWaveformAverage(long value) {
        model.requestChange(ID.ID_OSA_ACTIVE_WAVEFORM_AVERAGE, String.valueOf(value));
    }
    public long getOsaActiveWaveformAverage() {
        return Long.valueOf(model.getProperty(ID.ID_OSA_ACTIVE_WAVEFORM_AVERAGE).getCurrentValue());
    }
    public enum EnumGuiResuultTab{
        ID_GUI_RESUULT_TAB_TRACE,
        ID_GUI_RESUULT_TAB_FV,
    };
    public void setGuiResuultTab(EnumGuiResuultTab value) {
        model.requestChange(ID.ID_GUI_RESUULT_TAB, value.toString());
    }
    public EnumGuiResuultTab getGuiResuultTab() {
        return EnumGuiResuultTab.valueOf(model.getProperty(ID.ID_GUI_RESUULT_TAB).getCurrentValue());
    }
    public enum EnumOsaHorizontalWidthUnit{
        ID_OSA_HORIZONTAL_WIDTH_UNIT_NM,
        ID_OSA_HORIZONTAL_WIDTH_UNIT_GHZ,
    };
    public void setOsaHorizontalWidthUnit(EnumOsaHorizontalWidthUnit value) {
        model.requestChange(ID.ID_OSA_HORIZONTAL_WIDTH_UNIT, value.toString());
    }
    public EnumOsaHorizontalWidthUnit getOsaHorizontalWidthUnit() {
        return EnumOsaHorizontalWidthUnit.valueOf(model.getProperty(ID.ID_OSA_HORIZONTAL_WIDTH_UNIT).getCurrentValue());
    }
    public enum EnumMode{
        ID_MODE_NEW_OFF,
        ID_MODE_NORMAL,
        ID_MODE_THROUGH,
        ID_MODE_OH,
    };
    public void setMode(EnumMode value) {
        model.requestChange(ID.ID_MODE, value.toString());
    }
    public EnumMode getMode() {
        return EnumMode.valueOf(model.getProperty(ID.ID_MODE).getCurrentValue());
    }
    public void setActiveWaveformModuleSerial(String value) {
        model.requestChange(ID.ID_ACTIVE_WAVEFORM_MODULE_SERIAL, value);
    }
    public String getActiveWaveformModuleSerial() {
        return model.getProperty(ID.ID_ACTIVE_WAVEFORM_MODULE_SERIAL).getCurrentValue();
    }
    public enum EnumCsvDelimiter{
        ID_CSV_DELIMITER_COMMA,
        ID_CSV_DELIMITER_SEMICOLON,
        ID_CSV_DELIMITER_TAB,
    };
    public void setCsvDelimiter(EnumCsvDelimiter value) {
        model.requestChange(ID.ID_CSV_DELIMITER, value.toString());
    }
    public EnumCsvDelimiter getCsvDelimiter() {
        return EnumCsvDelimiter.valueOf(model.getProperty(ID.ID_CSV_DELIMITER).getCurrentValue());
    }
    public void setOsaDebugIotestFilename(String value) {
        model.requestChange(ID.ID_OSA_DEBUG_IOTEST_FILENAME, value);
    }
    public String getOsaDebugIotestFilename() {
        return model.getProperty(ID.ID_OSA_DEBUG_IOTEST_FILENAME).getCurrentValue();
    }
    public void setTpTransmitrate(double value) {
        model.requestChange(ID.ID_TP_TRANSMITRATE, String.valueOf(value));
    }
    public double getTpTransmitrate() {
        return Double.valueOf(model.getProperty(ID.ID_TP_TRANSMITRATE).getCurrentValue());
    }
    public enum EnumMessageScreenlock{
        ID_MESSAGECONTENT_NOMESSAGE,
        ID_MESSAGECONTENT_STARTUP,
        ID_MESSAGECONTENT_SHUTDOWN,
        ID_MESSAGECONTENT_LOADPREVSETTING,
        ID_MESSAGECONTENT_GENERATING_RESULT,
        ID_MESSAGECONTENT_LOADING_RESULT,
        ID_MESSAGECONTENT_GENERATING_SETUP,
        ID_MESSAGECONTENT_LOADING_SETUP,
        ID_MESSAGECONTENT_ANALYZING,
        ID_MESSAGECONTENT_CALIBRATING,
        ID_MESSAGECONTENT_NOMESSAGE_DUMMY,
    };
    public void setMessageScreenlock(EnumMessageScreenlock value) {
        model.requestChange(ID.ID_MESSAGE_SCREENLOCK, value.toString());
    }
    public EnumMessageScreenlock getMessageScreenlock() {
        return EnumMessageScreenlock.valueOf(model.getProperty(ID.ID_MESSAGE_SCREENLOCK).getCurrentValue());
    }
    public void setTpPatternErrors(double value) {
        model.requestChange(ID.ID_TP_PATTERN_ERRORS, String.valueOf(value));
    }
    public double getTpPatternErrors() {
        return Double.valueOf(model.getProperty(ID.ID_TP_PATTERN_ERRORS).getCurrentValue());
    }
    public enum EnumTestaction{
        ID_TESTACTION_START,
        ID_TESTACTION_STOP,
    };
    public void setTestaction(EnumTestaction value) {
        model.requestChange(ID.ID_TESTACTION, value.toString());
    }
    public EnumTestaction getTestaction() {
        return EnumTestaction.valueOf(model.getProperty(ID.ID_TESTACTION).getCurrentValue());
    }
    public void setOsaGridtableDataScpiHz(String value) {
        model.requestChange(ID.ID_OSA_GRIDTABLE_DATA_SCPI_HZ, value);
    }
    public String getOsaGridtableDataScpiHz() {
        return model.getProperty(ID.ID_OSA_GRIDTABLE_DATA_SCPI_HZ).getCurrentValue();
    }
    public void setOsaDebugSimulatorResolution(double value) {
        model.requestChange(ID.ID_OSA_DEBUG_SIMULATOR_RESOLUTION, String.valueOf(value));
    }
    public double getOsaDebugSimulatorResolution() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_DEBUG_SIMULATOR_RESOLUTION).getCurrentValue());
    }
    public void setResultJitter(double value) {
        model.requestChange(ID.ID_RESULT_JITTER, String.valueOf(value));
    }
    public double getResultJitter() {
        return Double.valueOf(model.getProperty(ID.ID_RESULT_JITTER).getCurrentValue());
    }
    public void setOwner(String value) {
        model.requestChange(ID.ID_OWNER, value);
    }
    public String getOwner() {
        return model.getProperty(ID.ID_OWNER).getCurrentValue();
    }
    public void setOsaSummaryPinChannelcount(double value) {
        model.requestChange(ID.ID_OSA_SUMMARY_PIN_CHANNELCOUNT, String.valueOf(value));
    }
    public double getOsaSummaryPinChannelcount() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_SUMMARY_PIN_CHANNELCOUNT).getCurrentValue());
    }
    public void setOsaSummaryPinGaintilt(double value) {
        model.requestChange(ID.ID_OSA_SUMMARY_PIN_GAINTILT, String.valueOf(value));
    }
    public double getOsaSummaryPinGaintilt() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_SUMMARY_PIN_GAINTILT).getCurrentValue());
    }
    public void setOsaCursorLevelCdSpan(double value) {
        model.requestChange(ID.ID_OSA_CURSOR_LEVEL_CD_SPAN, String.valueOf(value));
    }
    public double getOsaCursorLevelCdSpan() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_CURSOR_LEVEL_CD_SPAN).getCurrentValue());
    }
    public void setEdBitrate(double value) {
        model.requestChange(ID.ID_ED_BITRATE, String.valueOf(value));
    }
    public double getEdBitrate() {
        return Double.valueOf(model.getProperty(ID.ID_ED_BITRATE).getCurrentValue());
    }
    public void setOsaInspectionRegDsig(long value) {
        model.requestChange(ID.ID_OSA_INSPECTION_REG_DSIG, String.valueOf(value));
    }
    public long getOsaInspectionRegDsig() {
        return Long.valueOf(model.getProperty(ID.ID_OSA_INSPECTION_REG_DSIG).getCurrentValue());
    }
    public void setGraphViewMinydb(double value) {
        model.requestChange(ID.ID_GRAPH_VIEW_MINYDB, String.valueOf(value));
    }
    public double getGraphViewMinydb() {
        return Double.valueOf(model.getProperty(ID.ID_GRAPH_VIEW_MINYDB).getCurrentValue());
    }
    public void setOsaInspectionRegSfactorIntv(long value) {
        model.requestChange(ID.ID_OSA_INSPECTION_REG_SFACTOR_INTV, String.valueOf(value));
    }
    public long getOsaInspectionRegSfactorIntv() {
        return Long.valueOf(model.getProperty(ID.ID_OSA_INSPECTION_REG_SFACTOR_INTV).getCurrentValue());
    }
    public enum EnumOscState{
        ID_OSC_STATE_IDLE,
        ID_OSC_STATE_COLLECTING,
    };
    public void setOscState(EnumOscState value) {
        model.requestChange(ID.ID_OSC_STATE, value.toString());
    }
    public EnumOscState getOscState() {
        return EnumOscState.valueOf(model.getProperty(ID.ID_OSC_STATE).getCurrentValue());
    }
    public void setOsaActiveCursorLevel(double value) {
        model.requestChange(ID.ID_OSA_ACTIVE_CURSOR_LEVEL, String.valueOf(value));
    }
    public double getOsaActiveCursorLevel() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_ACTIVE_CURSOR_LEVEL).getCurrentValue());
    }
    public void setOsaEditPropertyIds(String value) {
        model.requestChange(ID.ID_OSA_EDIT_PROPERTY_IDS, value);
    }
    public String getOsaEditPropertyIds() {
        return model.getProperty(ID.ID_OSA_EDIT_PROPERTY_IDS).getCurrentValue();
    }
    public enum EnumOsaSetupActiveTrace{
        ID_OSA_SETUP_ACTIVE_TRACE_A,
        ID_OSA_SETUP_ACTIVE_TRACE_B,
        ID_OSA_SETUP_ACTIVE_TRACE_C,
        ID_OSA_SETUP_ACTIVE_TRACE_D,
    };
    public void setOsaSetupActiveTrace(EnumOsaSetupActiveTrace value) {
        model.requestChange(ID.ID_OSA_SETUP_ACTIVE_TRACE, value.toString());
    }
    public EnumOsaSetupActiveTrace getOsaSetupActiveTrace() {
        return EnumOsaSetupActiveTrace.valueOf(model.getProperty(ID.ID_OSA_SETUP_ACTIVE_TRACE).getCurrentValue());
    }
    public void setEdDatalength(long value) {
        model.requestChange(ID.ID_ED_DATALENGTH, String.valueOf(value));
    }
    public long getEdDatalength() {
        return Long.valueOf(model.getProperty(ID.ID_ED_DATALENGTH).getCurrentValue());
    }
    public enum EnumPpgStart{
        ID_PPG_START_ON,
        ID_PPG_START_OFF,
    };
    public void setPpgStart(EnumPpgStart value) {
        model.requestChange(ID.ID_PPG_START, value.toString());
    }
    public EnumPpgStart getPpgStart() {
        return EnumPpgStart.valueOf(model.getProperty(ID.ID_PPG_START).getCurrentValue());
    }
    public void setTransceiverWavelength(double value) {
        model.requestChange(ID.ID_TRANSCEIVER_WAVELENGTH, String.valueOf(value));
    }
    public double getTransceiverWavelength() {
        return Double.valueOf(model.getProperty(ID.ID_TRANSCEIVER_WAVELENGTH).getCurrentValue());
    }
    public void setAveragetime(long value) {
        model.requestChange(ID.ID_AVERAGETIME, String.valueOf(value));
    }
    public long getAveragetime() {
        return Long.valueOf(model.getProperty(ID.ID_AVERAGETIME).getCurrentValue());
    }
    public void setOsaTempEditDays(long value) {
        model.requestChange(ID.ID_OSA_TEMP_EDIT_DAYS, String.valueOf(value));
    }
    public long getOsaTempEditDays() {
        return Long.valueOf(model.getProperty(ID.ID_OSA_TEMP_EDIT_DAYS).getCurrentValue());
    }
    public enum EnumMessageQueryYesno{
        ID_MESSAGECONTENT_NOMESSAGE,
        ID_MESSAGECONTENT_GRIDTABLE_MERGE,
        ID_MESSAGECONTENT_GRIDTABLE_DELETE,
        ID_MESSAGECONTENT_GRIDTABLE_TRACE_TO_IMPORT,
        ID_MESSAGECONTENT_CONFIRMED_CLEAR_TRACE,
        ID_MESSAGECONTENT_CONFIRMED_CLEAR_TRACE_ALL,
        ID_MESSAGECONTENT_CAN_YOU_TURN_OFF_DRIFT_FOLDER,
        ID_MESSAGECONTENT_DO_YOU_WANT_TO_START_DRIFT,
        ID_MESSAGECONTENT_GRID_CREATE_REQUIRED,
        ID_MESSAGECONTENT_CONFIRM_OVERWRITE_IMPORT_FILE,
        ID_MESSAGECONTENT_CONFIRM_NEW_IMPORT_FILEPATH,
        ID_MESSAGECONTENT_CONFIRM_FIX_AUTOSPANS,
        ID_MESSAGECONTENT_RES_CHANGED_DO_YOU_SAVE_IT,
        ID_MESSAGECONTENT_CONFIRMED_OSNR_METHOD_CHANGE,
        ID_MESSAGECONTENT_DRIFT_RESET_INITIAL_TRACE_TIME,
        ID_MESSAGECONTENT_DRIFT_CONFIRM_RESUME_START,
        ID_MESSAGECONTENT_NOMESSAGE_DUMMY,
    };
    public void setMessageQueryYesno(EnumMessageQueryYesno value) {
        model.requestChange(ID.ID_MESSAGE_QUERY_YESNO, value.toString());
    }
    public EnumMessageQueryYesno getMessageQueryYesno() {
        return EnumMessageQueryYesno.valueOf(model.getProperty(ID.ID_MESSAGE_QUERY_YESNO).getCurrentValue());
    }
    public enum EnumOsaTraceOnoffVisibleAlloff{
        ID_OSA_TRACE_SHOW,
        ID_OSA_TRACE_HIDE,
    };
    public void setOsaTraceOnoffVisibleAlloff(EnumOsaTraceOnoffVisibleAlloff value) {
        model.requestChange(ID.ID_OSA_TRACE_ONOFF_VISIBLE_ALLOFF, value.toString());
    }
    public EnumOsaTraceOnoffVisibleAlloff getOsaTraceOnoffVisibleAlloff() {
        return EnumOsaTraceOnoffVisibleAlloff.valueOf(model.getProperty(ID.ID_OSA_TRACE_ONOFF_VISIBLE_ALLOFF).getCurrentValue());
    }
    public enum EnumServerState{
        ID_SERVER_STATE_INITIALIZING,
        ID_SERVER_STATE_IDLE,
        ID_SERVER_STATE_PREPAREMEASURE,
        ID_SERVER_STATE_AUTOSETTING,
        ID_SERVER_STATE_PARAMSETTING,
        ID_SERVER_STATE_AVERAGING,
        ID_SERVER_STATE_ANALYZING,
        ID_SERVER_STATE_FILEACCESS,
        ID_SERVER_STATE_CALIBRATION,
        ID_SERVER_STATE_DRIFT_WAITING,
        ID_SERVER_STATE_ERROR,
    };
    public void setServerState(EnumServerState value) {
        model.requestChange(ID.ID_SERVER_STATE, value.toString());
    }
    public EnumServerState getServerState() {
        return EnumServerState.valueOf(model.getProperty(ID.ID_SERVER_STATE).getCurrentValue());
    }
    public void setOsaSummaryPinTotalpower(double value) {
        model.requestChange(ID.ID_OSA_SUMMARY_PIN_TOTALPOWER, String.valueOf(value));
    }
    public double getOsaSummaryPinTotalpower() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_SUMMARY_PIN_TOTALPOWER).getCurrentValue());
    }
    public void setVerificationPeriod(long value) {
        model.requestChange(ID.ID_VERIFICATION_PERIOD, String.valueOf(value));
    }
    public long getVerificationPeriod() {
        return Long.valueOf(model.getProperty(ID.ID_VERIFICATION_PERIOD).getCurrentValue());
    }
    public void setOsaSummaryGainslope(double value) {
        model.requestChange(ID.ID_OSA_SUMMARY_GAINSLOPE, String.valueOf(value));
    }
    public double getOsaSummaryGainslope() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_SUMMARY_GAINSLOPE).getCurrentValue());
    }
    public void setOsaCursorLevelRangeMin(double value) {
        model.requestChange(ID.ID_OSA_CURSOR_LEVEL_RANGE_MIN, String.valueOf(value));
    }
    public double getOsaCursorLevelRangeMin() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_CURSOR_LEVEL_RANGE_MIN).getCurrentValue());
    }
    public void setOsaEventTableDriftVisualizer(String value) {
        model.requestChange(ID.ID_OSA_EVENT_TABLE_DRIFT_VISUALIZER, value);
    }
    public String getOsaEventTableDriftVisualizer() {
        return model.getProperty(ID.ID_OSA_EVENT_TABLE_DRIFT_VISUALIZER).getCurrentValue();
    }
    public void setOsaInspectionMotorSetPosition(long value) {
        model.requestChange(ID.ID_OSA_INSPECTION_MOTOR_SET_POSITION, String.valueOf(value));
    }
    public long getOsaInspectionMotorSetPosition() {
        return Long.valueOf(model.getProperty(ID.ID_OSA_INSPECTION_MOTOR_SET_POSITION).getCurrentValue());
    }
    public void setPhase(double value) {
        model.requestChange(ID.ID_PHASE, String.valueOf(value));
    }
    public double getPhase() {
        return Double.valueOf(model.getProperty(ID.ID_PHASE).getCurrentValue());
    }
    public void setSmartfilenamePreset(String value) {
        model.requestChange(ID.ID_SMARTFILENAME_PRESET, value);
    }
    public String getSmartfilenamePreset() {
        return model.getProperty(ID.ID_SMARTFILENAME_PRESET).getCurrentValue();
    }
    public void setOsaGridtableDataScpiM(String value) {
        model.requestChange(ID.ID_OSA_GRIDTABLE_DATA_SCPI_M, value);
    }
    public String getOsaGridtableDataScpiM() {
        return model.getProperty(ID.ID_OSA_GRIDTABLE_DATA_SCPI_M).getCurrentValue();
    }
    public enum EnumOsaChannelCenterDefinition{
        ID_OSA_CHANNEL_CENTER_DEFINITION_DETECTED,
        ID_OSA_CHANNEL_CENTER_DEFINITION_GRID,
    };
    public void setOsaChannelCenterDefinition(EnumOsaChannelCenterDefinition value) {
        model.requestChange(ID.ID_OSA_CHANNEL_CENTER_DEFINITION, value.toString());
    }
    public EnumOsaChannelCenterDefinition getOsaChannelCenterDefinition() {
        return EnumOsaChannelCenterDefinition.valueOf(model.getProperty(ID.ID_OSA_CHANNEL_CENTER_DEFINITION).getCurrentValue());
    }
    public void setOsaEventTableScpiHz(String value) {
        model.requestChange(ID.ID_OSA_EVENT_TABLE_SCPI_HZ, value);
    }
    public String getOsaEventTableScpiHz() {
        return model.getProperty(ID.ID_OSA_EVENT_TABLE_SCPI_HZ).getCurrentValue();
    }
    public void setOsaCursorThresholdLevel(double value) {
        model.requestChange(ID.ID_OSA_CURSOR_THRESHOLD_LEVEL, String.valueOf(value));
    }
    public double getOsaCursorThresholdLevel() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_CURSOR_THRESHOLD_LEVEL).getCurrentValue());
    }
    public void setActiveWaveformModuleName(String value) {
        model.requestChange(ID.ID_ACTIVE_WAVEFORM_MODULE_NAME, value);
    }
    public String getActiveWaveformModuleName() {
        return model.getProperty(ID.ID_ACTIVE_WAVEFORM_MODULE_NAME).getCurrentValue();
    }
    public void setOsaDriftgraphViewrangeStartx(double value) {
        model.requestChange(ID.ID_OSA_DRIFTGRAPH_VIEWRANGE_STARTX, String.valueOf(value));
    }
    public double getOsaDriftgraphViewrangeStartx() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_DRIFTGRAPH_VIEWRANGE_STARTX).getCurrentValue());
    }
    public void setActiveWaveformSoftwareVersion(String value) {
        model.requestChange(ID.ID_ACTIVE_WAVEFORM_SOFTWARE_VERSION, value);
    }
    public String getActiveWaveformSoftwareVersion() {
        return model.getProperty(ID.ID_ACTIVE_WAVEFORM_SOFTWARE_VERSION).getCurrentValue();
    }
    public enum EnumOsaSummarySnr{
        ID_SUMMARY_RESULT_NONE,
        ID_SUMMARY_RESULT_PASS,
        ID_SUMMARY_RESULT_FAIL,
    };
    public void setOsaSummarySnr(EnumOsaSummarySnr value) {
        model.requestChange(ID.ID_OSA_SUMMARY_SNR, value.toString());
    }
    public EnumOsaSummarySnr getOsaSummarySnr() {
        return EnumOsaSummarySnr.valueOf(model.getProperty(ID.ID_OSA_SUMMARY_SNR).getCurrentValue());
    }
    public void setOsaGridImportChannelWidth(double value) {
        model.requestChange(ID.ID_OSA_GRID_IMPORT_CHANNEL_WIDTH, String.valueOf(value));
    }
    public double getOsaGridImportChannelWidth() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_GRID_IMPORT_CHANNEL_WIDTH).getCurrentValue());
    }
    public void setCableid(String value) {
        model.requestChange(ID.ID_CABLEID, value);
    }
    public String getCableid() {
        return model.getProperty(ID.ID_CABLEID).getCurrentValue();
    }
    public void setOsaDebugSimulatorCalfile(String value) {
        model.requestChange(ID.ID_OSA_DEBUG_SIMULATOR_CALFILE, value);
    }
    public String getOsaDebugSimulatorCalfile() {
        return model.getProperty(ID.ID_OSA_DEBUG_SIMULATOR_CALFILE).getCurrentValue();
    }
    public void setOsaDriftgraphViewrangeStopx(double value) {
        model.requestChange(ID.ID_OSA_DRIFTGRAPH_VIEWRANGE_STOPX, String.valueOf(value));
    }
    public double getOsaDriftgraphViewrangeStopx() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_DRIFTGRAPH_VIEWRANGE_STOPX).getCurrentValue());
    }
    public void setOtdrTable(String value) {
        model.requestChange(ID.ID_OTDR_TABLE, value);
    }
    public String getOtdrTable() {
        return model.getProperty(ID.ID_OTDR_TABLE).getCurrentValue();
    }
    public void setOsaAverageCountMaxAverage(long value) {
        model.requestChange(ID.ID_OSA_AVERAGE_COUNT_MAX_AVERAGE, String.valueOf(value));
    }
    public long getOsaAverageCountMaxAverage() {
        return Long.valueOf(model.getProperty(ID.ID_OSA_AVERAGE_COUNT_MAX_AVERAGE).getCurrentValue());
    }
    public void setOsaActiveCursorStepLevel(double value) {
        model.requestChange(ID.ID_OSA_ACTIVE_CURSOR_STEP_LEVEL, String.valueOf(value));
    }
    public double getOsaActiveCursorStepLevel() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_ACTIVE_CURSOR_STEP_LEVEL).getCurrentValue());
    }
    public void setOsaStartWavelengthNm(double value) {
        model.requestChange(ID.ID_OSA_START_WAVELENGTH_NM, String.valueOf(value));
    }
    public double getOsaStartWavelengthNm() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_START_WAVELENGTH_NM).getCurrentValue());
    }
    public enum EnumMessageNoResponse{
        ID_MESSAGECONTENT_NOMESSAGE,
        ID_MESSAGECONTENT_ACTIVE_FIBER,
        ID_MESSAGECONTENT_OFFSET_ERROR,
        ID_MESSAGECONTENT_LOAD_FAIL,
        ID_MESSAGECONTENT_LOAD_CONFLICT,
        ID_MESSAGECONTENT_LOAD_DIFFERENT_WAVE,
        ID_MESSAGECONTENT_LOAD_FAIL_NOT_FOUND_RESULT,
        ID_MESSAGECONTENT_LOAD_SWEEP_TYPE_UNMATCH,
        ID_MESSAGECONTENT_SAVE_NO_DISKSPACE,
        ID_MESSAGECONTENT_WRITE_ERROR,
        ID_MESSAGECONTENT_FILE_EXISTS_ERROR,
        ID_MESSAGECONTENT_ZEROSETFAILED,
        ID_MESSAGECONTENT_NOTRACE_ERROR,
        ID_MESSAGECONTENT_NOTRACE_ERROR_FOR_REPORT,
        ID_MESSAGECONTENT_WRITE_ERROR_CALIB_PERIOD,
        ID_MESSAGECONTENT_READ_ERROR_CALIB_PERIOD,
        ID_MESSAGECONTENT_INIT_CALIB_PERIOD,
        ID_MESSAGECONTENT_HEALTHCHECK_ERROR_MEASURE,
        ID_MESSAGECONTENT_HEALTHCHECK_ERROR_UNITROM,
        ID_MESSAGECONTENT_HEALTHCHECK_ERROR_CALIBROM,
        ID_MESSAGECONTENT_LOAD_LISTMISSMATCH,
        ID_MESSAGECONTENT_GRIDTABLE_CHANNEL_OVERLAP,
        ID_MESSAGECONTENT_GRIDTABLE_CHANNEL_OVERLAP_IMPORT,
        ID_MESSAGECONTENT_GRIDTABLE_CHANNEL_OVERLAP_ADD,
        ID_MESSAGECONTENT_GRIDTABLE_LOAD_FAIL,
        ID_MESSAGECONTENT_GRIDTABLE_DELETE_ALL_ERROR,
        ID_MESSAGECONTENT_GRIDTABLE_CREATE_MANY_CHANNELS,
        ID_MESSAGECONTENT_GRIDTABLE_ADD_MANY_CHANNELS,
        ID_MESSAGECONTENT_GRIDTABLE_CHANNEL_EMPTY,
        ID_MESSAGECONTENT_OVER_RANGE_OSNR_PARAMETER,
        ID_MESSAGECONTENT_FAILED_AUTO_MEASURE,
        ID_MESSAGECONTENT_MEASURE_RESUMPLING_ERROR,
        ID_MESSAGECONTENT_CALIBRATION_ERROR,
        ID_MESSAGECONTENT_FAILED_CREATE_FOLDER,
        ID_MESSAGECONTENT_FAILD_DRIVER_OPEN,
        ID_MESSAGECONTENT_FAILD_READ_CALIBRATION_DATA,
        ID_MESSAGECONTENT_MOTOR_MOVE_TIMEOUT,
        ID_MESSAGECONTENT_DATA_READ_TIMEOUT,
        ID_MESSAGECONTENT_LD_CURRENT_OVERLOAD,
        ID_MESSAGECONTENT_MEMERGENCY_STOP,
        ID_MESSAGECONTENT_NOT_DETECT_PHOTOINTERRUPTER,
        ID_MESSAGECONTENT_ILLEGAL_DETECT_PHOTOINTERRUPTER,
        ID_MESSAGECONTENT_ILLEGAL_INTERRUPT,
        ID_MESSAGECONTENT_FAILED_OFFSET,
        ID_MESSAGECONTENT_DISKFULL_STOP_DRIFT_RESULT,
        ID_MESSAGECONTENT_DISKFULL_STOP_DRIFT_WDM_RESULT,
        ID_MESSAGECONTENT_PEAK_NOTFOUND,
        ID_MESSAGECONTENT_DRIFT_FINISHED,
        ID_MESSAGECONTENT_ANALYSIS_ERROR,
        ID_MESSAGECONTENT_INTERNAL_ERROR,
        ID_MESSAGECONTENT_MEASURE_MIRRORTABLE_ERROR,
        ID_MESSAGECONTENT_MEASURE_PD_MONITOR_ERROR,
        ID_MESSAGECONTENT_MEASURE_ENCODER_ERROR,
        ID_MESSAGECONTENT_VOLTAGE_ERROR,
        ID_MESSAGECONTENT_INVALID_FILE_LOCATION,
        ID_MESSAGECONTENT_INVALID_FILE_LOCATION_ONOFF,
        ID_MESSAGECONTENT_NO_HISTORY_TRACE,
        ID_MESSAGECONTENT_INIT_UN_CALC_OSNR_OR_POWER,
        ID_MESSAGECONTENT_EXPORT_DIAGNOSTICS_COMPLETE,
        ID_MESSAGECONTENT_FAILED_IMPORT_FILES,
        ID_MESSAGECONTENT_FOUND_NO_CHANNEL,
        ID_MESSAGECONTENT_NO_OFF_CHANNEL,
        ID_MESSAGECONTENT_DUPLICATED_OFF_CHANNEL,
        ID_MESSAGECONTENT_NOT_FOUND_FILE,
        ID_MESSAGECONTENT_LATENCTY_IS_DETECTED,
        ID_MESSAGECONTENT_NO_CHANNEL_DETECTED,
        ID_MESSAGECONTENT_DEFFERENT_CONTENTS,
        ID_MESSAGECONTENT_NO_ONOFF_RESULT_DATA,
        ID_MESSAGECONTENT_NOT_GENERATE_REPORT,
        ID_MESSAGECONTENT_USING_DEBUG_FUNCTION,
        ID_MESSAGECONTENT_NOMESSAGE_DUMMY,
    };
    public void setMessageNoResponse(EnumMessageNoResponse value) {
        model.requestChange(ID.ID_MESSAGE_NO_RESPONSE, value.toString());
    }
    public EnumMessageNoResponse getMessageNoResponse() {
        return EnumMessageNoResponse.valueOf(model.getProperty(ID.ID_MESSAGE_NO_RESPONSE).getCurrentValue());
    }
    public enum EnumOsaDebugFittingCurveGetType{
        ID_OSA_DEBUG_FITTING_CURVE_GET_TYPE_CORBA,
        ID_OSA_DEBUG_FITTING_CURVE_GET_TYPE_TABLE,
    };
    public void setOsaDebugFittingCurveGetType(EnumOsaDebugFittingCurveGetType value) {
        model.requestChange(ID.ID_OSA_DEBUG_FITTING_CURVE_GET_TYPE, value.toString());
    }
    public EnumOsaDebugFittingCurveGetType getOsaDebugFittingCurveGetType() {
        return EnumOsaDebugFittingCurveGetType.valueOf(model.getProperty(ID.ID_OSA_DEBUG_FITTING_CURVE_GET_TYPE).getCurrentValue());
    }
    public void setOsaDriftgraphViewMinx(double value) {
        model.requestChange(ID.ID_OSA_DRIFTGRAPH_VIEW_MINX, String.valueOf(value));
    }
    public double getOsaDriftgraphViewMinx() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_DRIFTGRAPH_VIEW_MINX).getCurrentValue());
    }
    public void setOsaGlobalNdb(double value) {
        model.requestChange(ID.ID_OSA_GLOBAL_NDB, String.valueOf(value));
    }
    public double getOsaGlobalNdb() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_GLOBAL_NDB).getCurrentValue());
    }
    public void setOsaEventTableChannelVisualizer(String value) {
        model.requestChange(ID.ID_OSA_EVENT_TABLE_CHANNEL_VISUALIZER, value);
    }
    public String getOsaEventTableChannelVisualizer() {
        return model.getProperty(ID.ID_OSA_EVENT_TABLE_CHANNEL_VISUALIZER).getCurrentValue();
    }
    public void setOsaSummaryChannelcountAll(double value) {
        model.requestChange(ID.ID_OSA_SUMMARY_CHANNELCOUNT_ALL, String.valueOf(value));
    }
    public double getOsaSummaryChannelcountAll() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_SUMMARY_CHANNELCOUNT_ALL).getCurrentValue());
    }
    public void setSoftwareVersion(String value) {
        model.requestChange(ID.ID_SOFTWARE_VERSION, value);
    }
    public String getSoftwareVersion() {
        return model.getProperty(ID.ID_SOFTWARE_VERSION).getCurrentValue();
    }
    public enum EnumOsaRbw{
        ID_OSA_RBW_FULL,
        ID_OSA_RBW_0_1_NM,
        ID_OSA_RBW_0_2_NM,
        ID_OSA_RBW_0_3_NM,
        ID_OSA_RBW_0_4_NM,
        ID_OSA_RBW_0_5_NM,
        ID_OSA_RBW_1_0_NM,
        ID_OSA_RBW_2_0_NM,
        ID_OSA_RBW_5_0_NM,
    };
    public void setOsaRbw(EnumOsaRbw value) {
        model.requestChange(ID.ID_OSA_RBW, value.toString());
    }
    public EnumOsaRbw getOsaRbw() {
        return EnumOsaRbw.valueOf(model.getProperty(ID.ID_OSA_RBW).getCurrentValue());
    }
    public enum EnumDriftChartGraphOperationMode{
        ID_GRAPH_OPERATION_MODE_ZOOMIN,
        ID_GRAPH_OPERATION_MODE_ZOOMOUT,
        ID_GRAPH_OPERATION_MODE_VIEWALL,
        ID_GRAPH_OPERATION_MODE_MOVE,
        ID_GRAPH_OPERATION_MODE_CURSOR,
    };
    public void setDriftChartGraphOperationMode(EnumDriftChartGraphOperationMode value) {
        model.requestChange(ID.ID_DRIFT_CHART_GRAPH_OPERATION_MODE, value.toString());
    }
    public EnumDriftChartGraphOperationMode getDriftChartGraphOperationMode() {
        return EnumDriftChartGraphOperationMode.valueOf(model.getProperty(ID.ID_DRIFT_CHART_GRAPH_OPERATION_MODE).getCurrentValue());
    }
    public void setOperator(String value) {
        model.requestChange(ID.ID_OPERATOR, value);
    }
    public String getOperator() {
        return model.getProperty(ID.ID_OPERATOR).getCurrentValue();
    }
    public enum EnumOsaTraceDriftVisibleInitial{
        ID_OSA_TRACE_SHOW,
        ID_OSA_TRACE_HIDE,
    };
    public void setOsaTraceDriftVisibleInitial(EnumOsaTraceDriftVisibleInitial value) {
        model.requestChange(ID.ID_OSA_TRACE_DRIFT_VISIBLE_INITIAL, value.toString());
    }
    public EnumOsaTraceDriftVisibleInitial getOsaTraceDriftVisibleInitial() {
        return EnumOsaTraceDriftVisibleInitial.valueOf(model.getProperty(ID.ID_OSA_TRACE_DRIFT_VISIBLE_INITIAL).getCurrentValue());
    }
    public enum EnumAutoSave{
        ID_AUTO_SAVE_PROMPT,
        ID_AUTO_SAVE_ON,
        ID_AUTO_SAVE_NONE,
    };
    public void setAutoSave(EnumAutoSave value) {
        model.requestChange(ID.ID_AUTO_SAVE, value.toString());
    }
    public EnumAutoSave getAutoSave() {
        return EnumAutoSave.valueOf(model.getProperty(ID.ID_AUTO_SAVE).getCurrentValue());
    }
    public enum EnumOsaEventTableFail{
        ID_SUMMARY_RESULT_NONE,
        ID_SUMMARY_RESULT_PASS,
        ID_SUMMARY_RESULT_FAIL,
    };
    public void setOsaEventTableFail(EnumOsaEventTableFail value) {
        model.requestChange(ID.ID_OSA_EVENT_TABLE_FAIL, value.toString());
    }
    public EnumOsaEventTableFail getOsaEventTableFail() {
        return EnumOsaEventTableFail.valueOf(model.getProperty(ID.ID_OSA_EVENT_TABLE_FAIL).getCurrentValue());
    }
    public void setOsaInspectionLigthsourceTemperature(double value) {
        model.requestChange(ID.ID_OSA_INSPECTION_LIGTHSOURCE_TEMPERATURE, String.valueOf(value));
    }
    public double getOsaInspectionLigthsourceTemperature() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_INSPECTION_LIGTHSOURCE_TEMPERATURE).getCurrentValue());
    }
    public void setOsaDebugSimulatorSteppos(long value) {
        model.requestChange(ID.ID_OSA_DEBUG_SIMULATOR_STEPPOS, String.valueOf(value));
    }
    public long getOsaDebugSimulatorSteppos() {
        return Long.valueOf(model.getProperty(ID.ID_OSA_DEBUG_SIMULATOR_STEPPOS).getCurrentValue());
    }
    public enum EnumOsaOnoffOsnrMethod{
        ID_OSA_ONOFF_OSNR_METHOD_IEC,
        ID_OSA_ONOFF_OSNR_METHOD_CCSA,
        ID_OSA_ONOFF_OSNR_METHOD_USER,
    };
    public void setOsaOnoffOsnrMethod(EnumOsaOnoffOsnrMethod value) {
        model.requestChange(ID.ID_OSA_ONOFF_OSNR_METHOD, value.toString());
    }
    public EnumOsaOnoffOsnrMethod getOsaOnoffOsnrMethod() {
        return EnumOsaOnoffOsnrMethod.valueOf(model.getProperty(ID.ID_OSA_ONOFF_OSNR_METHOD).getCurrentValue());
    }
    public enum EnumOsaTraceDriftVisibleCurrentAndHistory{
        ID_OSA_TRACE_SHOW,
        ID_OSA_TRACE_HIDE,
    };
    public void setOsaTraceDriftVisibleCurrentAndHistory(EnumOsaTraceDriftVisibleCurrentAndHistory value) {
        model.requestChange(ID.ID_OSA_TRACE_DRIFT_VISIBLE_CURRENT_AND_HISTORY, value.toString());
    }
    public EnumOsaTraceDriftVisibleCurrentAndHistory getOsaTraceDriftVisibleCurrentAndHistory() {
        return EnumOsaTraceDriftVisibleCurrentAndHistory.valueOf(model.getProperty(ID.ID_OSA_TRACE_DRIFT_VISIBLE_CURRENT_AND_HISTORY).getCurrentValue());
    }
    public void setOsaDebugSimulatorMiddleEdgepos(long value) {
        model.requestChange(ID.ID_OSA_DEBUG_SIMULATOR_MIDDLE_EDGEPOS, String.valueOf(value));
    }
    public long getOsaDebugSimulatorMiddleEdgepos() {
        return Long.valueOf(model.getProperty(ID.ID_OSA_DEBUG_SIMULATOR_MIDDLE_EDGEPOS).getCurrentValue());
    }
    public enum EnumOtdrStartStop{
        ID_OTDR_START_STOP_START,
        ID_OTDR_START_STOP_STOP,
    };
    public void setOtdrStartStop(EnumOtdrStartStop value) {
        model.requestChange(ID.ID_OTDR_START_STOP, value.toString());
    }
    public EnumOtdrStartStop getOtdrStartStop() {
        return EnumOtdrStartStop.valueOf(model.getProperty(ID.ID_OTDR_START_STOP).getCurrentValue());
    }
    public enum EnumCalibrationMode{
        ID_CALIBRATION_MODE_SPEED,
        ID_CALIBRATION_MODE_ACCURACY,
    };
    public void setCalibrationMode(EnumCalibrationMode value) {
        model.requestChange(ID.ID_CALIBRATION_MODE, value.toString());
    }
    public EnumCalibrationMode getCalibrationMode() {
        return EnumCalibrationMode.valueOf(model.getProperty(ID.ID_CALIBRATION_MODE).getCurrentValue());
    }
    public enum EnumTxrx{
        ID_TXRX_TX,
        ID_TXRX_RX,
    };
    public void setTxrx(EnumTxrx value) {
        model.requestChange(ID.ID_TXRX, value.toString());
    }
    public EnumTxrx getTxrx() {
        return EnumTxrx.valueOf(model.getProperty(ID.ID_TXRX).getCurrentValue());
    }
    public void setOsaNoiseIntegrationBw(double value) {
        model.requestChange(ID.ID_OSA_NOISE_INTEGRATION_BW, String.valueOf(value));
    }
    public double getOsaNoiseIntegrationBw() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_NOISE_INTEGRATION_BW).getCurrentValue());
    }
    public enum EnumGraphOperationMode{
        ID_GRAPH_OPERATION_MODE_ZOOMIN,
        ID_GRAPH_OPERATION_MODE_ZOOMOUT,
        ID_GRAPH_OPERATION_MODE_VIEWALL,
        ID_GRAPH_OPERATION_MODE_MOVE,
        ID_GRAPH_OPERATION_MODE_CURSOR,
    };
    public void setGraphOperationMode(EnumGraphOperationMode value) {
        model.requestChange(ID.ID_GRAPH_OPERATION_MODE, value.toString());
    }
    public EnumGraphOperationMode getGraphOperationMode() {
        return EnumGraphOperationMode.valueOf(model.getProperty(ID.ID_GRAPH_OPERATION_MODE).getCurrentValue());
    }
    public void setOsaGridSpacing(double value) {
        model.requestChange(ID.ID_OSA_GRID_SPACING, String.valueOf(value));
    }
    public double getOsaGridSpacing() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_GRID_SPACING).getCurrentValue());
    }
    public void setPpgDatalength(long value) {
        model.requestChange(ID.ID_PPG_DATALENGTH, String.valueOf(value));
    }
    public long getPpgDatalength() {
        return Long.valueOf(model.getProperty(ID.ID_PPG_DATALENGTH).getCurrentValue());
    }
    public void setOsaAverageCount(long value) {
        model.requestChange(ID.ID_OSA_AVERAGE_COUNT, String.valueOf(value));
    }
    public long getOsaAverageCount() {
        return Long.valueOf(model.getProperty(ID.ID_OSA_AVERAGE_COUNT).getCurrentValue());
    }
    public void setPpgCrosspoint(double value) {
        model.requestChange(ID.ID_PPG_CROSSPOINT, String.valueOf(value));
    }
    public double getPpgCrosspoint() {
        return Double.valueOf(model.getProperty(ID.ID_PPG_CROSSPOINT).getCurrentValue());
    }
    public enum EnumOsaInspectionSweepMode{
        ID_OTDR_PULSEWIDTH_10NS,
        ID_OTDR_PULSEWIDTH_50NS,
    };
    public void setOsaInspectionSweepMode(EnumOsaInspectionSweepMode value) {
        model.requestChange(ID.ID_OSA_INSPECTION_SWEEP_MODE, value.toString());
    }
    public EnumOsaInspectionSweepMode getOsaInspectionSweepMode() {
        return EnumOsaInspectionSweepMode.valueOf(model.getProperty(ID.ID_OSA_INSPECTION_SWEEP_MODE).getCurrentValue());
    }
    public void setOsaCursorLevelD(double value) {
        model.requestChange(ID.ID_OSA_CURSOR_LEVEL_D, String.valueOf(value));
    }
    public double getOsaCursorLevelD() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_CURSOR_LEVEL_D).getCurrentValue());
    }
    public enum EnumTechnology{
        ID_TECHNOLOGY_SDH,
        ID_TECHNOLOGY_OTN,
        ID_TECHNOLOGY_ETHERNET,
        ID_TECHNOLOGY_PDH,
    };
    public void setTechnology(EnumTechnology value) {
        model.requestChange(ID.ID_TECHNOLOGY, value.toString());
    }
    public EnumTechnology getTechnology() {
        return EnumTechnology.valueOf(model.getProperty(ID.ID_TECHNOLOGY).getCurrentValue());
    }
    public enum EnumTransmitter{
        ID_TRANSMITTER_SFP,
        ID_TRANSMITTER_CFP,
        ID_TRANSMITTER_QSFP,
        ID_TRANSMITTER_XFP,
    };
    public void setTransmitter(EnumTransmitter value) {
        model.requestChange(ID.ID_TRANSMITTER, value.toString());
    }
    public EnumTransmitter getTransmitter() {
        return EnumTransmitter.valueOf(model.getProperty(ID.ID_TRANSMITTER).getCurrentValue());
    }
    public void setAutosavedFilename(String value) {
        model.requestChange(ID.ID_AUTOSAVED_FILENAME, value);
    }
    public String getAutosavedFilename() {
        return model.getProperty(ID.ID_AUTOSAVED_FILENAME).getCurrentValue();
    }
    public enum EnumSpeed{
        ID_SPEED_1G,
        ID_SPEED_2_5G,
        ID_SPEED_10G,
        ID_SPEED_40G,
        ID_SPEED_100G,
    };
    public void setSpeed(EnumSpeed value) {
        model.requestChange(ID.ID_SPEED, value.toString());
    }
    public EnumSpeed getSpeed() {
        return EnumSpeed.valueOf(model.getProperty(ID.ID_SPEED).getCurrentValue());
    }
    public enum EnumOsaSummaryDeltaf{
        ID_SUMMARY_RESULT_NONE,
        ID_SUMMARY_RESULT_PASS,
        ID_SUMMARY_RESULT_FAIL,
    };
    public void setOsaSummaryDeltaf(EnumOsaSummaryDeltaf value) {
        model.requestChange(ID.ID_OSA_SUMMARY_DELTAF, value.toString());
    }
    public EnumOsaSummaryDeltaf getOsaSummaryDeltaf() {
        return EnumOsaSummaryDeltaf.valueOf(model.getProperty(ID.ID_OSA_SUMMARY_DELTAF).getCurrentValue());
    }
    public enum EnumOsaGridType{
        ID_OSA_GRID_TYPE_ITUT100G,
        ID_OSA_GRID_TYPE_ITUT50G,
        ID_OSA_GRID_TYPE_ITUT25G,
        ID_OSA_GRID_TYPE_ITUT12_5G,
        ID_OSA_GRID_TYPE_CWDM,
        ID_OSA_GRID_TYPE_USER,
    };
    public void setOsaGridType(EnumOsaGridType value) {
        model.requestChange(ID.ID_OSA_GRID_TYPE, value.toString());
    }
    public EnumOsaGridType getOsaGridType() {
        return EnumOsaGridType.valueOf(model.getProperty(ID.ID_OSA_GRID_TYPE).getCurrentValue());
    }
    public void setOsaSummaryAverageosnr(double value) {
        model.requestChange(ID.ID_OSA_SUMMARY_AVERAGEOSNR, String.valueOf(value));
    }
    public double getOsaSummaryAverageosnr() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_SUMMARY_AVERAGEOSNR).getCurrentValue());
    }
    public enum EnumProductname{
        ID_PRODUCTNAME_MT1000A,
        ID_PRODUCTNAME_MT1100A,
    };
    public void setProductname(EnumProductname value) {
        model.requestChange(ID.ID_PRODUCTNAME, value.toString());
    }
    public EnumProductname getProductname() {
        return EnumProductname.valueOf(model.getProperty(ID.ID_PRODUCTNAME).getCurrentValue());
    }
    public enum EnumOsaGridtableOperationMode{
        ID_OSA_GRIDTABLE_OPERATION_MODE_CREATE,
        ID_OSA_GRIDTABLE_OPERATION_MODE_EDIT,
        ID_OSA_GRIDTABLE_OPERATION_MODE_ADD,
        ID_OSA_GRIDTABLE_OPERATION_MODE_OTHER,
    };
    public void setOsaGridtableOperationMode(EnumOsaGridtableOperationMode value) {
        model.requestChange(ID.ID_OSA_GRIDTABLE_OPERATION_MODE, value.toString());
    }
    public EnumOsaGridtableOperationMode getOsaGridtableOperationMode() {
        return EnumOsaGridtableOperationMode.valueOf(model.getProperty(ID.ID_OSA_GRIDTABLE_OPERATION_MODE).getCurrentValue());
    }
    public enum EnumPort{
        ID_PORT_1,
        ID_PORT_2,
        ID_PORT_3,
        ID_PORT_4,
    };
    public void setPort(EnumPort value) {
        model.requestChange(ID.ID_PORT, value.toString());
    }
    public EnumPort getPort() {
        return EnumPort.valueOf(model.getProperty(ID.ID_PORT).getCurrentValue());
    }
    public void setOsaInspectionRegILimit(long value) {
        model.requestChange(ID.ID_OSA_INSPECTION_REG_I_LIMIT, String.valueOf(value));
    }
    public long getOsaInspectionRegILimit() {
        return Long.valueOf(model.getProperty(ID.ID_OSA_INSPECTION_REG_I_LIMIT).getCurrentValue());
    }
    public enum EnumEdStart{
        ID_ED_START_START,
        ID_ED_START_STOP,
    };
    public void setEdStart(EnumEdStart value) {
        model.requestChange(ID.ID_ED_START, value.toString());
    }
    public EnumEdStart getEdStart() {
        return EnumEdStart.valueOf(model.getProperty(ID.ID_ED_START).getCurrentValue());
    }
    public enum EnumOsaGridCreateType{
        ID_OSA_GRID_CREATE_TYPE_NONE,
        ID_OSA_GRID_CREATE_TYPE_NEW,
        ID_OSA_GRID_CREATE_TYPE_IMPORT,
    };
    public void setOsaGridCreateType(EnumOsaGridCreateType value) {
        model.requestChange(ID.ID_OSA_GRID_CREATE_TYPE, value.toString());
    }
    public EnumOsaGridCreateType getOsaGridCreateType() {
        return EnumOsaGridCreateType.valueOf(model.getProperty(ID.ID_OSA_GRID_CREATE_TYPE).getCurrentValue());
    }
    public void setOsaInspectionRegI(long value) {
        model.requestChange(ID.ID_OSA_INSPECTION_REG_I, String.valueOf(value));
    }
    public long getOsaInspectionRegI() {
        return Long.valueOf(model.getProperty(ID.ID_OSA_INSPECTION_REG_I).getCurrentValue());
    }
    public enum EnumProgressbarDialog{
        ID_OSA_INSPECTION_SWEEP_MODE_DEFAULT,
        ID_OSA_INSPECTION_SWEEP_MODE_PUMP,
    };
    public void setProgressbarDialog(EnumProgressbarDialog value) {
        model.requestChange(ID.ID_PROGRESSBAR_DIALOG, value.toString());
    }
    public EnumProgressbarDialog getProgressbarDialog() {
        return EnumProgressbarDialog.valueOf(model.getProperty(ID.ID_PROGRESSBAR_DIALOG).getCurrentValue());
    }
    public void setOsaDebugAssignedruntest(String value) {
        model.requestChange(ID.ID_OSA_DEBUG_ASSIGNEDRUNTEST, value);
    }
    public String getOsaDebugAssignedruntest() {
        return model.getProperty(ID.ID_OSA_DEBUG_ASSIGNEDRUNTEST).getCurrentValue();
    }
    public void setOsaSummaryTotalpower(double value) {
        model.requestChange(ID.ID_OSA_SUMMARY_TOTALPOWER, String.valueOf(value));
    }
    public double getOsaSummaryTotalpower() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_SUMMARY_TOTALPOWER).getCurrentValue());
    }
    public void setOsaPoutLossOffset(double value) {
        model.requestChange(ID.ID_OSA_POUT_LOSS_OFFSET, String.valueOf(value));
    }
    public double getOsaPoutLossOffset() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_POUT_LOSS_OFFSET).getCurrentValue());
    }
    public void setOsaGridtableData(String value) {
        model.requestChange(ID.ID_OSA_GRIDTABLE_DATA, value);
    }
    public String getOsaGridtableData() {
        return model.getProperty(ID.ID_OSA_GRIDTABLE_DATA).getCurrentValue();
    }
    public void setOsaCursorLevelC(double value) {
        model.requestChange(ID.ID_OSA_CURSOR_LEVEL_C, String.valueOf(value));
    }
    public double getOsaCursorLevelC() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_CURSOR_LEVEL_C).getCurrentValue());
    }
    public enum EnumOsaTraceDriftVisibleHistory{
        ID_OSA_TRACE_SHOW,
        ID_OSA_TRACE_HIDE,
    };
    public void setOsaTraceDriftVisibleHistory(EnumOsaTraceDriftVisibleHistory value) {
        model.requestChange(ID.ID_OSA_TRACE_DRIFT_VISIBLE_HISTORY, value.toString());
    }
    public EnumOsaTraceDriftVisibleHistory getOsaTraceDriftVisibleHistory() {
        return EnumOsaTraceDriftVisibleHistory.valueOf(model.getProperty(ID.ID_OSA_TRACE_DRIFT_VISIBLE_HISTORY).getCurrentValue());
    }
    public void setOsaTrace(String value) {
        model.requestChange(ID.ID_OSA_TRACE, value);
    }
    public String getOsaTrace() {
        return model.getProperty(ID.ID_OSA_TRACE).getCurrentValue();
    }
    public void setOsaInspectionMotorZeroPosition(long value) {
        model.requestChange(ID.ID_OSA_INSPECTION_MOTOR_ZERO_POSITION, String.valueOf(value));
    }
    public long getOsaInspectionMotorZeroPosition() {
        return Long.valueOf(model.getProperty(ID.ID_OSA_INSPECTION_MOTOR_ZERO_POSITION).getCurrentValue());
    }
    public void setOsaActiveChannelNumber(long value) {
        model.requestChange(ID.ID_OSA_ACTIVE_CHANNEL_NUMBER, String.valueOf(value));
    }
    public long getOsaActiveChannelNumber() {
        return Long.valueOf(model.getProperty(ID.ID_OSA_ACTIVE_CHANNEL_NUMBER).getCurrentValue());
    }
    public void setSelectedevent(long value) {
        model.requestChange(ID.ID_SELECTEDEVENT, String.valueOf(value));
    }
    public long getSelectedevent() {
        return Long.valueOf(model.getProperty(ID.ID_SELECTEDEVENT).getCurrentValue());
    }
    public enum EnumMessageOkWait{
        ID_MESSAGECONTENT_NOMESSAGE,
        ID_MESSAGECONTENT_DRIFT_APPLY_BAND_REQUIRED,
        ID_MESSAGECONTENT_CANNOT_LOAD_RESDRIFT_FOR_RFB,
        ID_MESSAGECONTENT_NOMESSAGE_DUMMY,
    };
    public void setMessageOkWait(EnumMessageOkWait value) {
        model.requestChange(ID.ID_MESSAGE_OK_WAIT, value.toString());
    }
    public EnumMessageOkWait getMessageOkWait() {
        return EnumMessageOkWait.valueOf(model.getProperty(ID.ID_MESSAGE_OK_WAIT).getCurrentValue());
    }
    public void setOsaDebugSimulatorNoiseAmplitude(double value) {
        model.requestChange(ID.ID_OSA_DEBUG_SIMULATOR_NOISE_AMPLITUDE, String.valueOf(value));
    }
    public double getOsaDebugSimulatorNoiseAmplitude() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_DEBUG_SIMULATOR_NOISE_AMPLITUDE).getCurrentValue());
    }
    public enum EnumOsaInspectionLightsourceType{
        ID_OSA_INSPECTION_LIGHTSOURCE_TYPE_PUMP,
        ID_OSA_INSPECTION_LIGHTSOURCE_TYPE_DFB,
    };
    public void setOsaInspectionLightsourceType(EnumOsaInspectionLightsourceType value) {
        model.requestChange(ID.ID_OSA_INSPECTION_LIGHTSOURCE_TYPE, value.toString());
    }
    public EnumOsaInspectionLightsourceType getOsaInspectionLightsourceType() {
        return EnumOsaInspectionLightsourceType.valueOf(model.getProperty(ID.ID_OSA_INSPECTION_LIGHTSOURCE_TYPE).getCurrentValue());
    }
    public enum EnumOsaTraceOnoffVisibleAllon{
        ID_OSA_TRACE_SHOW,
        ID_OSA_TRACE_HIDE,
    };
    public void setOsaTraceOnoffVisibleAllon(EnumOsaTraceOnoffVisibleAllon value) {
        model.requestChange(ID.ID_OSA_TRACE_ONOFF_VISIBLE_ALLON, value.toString());
    }
    public EnumOsaTraceOnoffVisibleAllon getOsaTraceOnoffVisibleAllon() {
        return EnumOsaTraceOnoffVisibleAllon.valueOf(model.getProperty(ID.ID_OSA_TRACE_ONOFF_VISIBLE_ALLON).getCurrentValue());
    }
    public void setOsaX2PowerRbw(double value) {
        model.requestChange(ID.ID_OSA_X2_POWER_RBW, String.valueOf(value));
    }
    public double getOsaX2PowerRbw() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_X2_POWER_RBW).getCurrentValue());
    }
    public void setSelectedeventSummary(long value) {
        model.requestChange(ID.ID_SELECTEDEVENT_SUMMARY, String.valueOf(value));
    }
    public long getSelectedeventSummary() {
        return Long.valueOf(model.getProperty(ID.ID_SELECTEDEVENT_SUMMARY).getCurrentValue());
    }
    public void setOsaFittingCurveTable(String value) {
        model.requestChange(ID.ID_OSA_FITTING_CURVE_TABLE, value);
    }
    public String getOsaFittingCurveTable() {
        return model.getProperty(ID.ID_OSA_FITTING_CURVE_TABLE).getCurrentValue();
    }
    public void setGraphViewFullscaleMinydb(double value) {
        model.requestChange(ID.ID_GRAPH_VIEW_FULLSCALE_MINYDB, String.valueOf(value));
    }
    public double getGraphViewFullscaleMinydb() {
        return Double.valueOf(model.getProperty(ID.ID_GRAPH_VIEW_FULLSCALE_MINYDB).getCurrentValue());
    }
    public void setTransceiverCompliance(String value) {
        model.requestChange(ID.ID_TRANSCEIVER_COMPLIANCE, value);
    }
    public String getTransceiverCompliance() {
        return model.getProperty(ID.ID_TRANSCEIVER_COMPLIANCE).getCurrentValue();
    }
    public void setSmartfilenameMacrolist(String value) {
        model.requestChange(ID.ID_SMARTFILENAME_MACROLIST, value);
    }
    public String getSmartfilenameMacrolist() {
        return model.getProperty(ID.ID_SMARTFILENAME_MACROLIST).getCurrentValue();
    }
    public enum EnumOsaSweepType{
        ID_OSA_SWEEP_TYPE_SINGLE,
        ID_OSA_SWEEP_TYPE_REPEAT,
        ID_OSA_SWEEP_TYPE_AVERAGE,
        ID_OSA_SWEEP_TYPE_INBAND,
    };
    public void setOsaSweepType(EnumOsaSweepType value) {
        model.requestChange(ID.ID_OSA_SWEEP_TYPE, value.toString());
    }
    public EnumOsaSweepType getOsaSweepType() {
        return EnumOsaSweepType.valueOf(model.getProperty(ID.ID_OSA_SWEEP_TYPE).getCurrentValue());
    }
    public void setDisplayCount(String value) {
        model.requestChange(ID.ID_DISPLAY_COUNT, value);
    }
    public String getDisplayCount() {
        return model.getProperty(ID.ID_DISPLAY_COUNT).getCurrentValue();
    }
    public enum EnumOtdrDistanceunit{
        ID_OTDR_DISTANCEUNIT_KM,
        ID_OTDR_DISTANCEUNIT_M,
        ID_OTDR_DISTANCEUNIT_MILE,
        ID_OTDR_DISTANCEUNIT_FEET,
    };
    public void setOtdrDistanceunit(EnumOtdrDistanceunit value) {
        model.requestChange(ID.ID_OTDR_DISTANCEUNIT, value.toString());
    }
    public EnumOtdrDistanceunit getOtdrDistanceunit() {
        return EnumOtdrDistanceunit.valueOf(model.getProperty(ID.ID_OTDR_DISTANCEUNIT).getCurrentValue());
    }
    public enum EnumOtdrMode{
        ID_OTDR_MODE_NORMAL,
        ID_OTDR_MODE_ADVANCED,
    };
    public void setOtdrMode(EnumOtdrMode value) {
        model.requestChange(ID.ID_OTDR_MODE, value.toString());
    }
    public EnumOtdrMode getOtdrMode() {
        return EnumOtdrMode.valueOf(model.getProperty(ID.ID_OTDR_MODE).getCurrentValue());
    }
    public void setPpgBitrate(double value) {
        model.requestChange(ID.ID_PPG_BITRATE, String.valueOf(value));
    }
    public double getPpgBitrate() {
        return Double.valueOf(model.getProperty(ID.ID_PPG_BITRATE).getCurrentValue());
    }
    public void setOsaInspectionMesureLastError(String value) {
        model.requestChange(ID.ID_OSA_INSPECTION_MESURE_LAST_ERROR, value);
    }
    public String getOsaInspectionMesureLastError() {
        return model.getProperty(ID.ID_OSA_INSPECTION_MESURE_LAST_ERROR).getCurrentValue();
    }
    public enum EnumOsaSummaryPwr{
        ID_SUMMARY_RESULT_NONE,
        ID_SUMMARY_RESULT_PASS,
        ID_SUMMARY_RESULT_FAIL,
    };
    public void setOsaSummaryPwr(EnumOsaSummaryPwr value) {
        model.requestChange(ID.ID_OSA_SUMMARY_PWR, value.toString());
    }
    public EnumOsaSummaryPwr getOsaSummaryPwr() {
        return EnumOsaSummaryPwr.valueOf(model.getProperty(ID.ID_OSA_SUMMARY_PWR).getCurrentValue());
    }
    public enum EnumOsaSummaryDeltal{
        ID_SUMMARY_RESULT_NONE,
        ID_SUMMARY_RESULT_PASS,
        ID_SUMMARY_RESULT_FAIL,
    };
    public void setOsaSummaryDeltal(EnumOsaSummaryDeltal value) {
        model.requestChange(ID.ID_OSA_SUMMARY_DELTAL, value.toString());
    }
    public EnumOsaSummaryDeltal getOsaSummaryDeltal() {
        return EnumOsaSummaryDeltal.valueOf(model.getProperty(ID.ID_OSA_SUMMARY_DELTAL).getCurrentValue());
    }
    public enum EnumApplicationtype{
        ID_APPLICATIONTYPE_WDM,
        ID_APPLICATIONTYPE_DRIFT,
        ID_APPLICATIONTYPE_EDFA,
        ID_APPLICATIONTYPE_ONOFFOSNR,
    };
    public void setApplicationtype(EnumApplicationtype value) {
        model.requestChange(ID.ID_APPLICATIONTYPE, value.toString());
    }
    public EnumApplicationtype getApplicationtype() {
        return EnumApplicationtype.valueOf(model.getProperty(ID.ID_APPLICATIONTYPE).getCurrentValue());
    }
    public void setOsaSummaryGaintilt(double value) {
        model.requestChange(ID.ID_OSA_SUMMARY_GAINTILT, String.valueOf(value));
    }
    public double getOsaSummaryGaintilt() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_SUMMARY_GAINTILT).getCurrentValue());
    }
    public enum EnumOsaGridImportReferenceGridType{
        ID_OSA_GRID_TYPE_ITUT100G,
        ID_OSA_GRID_TYPE_ITUT50G,
        ID_OSA_GRID_TYPE_ITUT25G,
        ID_OSA_GRID_TYPE_ITUT12_5G,
        ID_OSA_GRID_TYPE_CWDM,
        ID_OSA_GRID_TYPE_USER,
    };
    public void setOsaGridImportReferenceGridType(EnumOsaGridImportReferenceGridType value) {
        model.requestChange(ID.ID_OSA_GRID_IMPORT_REFERENCE_GRID_TYPE, value.toString());
    }
    public EnumOsaGridImportReferenceGridType getOsaGridImportReferenceGridType() {
        return EnumOsaGridImportReferenceGridType.valueOf(model.getProperty(ID.ID_OSA_GRID_IMPORT_REFERENCE_GRID_TYPE).getCurrentValue());
    }
    public enum EnumGuiTestTab{
        ID_GUI_TEST_TAB_MEASUREMENT,
        ID_GUI_TEST_TAB_HEADERS,
        ID_GUI_TEST_TAB_PREFERENCES,
        ID_GUI_TEST_TAB_ADVANCED,
    };
    public void setGuiTestTab(EnumGuiTestTab value) {
        model.requestChange(ID.ID_GUI_TEST_TAB, value.toString());
    }
    public EnumGuiTestTab getGuiTestTab() {
        return EnumGuiTestTab.valueOf(model.getProperty(ID.ID_GUI_TEST_TAB).getCurrentValue());
    }
    public void setOsaDebugSimulatorDfbFilename(String value) {
        model.requestChange(ID.ID_OSA_DEBUG_SIMULATOR_DFB_FILENAME, value);
    }
    public String getOsaDebugSimulatorDfbFilename() {
        return model.getProperty(ID.ID_OSA_DEBUG_SIMULATOR_DFB_FILENAME).getCurrentValue();
    }
    public enum EnumMessageScreenlockFordebug{
        ID_MESSAGECONTENT_NOMESSAGE,
        ID_MESSAGECONTENT_STARTUP,
        ID_MESSAGECONTENT_SHUTDOWN,
        ID_MESSAGECONTENT_LOADPREVSETTING,
        ID_MESSAGECONTENT_GENERATING_RESULT,
        ID_MESSAGECONTENT_LOADING_RESULT,
        ID_MESSAGECONTENT_GENERATING_SETUP,
        ID_MESSAGECONTENT_LOADING_SETUP,
        ID_MESSAGECONTENT_ANALYZING,
        ID_MESSAGECONTENT_CALIBRATING,
        ID_MESSAGECONTENT_NOMESSAGE_DUMMY,
    };
    public void setMessageScreenlockFordebug(EnumMessageScreenlockFordebug value) {
        model.requestChange(ID.ID_MESSAGE_SCREENLOCK_FORDEBUG, value.toString());
    }
    public EnumMessageScreenlockFordebug getMessageScreenlockFordebug() {
        return EnumMessageScreenlockFordebug.valueOf(model.getProperty(ID.ID_MESSAGE_SCREENLOCK_FORDEBUG).getCurrentValue());
    }
    public void setOsaInspectionRegSfactorI(long value) {
        model.requestChange(ID.ID_OSA_INSPECTION_REG_SFACTOR_I, String.valueOf(value));
    }
    public long getOsaInspectionRegSfactorI() {
        return Long.valueOf(model.getProperty(ID.ID_OSA_INSPECTION_REG_SFACTOR_I).getCurrentValue());
    }
    public void setEdResultBer(double value) {
        model.requestChange(ID.ID_ED_RESULT_BER, String.valueOf(value));
    }
    public double getEdResultBer() {
        return Double.valueOf(model.getProperty(ID.ID_ED_RESULT_BER).getCurrentValue());
    }
    public void setOsaSpanWavelengthThz(double value) {
        model.requestChange(ID.ID_OSA_SPAN_WAVELENGTH_THZ, String.valueOf(value));
    }
    public double getOsaSpanWavelengthThz() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_SPAN_WAVELENGTH_THZ).getCurrentValue());
    }
    public enum EnumOsaTraceDriftVisibleCurrent{
        ID_OSA_TRACE_SHOW,
        ID_OSA_TRACE_HIDE,
    };
    public void setOsaTraceDriftVisibleCurrent(EnumOsaTraceDriftVisibleCurrent value) {
        model.requestChange(ID.ID_OSA_TRACE_DRIFT_VISIBLE_CURRENT, value.toString());
    }
    public EnumOsaTraceDriftVisibleCurrent getOsaTraceDriftVisibleCurrent() {
        return EnumOsaTraceDriftVisibleCurrent.valueOf(model.getProperty(ID.ID_OSA_TRACE_DRIFT_VISIBLE_CURRENT).getCurrentValue());
    }
    public enum EnumTotalSummary{
        ID_TOTAL_SUMMARY_PASS,
        ID_TOTAL_SUMMARY_FAIL,
    };
    public void setTotalSummary(EnumTotalSummary value) {
        model.requestChange(ID.ID_TOTAL_SUMMARY, value.toString());
    }
    public EnumTotalSummary getTotalSummary() {
        return EnumTotalSummary.valueOf(model.getProperty(ID.ID_TOTAL_SUMMARY).getCurrentValue());
    }
    public void setOsaStopWavelengthNm(double value) {
        model.requestChange(ID.ID_OSA_STOP_WAVELENGTH_NM, String.valueOf(value));
    }
    public double getOsaStopWavelengthNm() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_STOP_WAVELENGTH_NM).getCurrentValue());
    }
    public enum EnumOsaActiveTraceDriftSelectView{
        ID_OSA_ACTIVE_TRACE_DRIFT_SELECT_INITIAL,
        ID_OSA_ACTIVE_TRACE_DRIFT_SELECT_CURRENT,
    };
    public void setOsaActiveTraceDriftSelectView(EnumOsaActiveTraceDriftSelectView value) {
        model.requestChange(ID.ID_OSA_ACTIVE_TRACE_DRIFT_SELECT_VIEW, value.toString());
    }
    public EnumOsaActiveTraceDriftSelectView getOsaActiveTraceDriftSelectView() {
        return EnumOsaActiveTraceDriftSelectView.valueOf(model.getProperty(ID.ID_OSA_ACTIVE_TRACE_DRIFT_SELECT_VIEW).getCurrentValue());
    }
    public void setAutosavestartnumber(long value) {
        model.requestChange(ID.ID_AUTOSAVESTARTNUMBER, String.valueOf(value));
    }
    public long getAutosavestartnumber() {
        return Long.valueOf(model.getProperty(ID.ID_AUTOSAVESTARTNUMBER).getCurrentValue());
    }
    public void setElapsedTime(long value) {
        model.requestChange(ID.ID_ELAPSED_TIME, String.valueOf(value));
    }
    public long getElapsedTime() {
        return Long.valueOf(model.getProperty(ID.ID_ELAPSED_TIME).getCurrentValue());
    }
    public void setOsaInspectionRegPosError(long value) {
        model.requestChange(ID.ID_OSA_INSPECTION_REG_POS_ERROR, String.valueOf(value));
    }
    public long getOsaInspectionRegPosError() {
        return Long.valueOf(model.getProperty(ID.ID_OSA_INSPECTION_REG_POS_ERROR).getCurrentValue());
    }
    public enum EnumModule{
        ID_MODULE_MU100010A,
        ID_MODULE_MU100020A,
        ID_MODULE_MU100040A,
    };
    public void setModule(EnumModule value) {
        model.requestChange(ID.ID_MODULE, value.toString());
    }
    public EnumModule getModule() {
        return EnumModule.valueOf(model.getProperty(ID.ID_MODULE).getCurrentValue());
    }
    public void setOsaPinLossOffset(double value) {
        model.requestChange(ID.ID_OSA_PIN_LOSS_OFFSET, String.valueOf(value));
    }
    public double getOsaPinLossOffset() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_PIN_LOSS_OFFSET).getCurrentValue());
    }
    public enum EnumOsaViewChannelResult{
        ID_OSA_VIEW_CHANNEL_RESULT_ALL,
        ID_OSA_VIEW_CHANNEL_RESULT_FOUND,
        ID_OSA_VIEW_CHANNEL_RESULT_ALARM,
    };
    public void setOsaViewChannelResult(EnumOsaViewChannelResult value) {
        model.requestChange(ID.ID_OSA_VIEW_CHANNEL_RESULT, value.toString());
    }
    public EnumOsaViewChannelResult getOsaViewChannelResult() {
        return EnumOsaViewChannelResult.valueOf(model.getProperty(ID.ID_OSA_VIEW_CHANNEL_RESULT).getCurrentValue());
    }
    public void setSelectedeventCompletedNumber(long value) {
        model.requestChange(ID.ID_SELECTEDEVENT_COMPLETED_NUMBER, String.valueOf(value));
    }
    public long getSelectedeventCompletedNumber() {
        return Long.valueOf(model.getProperty(ID.ID_SELECTEDEVENT_COMPLETED_NUMBER).getCurrentValue());
    }
    public void setSelectedTraceIndex(long value) {
        model.requestChange(ID.ID_SELECTED_TRACE_INDEX, String.valueOf(value));
    }
    public long getSelectedTraceIndex() {
        return Long.valueOf(model.getProperty(ID.ID_SELECTED_TRACE_INDEX).getCurrentValue());
    }
    public void setOsaGridWarningParamMessage(String value) {
        model.requestChange(ID.ID_OSA_GRID_WARNING_PARAM_MESSAGE, value);
    }
    public String getOsaGridWarningParamMessage() {
        return model.getProperty(ID.ID_OSA_GRID_WARNING_PARAM_MESSAGE).getCurrentValue();
    }
    public void setOsaDriftgraphViewPowerMax(double value) {
        model.requestChange(ID.ID_OSA_DRIFTGRAPH_VIEW_POWER_MAX, String.valueOf(value));
    }
    public double getOsaDriftgraphViewPowerMax() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_DRIFTGRAPH_VIEW_POWER_MAX).getCurrentValue());
    }
    public void setOsaCursorLevelRangeMax(double value) {
        model.requestChange(ID.ID_OSA_CURSOR_LEVEL_RANGE_MAX, String.valueOf(value));
    }
    public double getOsaCursorLevelRangeMax() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_CURSOR_LEVEL_RANGE_MAX).getCurrentValue());
    }
    public void setOsaInspectionMotorSetWavelength(double value) {
        model.requestChange(ID.ID_OSA_INSPECTION_MOTOR_SET_WAVELENGTH, String.valueOf(value));
    }
    public double getOsaInspectionMotorSetWavelength() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_INSPECTION_MOTOR_SET_WAVELENGTH).getCurrentValue());
    }
    public void setOsaEventTable(String value) {
        model.requestChange(ID.ID_OSA_EVENT_TABLE, value);
    }
    public String getOsaEventTable() {
        return model.getProperty(ID.ID_OSA_EVENT_TABLE).getCurrentValue();
    }
    public void setOsaAverageCountMaxInband(long value) {
        model.requestChange(ID.ID_OSA_AVERAGE_COUNT_MAX_INBAND, String.valueOf(value));
    }
    public long getOsaAverageCountMaxInband() {
        return Long.valueOf(model.getProperty(ID.ID_OSA_AVERAGE_COUNT_MAX_INBAND).getCurrentValue());
    }
    public void setComment(String value) {
        model.requestChange(ID.ID_COMMENT, value);
    }
    public String getComment() {
        return model.getProperty(ID.ID_COMMENT).getCurrentValue();
    }
    public void setOsaGridChannelMaxCount(long value) {
        model.requestChange(ID.ID_OSA_GRID_CHANNEL_MAX_COUNT, String.valueOf(value));
    }
    public long getOsaGridChannelMaxCount() {
        return Long.valueOf(model.getProperty(ID.ID_OSA_GRID_CHANNEL_MAX_COUNT).getCurrentValue());
    }
    public void setSamplingTrigger(double value) {
        model.requestChange(ID.ID_SAMPLING_TRIGGER, String.valueOf(value));
    }
    public double getSamplingTrigger() {
        return Double.valueOf(model.getProperty(ID.ID_SAMPLING_TRIGGER).getCurrentValue());
    }
    public enum EnumActiveCursor{
        ID_ACTIVE_CURSOR_A,
        ID_ACTIVE_CURSOR_B,
        ID_ACTIVE_CURSOR_C,
        ID_ACTIVE_CURSOR_D,
        ID_ACTIVE_CURSOR_THRESH_LV,
        ID_ACTIVE_CURSOR_NONE,
    };
    public void setActiveCursor(EnumActiveCursor value) {
        model.requestChange(ID.ID_ACTIVE_CURSOR, value.toString());
    }
    public EnumActiveCursor getActiveCursor() {
        return EnumActiveCursor.valueOf(model.getProperty(ID.ID_ACTIVE_CURSOR).getCurrentValue());
    }
    public enum EnumPpgPattern{
        ID_PPG_PATTERN_PRBS7,
        ID_PPG_PATTERN_PRBS8,
        ID_PPG_PATTERN_PRBS9,
        ID_PPG_PATTERN_PROGRAM,
    };
    public void setPpgPattern(EnumPpgPattern value) {
        model.requestChange(ID.ID_PPG_PATTERN, value.toString());
    }
    public EnumPpgPattern getPpgPattern() {
        return EnumPpgPattern.valueOf(model.getProperty(ID.ID_PPG_PATTERN).getCurrentValue());
    }
    public void setActiveWaveformControllerSerial(String value) {
        model.requestChange(ID.ID_ACTIVE_WAVEFORM_CONTROLLER_SERIAL, value);
    }
    public String getActiveWaveformControllerSerial() {
        return model.getProperty(ID.ID_ACTIVE_WAVEFORM_CONTROLLER_SERIAL).getCurrentValue();
    }
    public void setActiveWaveformMeasureDatetime(String value) {
        model.requestChange(ID.ID_ACTIVE_WAVEFORM_MEASURE_DATETIME, value);
    }
    public String getActiveWaveformMeasureDatetime() {
        return model.getProperty(ID.ID_ACTIVE_WAVEFORM_MEASURE_DATETIME).getCurrentValue();
    }
    public enum EnumMeasMode{
        ID_MEAS_MODE_AVERAGE,
        ID_MEAS_MODE_TRIAL,
        ID_MEAS_MODE_EDFA_IN,
        ID_MEAS_MODE_EDFA_OUT,
    };
    public void setMeasMode(EnumMeasMode value) {
        model.requestChange(ID.ID_MEAS_MODE, value.toString());
    }
    public EnumMeasMode getMeasMode() {
        return EnumMeasMode.valueOf(model.getProperty(ID.ID_MEAS_MODE).getCurrentValue());
    }
    public enum EnumCalibrationModeDrift{
        ID_CALIBRATION_MODE_SPEED,
        ID_CALIBRATION_MODE_ACCURACY,
    };
    public void setCalibrationModeDrift(EnumCalibrationModeDrift value) {
        model.requestChange(ID.ID_CALIBRATION_MODE_DRIFT, value.toString());
    }
    public EnumCalibrationModeDrift getCalibrationModeDrift() {
        return EnumCalibrationModeDrift.valueOf(model.getProperty(ID.ID_CALIBRATION_MODE_DRIFT).getCurrentValue());
    }
    public enum EnumOsaGridShowList{
        ID_OSA_GRID_SHOW_LIST_ALL,
        ID_OSA_GRID_SHOW_LIST_DEFAULT,
        ID_OSA_GRID_SHOW_LIST_CHANGED,
    };
    public void setOsaGridShowList(EnumOsaGridShowList value) {
        model.requestChange(ID.ID_OSA_GRID_SHOW_LIST, value.toString());
    }
    public EnumOsaGridShowList getOsaGridShowList() {
        return EnumOsaGridShowList.valueOf(model.getProperty(ID.ID_OSA_GRID_SHOW_LIST).getCurrentValue());
    }
    public enum EnumTraceviewMode{
        ID_TRACEVIEW_MODE_GRAPH,
        ID_TRACEVIEW_MODE_TABLE,
        ID_TRACEVIEW_MODE_GRAPH_TABLE,
    };
    public void setTraceviewMode(EnumTraceviewMode value) {
        model.requestChange(ID.ID_TRACEVIEW_MODE, value.toString());
    }
    public EnumTraceviewMode getTraceviewMode() {
        return EnumTraceviewMode.valueOf(model.getProperty(ID.ID_TRACEVIEW_MODE).getCurrentValue());
    }
    public enum EnumOsaActiveTraceEdfaSelect{
        ID_OSA_ACTIVE_TRACE_EDFA_SELECT_IN,
        ID_OSA_ACTIVE_TRACE_EDFA_SELECT_OUT,
    };
    public void setOsaActiveTraceEdfaSelect(EnumOsaActiveTraceEdfaSelect value) {
        model.requestChange(ID.ID_OSA_ACTIVE_TRACE_EDFA_SELECT, value.toString());
    }
    public EnumOsaActiveTraceEdfaSelect getOsaActiveTraceEdfaSelect() {
        return EnumOsaActiveTraceEdfaSelect.valueOf(model.getProperty(ID.ID_OSA_ACTIVE_TRACE_EDFA_SELECT).getCurrentValue());
    }
    public void setOsaInspectionLigthsourcePower(double value) {
        model.requestChange(ID.ID_OSA_INSPECTION_LIGTHSOURCE_POWER, String.valueOf(value));
    }
    public double getOsaInspectionLigthsourcePower() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_INSPECTION_LIGTHSOURCE_POWER).getCurrentValue());
    }
    public enum EnumOsaActiveWaveformType{
        ID_OSA_ACTIVE_WAVEFORM_TYPE_OUTBAND,
        ID_OSA_ACTIVE_WAVEFORM_TYPE_INBAND,
        ID_OSA_ACTIVE_WAVEFORM_TYPE_NONE,
    };
    public void setOsaActiveWaveformType(EnumOsaActiveWaveformType value) {
        model.requestChange(ID.ID_OSA_ACTIVE_WAVEFORM_TYPE, value.toString());
    }
    public EnumOsaActiveWaveformType getOsaActiveWaveformType() {
        return EnumOsaActiveWaveformType.valueOf(model.getProperty(ID.ID_OSA_ACTIVE_WAVEFORM_TYPE).getCurrentValue());
    }
    public enum EnumReceiver{
        ID_RECEIVER_SFP,
        ID_RECEIVER_ELECTRICAL,
    };
    public void setReceiver(EnumReceiver value) {
        model.requestChange(ID.ID_RECEIVER, value.toString());
    }
    public EnumReceiver getReceiver() {
        return EnumReceiver.valueOf(model.getProperty(ID.ID_RECEIVER).getCurrentValue());
    }
    public enum EnumMessageQueryOkcancel{
        ID_MESSAGECONTENT_NOMESSAGE,
        ID_MESSAGECONTENT_NOMESSAGE_DUMMY,
    };
    public void setMessageQueryOkcancel(EnumMessageQueryOkcancel value) {
        model.requestChange(ID.ID_MESSAGE_QUERY_OKCANCEL, value.toString());
    }
    public EnumMessageQueryOkcancel getMessageQueryOkcancel() {
        return EnumMessageQueryOkcancel.valueOf(model.getProperty(ID.ID_MESSAGE_QUERY_OKCANCEL).getCurrentValue());
    }
    public void setOsaSummaryAveragepower(double value) {
        model.requestChange(ID.ID_OSA_SUMMARY_AVERAGEPOWER, String.valueOf(value));
    }
    public double getOsaSummaryAveragepower() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_SUMMARY_AVERAGEPOWER).getCurrentValue());
    }
    public enum EnumOsaActiveTraceDriftSelect{
        ID_OSA_ACTIVE_TRACE_DRIFT_SELECT_INITIAL,
        ID_OSA_ACTIVE_TRACE_DRIFT_SELECT_CURRENT,
    };
    public void setOsaActiveTraceDriftSelect(EnumOsaActiveTraceDriftSelect value) {
        model.requestChange(ID.ID_OSA_ACTIVE_TRACE_DRIFT_SELECT, value.toString());
    }
    public EnumOsaActiveTraceDriftSelect getOsaActiveTraceDriftSelect() {
        return EnumOsaActiveTraceDriftSelect.valueOf(model.getProperty(ID.ID_OSA_ACTIVE_TRACE_DRIFT_SELECT).getCurrentValue());
    }
    public void setOsaLevelOffset(double value) {
        model.requestChange(ID.ID_OSA_LEVEL_OFFSET, String.valueOf(value));
    }
    public double getOsaLevelOffset() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_LEVEL_OFFSET).getCurrentValue());
    }
    public void setOsaDebugSimulatorAnalysisparam(String value) {
        model.requestChange(ID.ID_OSA_DEBUG_SIMULATOR_ANALYSISPARAM, value);
    }
    public String getOsaDebugSimulatorAnalysisparam() {
        return model.getProperty(ID.ID_OSA_DEBUG_SIMULATOR_ANALYSISPARAM).getCurrentValue();
    }
    public void setOsaDebugSimulatorSwaveRatio(double value) {
        model.requestChange(ID.ID_OSA_DEBUG_SIMULATOR_SWAVE_RATIO, String.valueOf(value));
    }
    public double getOsaDebugSimulatorSwaveRatio() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_DEBUG_SIMULATOR_SWAVE_RATIO).getCurrentValue());
    }
    public void setOsaDebugSimulatorAdValue(long value) {
        model.requestChange(ID.ID_OSA_DEBUG_SIMULATOR_AD_VALUE, String.valueOf(value));
    }
    public long getOsaDebugSimulatorAdValue() {
        return Long.valueOf(model.getProperty(ID.ID_OSA_DEBUG_SIMULATOR_AD_VALUE).getCurrentValue());
    }
    public enum EnumTimingSource{
        ID_TIMING_SOURCE_INTERNAL,
        ID_TIMING_SOURCE_EXTERNAL,
    };
    public void setTimingSource(EnumTimingSource value) {
        model.requestChange(ID.ID_TIMING_SOURCE, value.toString());
    }
    public EnumTimingSource getTimingSource() {
        return EnumTimingSource.valueOf(model.getProperty(ID.ID_TIMING_SOURCE).getCurrentValue());
    }
    public void setOsaDriftgraphViewOsnrMin(double value) {
        model.requestChange(ID.ID_OSA_DRIFTGRAPH_VIEW_OSNR_MIN, String.valueOf(value));
    }
    public double getOsaDriftgraphViewOsnrMin() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_DRIFTGRAPH_VIEW_OSNR_MIN).getCurrentValue());
    }
    public enum EnumOsaDriftgraphDisplaytype2{
        ID_OSA_DRIFTGRAPH_DISPLAYTYPE_POWER,
        ID_OSA_DRIFTGRAPH_DISPLAYTYPE_OSNR,
        ID_OSA_DRIFTGRAPH_DISPLAYTYPE_WAVELENGTH,
    };
    public void setOsaDriftgraphDisplaytype2(EnumOsaDriftgraphDisplaytype2 value) {
        model.requestChange(ID.ID_OSA_DRIFTGRAPH_DISPLAYTYPE2, value.toString());
    }
    public EnumOsaDriftgraphDisplaytype2 getOsaDriftgraphDisplaytype2() {
        return EnumOsaDriftgraphDisplaytype2.valueOf(model.getProperty(ID.ID_OSA_DRIFTGRAPH_DISPLAYTYPE2).getCurrentValue());
    }
    public void setOsaDebugCalibrateTemp(double value) {
        model.requestChange(ID.ID_OSA_DEBUG_CALIBRATE_TEMP, String.valueOf(value));
    }
    public double getOsaDebugCalibrateTemp() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_DEBUG_CALIBRATE_TEMP).getCurrentValue());
    }
    public void setOsaStartWavelengthThz(double value) {
        model.requestChange(ID.ID_OSA_START_WAVELENGTH_THZ, String.valueOf(value));
    }
    public double getOsaStartWavelengthThz() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_START_WAVELENGTH_THZ).getCurrentValue());
    }
    public void setOsaDriftgraphViewMarkerMinx(double value) {
        model.requestChange(ID.ID_OSA_DRIFTGRAPH_VIEW_MARKER_MINX, String.valueOf(value));
    }
    public double getOsaDriftgraphViewMarkerMinx() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_DRIFTGRAPH_VIEW_MARKER_MINX).getCurrentValue());
    }
    public void setActiveTraceFilename(String value) {
        model.requestChange(ID.ID_ACTIVE_TRACE_FILENAME, value);
    }
    public String getActiveTraceFilename() {
        return model.getProperty(ID.ID_ACTIVE_TRACE_FILENAME).getCurrentValue();
    }
    public void setOsaInspectionRegSfactorP(long value) {
        model.requestChange(ID.ID_OSA_INSPECTION_REG_SFACTOR_P, String.valueOf(value));
    }
    public long getOsaInspectionRegSfactorP() {
        return Long.valueOf(model.getProperty(ID.ID_OSA_INSPECTION_REG_SFACTOR_P).getCurrentValue());
    }
    public void setOsaActiveChannelGain(double value) {
        model.requestChange(ID.ID_OSA_ACTIVE_CHANNEL_GAIN, String.valueOf(value));
    }
    public double getOsaActiveChannelGain() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_ACTIVE_CHANNEL_GAIN).getCurrentValue());
    }
    public void setOsaActiveChannelNf(double value) {
        model.requestChange(ID.ID_OSA_ACTIVE_CHANNEL_NF, String.valueOf(value));
    }
    public double getOsaActiveChannelNf() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_ACTIVE_CHANNEL_NF).getCurrentValue());
    }
    public void setOsaDebugAutomatorfails(String value) {
        model.requestChange(ID.ID_OSA_DEBUG_AUTOMATORFAILS, value);
    }
    public String getOsaDebugAutomatorfails() {
        return model.getProperty(ID.ID_OSA_DEBUG_AUTOMATORFAILS).getCurrentValue();
    }
    public void setOsaInspectionRegD(long value) {
        model.requestChange(ID.ID_OSA_INSPECTION_REG_D, String.valueOf(value));
    }
    public long getOsaInspectionRegD() {
        return Long.valueOf(model.getProperty(ID.ID_OSA_INSPECTION_REG_D).getCurrentValue());
    }
    public enum EnumApplication{
        ID_APPLICATION_BERT,
        ID_APPLICATION_RFC2544,
        ID_APPLICATION_PING,
    };
    public void setApplication(EnumApplication value) {
        model.requestChange(ID.ID_APPLICATION, value.toString());
    }
    public EnumApplication getApplication() {
        return EnumApplication.valueOf(model.getProperty(ID.ID_APPLICATION).getCurrentValue());
    }
    public void setPpgAmplitude(double value) {
        model.requestChange(ID.ID_PPG_AMPLITUDE, String.valueOf(value));
    }
    public double getPpgAmplitude() {
        return Double.valueOf(model.getProperty(ID.ID_PPG_AMPLITUDE).getCurrentValue());
    }
    public enum EnumOsaActiveTraceOnoffSelect{
        ID_OSA_ACTIVE_TRACE_ONOFF_SELECT_A,
        ID_OSA_ACTIVE_TRACE_ONOFF_SELECT_B,
    };
    public void setOsaActiveTraceOnoffSelect(EnumOsaActiveTraceOnoffSelect value) {
        model.requestChange(ID.ID_OSA_ACTIVE_TRACE_ONOFF_SELECT, value.toString());
    }
    public EnumOsaActiveTraceOnoffSelect getOsaActiveTraceOnoffSelect() {
        return EnumOsaActiveTraceOnoffSelect.valueOf(model.getProperty(ID.ID_OSA_ACTIVE_TRACE_ONOFF_SELECT).getCurrentValue());
    }
    public void setGraphViewExtentdb(double value) {
        model.requestChange(ID.ID_GRAPH_VIEW_EXTENTDB, String.valueOf(value));
    }
    public double getGraphViewExtentdb() {
        return Double.valueOf(model.getProperty(ID.ID_GRAPH_VIEW_EXTENTDB).getCurrentValue());
    }
    public void setActiveWaveformControllerVerificationDate(String value) {
        model.requestChange(ID.ID_ACTIVE_WAVEFORM_CONTROLLER_VERIFICATION_DATE, value);
    }
    public String getActiveWaveformControllerVerificationDate() {
        return model.getProperty(ID.ID_ACTIVE_WAVEFORM_CONTROLLER_VERIFICATION_DATE).getCurrentValue();
    }
    public void setOsaEventTableEdfaVisualizer(String value) {
        model.requestChange(ID.ID_OSA_EVENT_TABLE_EDFA_VISUALIZER, value);
    }
    public String getOsaEventTableEdfaVisualizer() {
        return model.getProperty(ID.ID_OSA_EVENT_TABLE_EDFA_VISUALIZER).getCurrentValue();
    }
    public void setOsaDebugSimulatorFilename(String value) {
        model.requestChange(ID.ID_OSA_DEBUG_SIMULATOR_FILENAME, value);
    }
    public String getOsaDebugSimulatorFilename() {
        return model.getProperty(ID.ID_OSA_DEBUG_SIMULATOR_FILENAME).getCurrentValue();
    }
    public enum EnumActiveTab{
        ID_ACTIVE_TAB_SETUP,
        ID_ACTIVE_TAB_TEST,
        ID_ACTIVE_TAB_RESULT,
    };
    public void setActiveTab(EnumActiveTab value) {
        model.requestChange(ID.ID_ACTIVE_TAB, value.toString());
    }
    public EnumActiveTab getActiveTab() {
        return EnumActiveTab.valueOf(model.getProperty(ID.ID_ACTIVE_TAB).getCurrentValue());
    }
    public enum EnumOsaDriftgraphDisplaytype3{
        ID_OSA_DRIFTGRAPH_DISPLAYTYPE_POWER,
        ID_OSA_DRIFTGRAPH_DISPLAYTYPE_OSNR,
        ID_OSA_DRIFTGRAPH_DISPLAYTYPE_WAVELENGTH,
    };
    public void setOsaDriftgraphDisplaytype3(EnumOsaDriftgraphDisplaytype3 value) {
        model.requestChange(ID.ID_OSA_DRIFTGRAPH_DISPLAYTYPE3, value.toString());
    }
    public EnumOsaDriftgraphDisplaytype3 getOsaDriftgraphDisplaytype3() {
        return EnumOsaDriftgraphDisplaytype3.valueOf(model.getProperty(ID.ID_OSA_DRIFTGRAPH_DISPLAYTYPE3).getCurrentValue());
    }
    public enum EnumOsaNfSelect{
        ID_OSA_NF_SELECT_SASE,
        ID_OSA_NF_SELECT_TOTAL,
    };
    public void setOsaNfSelect(EnumOsaNfSelect value) {
        model.requestChange(ID.ID_OSA_NF_SELECT, value.toString());
    }
    public EnumOsaNfSelect getOsaNfSelect() {
        return EnumOsaNfSelect.valueOf(model.getProperty(ID.ID_OSA_NF_SELECT).getCurrentValue());
    }
    public enum EnumOtdrPulsewidth{
        ID_OTDR_PULSEWIDTH_10NS,
        ID_OTDR_PULSEWIDTH_50NS,
        ID_OTDR_PULSEWIDTH_100NS,
        ID_OTDR_PULSEWIDTH_1000NS,
    };
    public void setOtdrPulsewidth(EnumOtdrPulsewidth value) {
        model.requestChange(ID.ID_OTDR_PULSEWIDTH, value.toString());
    }
    public EnumOtdrPulsewidth getOtdrPulsewidth() {
        return EnumOtdrPulsewidth.valueOf(model.getProperty(ID.ID_OTDR_PULSEWIDTH).getCurrentValue());
    }
    public void setGraphViewMaxydb(double value) {
        model.requestChange(ID.ID_GRAPH_VIEW_MAXYDB, String.valueOf(value));
    }
    public double getGraphViewMaxydb() {
        return Double.valueOf(model.getProperty(ID.ID_GRAPH_VIEW_MAXYDB).getCurrentValue());
    }
    public void setActiveCursorStepDistance(double value) {
        model.requestChange(ID.ID_ACTIVE_CURSOR_STEP_DISTANCE, String.valueOf(value));
    }
    public double getActiveCursorStepDistance() {
        return Double.valueOf(model.getProperty(ID.ID_ACTIVE_CURSOR_STEP_DISTANCE).getCurrentValue());
    }
    public enum EnumCursors{
        ID_CURSORS_LOCK,
        ID_CURSORS_UNLOCK,
    };
    public void setCursors(EnumCursors value) {
        model.requestChange(ID.ID_CURSORS, value.toString());
    }
    public EnumCursors getCursors() {
        return EnumCursors.valueOf(model.getProperty(ID.ID_CURSORS).getCurrentValue());
    }
    public void setOsaDriftgraphViewMarkerMaxx(double value) {
        model.requestChange(ID.ID_OSA_DRIFTGRAPH_VIEW_MARKER_MAXX, String.valueOf(value));
    }
    public double getOsaDriftgraphViewMarkerMaxx() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_DRIFTGRAPH_VIEW_MARKER_MAXX).getCurrentValue());
    }
    public void setOsaOnoffTableTraceList(String value) {
        model.requestChange(ID.ID_OSA_ONOFF_TABLE_TRACE_LIST, value);
    }
    public String getOsaOnoffTableTraceList() {
        return model.getProperty(ID.ID_OSA_ONOFF_TABLE_TRACE_LIST).getCurrentValue();
    }
    public void setOsaDebugAutomatorstate(String value) {
        model.requestChange(ID.ID_OSA_DEBUG_AUTOMATORSTATE, value);
    }
    public String getOsaDebugAutomatorstate() {
        return model.getProperty(ID.ID_OSA_DEBUG_AUTOMATORSTATE).getCurrentValue();
    }
    public enum EnumServerstateLabelState{
        ID_SERVERSTATE_LABEL_STATE_HIDE,
        ID_SERVERSTATE_LABEL_STATE_SHOW,
        ID_SERVERSTATE_LABEL_STATE_FLASH,
    };
    public void setServerstateLabelState(EnumServerstateLabelState value) {
        model.requestChange(ID.ID_SERVERSTATE_LABEL_STATE, value.toString());
    }
    public EnumServerstateLabelState getServerstateLabelState() {
        return EnumServerstateLabelState.valueOf(model.getProperty(ID.ID_SERVERSTATE_LABEL_STATE).getCurrentValue());
    }
    public enum EnumSummaryResult{
        ID_SUMMARY_RESULT_NONE,
        ID_SUMMARY_RESULT_PASS,
        ID_SUMMARY_RESULT_FAIL,
    };
    public void setSummaryResult(EnumSummaryResult value) {
        model.requestChange(ID.ID_SUMMARY_RESULT, value.toString());
    }
    public EnumSummaryResult getSummaryResult() {
        return EnumSummaryResult.valueOf(model.getProperty(ID.ID_SUMMARY_RESULT).getCurrentValue());
    }
    public enum EnumOsaGridShowItem{
        ID_OSA_GRID_SHOW_ITEM_ALL,
        ID_OSA_GRID_SHOW_ITEM_OSNR,
        ID_OSA_GRID_SHOW_ITEM_PF,
    };
    public void setOsaGridShowItem(EnumOsaGridShowItem value) {
        model.requestChange(ID.ID_OSA_GRID_SHOW_ITEM, value.toString());
    }
    public EnumOsaGridShowItem getOsaGridShowItem() {
        return EnumOsaGridShowItem.valueOf(model.getProperty(ID.ID_OSA_GRID_SHOW_ITEM).getCurrentValue());
    }
    public void setGraphViewStartdb(double value) {
        model.requestChange(ID.ID_GRAPH_VIEW_STARTDB, String.valueOf(value));
    }
    public double getGraphViewStartdb() {
        return Double.valueOf(model.getProperty(ID.ID_GRAPH_VIEW_STARTDB).getCurrentValue());
    }
    public enum EnumOsciloTest{
        ID_OSCILO_TEST_START,
        ID_OSCILO_TEST_STOP,
    };
    public void setOsciloTest(EnumOsciloTest value) {
        model.requestChange(ID.ID_OSCILO_TEST, value.toString());
    }
    public EnumOsciloTest getOsciloTest() {
        return EnumOsciloTest.valueOf(model.getProperty(ID.ID_OSCILO_TEST).getCurrentValue());
    }
    public void setActiveCursorDistance(double value) {
        model.requestChange(ID.ID_ACTIVE_CURSOR_DISTANCE, String.valueOf(value));
    }
    public double getActiveCursorDistance() {
        return Double.valueOf(model.getProperty(ID.ID_ACTIVE_CURSOR_DISTANCE).getCurrentValue());
    }
    public void setOsaSummaryPoutChannelcount(double value) {
        model.requestChange(ID.ID_OSA_SUMMARY_POUT_CHANNELCOUNT, String.valueOf(value));
    }
    public double getOsaSummaryPoutChannelcount() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_SUMMARY_POUT_CHANNELCOUNT).getCurrentValue());
    }
    public enum EnumOsaOsnrFitCurve{
        ID_OSA_OSNR_FIT_CURVE_LINEAR,
        ID_OSA_OSNR_FIT_CURVE_GAUSS,
        ID_OSA_OSNR_FIT_CURVE_3RD_POLY,
        ID_OSA_OSNR_FIT_CURVE_4TH_POLY,
        ID_OSA_OSNR_FIT_CURVE_5TH_POLY,
    };
    public void setOsaOsnrFitCurve(EnumOsaOsnrFitCurve value) {
        model.requestChange(ID.ID_OSA_OSNR_FIT_CURVE, value.toString());
    }
    public EnumOsaOsnrFitCurve getOsaOsnrFitCurve() {
        return EnumOsaOsnrFitCurve.valueOf(model.getProperty(ID.ID_OSA_OSNR_FIT_CURVE).getCurrentValue());
    }
    public void setOsaSummaryGainvari(double value) {
        model.requestChange(ID.ID_OSA_SUMMARY_GAINVARI, String.valueOf(value));
    }
    public double getOsaSummaryGainvari() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_SUMMARY_GAINVARI).getCurrentValue());
    }
    public void setFiberid(String value) {
        model.requestChange(ID.ID_FIBERID, value);
    }
    public String getFiberid() {
        return model.getProperty(ID.ID_FIBERID).getCurrentValue();
    }
    public enum EnumTest{
        ID_TEST_DO_START,
        ID_TEST_DO_STOP,
    };
    public void setTest(EnumTest value) {
        model.requestChange(ID.ID_TEST, value.toString());
    }
    public EnumTest getTest() {
        return EnumTest.valueOf(model.getProperty(ID.ID_TEST).getCurrentValue());
    }
    public void setResultTf(double value) {
        model.requestChange(ID.ID_RESULT_TF, String.valueOf(value));
    }
    public double getResultTf() {
        return Double.valueOf(model.getProperty(ID.ID_RESULT_TF).getCurrentValue());
    }
    public void setOsaEventTableChannelInvestigator(String value) {
        model.requestChange(ID.ID_OSA_EVENT_TABLE_CHANNEL_INVESTIGATOR, value);
    }
    public String getOsaEventTableChannelInvestigator() {
        return model.getProperty(ID.ID_OSA_EVENT_TABLE_CHANNEL_INVESTIGATOR).getCurrentValue();
    }
    public enum EnumOsaStartStop{
        ID_OSA_START_STOP_START,
        ID_OSA_START_STOP_STOP,
    };
    public void setOsaStartStop(EnumOsaStartStop value) {
        model.requestChange(ID.ID_OSA_START_STOP, value.toString());
    }
    public EnumOsaStartStop getOsaStartStop() {
        return EnumOsaStartStop.valueOf(model.getProperty(ID.ID_OSA_START_STOP).getCurrentValue());
    }
    public void setOsaGlobalNoiseBw(double value) {
        model.requestChange(ID.ID_OSA_GLOBAL_NOISE_BW, String.valueOf(value));
    }
    public double getOsaGlobalNoiseBw() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_GLOBAL_NOISE_BW).getCurrentValue());
    }
    public void setOsaEventTableEdfa(String value) {
        model.requestChange(ID.ID_OSA_EVENT_TABLE_EDFA, value);
    }
    public String getOsaEventTableEdfa() {
        return model.getProperty(ID.ID_OSA_EVENT_TABLE_EDFA).getCurrentValue();
    }
    public enum EnumStartStop{
        ID_START_STOP_START,
        ID_START_STOP_STOP,
    };
    public void setStartStop(EnumStartStop value) {
        model.requestChange(ID.ID_START_STOP, value.toString());
    }
    public EnumStartStop getStartStop() {
        return EnumStartStop.valueOf(model.getProperty(ID.ID_START_STOP).getCurrentValue());
    }
    public void setOscDuration(long value) {
        model.requestChange(ID.ID_OSC_DURATION, String.valueOf(value));
    }
    public long getOscDuration() {
        return Long.valueOf(model.getProperty(ID.ID_OSC_DURATION).getCurrentValue());
    }
    public void setOsaGraphViewrangedbMax(double value) {
        model.requestChange(ID.ID_OSA_GRAPH_VIEWRANGEDB_MAX, String.valueOf(value));
    }
    public double getOsaGraphViewrangedbMax() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_GRAPH_VIEWRANGEDB_MAX).getCurrentValue());
    }
    public void setOsaDebugSimulatorStartpos(long value) {
        model.requestChange(ID.ID_OSA_DEBUG_SIMULATOR_STARTPOS, String.valueOf(value));
    }
    public long getOsaDebugSimulatorStartpos() {
        return Long.valueOf(model.getProperty(ID.ID_OSA_DEBUG_SIMULATOR_STARTPOS).getCurrentValue());
    }
    public void setOsaCenterWavelengthThz(double value) {
        model.requestChange(ID.ID_OSA_CENTER_WAVELENGTH_THZ, String.valueOf(value));
    }
    public double getOsaCenterWavelengthThz() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_CENTER_WAVELENGTH_THZ).getCurrentValue());
    }
    public void setTpErroredframes(double value) {
        model.requestChange(ID.ID_TP_ERROREDFRAMES, String.valueOf(value));
    }
    public double getTpErroredframes() {
        return Double.valueOf(model.getProperty(ID.ID_TP_ERROREDFRAMES).getCurrentValue());
    }
    public void setOsaAverageCountMaxSingle(long value) {
        model.requestChange(ID.ID_OSA_AVERAGE_COUNT_MAX_SINGLE, String.valueOf(value));
    }
    public long getOsaAverageCountMaxSingle() {
        return Long.valueOf(model.getProperty(ID.ID_OSA_AVERAGE_COUNT_MAX_SINGLE).getCurrentValue());
    }
    public enum EnumAllTest{
        ID_ALL_TEST_START,
        ID_ALL_TEST_STOP,
    };
    public void setAllTest(EnumAllTest value) {
        model.requestChange(ID.ID_ALL_TEST, value.toString());
    }
    public EnumAllTest getAllTest() {
        return EnumAllTest.valueOf(model.getProperty(ID.ID_ALL_TEST).getCurrentValue());
    }
    public enum EnumResultFileload{
        ID_RESULT_FILELOAD_NOTFINISHED,
        ID_RESULT_FILELOAD_SUCCESS,
        ID_RESULT_FILELOAD_FAILED,
    };
    public void setResultFileload(EnumResultFileload value) {
        model.requestChange(ID.ID_RESULT_FILELOAD, value.toString());
    }
    public EnumResultFileload getResultFileload() {
        return EnumResultFileload.valueOf(model.getProperty(ID.ID_RESULT_FILELOAD).getCurrentValue());
    }
    public void setOsaSummaryPoutTotalpower(double value) {
        model.requestChange(ID.ID_OSA_SUMMARY_POUT_TOTALPOWER, String.valueOf(value));
    }
    public double getOsaSummaryPoutTotalpower() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_SUMMARY_POUT_TOTALPOWER).getCurrentValue());
    }
    public enum EnumOsaInspectionOptswitch{
        ID_OSA_INSPECTION_OPTSWITCH_NORMAL,
        ID_OSA_INSPECTION_OPTSWITCH_CROSS,
    };
    public void setOsaInspectionOptswitch(EnumOsaInspectionOptswitch value) {
        model.requestChange(ID.ID_OSA_INSPECTION_OPTSWITCH, value.toString());
    }
    public EnumOsaInspectionOptswitch getOsaInspectionOptswitch() {
        return EnumOsaInspectionOptswitch.valueOf(model.getProperty(ID.ID_OSA_INSPECTION_OPTSWITCH).getCurrentValue());
    }
    public void setOsaSpanWavelengthNm(double value) {
        model.requestChange(ID.ID_OSA_SPAN_WAVELENGTH_NM, String.valueOf(value));
    }
    public double getOsaSpanWavelengthNm() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_SPAN_WAVELENGTH_NM).getCurrentValue());
    }
    public enum EnumOsaActiveGridType{
        ID_OSA_GRID_TYPE_ITUT100G,
        ID_OSA_GRID_TYPE_ITUT50G,
        ID_OSA_GRID_TYPE_ITUT25G,
        ID_OSA_GRID_TYPE_ITUT12_5G,
        ID_OSA_GRID_TYPE_CWDM,
        ID_OSA_GRID_TYPE_USER,
    };
    public void setOsaActiveGridType(EnumOsaActiveGridType value) {
        model.requestChange(ID.ID_OSA_ACTIVE_GRID_TYPE, value.toString());
    }
    public EnumOsaActiveGridType getOsaActiveGridType() {
        return EnumOsaActiveGridType.valueOf(model.getProperty(ID.ID_OSA_ACTIVE_GRID_TYPE).getCurrentValue());
    }
    public void setOsaInspectionRegDInterval(long value) {
        model.requestChange(ID.ID_OSA_INSPECTION_REG_D_INTERVAL, String.valueOf(value));
    }
    public long getOsaInspectionRegDInterval() {
        return Long.valueOf(model.getProperty(ID.ID_OSA_INSPECTION_REG_D_INTERVAL).getCurrentValue());
    }
    public void setCustomer(String value) {
        model.requestChange(ID.ID_CUSTOMER, value);
    }
    public String getCustomer() {
        return model.getProperty(ID.ID_CUSTOMER).getCurrentValue();
    }
    public void setOsaStopWavelengthThz(double value) {
        model.requestChange(ID.ID_OSA_STOP_WAVELENGTH_THZ, String.valueOf(value));
    }
    public double getOsaStopWavelengthThz() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_STOP_WAVELENGTH_THZ).getCurrentValue());
    }
    public void setActiveWaveformControllerName(String value) {
        model.requestChange(ID.ID_ACTIVE_WAVEFORM_CONTROLLER_NAME, value);
    }
    public String getActiveWaveformControllerName() {
        return model.getProperty(ID.ID_ACTIVE_WAVEFORM_CONTROLLER_NAME).getCurrentValue();
    }
    public enum EnumOsaGridEditSpanType{
        ID_OSA_GRID_EDIT_SPAN_TYPE_NONE,
        ID_OSA_GRID_SIGNAL_SPAN,
        ID_OSA_GRID_MASKED_SPAN,
        ID_OSA_GRID_FITTING_SPAN,
        ID_OSA_GRID_FIX_OSNR_AUTO_SPAN,
    };
    public void setOsaGridEditSpanType(EnumOsaGridEditSpanType value) {
        model.requestChange(ID.ID_OSA_GRID_EDIT_SPAN_TYPE, value.toString());
    }
    public EnumOsaGridEditSpanType getOsaGridEditSpanType() {
        return EnumOsaGridEditSpanType.valueOf(model.getProperty(ID.ID_OSA_GRID_EDIT_SPAN_TYPE).getCurrentValue());
    }
    public enum EnumOsaDriftgraphDisplaytype1{
        ID_OSA_DRIFTGRAPH_DISPLAYTYPE_POWER,
        ID_OSA_DRIFTGRAPH_DISPLAYTYPE_OSNR,
        ID_OSA_DRIFTGRAPH_DISPLAYTYPE_WAVELENGTH,
    };
    public void setOsaDriftgraphDisplaytype1(EnumOsaDriftgraphDisplaytype1 value) {
        model.requestChange(ID.ID_OSA_DRIFTGRAPH_DISPLAYTYPE1, value.toString());
    }
    public EnumOsaDriftgraphDisplaytype1 getOsaDriftgraphDisplaytype1() {
        return EnumOsaDriftgraphDisplaytype1.valueOf(model.getProperty(ID.ID_OSA_DRIFTGRAPH_DISPLAYTYPE1).getCurrentValue());
    }
    public void setOsaActiveChannelPower(double value) {
        model.requestChange(ID.ID_OSA_ACTIVE_CHANNEL_POWER, String.valueOf(value));
    }
    public double getOsaActiveChannelPower() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_ACTIVE_CHANNEL_POWER).getCurrentValue());
    }
    public void setOsaActiveChannelOsnr(double value) {
        model.requestChange(ID.ID_OSA_ACTIVE_CHANNEL_OSNR, String.valueOf(value));
    }
    public double getOsaActiveChannelOsnr() {
        return Double.valueOf(model.getProperty(ID.ID_OSA_ACTIVE_CHANNEL_OSNR).getCurrentValue());
    }
    public void setOsaInspectionMotorInitrotorPosition(long value) {
        model.requestChange(ID.ID_OSA_INSPECTION_MOTOR_INITROTOR_POSITION, String.valueOf(value));
    }
    public long getOsaInspectionMotorInitrotorPosition() {
        return Long.valueOf(model.getProperty(ID.ID_OSA_INSPECTION_MOTOR_INITROTOR_POSITION).getCurrentValue());
    }
    public void setActiveWaveformModuleVerificationDueDate(String value) {
        model.requestChange(ID.ID_ACTIVE_WAVEFORM_MODULE_VERIFICATION_DUE_DATE, value);
    }
    public String getActiveWaveformModuleVerificationDueDate() {
        return model.getProperty(ID.ID_ACTIVE_WAVEFORM_MODULE_VERIFICATION_DUE_DATE).getCurrentValue();
    }
}
