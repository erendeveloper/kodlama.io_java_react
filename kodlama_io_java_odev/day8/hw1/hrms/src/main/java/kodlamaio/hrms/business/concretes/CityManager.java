package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.business.concretes.checkInfo.CityCheckManager;
import kodlamaio.hrms.business.concretes.checkInfo.JobCheckManager;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.dataAccess.abstracts.JobDao;
import kodlamaio.hrms.entities.concretes.City;
import kodlamaio.hrms.entities.concretes.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CityManager implements CityService {

    private CityDao cityDao;

    @Autowired
    public CityManager(CityDao cityDao) {
        this.cityDao = cityDao;
    }



    @Override
    public DataResult<List<City>> getAll(){
        return  new SuccessDataResult<List<City>>(this.cityDao.findAll(),"Cities retrieved");

    }

    @Override
    public Result add(City city) {

        CityCheckManager cityCheckManager = new CityCheckManager(city);
        if(!cityCheckManager.checkCitySaved(this.cityDao.findAll())){
            this.cityDao.save(city);
            return new SuccessDataResult("City added");
        }
        else{
            return  new ErrorDataResult(cityCheckManager.getMessage());
        }


    }
}
