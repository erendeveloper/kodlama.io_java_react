import business.concretes.UserManager;
import core.LoginManagerAdapter;
import dataAccess.concretes.HibernateUserDao;
import entitiies.concretes.User;

public class Main {

    public static void main(String[] args) {
	// write your code here

        UserManager userManager=new UserManager(new LoginManagerAdapter(), new HibernateUserDao());

        User user=new User(1,"Eren","Aydin","eren@eren.com","123456");

        userManager.addWithService("alibaba@gmail.com");

        if(userManager.add(user)){
            userManager.confirmVerificationEmail(user);
        }
        userManager.login(user,"eren@eren.com","123456");




    }
}
