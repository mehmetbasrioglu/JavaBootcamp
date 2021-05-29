package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	
	List<JobAdvertisement> getByEmployerId(int employerId);
	
	List<JobAdvertisement> findAllByIsActive(boolean isActive);
	
	List<JobAdvertisement> findAllByIsActiveOrderByCreatedDateDesc(boolean isActive);
	
	
}