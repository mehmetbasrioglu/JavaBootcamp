package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateSchoolService;
import kodlamaio.hrms.core.utilites.converters.DtoConverterService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.ErrorDataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.core.utilites.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCvDao;
import kodlamaio.hrms.dataAccess.abstracts.CandidateSchoolDao;
import kodlamaio.hrms.entities.concretes.CandidateCv;
import kodlamaio.hrms.entities.concretes.CandidateSchool;
import kodlamaio.hrms.entities.dtos.CandidateSchoolDto;

@Service
public class CandidateSchoolManager implements CandidateSchoolService{

	private CandidateSchoolDao CandidateSchoolDao;
	private CandidateCvDao candidateCvDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public CandidateSchoolManager(CandidateSchoolDao candidateSchoolDao,
			CandidateCvDao candidateCvDao,DtoConverterService dtoConverterService) {
		super();
		CandidateSchoolDao = candidateSchoolDao;
		this.candidateCvDao = candidateCvDao;
		this.dtoConverterService = dtoConverterService;
	}


	@Override
	public DataResult<List<CandidateSchool>> findByCandidateId(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<CandidateSchool>>(this.CandidateSchoolDao.findByCandidateCvId(id));
	}
	
	
	@Override
	public DataResult<List<CandidateSchool>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<CandidateSchool>>(this.CandidateSchoolDao.findAll(),"İş Arayanın Eğitimi Listelendi");
	}


	@Override
	public Result updateSchool(CandidateSchoolDto candidateSchool) {
		// TODO Auto-generated method stub
		CandidateSchool ref =  this.CandidateSchoolDao.findById(candidateSchool.getId());
		
		if(candidateSchool.getGraduationDate() != null) {
			ref.setGraduationDate(candidateSchool.getGraduationDate());
		}
		 if(candidateSchool.getEntryDate() != null) {
			ref.setEntryDate(candidateSchool.getEntryDate());
		}
		 if(candidateSchool.getSchoolName() != null) {
			ref.setSchoolName(candidateSchool.getSchoolName());
		}
		 if(candidateSchool.getDepartment() != null) {
			ref.setDepartment(candidateSchool.getDepartment());
		}
		
		 this.CandidateSchoolDao.save((CandidateSchool) dtoConverterService.dtoClassConverter(ref, CandidateSchool.class));
		
		return new SuccessResult("başarılı");
	}


	@Override
	public DataResult<List<CandidateSchool>> orderedCandidateCvSchools(int id) {
		// TODO Auto-generated method stub
		if(!this.candidateCvDao.existsById(id)) {
			return new ErrorDataResult<>("Cv bulunamadı");
		}
		return new SuccessDataResult<List<CandidateSchool>>(this.CandidateSchoolDao.getSchoolsOrderByGraduationDateDesc(id),"Başarılı Şekilde İş arayanın okul bilgileri listelendi");
	}


	@Override
	public Result add(CandidateSchoolDto school) {
		// TODO Auto-generated method stub
		this.CandidateSchoolDao.save((CandidateSchool) dtoConverterService.dtoClassConverter(school, CandidateSchool.class));
		return new SuccessResult("Başarılı");
	}


	@Override
	public DataResult<List<CandidateSchool>> getBySchoolId(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<CandidateSchool>>(this.CandidateSchoolDao.getById(id),"başarılı");
	}



}
