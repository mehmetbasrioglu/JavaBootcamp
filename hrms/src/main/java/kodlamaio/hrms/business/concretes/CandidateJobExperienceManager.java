package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateJobExperienceService;
import kodlamaio.hrms.core.utilites.converters.DtoConverterService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.ErrorDataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.core.utilites.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCvDao;
import kodlamaio.hrms.dataAccess.abstracts.CandidateJobExperienceDao;
import kodlamaio.hrms.entities.concretes.CandidateJobExperience;
import kodlamaio.hrms.entities.concretes.CandidateSchool;
import kodlamaio.hrms.entities.dtos.CandidateJobExperienceDto;

@Service
public class CandidateJobExperienceManager implements CandidateJobExperienceService{

	private CandidateJobExperienceDao candidateJobExperienceDao;

	private CandidateCvDao candidateCvDao;
	
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public CandidateJobExperienceManager(CandidateJobExperienceDao candidateJobExperienceDao,
			CandidateCvDao candidateCvDao,DtoConverterService dtoConverterService) {
		super();
		this.candidateJobExperienceDao = candidateJobExperienceDao;
		this.candidateCvDao = candidateCvDao;
		this.dtoConverterService = dtoConverterService;
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

	@Override
	public Result add(CandidateJobExperienceDto jobExp) {
		// TODO Auto-generated method stub
		this.candidateJobExperienceDao.save((CandidateJobExperience) this.dtoConverterService.dtoClassConverter(jobExp, CandidateJobExperience.class));
		return new SuccessResult("Başarılı");
	}

	@Override
	public DataResult<List<CandidateJobExperience>> getById(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<CandidateJobExperience>>(this.candidateJobExperienceDao.getById(id),"başarılı");
	}

	@Override
	public Result update(CandidateJobExperienceDto jobExp) {
		// TODO Auto-generated method stub
		CandidateJobExperience ref = this.candidateJobExperienceDao.findById(jobExp.getId());
		if(jobExp.getWorkplaceName() != null) {
			ref.setWorkplaceName(jobExp.getWorkplaceName());
		}
		
		if(jobExp.getEntryDate() != null) {
			ref.setEntryDate(jobExp.getEntryDate());
		}
		
		if(jobExp.getExitDate() != null) {
			ref.setExitDate(jobExp.getExitDate());
		}
		
		if(jobExp.getJobDetail() != null) {
			ref.setJobDetail(jobExp.getJobDetail());
		}
		
		
		this.candidateJobExperienceDao.save(ref);
		
		
		return new SuccessResult("id:"+ref.getWorkplaceName());
	}


}
