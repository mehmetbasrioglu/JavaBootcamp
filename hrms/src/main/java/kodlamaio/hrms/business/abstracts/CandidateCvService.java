package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateCv;

public interface CandidateCvService {
	DataResult<List<CandidateCv>> getAll();

	Result add(CandidateCv candidateCv);
	
	DataResult<List<CandidateCv>> findByCandidateId(int id);
}
