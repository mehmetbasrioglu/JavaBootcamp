package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateCvService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.core.utilites.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCvDao;
import kodlamaio.hrms.dataAccess.abstracts.CandidateJobExperienceDao;
import kodlamaio.hrms.dataAccess.abstracts.CandidateLanguageDao;
import kodlamaio.hrms.dataAccess.abstracts.CandidateSchoolDao;
import kodlamaio.hrms.dataAccess.abstracts.CandidateTalentDao;
import kodlamaio.hrms.entities.concretes.CandidateCv;
import kodlamaio.hrms.entities.concretes.CandidateJobExperience;
import kodlamaio.hrms.entities.concretes.CandidateLanguage;
import kodlamaio.hrms.entities.concretes.CandidateSchool;
import kodlamaio.hrms.entities.concretes.CandidateTalent;

@Service
public class CandidateCvManager implements CandidateCvService{

	private CandidateCvDao candidateCvDao;
	private CandidateSchoolDao candidateSchoolDao;
	private CandidateTalentDao candidateTalentDao;
	private CandidateLanguageDao candidateLanguageDao;
	private CandidateJobExperienceDao candidateJobExperienceDao;
	
	@Autowired
	public CandidateCvManager(CandidateCvDao candidateCvDao,
			CandidateSchoolDao candidateSchoolDao,
			CandidateTalentDao candidateTalentDao,
			CandidateLanguageDao candidateLanguageDao,
			CandidateJobExperienceDao candidateJobExperienceDao) {
		this.candidateCvDao = candidateCvDao;
		this.candidateSchoolDao = candidateSchoolDao;
		this.candidateTalentDao = candidateTalentDao;
		this.candidateLanguageDao = candidateLanguageDao;
		this.candidateJobExperienceDao = candidateJobExperienceDao;
	}
	
	@Override
	public DataResult<List<CandidateCv>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<CandidateCv>>(this.candidateCvDao.findAll(),"İş Arayan Cv si listelendi");
	}

	@Override
	public Result add(CandidateCv candidateCv) {
		CandidateCv temporaryRef = candidateCvDao.save(candidateCv);
		
		
		setCvSchoolId(temporaryRef.getSchools(), temporaryRef);
		setCvTalentId(temporaryRef.getTalents(), temporaryRef);
		setCvLanguageId(temporaryRef.getLanguages(), temporaryRef);
		setCvJobExperienceId(temporaryRef.getJobExperience(), temporaryRef);
		
		System.out.println("Okul:"+candidateCv.getSchools().size());
		System.out.println("Dil:"+candidateCv.getLanguages().size());
		System.out.println("Yetenek:"+candidateCv.getTalents().size());
		System.out.println("İş Deneyimi:"+candidateCv.getJobExperience().size());
		
		
		
		
		return new SuccessResult("İş Arayan Cv si eklendi");
	}
	

	@Override
	public DataResult<List<CandidateCv>> findByCandidateId(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<CandidateCv>>(this.candidateCvDao.findByCandidateId(id));
	}
	

	private void setCvSchoolId(List<CandidateSchool> sc , CandidateCv cv) {
		for (CandidateSchool candidateSchool : sc) {
			candidateSchool.setCandidateCv(cv);
			candidateSchoolDao.save(candidateSchool);
		}
	}
	
	private void setCvTalentId(List<CandidateTalent> sc , CandidateCv cv) {
		for (CandidateTalent candidateTalent : sc) {
			candidateTalent.setCandidateCv(cv);
			candidateTalentDao.save(candidateTalent);
		}
	}
	
	private void setCvLanguageId(List<CandidateLanguage> sc , CandidateCv cv) {
		for (CandidateLanguage data : sc) {
			data.setCandidateCv(cv);
			candidateLanguageDao.save(data);
		}
	}
	
	private void setCvJobExperienceId(List<CandidateJobExperience> sc , CandidateCv cv) {
		for (CandidateJobExperience data : sc) {
			data.setCandidateCv(cv);
			candidateJobExperienceDao.save(data);
		}
	}

 

}
