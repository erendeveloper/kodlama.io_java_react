package kodlamaio.hrms.business.concretes.checkInfo;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import lombok.Data;

@Data
public class JobAdvertisementCheckManager {

    private JobAdvertisement jobAdvertisement;
    private String message;

    public JobAdvertisementCheckManager(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisement = jobAdvertisement;
    }

    public boolean checkJobAdvertisementInfo(){

        if(jobAdvertisement.getJob()==null){
            message="Job must be selected";
            return false;
        }
        else if(jobAdvertisement.getJobDescription()==null || jobAdvertisement.getJobDescription().isEmpty()){
            message="Job Description field cannot be left blank";
            return false;
        }
        if(jobAdvertisement.getCity()==null){
            message="City must be selected";
            return false;
        }
        else if(jobAdvertisement.getRecruitNumbers()<=0){
            message="Recruit numbers must be greater than 0";
            return false;
        }
        else{
            return true;
        }

    }


}
