package kodlamaio.hrms.business.abstracts;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateCv;
import kodlamaio.hrms.entities.dtos.CandidateCvDto;

public interface CandidateCvService {
	DataResult<List<CandidateCv>> getAll();

	DataResult<CandidateCv> findById(int id);

	Result add(CandidateCvDto candidateCv);
	
	DataResult<List<CandidateCv>> findByCandidateId(int id);
	
	Result uploadCvPhoto(int candidateCvId, MultipartFile multipartFile) throws IOException;
	
	Result updateCoverLetter(String text,int cvId);
}
