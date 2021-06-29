package kodlamaio.hrms.business.concretes.checkInfo;

import kodlamaio.hrms.core.adapters.CheckMernis;
import kodlamaio.hrms.core.adapters.EmailVerification;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
public class JobSeekerCheckManager{

    private JobSeeker jobSeeker;
    private String message="";

    public JobSeekerCheckManager(JobSeeker jobSeeker) {
        this.jobSeeker = jobSeeker;
    }

    public boolean checkJobSeekerInfo(String rePassword, List<JobSeeker> allJobSeekers){

        if(!checkEmptyFields(rePassword))
            return false;
        else if(!jobSeeker.getPassword().equals(rePassword)){
            message="Passwords does not match";
            return false;
        }
        else if (!CheckMernis.checkJobSeeker(jobSeeker)){
            message="Jobsseker data was not verified by Mernis";
            return false;
        }
        else if(checkNationalityIdSaved(allJobSeekers)){
            return false;
        }
        else if(checkEmailSaved(allJobSeekers)){
            message="Email is not a your commpany email";
            return false;
        }
        else if(EmailVerification.verifyEmail())
            return true;
        else{
            message="Email has not not verified yet";
            return false;
        }


    }

    private boolean checkEmptyFields(String rePassword){

        if(jobSeeker.getName()==null || jobSeeker.getName().isEmpty()){
            //return new ErrorResult("Name field cannot be left blank");
            message="Name field cannot be left blank";
            return false;
        }
        else if(jobSeeker.getSurname()==null || jobSeeker.getSurname().isEmpty()){
            //return new ErrorResult("Surname field cannot be left blank");
            message="Surname field cannot be left blank";
            return false;
        }
        else if(jobSeeker.getNationaltyId()==null || jobSeeker.getNationaltyId().isEmpty()){//buraya mernis yaz
            //return new ErrorResult("NationaltyId field cannot be left blank");
            message="NationaltyId field cannot be left blank";
            return false;
        }
        else if(jobSeeker.getBirthYear()==0){
            //return new ErrorResult("Birth Year field cannot be left blank");
            message="Birth Year field cannot be left blank";
            return false;
        }
        else if(jobSeeker.getEmail()==null || jobSeeker.getEmail().isEmpty()){
            //return new ErrorResult("Email field cannot be left blank");
            message="Email field cannot be left blank";
            return false;
        }
        else if(jobSeeker.getPassword()==null || jobSeeker.getPassword().isEmpty()){
            //return new ErrorResult("Password field cannot be left blank");
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

    private boolean checkNationalityIdSaved(List<JobSeeker> allJobSeekers){

        for(JobSeeker jobseeker : allJobSeekers){
            if (jobseeker.getNationaltyId().equals(this.jobSeeker.getNationaltyId())){
                message="NationalityId is saved before";
                return true;
            }
        }

        return false;
    }

    private boolean checkEmailSaved(List<JobSeeker> allJobSeekers){
        for(JobSeeker jobSeeker : allJobSeekers){
            if(jobSeeker.getEmail().equals(this.jobSeeker.getEmail())){
                message="Email is not a your commpany email";
                return true;
            }
        }

        return false;
    }


}
