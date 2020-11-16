package openti;
import jp.silverbullet.core.dependency2.RequestRejectedException;
import jp.silverbullet.core.sequncer.EasyAccessInterface;
public class AnotherUserEasyAccess {
    private EasyAccessInterface model;
    public AnotherUserEasyAccess(EasyAccessInterface model2) {
        this.model = model2;
    }
    public void setStartFreq(Long value) throws RequestRejectedException {
        model.requestChange(AnotherID.ID_START_FREQ, String.valueOf(value));
    }
    public Long getStartFreq() {
        return Long.valueOf(model.getCurrentValue(AnotherID.ID_START_FREQ));
    }
    public void setStopFreq(Long value) throws RequestRejectedException {
        model.requestChange(AnotherID.ID_STOP_FREQ, String.valueOf(value));
    }
    public Long getStopFreq() {
        return Long.valueOf(model.getCurrentValue(AnotherID.ID_STOP_FREQ));
    }
    public enum EnumStart{
        ID_START_START,
        ID_START_STOP,
    };
    public void setStart(EnumStart value) throws RequestRejectedException {
        model.requestChange(AnotherID.ID_START, value.toString());
    }
    public EnumStart getStart() {
        return EnumStart.valueOf(model.getCurrentValue(AnotherID.ID_START));
    }
    public void setResult(Long value) throws RequestRejectedException {
        model.requestChange(AnotherID.ID_RESULT, String.valueOf(value));
    }
    public Long getResult() {
        return Long.valueOf(model.getCurrentValue(AnotherID.ID_RESULT));
    }
}
