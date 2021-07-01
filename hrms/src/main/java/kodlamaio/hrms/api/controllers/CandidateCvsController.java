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

import kodlamaio.hrms.business.abstracts.CandidateCvService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateCv;
import kodlamaio.hrms.entities.dtos.CandidateCvDto;

@RestController
@RequestMapping("api/cv")
@CrossOrigin
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
	
	@GetMapping("/findbycvid")
	public DataResult<CandidateCv> findByCvId(@RequestParam int id) {
		// TODO Auto-generated method stub
		return this.candidateCvService.findById(id);
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateCvDto candidateCv){
		return this.candidateCvService.add(candidateCv);
	}
	
	@PostMapping("/addcvphoto")
	public Result uploadCvPhoto(@RequestParam int candidateCvId, @RequestParam MultipartFile multipartFile) throws IOException{
		return this.candidateCvService.uploadCvPhoto(candidateCvId, multipartFile);
	}
	@PostMapping("/updateCoverLetter")
	public Result updateCoverLetter(String text, int cvId) {
		return this.candidateCvService.updateCoverLetter(text, cvId);
	}
	
}
