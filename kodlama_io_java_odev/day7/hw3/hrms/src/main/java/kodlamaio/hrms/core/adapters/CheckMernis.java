package kodlamaio.hrms.core.adapters;

import kodlamaio.hrms.MernisService.FHEKPSPublicSoap;
import kodlamaio.hrms.MernisService.FHEKPSPublicSoap12;
import kodlamaio.hrms.entities.concretes.JobSeeker;

public class CheckMernis{

    public static boolean checkJobSeeker(JobSeeker jobSeeker){


        FHEKPSPublicSoap client = new FHEKPSPublicSoap();

        try {
            return client.TCKimlikNoDogrula(
                    Long.parseLong(jobSeeker.getNationaltyId()),
                    jobSeeker.getName().toUpperCase(),
                    jobSeeker.getSurname().toUpperCase(),
                    jobSeeker.getBirthYear()
            );
        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
    }
}
