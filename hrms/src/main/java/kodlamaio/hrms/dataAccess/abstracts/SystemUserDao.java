package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.SystemUser;
import kodlamaio.hrms.entities.dtos.SystemUserDto;

public interface SystemUserDao extends JpaRepository<SystemUser, Integer>{
	
	 @Query("Select new kodlamaio.hrms.entities.dtos.SystemUserDto"
		  		+ "(sys.id, u.id) "
		  		+ "From User u Inner Join u.systemUser sys")
	List<SystemUserDto> getSystemUsers();
}
