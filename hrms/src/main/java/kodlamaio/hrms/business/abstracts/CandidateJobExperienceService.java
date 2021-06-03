package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.entities.concretes.CandidateJobExperience;

public interface CandidateJobExperienceService {
	DataResult<List<CandidateJobExperience>> getAll();
	DataResult<List<CandidateJobExperience>> orderedCandidateCvJobExperience(int id);
}
