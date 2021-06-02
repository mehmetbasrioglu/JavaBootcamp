package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.entities.concretes.CandidateTalent;

public interface CandidateTalentService {
	DataResult<List<CandidateTalent>> getAll();
}
