package kodlamaio.hrms.business.concretes.checkInfo;

import kodlamaio.hrms.core.adapters.EmailVerification;
import kodlamaio.hrms.entities.concretes.Employer;
import lombok.Data;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
public class EmployerCheckManager{

    private Employer employer;
    private String message;

    public EmployerCheckManager(Employer employer) {
        this.employer = employer;
    }

    public boolean checkEmployerInfo(String rePassword,List<Employer> allEmployers){
        if(!checkEmptyFields(rePassword))
            return false;
        if(!employer.getPassword().equals(rePassword)){
            message="Passwords does not match";
            return false;
        }
        if(checkEmailSaved(allEmployers)){
            return false;
        }
        if(EmailVerification.verifyEmail())
            return true;
        else{
            message="Email has not not verified yet";
            return false;
        }
    }

    public boolean checkEmptyFields(String rePassword){

        if(employer.getCompanyName()==null || employer.getCompanyName().isEmpty()){
            message="Company Name field cannot be left blank";
            return false;
        }
        else if(employer.getWebsiteAddress()==null || employer.getWebsiteAddress().isEmpty()){
            message="Website Address field cannot be left blank";
            return false;
        }
        else if(employer.getEmail()==null || employer.getEmail().isEmpty()){//buraya mernis yaz
            message="Email field cannot be left blank";
            return false;
        }
        else if(employer.getPhoneNumber()==null || employer.getPhoneNumber().isEmpty()){
            message="Phone Number field cannot be left blank";
            return false;
        }
        else if(employer.getPassword()==null || employer.getPassword().isEmpty()){
            message="Password field cannot be left blank";
            return false;
        }
        else if(rePassword==null || rePassword.isEmpty()){
            message="Re-Password field cannot be left blank";
            return false;
        }
        else{
            return  true;
        }

    }

    public boolean checkCompanyEmail(String email, String websiteAddress){

        boolean isEmailCorrectFormatted=false;

        String webSitedomain=websiteAddress.replaceFirst("^(https?://)?(www\\.)?", "");
        String emailDomain=email .substring(email .indexOf("@") + 1);

        String regex = " ^(.+)@(.+)$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(email);

        if(matcher.matches() && webSitedomain.equals(emailDomain)){
            return true;
        }
        else{
            message="Email is not a company email";
            return false;
        }

    }

    public boolean checkEmailSaved(List<Employer> allEmployers){
        for(Employer employer : allEmployers){
            if(employer.getEmail().equals(this.employer.getEmail())){
                message="Email is not a your commpany email";
                return true;
            }
        }

        return false;
    }

}
