package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateJobExperienceService;
import kodlamaio.hrms.business.abstracts.CandidateSchoolService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.entities.concretes.CandidateJobExperience;
import kodlamaio.hrms.entities.concretes.CandidateSchool;

@RestController
@RequestMapping("/api/candidateexperience")
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
	
}