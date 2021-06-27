package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateJobExperienceService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateJobExperience;
import kodlamaio.hrms.entities.concretes.CandidateSchool;
import kodlamaio.hrms.entities.dtos.CandidateJobExperienceDto;
import kodlamaio.hrms.entities.dtos.CandidateSchoolDto;

@RestController
@RequestMapping("/api/candidateexperience")
@CrossOrigin
public class CandidateJobExperienceController {
	private CandidateJobExperienceService candidateJobExperienceService;
	
	@Autowired
	public CandidateJobExperienceController(CandidateJobExperienceService candidateJobExperienceService) {
		this.candidateJobExperienceService = candidateJobExperienceService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<CandidateJobExperience>> getAll(){
		return this.candidateJobExperienceService.getAll();
	}
	@GetMapping("/getbyid")
	public DataResult<List<CandidateJobExperience>> getbyid(@RequestParam int id) {
		// TODO Auto-generated method stub
		return this.candidateJobExperienceService.getById(id);
	}
		
	@PostMapping("/update")
	public Result update(@RequestBody CandidateJobExperienceDto jobExp) {
		// TODO Auto-generated method stub
		return this.candidateJobExperienceService.update(jobExp);
	}

	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateJobExperienceDto jobexp) {
		return this.candidateJobExperienceService.add(jobexp);
	}
	
	@GetMapping("/getcandidateJobExperiencesswithordered")
	public DataResult<List<CandidateJobExperience>> orderedCandidateCvSchools(@RequestParam int id){
		return this.candidateJobExperienceService.orderedCandidateCvJobExperience(id);
	}
	
	
}
