package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.entities.concretes.User;

public interface UserService {
	List<User> getAll();
}
