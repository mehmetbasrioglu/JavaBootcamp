package kodlamaio.pinterestclonebackend.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.pinterestclonebackend.business.abstracts.PinService;
import kodlamaio.pinterestclonebackend.core.DataResult;
import kodlamaio.pinterestclonebackend.entities.concretes.Pin;

@RestController
@RequestMapping("/api/pin")
public class PinController {
	private PinService pinService;
	
	@Autowired
	public PinController(PinService pinService) {
		super();
		this.pinService = pinService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Pin>> getAll(){
		return this.pinService.getAll();
	}

}
