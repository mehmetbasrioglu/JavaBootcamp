package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateSchoolService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.CandidateCv;
import kodlamaio.hrms.entities.concretes.CandidateSchool;

@RestController
@RequestMapping("/api/candidateschools")
public class CandidateSchoolsController {
	private CandidateSchoolService candidateSchoolService;
	
	@Autowired
	public CandidateSchoolsController(CandidateSchoolService candidateSchoolService) {
		this.candidateSchoolService = candidateSchoolService;
	}
	
	@GetMapping("/findbycandidatecvid")
	public DataResult<List<CandidateSchool>> findByCandidateId(@RequestParam int id) {
		// TODO Auto-generated method stub
		return this.candidateSchoolService.findByCandidateId(id);
	}
	
	@PostMapping("/update")
	public DataResult<CandidateSchool> update(@RequestBody CandidateSchool candidateSchool) {
		// TODO Auto-generated method stub
		return this.candidateSchoolService.updateSchool(candidateSchool);
	}

	
	@GetMapping("/getall")
	public DataResult<List<CandidateSchool>> getAll(){
		return this.candidateSchoolService.getAll();
	}
	
	@GetMapping("/getcandidateschoolswithordered")
	public DataResult<List<CandidateSchool>> orderedCandidateCvSchools(@RequestParam int id){
		return this.candidateSchoolService.orderedCandidateCvSchools(id);
	}
	
	
}
