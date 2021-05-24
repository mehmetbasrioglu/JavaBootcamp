package kodlamaio.pinterestclonebackend.business.abstracts;

import java.util.List;

import kodlamaio.pinterestclonebackend.core.DataResult;
import kodlamaio.pinterestclonebackend.entities.concretes.User;

public interface UserService {
	DataResult<List<User>> getAll();
}
