package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilites.business.BusinessEngine;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.ErrorDataResult;
import kodlamaio.hrms.core.utilites.results.ErrorResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.core.utilites.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
	
	private JobAdvertisementDao jobAdvertisementDao;

	private EmployerDao employerDao;
	
	private CityDao cityDao;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao,EmployerDao employerDao, CityDao cityDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.employerDao = employerDao;
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findAll(),"data listelendi");
		
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		
		Result engine = BusinessEngine.run(
				findEmployer(jobAdvertisement),
				findCity(jobAdvertisement),
				descriptionNullChecker(jobAdvertisement),
				ifMinSalaryNull(jobAdvertisement),
				ifMaxSalaryNull(jobAdvertisement),
				minSalaryChecker(jobAdvertisement),
				maxSalaryChecker(jobAdvertisement),
				 ifMinSalaryEqualsMaxSalary(jobAdvertisement) ,
				 ifQuotaSmallerThanOne(jobAdvertisement),
				 appealExpirationChecker( jobAdvertisement)
				);
		if(!engine.isSuccess()) {
			return new ErrorResult(engine.getMessage());
		}
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("eklendi");
		
	
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> findAllByIsActive() {
		// TODO Auto-generated method stub
		return new SuccessDataResult <List<JobAdvertisement>>(this.jobAdvertisementDao.findAllByIsActive(true),"Başarılı");
	}

	@Override
	public DataResult<List<JobAdvertisement>> findAllByIsActiveSorted() {
		// TODO Auto-generated method stub
		return new SuccessDataResult <List<JobAdvertisement>>(this.jobAdvertisementDao.findAllByIsActiveOrderByCreatedDateDesc(true),"Başarılı");
		
	}

	@Override
	public DataResult<List<JobAdvertisement>> findAllByIsActiveAndCompanyName(int id) {
		// TODO Auto-generated method stub
		if(!this.employerDao.existsById(id)) {
			return new ErrorDataResult("Hata: İş veren bulunamadı");
		}
		else {
			return new SuccessDataResult <List<JobAdvertisement>>(this.jobAdvertisementDao.getEmployersActiveJobAdvertisement(id),"Başarılı");
		}
	}

	@Override
	public DataResult<JobAdvertisement> setJobAdvertisementDisabled(int id) {
		// TODO Auto-generated method stub
		if(!this.jobAdvertisementDao.existsById(id)) {
			return new ErrorDataResult("Hata: İş veren bulunamadı");
		}
		JobAdvertisement ref =  this.jobAdvertisementDao.getOne(id);
		ref.setActive(false);
		return new SuccessDataResult <JobAdvertisement>(this.jobAdvertisementDao.save(ref),"İş İlanı Pasif olarak ayarlandı");
		
	}
	

	
	private Result findEmployer(JobAdvertisement jobAdvertisement) {
		if(!this.employerDao.existsById(jobAdvertisement.getEmployer().getId())) {
			return new ErrorResult("İş veren bulunamadı");
		}
		return new SuccessResult();
	}
	
	
	private Result findCity(JobAdvertisement jobAdvertisement) {
		if(!this.cityDao.existsById(jobAdvertisement.getCity().getId())) {
			return new ErrorResult("Şehir bulunamadı");
		}
		return new SuccessResult();
	}
	
	private Result descriptionNullChecker(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.getDescription().isEmpty()) {
			return new ErrorResult("İş Tanımı Boş Bırakılamaz");
		}
		return new SuccessResult();
	}
	
	private Result ifMinSalaryNull(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.getMinSalary() == null) {
			return new ErrorResult("Minimum Maaş Girilmek Zorundadır");
		}
		return new SuccessResult();
	}
	
	
	private Result ifMaxSalaryNull(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.getMaxSalary() == null) {
			return new ErrorResult("Maksimum Maaş Girilmek Zorundadır");
		}
		return new SuccessResult();
	}
	
	private Result minSalaryChecker(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.getMinSalary() == 0) {
			return new ErrorResult("Minimum Maaş 0 verilemez");
		}
		return new SuccessResult();
	}
	
	private Result maxSalaryChecker(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.getMaxSalary() == 0) {
			return new ErrorResult("Maksimum Maaş 0 verilemez");
		}
		return new SuccessResult();
	}
	
	private Result ifMinSalaryEqualsMaxSalary(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.getMinSalary() >= jobAdvertisement.getMaxSalary()) {
			return new ErrorResult("Minimum Maaş Maksimum Maaşa eşit olamaz");
		}
		return new SuccessResult();
	}
	
	private Result ifQuotaSmallerThanOne(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.getQuota() < 1) {
			return new ErrorResult("Açık pozisyon adedi 1 den küçük olamaz");
		}
		return new SuccessResult();
	}
	
	private Result appealExpirationChecker(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.getAppealExpirationDate() == null) {
			return new ErrorResult("Son Başvuru Tarihi Girilmek Zorundadır");
		}
		return new SuccessResult();
	}
	
	


}
