package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.FavouriteService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.Favourites;
import kodlamaio.hrms.entities.dtos.FavouritesDto;

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
	
	@PostMapping("/add")
	public Result add(@RequestBody FavouritesDto favDto){
		return this.favService.add(favDto);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam int id,@RequestParam int jobId){
		return this.favService.delete(id,jobId);
	}
	@GetMapping("/findByCandidateId")
	public DataResult<List<Favourites>> findByCandidateId(@RequestParam int id) {
		// TODO Auto-generated method stub
		return this.favService.findByCandidateId(id);
	}
	
	@GetMapping("/findByCandidateIdAndJobId")
	public DataResult<Favourites> findByCandidateIdAndJobId(@RequestParam int id,@RequestParam int jobId) {
		// TODO Auto-generated method stub
		return this.favService.findByCandidateIdAndJobId(id,jobId);
	}
}
