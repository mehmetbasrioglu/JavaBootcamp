package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateJobExperienceService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.ErrorDataResult;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCvDao;
import kodlamaio.hrms.dataAccess.abstracts.CandidateJobExperienceDao;
import kodlamaio.hrms.entities.concretes.CandidateJobExperience;
import kodlamaio.hrms.entities.concretes.CandidateSchool;

@Service
public class CandidateJobExperienceManager implements CandidateJobExperienceService{

	private CandidateJobExperienceDao candidateJobExperienceDao;

	private CandidateCvDao candidateCvDao;
	
	@Autowired
	public CandidateJobExperienceManager(CandidateJobExperienceDao candidateJobExperienceDao,
			CandidateCvDao candidateCvDao) {
		super();
		this.candidateJobExperienceDao = candidateJobExperienceDao;
		this.candidateCvDao = candidateCvDao;
	}
	
	@Override
	public DataResult<List<CandidateJobExperience>> orderedCandidateCvJobExperience(int id) {
		// TODO Auto-generated method stub
		if(!this.candidateCvDao.existsById(id)) {
			return new ErrorDataResult<>("Cv bulunamadı");
		}
		return new SuccessDataResult<List<CandidateJobExperience>>(this.candidateJobExperienceDao.getJobExperienceOrderByExitDateDesc(id),"Başarılı Şekilde İş arayanın tecrübe bilgileri listelendi");
	}

	@Override
	public DataResult<List<CandidateJobExperience>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<CandidateJobExperience>>(this.candidateJobExperienceDao.findAll(),"Başarılı Şekilde İş adayının deneyimleri listelendi");
	}

}
