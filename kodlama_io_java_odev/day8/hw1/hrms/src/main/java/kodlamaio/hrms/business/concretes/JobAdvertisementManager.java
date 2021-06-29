package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.business.concretes.checkInfo.JobAdvertisementCheckManager;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

    private JobAdvertisementDao jobAdvertisementDao;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
        this.jobAdvertisementDao = jobAdvertisementDao;
    }


    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
        return  new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(),"JobAdvertisements retrieved");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getActive() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByStatueTrue(),"Active job advertisements listed");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getActiveSorted() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByStatueTrueOrderByReleaseDate(),"Active job advertisements sorted listed");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByEmployerName(String companyName) {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByEmployer_CompanyName(companyName),companyName+" advertisements retrieved");
    }

    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
        JobAdvertisementCheckManager jobAdvertisementCheckManager=new JobAdvertisementCheckManager(jobAdvertisement);
        if(!jobAdvertisementCheckManager.checkJobAdvertisementInfo()){
            this.jobAdvertisementDao.save(jobAdvertisement);
            return new SuccessDataResult("Job advertisement added");
        }
        else{
            return  new ErrorDataResult(jobAdvertisementCheckManager.getMessage());
        }
    }
}
