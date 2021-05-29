package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilites.business.BusinessEngine;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.ErrorDataResult;
import kodlamaio.hrms.core.utilites.results.ErrorResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.core.utilites.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.entities.concretes.City;

@Service
public class CityManager implements CityService{
	
	private CityDao cityDao;
	
	@Autowired
	public CityManager(CityDao cityDao) {
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> getAll() {
		// TODO Auto-generated method stub
		//Result engine = BusinessEngine.run(null);
		return new SuccessDataResult<List<City>>(this.cityDao.findAll(),"Başarılı Şekilde Şehirler Listelendi");
	}

	@Override
	public DataResult<City> add(City city) {
		// TODO Auto-generated method stub
		Result engine = BusinessEngine.run(cityNameChecker(city));
		if(!engine.isSuccess()) {
			return new ErrorDataResult(null,engine.getMessage());
		}
		return new SuccessDataResult<City>(this.cityDao.save(city),"Başarılı Şekilde Eklendi");
	}
	
	private Result cityNameChecker(City city) {
		if(city.getCityName().isEmpty() || city.getCityName().isBlank()) {
			return new ErrorResult("Şehir Adı Girilmek Zorunda");
		}
		return new SuccessResult();
	}
	

}
