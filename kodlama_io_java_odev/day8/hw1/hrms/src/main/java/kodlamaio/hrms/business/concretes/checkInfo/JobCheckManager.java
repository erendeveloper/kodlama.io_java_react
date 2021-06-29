package kodlamaio.hrms.business.concretes.checkInfo;

import kodlamaio.hrms.entities.concretes.Job;
import lombok.Data;

import java.util.List;

@Data
public class JobCheckManager {

    private Job job;
    private String message="";

    public JobCheckManager(Job job){
        this.job=job;
    }

    public boolean checkJobSaved(List<Job> allJobs){

        for(Job job : allJobs){
            if(job.getJobName().equals(this.job.getJobName())){
                message="Job is already added";
                return true;
            }
        }

        return false;

    }

}
