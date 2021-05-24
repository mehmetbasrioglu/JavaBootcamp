package kodlamaio.pinterestclonebackend.business.abstracts;

import java.util.List;

import kodlamaio.pinterestclonebackend.core.DataResult;
import kodlamaio.pinterestclonebackend.entities.concretes.Pin;

public interface PinService {
	DataResult<List<Pin>> getAll();
	
}
