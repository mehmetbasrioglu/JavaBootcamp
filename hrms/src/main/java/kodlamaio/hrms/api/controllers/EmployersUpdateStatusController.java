package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployerUpdateStatusService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.core.utilites.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.EmployerUpdateStatus;

@RestController
@RequestMapping("/api/employer")
public class EmployersUpdateStatusController {
	private EmployerUpdateStatusService employerService;
	
	@Autowired
	public EmployersUpdateStatusController(EmployerUpdateStatusService employerService) {
		this.employerService = employerService;
	}
	
	@GetMapping("/status/getall")
	public DataResult<List<EmployerUpdateStatus>> getAll(){
		return this.employerService.getAll();
	}
	
	@GetMapping("/status/findbyemployerid")
	public DataResult<EmployerUpdateStatus> findByEmployerId(@RequestParam int employerId){
		return this.employerService.findByEmployerId(employerId);
	}
	
	@PostMapping("/status/add")
	public Result add(@RequestBody EmployerUpdateStatus employer) {
		// TODO Auto-generated method stub
		return this.employerService.add(employer);
	}
	
	@PostMapping("/status/update/confirm")
	public Result confirm(@RequestParam int id) {
		// TODO Auto-generated method stub
		return this.employerService.confirm(id);
	}
	
	
}
