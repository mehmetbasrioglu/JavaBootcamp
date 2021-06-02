package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CandidateTalent;

public interface CandidateTalentDao extends JpaRepository<CandidateTalent, Integer>{

}
