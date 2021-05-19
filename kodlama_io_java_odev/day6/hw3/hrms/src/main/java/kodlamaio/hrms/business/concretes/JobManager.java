package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.dataAccess.abstracts.JobDao;
import kodlamaio.hrms.entities.concretes.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class JobManager implements JobService {

    @Autowired
    public JobManager(JobDao jobDao) {
        this.jobDao = jobDao;
    }

    private JobDao jobDao;

    @Override
    public List<Job> getAll() {
        return this.jobDao.findAll();
    }

}
