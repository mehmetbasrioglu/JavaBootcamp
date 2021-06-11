package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SystemUserService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.SystemUser;
import kodlamaio.hrms.entities.dtos.SystemUserDto;

@RestController
@RequestMapping("/api/systemusers")
public class SystemUsersController {
	
	private SystemUserService systemUserService;

	@Autowired
	public SystemUsersController(SystemUserService systemUserService) {
		super();
		this.systemUserService = systemUserService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<SystemUserDto>> getAll() {
		// TODO Auto-generated method stub
		return this.systemUserService.getAll();
	}
	
	@PostMapping("/add")
	public DataResult<SystemUser> add(@RequestBody SystemUser systemUser) {
		return this.systemUserService.add(systemUser);
	}
	
	
	
	
}
