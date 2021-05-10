package business.concretes;

import business.abstracts.IUserService;
import core.LoginManagerAdapter;
import core.LoginService;
import dataAccess.abstracts.IUserDao;
import entitiies.concretes.User;

import java.util.List;



public class UserManager implements IUserService {

    private LoginService loginService;
    private IUserDao userDao;


    public UserManager(LoginService loginService, IUserDao userDao) {
        this.loginService = loginService;
        this.userDao = userDao;
    }

    @Override
    public boolean add(User user) {
      ValidationManager validationManager=new ValidationManager(user);
      if(validationManager.checkAllData()){
          sendVerificationEmail(user);
          return true;
      }
      else{
          System.out.println("Sisteme eklenemedi.bilgilerinizi kontrol ediniz");
          return false;
      }
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    private void sendVerificationEmail(User user){
        System.out.println(user.getName()+" "+user.getSurname()+" kullanicisina dogrulama email'i gonderildi");
    }
    public void confirmVerificationEmail(User user){
        System.out.println(user.getName()+" "+user.getSurname()+" kullanicisi dogrulama email'ini onayladi");
        userDao.add(user);
    }
    public void addWithService(String email){
        loginService.login(email);
    }
    public void login(User user,String email, String password){
        ValidationManager validationManager=new ValidationManager(user);
        if(validationManager.checkEmailPassword(email,password)){
            System.out.println("Sisteme giris yapildi");
        }
        else{
            System.out.println("bilgileriniz yanlis, kontrol ediniz");
        }
    }
}
