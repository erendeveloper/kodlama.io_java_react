package googleLogin.concretes;

import googleLogin.abstracts.GoogleLoginService;

public class GoogleLoginManager implements GoogleLoginService {


    @Override
    public void authenticate(String email) {

        System.out.println(email+" email'i ile google girisi yapildi");
    }

}
