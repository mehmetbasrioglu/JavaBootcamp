package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	
	List<JobAdvertisement> getOneById(int id);

	
	List<JobAdvertisement> getByEmployerId(int employerId);
	
	List<JobAdvertisement> findAllByIsActive(boolean isActive);
	
	List<JobAdvertisement> findAllByIsActiveOrderByCreatedDateDesc(boolean isActive);
	
	@Query("From JobAdvertisement where isActive = true and employer_id =:id")
	List<JobAdvertisement> getEmployersActiveJobAdvertisement(int id);
	
	@Query("From JobAdvertisement where isConfirmed = true")
	List<JobAdvertisement> getConfirmedJobAdvertisements();
	
	@Query("From JobAdvertisement where isConfirmed = false")
	List<JobAdvertisement> getWaitingJobAdvertisements();
	
	
	
	
	
	
}