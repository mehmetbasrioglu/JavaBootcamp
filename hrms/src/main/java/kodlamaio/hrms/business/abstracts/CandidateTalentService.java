package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateTalent;
import kodlamaio.hrms.entities.dtos.CandidateTalentDto;

public interface CandidateTalentService {
	DataResult<List<CandidateTalent>> getAll();
	
	Result add(CandidateTalentDto talent);
}
