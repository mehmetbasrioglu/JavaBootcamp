package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateCvService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.CandidateCv;
import kodlamaio.hrms.entities.concretes.CandidateJobExperience;

@RestController
@RequestMapping("api/cv")
public class CandidateCvsController {
	private CandidateCvService candidateCvService;
	
	@Autowired
	public CandidateCvsController(CandidateCvService candidateCvService) {
		this.candidateCvService = candidateCvService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<CandidateCv>> getAll(){
		return this.candidateCvService.getAll();
	}
	
	@GetMapping("/findbycandidateid")
	public DataResult<List<CandidateCv>> findByCandidateId(@RequestParam int id) {
		// TODO Auto-generated method stub
		return this.candidateCvService.findByCandidateId(id);
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateCv candidateCv){
		return this.candidateCvService.add(candidateCv);
	}
	
}
