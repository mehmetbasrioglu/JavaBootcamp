package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer>{
	
	List<Candidate> findAllByEmail(String email);
	List<Candidate> findAllByIdentificationNumber(String identificationNumber);
}
