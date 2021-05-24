package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.ErrorDataResult;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService{
	
	@Autowired
	private JobTitleDao jobTitleDao;
	
	public JobTitleManager() {
		
	}
	
	@Override
	public List<JobTitle> getAll() {
		// TODO Auto-generated method stub
		return jobTitleDao.findAll();
	}

	@Override
	public Optional<JobTitle> findById(Integer id) {
		// TODO Auto-generated method stub
		return jobTitleDao.findById(id);
	}

	@Override
    public List<JobTitle> findJobTitles(String title) {
        return this.jobTitleDao.findJobTitles(title);
    }

	@Override
	public DataResult<JobTitle> add(JobTitle title) {
		// TODO Auto-generated method stub
		if(jobTitleDao.findAllByTitle(title.getTitle()).stream().count() !=0 ) {
			return new ErrorDataResult<JobTitle>(null,"Böyle Bir İş Pozisyonu Zaten Kayıtlı");
			
		}
		return new SuccessDataResult<JobTitle>(this.jobTitleDao.save(title),"Başarıyla İş Pozisyonu Eklendi");
		
	}

}
