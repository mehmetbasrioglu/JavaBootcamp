package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.entities.concretes.SystemUser;
import kodlamaio.hrms.entities.dtos.SystemUserDto;

public interface SystemUserService {
	DataResult<List<SystemUserDto>> getAll();
	
	DataResult<SystemUser> add(SystemUser systemUser);
}
