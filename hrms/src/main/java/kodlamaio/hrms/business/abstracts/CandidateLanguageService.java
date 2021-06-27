package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateLanguage;
import kodlamaio.hrms.entities.dtos.CandidateLanguageDto;

public interface CandidateLanguageService{
	DataResult<List<CandidateLanguage>> getAll();
	
	Result add(CandidateLanguageDto lang);
	
	Result update(int cvId,int langId,int level);
}
