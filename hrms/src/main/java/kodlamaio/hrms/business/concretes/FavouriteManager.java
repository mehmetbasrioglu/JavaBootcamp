package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kodlamaio.hrms.business.abstracts.FavouriteService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.FavouritesDao;
import kodlamaio.hrms.entities.concretes.Favourites;

@Component
public class FavouriteManager implements FavouriteService{
	private FavouritesDao favsDao;
	@Autowired
	public FavouriteManager(FavouritesDao favsDao) {
		this.favsDao = favsDao;
	}
	@Override
	public DataResult<List<Favourites>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Favourites>>(this.favsDao.findAll(),"başarılı");
	}
	@Override
	public DataResult<Favourites> findByCandidateIdAndJobId(int id,int jobId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Favourites>(this.favsDao.findByCandidateIdAndJobId(id,jobId),"başarılı");
	}
	
	
}
