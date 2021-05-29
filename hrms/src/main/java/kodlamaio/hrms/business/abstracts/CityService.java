package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.entities.concretes.City;

public interface CityService {
	DataResult<List<City>> getAll();

	DataResult<City> add(City city);
}
