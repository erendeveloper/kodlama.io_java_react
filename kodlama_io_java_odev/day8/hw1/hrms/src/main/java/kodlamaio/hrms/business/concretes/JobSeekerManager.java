package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.business.concretes.checkInfo.JobSeekerCheckManager;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {

    private JobSeekerDao jobSeekerDao;

    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao) {
        this.jobSeekerDao=jobSeekerDao;
    }

    @Override
    public DataResult<List<JobSeeker>> getAll() {
        return  new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(),"Job seekers retrived");
    }

    @Override
    public Result add(JobSeeker jobSeeker, String rePassword){
        JobSeekerCheckManager jobSeekerCheckManager=new JobSeekerCheckManager(jobSeeker);
        if(jobSeekerCheckManager.checkJobSeekerInfo(rePassword,this.jobSeekerDao.findAll())){
            this.jobSeekerDao.save(jobSeeker);
            return new SuccessDataResult("Jobseeker added");
        }
        else{
            return new ErrorDataResult(jobSeekerCheckManager.getMessage());
        }
    }



}
