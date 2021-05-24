package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.entities.concretes.User;

public interface UserService {
	List<User> getAll();
	User add(User user);
}
