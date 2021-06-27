package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateLanguageService;
import kodlamaio.hrms.core.utilites.converters.DtoConverterService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.ErrorResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.core.utilites.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateLanguageDao;
import kodlamaio.hrms.entities.concretes.CandidateLanguage;
import kodlamaio.hrms.entities.dtos.CandidateLanguageDto;

@Service
public class CandidateLanguageManager implements CandidateLanguageService{
	


	private CandidateLanguageDao candidateLanguageDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public CandidateLanguageManager(CandidateLanguageDao candidateLanguageDao,DtoConverterService dtoConverterService) {
		super();
		this.candidateLanguageDao = candidateLanguageDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public DataResult<List<CandidateLanguage>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<CandidateLanguage>>(this.candidateLanguageDao.findAll(),"Başarılı");
	}

	@Override
	public Result add(CandidateLanguageDto lang) {
		// TODO Auto-generated method stub
		if(this.candidateLanguageDao.existsCvIdAndLangId(lang.getCandidateCvId(), lang.getLanguageId()) != null) {
			return new ErrorResult("Daha önceden eklenmiş");
		}
		this.candidateLanguageDao.save((CandidateLanguage) dtoConverterService.dtoClassConverter(lang, CandidateLanguage.class));
		return new SuccessResult("Başarılı");
	}

	@Override
	public Result update(int cvId, int langId,int level) {
		// TODO Auto-generated method stub
		CandidateLanguage ref = this.candidateLanguageDao.getByCandidateCvIdAndLanguageId(cvId,langId);
		ref.setLevel(level);
		this.candidateLanguageDao.save(ref);
		return new SuccessResult(""+ref.getLevel());
	}

}
