package kodlamaio.hrms.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.EmployerUpdateStatusService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilites.IdentityValidation;
import kodlamaio.hrms.core.utilites.business.BusinessEngine;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.ErrorDataResult;
import kodlamaio.hrms.core.utilites.results.ErrorResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.core.utilites.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerUpdateStatusDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.EmployerUpdateStatus;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class EmployerUpdateStatusManager implements EmployerUpdateStatusService{
	
	private EmployerUpdateStatusDao employerUpdateStatusDao;
	private EmployerService employerService;
	private UserService userService;
	
	@Autowired
	public EmployerUpdateStatusManager(
			EmployerUpdateStatusDao employerUpdateStatusDao,
			EmployerService employerService,UserService userService) 
	{
		this.employerUpdateStatusDao = employerUpdateStatusDao;
		this.employerService = employerService;
		this.userService = userService;
		
	}

	@Override
	public Result add(EmployerUpdateStatus employer) {

		if(this.employerUpdateStatusDao.existsByEmployerId(employer.getEmployerId())) {
			return new ErrorResult("Bekleyen Güncelleme İsteği Var !");
		}
		else {
			this.employerUpdateStatusDao.save(employer);
			//System.out.println(employer.getUpdate());
			return new SuccessResult("test");
		}
	}

	@Override
	public DataResult<List<EmployerUpdateStatus>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<EmployerUpdateStatus>> (this.employerUpdateStatusDao.findAll(),"başarılı");
	}

	@Override
	public DataResult<EmployerUpdateStatus> findByEmployerId(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<EmployerUpdateStatus>(this.employerUpdateStatusDao.findByEmployerId(id),"başarılı");
	}

	@Override
	public Result confirm(int id) {
		Employer ref = this.employerService.findByEmployerId(id);
		EmployerUpdateStatus newDataRef = getNewData(id);
		
		if(newDataRef != null) {

			Result engine = BusinessEngine.run(existsByEmployerId(id),updateChecker(ref,newDataRef));
			if(!engine.isSuccess()) {
				return new ErrorDataResult(null,engine.getMessage());
			}
			
			return new SuccessResult();
		}
		
		return new ErrorResult("İşverenin güncelleme isteği bulunamadı");
		
		
	}
	
	
	private Result existsByEmployerId(int id) {
		if(this.employerUpdateStatusDao.existsByEmployerId(id)) {
			return new SuccessResult();
		}
		return new ErrorResult("İşveren isteği bulunamadı");
		
	}
	
	private Result updateChecker(Employer ref,EmployerUpdateStatus newDataRef) {
		if(newDataRef.getUpdate().getCompany_name() != null && newDataRef.getUpdate().getCompany_name() != "") {
			ref.setCompanyName(newDataRef.getUpdate().getCompany_name());
		}
		 if(newDataRef.getUpdate().getEmail() != null && newDataRef.getUpdate().getEmail() != "") {
			ref.setEmail(newDataRef.getUpdate().getEmail());
		}
		
		 if(newDataRef.getUpdate().getPassword() != null && newDataRef.getUpdate().getPassword() != "") {
			ref.setPassword(newDataRef.getUpdate().getPassword());
		}
		
		 if(newDataRef.getUpdate().getPhoneNumber() != null && newDataRef.getUpdate().getPhoneNumber() != "") {
			ref.setPhoneNumber(newDataRef.getUpdate().getPhoneNumber());
		}
		
		 if(newDataRef.getUpdate().getWebAddress() != null && newDataRef.getUpdate().getWebAddress() != "") {
			ref.setWebAdress(newDataRef.getUpdate().getWebAddress());
		}
		 this.employerService.update(ref);
		 this.employerUpdateStatusDao.delete(newDataRef);
		 return new SuccessResult();
	}

	
	private EmployerUpdateStatus getNewData(int employerId) {
		return this.employerUpdateStatusDao.findByEmployerId(employerId);
	}
}
