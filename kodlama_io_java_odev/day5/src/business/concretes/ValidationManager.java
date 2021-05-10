package business.concretes;

import dataAccess.concretes.HibernateUserDao;
import entitiies.concretes.User;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationManager {

    User user;
    HibernateUserDao hibernateUserDao=new HibernateUserDao();

    public ValidationManager(User user) {
        this.user = user;
    }

    public boolean checkAllData(){

        int errorCounter=0;

        if(emailFormatCheck(user.getEmail())){
            System.out.println("email yanlis");
            errorCounter++;
        }
        if(!passwordFormatcheck(user.getPassword())){
            System.out.println("Sifre 6 haneden az olamaz");
            errorCounter++;
        }
        if(!nameFormatcheck(user.getName())) {
            System.out.println("Ad 2 karakteren kisa olamaz");
            errorCounter++;
        }
        if(!nameFormatcheck(user.getSurname())) {
            System.out.println("Soyad 2 karakteren kisa olamaz");
            errorCounter++;
        }
        if(!emailAvailabilityCheck()) {
            System.out.println("Bu email adresi mevcut");
            errorCounter++;
        }

        if(errorCounter>0)
            return false;
        else
            return true;

    }

    private boolean emailFormatCheck(String email){
        String regex = " ^(.+)@(.+)$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean passwordFormatcheck(String password){
        if(password.length()>=6)
            return true;
        else
            return false;
    }

    private boolean nameFormatcheck(String name){
        if(name.length()>=2)
            return true;
        else
            return false;
    }

    private boolean emailAvailabilityCheck(){
        ArrayList<User> users = hibernateUserDao.getAll();
        for(User user : users){
            if(user.getEmail().equals(this.user.getEmail())){
                return false;
            }
        }
        return true;
    }

    public boolean checkEmailPassword(String email,String password){
        ArrayList<User> users = hibernateUserDao.getAll();
         for(User user : users){
             if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                 return true;
             }
         }
         return false;
    }

}
