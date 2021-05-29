package kodlamaio.hrms.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobTitle;


@RestController
@RequestMapping("/api/jobtitle/") 
public class JobTitlesController {
	private JobTitleService jobTitleService;
	
	public JobTitlesController(JobTitleService jobTitleService) {
		super();
		this.jobTitleService = jobTitleService;
	}
	
	@GetMapping("getall")
	public DataResult<List<JobTitle>> getAll(){
		return jobTitleService.getAll();
	}
	
	@RequestMapping(value = "findbyid/{id}", method = RequestMethod.GET)
	public DataResult<List<JobTitle>> findById(@PathVariable("id") Integer id){
		return jobTitleService.findById(id);
	}
	
	@RequestMapping(value = "findbytitle/{title}", method = RequestMethod.GET)
	public DataResult<List<JobTitle>> findByTitle(@PathVariable("title") String title){
		return jobTitleService.findJobTitles(title);
	}
	
	@PostMapping("add")
	public DataResult<JobTitle> add(@RequestBody JobTitle title){
		return this.jobTitleService.add(title);
	}
	
}
