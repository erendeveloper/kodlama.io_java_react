package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.City;
import kodlamaio.hrms.entities.concretes.Job;

import java.util.List;

public interface CityService {

    DataResult<List<City>> getAll();
    Result add(City city);

}
