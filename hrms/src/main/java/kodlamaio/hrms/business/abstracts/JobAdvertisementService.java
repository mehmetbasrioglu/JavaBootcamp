package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.data.domain.Page;

import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementService {
DataResult<List<JobAdvertisement>> getAll();
	
	Result add(JobAdvertisementDto jobAdvertisement);
	
	DataResult<List<JobAdvertisement>> findAllByIsActive();
	
	DataResult<List<JobAdvertisement>> findAllByIsActiveSorted();
	
	DataResult<List<JobAdvertisement>> findAllByIsActiveAndCompanyName(int id);
	
	DataResult<JobAdvertisement> setJobAdvertisementDisabled(int id);
	
	DataResult<List<JobAdvertisement>> getConfirmedJobAdvertisements();
	
	DataResult<List<JobAdvertisement>> getByEmployerIdAndActiveJobAdvertisementAndConfirmed(int employerId);
	
	DataResult<List<JobAdvertisement>> getConfirmedJobAdvertisementsWithPageable(int pageNo, int pageSize);
	
	DataResult<List<JobAdvertisement>> getWaitingJobAdvertisements();
	
	DataResult<List<JobAdvertisement>> getOneJobAds(int id);
	
	Result confirmJobAd(int id);

	DataResult<List<JobAdvertisement>> getFilter(JobAdvertisement jobAds);
	
	
}
