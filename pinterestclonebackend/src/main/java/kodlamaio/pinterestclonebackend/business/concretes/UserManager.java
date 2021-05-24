package kodlamaio.pinterestclonebackend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.pinterestclonebackend.business.abstracts.UserService;
import kodlamaio.pinterestclonebackend.core.DataResult;
import kodlamaio.pinterestclonebackend.core.SuccessDataResult;
import kodlamaio.pinterestclonebackend.dataAccess.abstracts.UserDao;
import kodlamaio.pinterestclonebackend.entities.concretes.User;

@Service
public class UserManager  implements UserService{

	@Autowired
	private UserDao userDao;
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}
	
	@Override
	public DataResult<List<User>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<User>>(this.userDao.findAll(),"Başarılı");
	}


	

}
