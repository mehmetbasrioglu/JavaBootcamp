package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkHourService;
import kodlamaio.hrms.business.abstracts.WorkTypeService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.entities.concretes.WorkHour;
import kodlamaio.hrms.entities.concretes.WorkType;

@RestController
@RequestMapping("/api/worktype")
@CrossOrigin
public class WorkTypesController {
	private WorkTypeService workTypeService;
	
	@Autowired
	public WorkTypesController(WorkTypeService workTypeService) {
		this.workTypeService = workTypeService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<WorkType>> getAll(){
		return this.workTypeService.getAll();
	}
	
}
