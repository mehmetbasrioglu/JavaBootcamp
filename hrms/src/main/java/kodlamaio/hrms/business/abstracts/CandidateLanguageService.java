package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.entities.concretes.CandidateLanguage;

public interface CandidateLanguageService{
	DataResult<List<CandidateLanguage>> getAll();
}
