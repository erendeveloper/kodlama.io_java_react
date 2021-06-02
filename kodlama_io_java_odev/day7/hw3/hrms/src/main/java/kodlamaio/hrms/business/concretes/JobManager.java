package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.JobDao;
import kodlamaio.hrms.entities.concretes.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class JobManager implements JobService {

    private JobDao jobDao;

    @Autowired
    public JobManager(JobDao jobDao) {
        this.jobDao = jobDao;
    }



    /*@Override
    public List<Job> getAll() {
        return this.jobDao.findAll();
    }
    */
    @Override
    public DataResult<List<Job>> getAll(){
        return  new SuccessDataResult<List<Job>>(this.jobDao.findAll(),"Jobs data listelendi");

    }

    @Override
    public Result add(Job job) {
        this.jobDao.save(job);
        return new SuccessDataResult("Job added");
    }
}
