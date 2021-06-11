package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WorkHourService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.WorkHourDao;
import kodlamaio.hrms.entities.concretes.WorkHour;

@Service
public class WorkHourManager implements WorkHourService{


	private WorkHourDao workHourDao;
	

	@Autowired
	public WorkHourManager(WorkHourDao workHourDao) {
		super();
		this.workHourDao = workHourDao;
	}
	
	@Override
	public DataResult<List<WorkHour>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<WorkHour>>(this.workHourDao.findAll(),"Başarılı Şekilde Çalışma Saatleri Listelendi");
	}

}
