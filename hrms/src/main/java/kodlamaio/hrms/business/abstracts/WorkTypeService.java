package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.entities.concretes.WorkType;

public interface WorkTypeService {
	DataResult<List<WorkType>> getAll();
}
