package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateCv;
import kodlamaio.hrms.entities.concretes.CandidateSchool;
import kodlamaio.hrms.entities.dtos.CandidateSchoolDto;

public interface CandidateSchoolService {
	DataResult<List<CandidateSchool>> getAll();
	
	
	DataResult<List<CandidateSchool>> getBySchoolId(int id);

	DataResult<List<CandidateSchool>> findByCandidateId(int id);
	
	DataResult<List<CandidateSchool>> orderedCandidateCvSchools(int id);


	Result updateSchool(CandidateSchoolDto candidateSchool);
	
	Result add(CandidateSchoolDto school);
	
	
	
	
}
