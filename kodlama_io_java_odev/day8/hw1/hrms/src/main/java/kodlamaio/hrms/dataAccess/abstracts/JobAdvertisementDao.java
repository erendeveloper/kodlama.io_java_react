package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {

    //List<JobAdvertisement> findByActiveTrue(boolean statue);
    List<JobAdvertisement> findByStatueTrue();
    List<JobAdvertisement> findByStatueTrueOrderByReleaseDate();
    List<JobAdvertisement> findByEmployer_CompanyName(String employerName);


}
