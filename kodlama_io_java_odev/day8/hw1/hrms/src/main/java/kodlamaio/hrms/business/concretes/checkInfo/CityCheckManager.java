package kodlamaio.hrms.business.concretes.checkInfo;

import kodlamaio.hrms.entities.concretes.City;
import lombok.Data;

import java.util.List;

@Data
public class CityCheckManager {

    private City city;
    private String message="";

    public CityCheckManager(City city){
        this.city=city;
    }

    public boolean checkCitySaved(List<City> allCities){

        for(City city : allCities){
            if(city.getName().equals(this.city.getName())){
                message="Job is already added";
                return true;
            }
        }

        return false;

    }

}
