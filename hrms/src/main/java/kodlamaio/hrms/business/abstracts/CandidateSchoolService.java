package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.entities.concretes.CandidateCv;
import kodlamaio.hrms.entities.concretes.CandidateSchool;

public interface CandidateSchoolService {
	DataResult<List<CandidateSchool>> getAll();
	

	DataResult<List<CandidateSchool>> findByCandidateId(int id);
	
	DataResult<List<CandidateSchool>> orderedCandidateCvSchools(int id);


	DataResult<CandidateSchool> updateSchool(CandidateSchool candidateSchool);
	
	
	
	
}
