package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kodlamaio.hrms.business.abstracts.FavouriteService;
import kodlamaio.hrms.core.utilites.converters.DtoConverterService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.core.utilites.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.FavouritesDao;
import kodlamaio.hrms.entities.concretes.Favourites;
import kodlamaio.hrms.entities.dtos.FavouritesDto;

@Component
public class FavouriteManager implements FavouriteService{
	private FavouritesDao favsDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public FavouriteManager(FavouritesDao favsDao,DtoConverterService dtoConverterService) {
		this.favsDao = favsDao;
		this.dtoConverterService = dtoConverterService;
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
	
	@Override
	public Result add(FavouritesDto favdto) {
		// TODO Auto-generated method stub
		this.favsDao.save((Favourites) this.dtoConverterService.dtoClassConverter(favdto, Favourites.class));
		return new SuccessResult("başarılı ile favori eklendi");
	}
	@Override
	public Result delete(int id, int jobId) {
		// TODO Auto-generated method stub
		this.favsDao.deleteByCandidateIdAndJobId(id,jobId);
		return new SuccessResult("başarılı");
	}
	@Override
	public DataResult<List<Favourites>> findByCandidateId(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Favourites>>(this.favsDao.findByCandidateId(id),"başarılı");
	}
	
	
}
