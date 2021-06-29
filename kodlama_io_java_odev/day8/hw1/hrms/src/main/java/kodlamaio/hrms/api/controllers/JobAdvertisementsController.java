package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementsController {

    private JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
        super();
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobAdvertisement>> getAll(){
        return this.jobAdvertisementService.getAll();
    }

    @GetMapping("/getactive")
    public DataResult<List<JobAdvertisement>> getActive(){
        return this.jobAdvertisementService.getActive();
    }
    @GetMapping("/getactivesorted")
    public DataResult<List<JobAdvertisement>> getActiveSorted(){
        return this.jobAdvertisementService.getActiveSorted();
    }
    @GetMapping("/getbyemployer")
    public DataResult<List<JobAdvertisement>> getByEmployer(String companyName){
        return this.jobAdvertisementService.getByEmployerName(companyName);
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobAdvertisement jobAdvertisement){
        return this.jobAdvertisementService.add(jobAdvertisement);
    }


}
