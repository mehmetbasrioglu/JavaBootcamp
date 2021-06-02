package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.TalentService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.entities.concretes.Talent;

@RestController
@RequestMapping("/api/talent")
public class TalentsController {
	private TalentService talentService;
	
	@Autowired
	public TalentsController(TalentService talentService) {
		this.talentService = talentService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Talent>> getAll(){
		return this.talentService.getAll();
	}
	
}
