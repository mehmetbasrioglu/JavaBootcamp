package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CandidateJobExperience;

public interface CandidateJobExperienceDao extends JpaRepository<CandidateJobExperience, Integer>{

}
