package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.TalentService;
import kodlamaio.hrms.business.abstracts.WorkHourService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.entities.concretes.Talent;
import kodlamaio.hrms.entities.concretes.WorkHour;

@RestController
@RequestMapping("/api/workhour")
@CrossOrigin
public class WorkHoursController {
	private WorkHourService workHourService;
	
	@Autowired
	public WorkHoursController(WorkHourService workHourService) {
		this.workHourService = workHourService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<WorkHour>> getAll(){
		return this.workHourService.getAll();
	}
	
}
