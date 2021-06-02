package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Talent;

public interface TalentDao extends JpaRepository<Talent, Integer>{

}
