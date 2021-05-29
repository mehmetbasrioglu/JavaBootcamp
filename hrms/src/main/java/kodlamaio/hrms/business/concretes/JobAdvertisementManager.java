package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilites.results.DataResult;
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
		
		if(!this.employerDao.existsById(jobAdvertisement.getEmployer().getId())) {
			return new ErrorResult("Hata: İş veren bulunamadı");
		}
		
		else if(!this.cityDao.existsById(jobAdvertisement.getCity().getId())){
			return new ErrorResult("Hata: Şehir Bulunamadı");
		}
		
		else if(jobAdvertisement.getDescription().isEmpty()){
			return new ErrorResult("Hata: İlan İçeriği Boş Bırakılamaz");
		}
		
		else if(jobAdvertisement.getMinSalary() == null){
			return new ErrorResult("Hata: Minimum Maaş Girilmek Zorundadır");
		}
		
		else if(jobAdvertisement.getMaxSalary() == null){
			return new ErrorResult("Hata: Maksimum Maaş Girilmek Zorundadır");
		}
		
		else if(jobAdvertisement.getMinSalary() == 0){
			return new ErrorResult("Hata: Minimum Maaş Sıfırdan Büyük Olmalıdır");
		}
		
		else if(jobAdvertisement.getMaxSalary() == 0){
			return new ErrorResult("Hata: Maksimum Maaş Sıfırdan Büyük Olmalıdır");
		}
		
		else if(jobAdvertisement.getMinSalary() >= jobAdvertisement.getMaxSalary()){
			return new ErrorResult("Hata: Minimum Maaş Büyük  ve Eşit Olamaz");
		}
		
		
		else if(jobAdvertisement.getQuota() < 1){
			return new ErrorResult("Hata: Açık pozisyon adedi en az 1 olmak zorundadır.");
		}
//2021-05-29T13:17:26.477Z
		else if(jobAdvertisement.getAppealExpirationDate() == null){
			return new ErrorResult("Hata: Son Başvuru Tarihi Girilmek Zorundadır");
		}
		
		
		else {
			this.jobAdvertisementDao.save(jobAdvertisement);
			return new SuccessResult("eklendi");
		}
			
	
	}

	@Override
	public List<JobAdvertisement> findAllByIsActive() {
		// TODO Auto-generated method stub
		return this.jobAdvertisementDao.findAllByIsActive(true);
	}

	@Override
	public List<JobAdvertisement> findAllByIsActiveSorted() {
		// TODO Auto-generated method stub
		Sort sort = Sort.by(Sort.Direction.DESC,"created_date");
		return this.jobAdvertisementDao.findAllByIsActiveOrderByCreatedDateDesc(true);
		
	}

}
