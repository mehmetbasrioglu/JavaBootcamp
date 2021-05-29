package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.entities.concretes.City;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/city")
@AllArgsConstructor
public class CitiesController {
	
	@Autowired
	private CityService cityService;
	
	@GetMapping("/getall")
	public DataResult<List<City>> getAll(){
		return this.cityService.getAll();
	}
	
	@PostMapping("/add")
	public DataResult<City> add(City city){
		return this.cityService.add(city);
	}
	
}
