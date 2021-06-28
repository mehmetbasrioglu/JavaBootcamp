package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.entities.concretes.Favourites;
import kodlamaio.hrms.entities.dtos.FavouritesDto;

public interface FavouriteService {
	DataResult<List<Favourites>> getAll();
	
	DataResult<Favourites> findByCandidateIdAndJobId(int id,int jobId);
	
	
	Result add(FavouritesDto favdto); 
	
	Result delete(int id,int jobId);

	DataResult<List<Favourites>> findByCandidateId(int id);
	
	
}
