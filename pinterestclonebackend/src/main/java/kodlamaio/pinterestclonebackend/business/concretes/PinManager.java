package kodlamaio.pinterestclonebackend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.pinterestclonebackend.business.abstracts.PinService;
import kodlamaio.pinterestclonebackend.core.DataResult;
import kodlamaio.pinterestclonebackend.core.SuccessDataResult;
import kodlamaio.pinterestclonebackend.dataAccess.abstracts.PinDao;
import kodlamaio.pinterestclonebackend.entities.concretes.Pin;

@Service
public class PinManager implements PinService{
	@Autowired
	private PinDao pinDao;

	public PinManager(PinDao pinDao) {
		super();
		this.pinDao = pinDao;
	}

	@Override
	public DataResult<List<Pin>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Pin>>(this.pinDao.findAll(),"başarılı");
	}
	
	
	
}
