package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.entities.concretes.Favourites;

public interface FavouriteService {
	DataResult<List<Favourites>> getAll();
	
	DataResult<Favourites> findByCandidateIdAndJobId(int id,int jobId);
}
