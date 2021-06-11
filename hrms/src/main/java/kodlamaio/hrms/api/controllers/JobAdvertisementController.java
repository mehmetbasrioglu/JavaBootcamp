package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

@RestController
@RequestMapping("/api/jobAdvertisements")
public class JobAdvertisementController {

	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>>  getAll(){
		return this.jobAdvertisementService.getAll();
	}
	
	@GetMapping("/getallactive")
	public DataResult<List<JobAdvertisement>>  getAllActive(){
		return this.jobAdvertisementService.findAllByIsActive();
	}
	
	@GetMapping("/getallactivesorted")
	public DataResult<List<JobAdvertisement>>  getAllActiveSorted(){
		return this.jobAdvertisementService.findAllByIsActiveSorted();
	}
	
	@GetMapping("/getEmployerJobAdvertisement")
	public DataResult<List<JobAdvertisement>> findAllByIsActiveAndCompanyName(int id) {
		// TODO Auto-generated method stub
		return this.jobAdvertisementService.findAllByIsActiveAndCompanyName(id);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisementDto jobAdvertisement){
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@PostMapping("/jobAdvertisementDisable")
	public DataResult<JobAdvertisement> setJobAdvertisementDisabled(int id) {
		return this.jobAdvertisementService.setJobAdvertisementDisabled(id);
	}
	
}