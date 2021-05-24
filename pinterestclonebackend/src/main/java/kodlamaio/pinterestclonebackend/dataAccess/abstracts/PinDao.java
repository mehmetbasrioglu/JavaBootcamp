package kodlamaio.pinterestclonebackend.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.pinterestclonebackend.entities.concretes.Pin;

public interface PinDao extends JpaRepository<Pin, Integer>{

}
