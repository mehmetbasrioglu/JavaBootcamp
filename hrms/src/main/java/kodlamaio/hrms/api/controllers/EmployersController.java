package kodlamaio.hrms.api.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployersController {
	@Autowired
	private EmployerService employerService;

	public EmployersController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employer>> getAll(){
		return this.employerService.getAll();
	}
	
	@GetMapping("/findbyid")
	public DataResult<Employer> findById(@RequestParam int id){
		return this.employerService.findById(id);
	}
	
	@PostMapping("/add")
	public DataResult<Employer> add(@RequestBody Employer employer){
		return this.employerService.add(employer);
	}
	
	@PostMapping("/uploadphoto")
	public Result uploadEmployerPhoto(@RequestParam int employerId, @RequestParam MultipartFile multipartFile) throws IOException{
		return this.employerService.uploadEmployerPhoto(employerId, multipartFile);
	}
	
	@PostMapping("/uploadheaderphoto")
	public Result uploadEmployerHeaderPhoto(@RequestParam int employerId, @RequestParam MultipartFile multipartFile) throws IOException{
		return this.employerService.uploadEmployerHeaderPhoto(employerId, multipartFile);
	}
	
	
}
