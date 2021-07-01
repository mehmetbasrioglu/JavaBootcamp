package kodlamaio.hrms.business.abstracts;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerService {
	DataResult<Employer> add(Employer employer);
	DataResult<List<Employer>>getAll();
	
	DataResult<Employer> findById(int id);
	
	Employer findByEmployerId(int id);
	Employer update(Employer employer);
	
	
	
	Result uploadEmployerPhoto(int employerId, MultipartFile multipartFile) throws IOException;
}
