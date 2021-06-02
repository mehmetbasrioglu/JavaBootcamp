package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.entities.concretes.Talent;

public interface TalentService {
	DataResult<List<Talent>> getAll();
}
