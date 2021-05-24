package kodlamaio.pinterestclonebackend.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.pinterestclonebackend.business.abstracts.UserService;
import kodlamaio.pinterestclonebackend.core.DataResult;
import kodlamaio.pinterestclonebackend.entities.concretes.User;

@RestController
@RequestMapping("/api/user")
public class UserController {
	 private UserService userService;
	 
	 @Autowired
	 public UserController(UserService userService) {
			super();
			this.userService = userService;
		}
	 
	 @GetMapping("/getall")
	 public DataResult<List<User>> getAll(){
		 return this.userService.getAll();
	 }

	
}
