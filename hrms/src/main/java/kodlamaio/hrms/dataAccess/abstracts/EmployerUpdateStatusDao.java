package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.EmployerUpdateStatus;

public interface EmployerUpdateStatusDao extends JpaRepository<EmployerUpdateStatus, Integer>{
	
	EmployerUpdateStatus findByEmployerId(int id);
	
	boolean existsByEmployerId(int id);
	
}
