package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.CandidateJobExperience;
import kodlamaio.hrms.entities.concretes.CandidateSchool;
import kodlamaio.hrms.entities.dtos.CandidateJobExperienceDto;

public interface CandidateJobExperienceDao extends JpaRepository<CandidateJobExperience, Integer>{
	//NULLS LAST - Null olanları da en sona at
	
	@Query("From CandidateJobExperience c where candidates_cv_id =:id ORDER BY exit_date, is_continue DESC")
	List<CandidateJobExperience> getJobExperienceOrderByExitDateDesc(int id);
	
	List<CandidateJobExperience> getById(int id);
	
	@Query(value="select * from candidates_job_experiences where id =:id  ",nativeQuery=true)
	CandidateJobExperience findById(int id);
	
}
