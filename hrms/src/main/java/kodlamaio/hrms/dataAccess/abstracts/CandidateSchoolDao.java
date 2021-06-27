package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.CandidateCv;
import kodlamaio.hrms.entities.concretes.CandidateSchool;
import kodlamaio.hrms.entities.dtos.CandidateSchoolDto;

public interface CandidateSchoolDao extends JpaRepository<CandidateSchool, Integer>{
	List<CandidateSchool> findByCandidateCvId(int id);
	
	@Query(value="select * from candidates_cv_school where id =:id  ",nativeQuery=true)
	CandidateSchool findById(int id);
	
	//NULLS LAST - Null olanları da en sona at
	
	@Query("From CandidateSchool c where candidates_cv_id =:id ORDER BY graduation_date, is_continue DESC ")
	List<CandidateSchool> getSchoolsOrderByGraduationDateDesc(int id);

	List<CandidateSchool> getById(int id);
}
