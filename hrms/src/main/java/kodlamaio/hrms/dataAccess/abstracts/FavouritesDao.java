package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.Favourites;

public interface FavouritesDao extends JpaRepository<Favourites, Integer>{
	@Query(value="select * from favs where candidate_id =:id and job_advertisement_id=:jobId",nativeQuery=true)
	Favourites findByCandidateIdAndJobId(int id,int jobId);
}
