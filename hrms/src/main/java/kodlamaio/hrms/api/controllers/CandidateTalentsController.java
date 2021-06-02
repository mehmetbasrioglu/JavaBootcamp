package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateTalentService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.entities.concretes.CandidateTalent;

@RestController
@RequestMapping("/api/candidatetalents")
public class CandidateTalentsController {
	private CandidateTalentService candidateTalentService;
	
	@Autowired
	public CandidateTalentsController(CandidateTalentService candidateTalentService) {
		this.candidateTalentService = candidateTalentService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<CandidateTalent>> getAll(){
		return this.candidateTalentService.getAll();
	}
	
}