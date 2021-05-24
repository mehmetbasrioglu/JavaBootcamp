package kodlamaio.hrms.business.abstracts;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobTitle;

public interface JobTitleService {
	
	DataResult<JobTitle> add(JobTitle title);
	
	
	List<JobTitle> getAll();
	Optional<JobTitle> findById(Integer id);
	
	List<JobTitle> findJobTitles(String title);
}
