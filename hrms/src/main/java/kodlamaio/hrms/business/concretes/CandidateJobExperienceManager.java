package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateJobExperienceService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateJobExperienceDao;
import kodlamaio.hrms.entities.concretes.CandidateJobExperience;

@Service
public class CandidateJobExperienceManager implements CandidateJobExperienceService{

	private CandidateJobExperienceDao candidateJobExperienceDao;
	
	@Autowired
	public CandidateJobExperienceManager(CandidateJobExperienceDao candidateJobExperienceDao) {
		super();
		this.candidateJobExperienceDao = candidateJobExperienceDao;
	}

	@Override
	public DataResult<List<CandidateJobExperience>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<CandidateJobExperience>>(this.candidateJobExperienceDao.findAll(),"Başarılı Şekilde İş adayının deneyimleri listelendi");
	}

}
