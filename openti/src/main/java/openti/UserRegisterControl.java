package openti;
import obsolute.register.RegisterAccess;
import jp.silverbullet.register.RegisterControl;
public class UserRegisterControl extends RegisterControl {
    private RegisterAccess registerAccess = null;
    public RegisterAccess getRegisterAccess() {
    	return registerAccess;
    }
    public UserRegisterControl(RegisterAccess registerAccess2) {
         super(registerAccess2);
         this.registerAccess = registerAccess2;
    }
}
