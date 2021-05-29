package kodlamaio.hrms.dataAccess.abstracts;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface EmployerDao extends JpaRepository<Employer, Integer>{
	List<Employer> findAllByEmail(String email);
    boolean  existsById(int id);
}
