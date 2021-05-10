package core;

import googleLogin.concretes.GoogleLoginManager;

public class LoginManagerAdapter implements  LoginService{


    @Override
    public void login(String email) {
        GoogleLoginManager manager = new GoogleLoginManager();
        manager.authenticate(email);

    }
}
