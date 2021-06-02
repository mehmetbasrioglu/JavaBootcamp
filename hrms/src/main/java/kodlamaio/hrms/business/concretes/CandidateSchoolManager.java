package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateSchoolService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateSchoolDao;
import kodlamaio.hrms.entities.concretes.CandidateCv;
import kodlamaio.hrms.entities.concretes.CandidateSchool;

@Service
public class CandidateSchoolManager implements CandidateSchoolService{

	private CandidateSchoolDao CandidateSchoolDao;
	
	@Autowired
	public CandidateSchoolManager(CandidateSchoolDao candidateSchoolDao) {
		super();
		CandidateSchoolDao = candidateSchoolDao;
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
	public DataResult<CandidateSchool> updateSchool(CandidateSchool candidateSchool) {
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
		
		return new SuccessDataResult<CandidateSchool>(this.CandidateSchoolDao.save(ref),"Başarılı şekilde update oldu");
	}



}
