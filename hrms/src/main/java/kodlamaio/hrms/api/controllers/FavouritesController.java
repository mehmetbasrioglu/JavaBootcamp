package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.FavouriteService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.Favourites;

@RestController
@RequestMapping("/api/favourite")
@CrossOrigin

public class FavouritesController {
	private FavouriteService favService;
	
	@Autowired
	public FavouritesController(FavouriteService favService) {
		this.favService = favService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Favourites>> getAll(){
		return this.favService.getAll();
	}
	
	@GetMapping("/findByCandidateId")
	public DataResult<Favourites> findByCandidateId(@RequestParam int id,@RequestParam int jobId) {
		// TODO Auto-generated method stub
		return this.favService.findByCandidateIdAndJobId(id,jobId);
	}
}
