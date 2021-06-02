package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.concretes.checkInfo.EmployerCheckManager;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;

    @Autowired
    public EmployerManager(EmployerDao employerDao) {
        this.employerDao=employerDao;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return  new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Employers data listed");
    }

    @Override
    public Result add(Employer employer, String rePassword){
        EmployerCheckManager employerCheckManager=new EmployerCheckManager(employer);
        if(employerCheckManager.checkEmployerInfo(rePassword,this.employerDao.findAll())){
            this.employerDao.save(employer);
            return new SuccessDataResult("Employer added");
        }
        else{
            return new ErrorDataResult(employerCheckManager.getMessage());
        }
    }
}
