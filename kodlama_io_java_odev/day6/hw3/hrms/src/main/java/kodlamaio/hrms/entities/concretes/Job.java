package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="jobs")
public class Job{

    @Id
    @GeneratedValue
    @Column(name="job_id")
    private
    int jobId;

    @Column(name="job_name")
    private
    String jobName;

    public Job(){

    }

    public Job(int jobId, String jobName) {
        this.setJobId(jobId);
        this.setJobName(jobName);
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
}
