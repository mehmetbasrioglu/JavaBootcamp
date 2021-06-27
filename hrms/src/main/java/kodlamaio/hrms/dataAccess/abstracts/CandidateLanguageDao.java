package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.CandidateLanguage;
import kodlamaio.hrms.entities.concretes.CandidateTalent;
import kodlamaio.hrms.entities.dtos.CandidateLanguageDto;

public interface CandidateLanguageDao extends JpaRepository<CandidateLanguage, Integer>{

	@Query(value="select * from candidates_lang where candidates_cv_id =:cvId and languages_id=:langId  ",nativeQuery=true)
	CandidateLanguage getByCandidateCvIdAndLanguageId(int cvId, int langId);
	
	@Query(value="select * from candidates_lang where candidates_cv_id =:cvId and languages_id=:langId  LIMIT 1 ",nativeQuery=true)
	CandidateLanguage existsCvIdAndLangId(int cvId, int langId);

}
