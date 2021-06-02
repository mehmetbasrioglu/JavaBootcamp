package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="candidates_cv")
public class CandidateCv {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="candidate_id")
	private int candidateId;
	@Column(name="linkedin_address")
	private String linkedinAddress;
	@Column(name="github_address")
	private String githubAddress;
	@Column(name="cover_letter")
	private String coverLetter;
	@Column(name="is_active")
	private boolean isActive;
	@Column(name="avatar_url")
	private String avatarUrl;
	//candidates_cv_school_id
	
	/**
	 * @Column(name="candidates_cv_school_id")
	private int candidatesCvSchoolId;
	 */
	
	@OneToMany(mappedBy = "candidateCv", fetch = FetchType.LAZY)
    private List<CandidateSchool> schools;
	
	@OneToMany(mappedBy = "candidateCv", fetch = FetchType.LAZY)
    private List<CandidateTalent> talents;
	
	@OneToMany(mappedBy = "candidateCv", fetch = FetchType.LAZY)
    private List<CandidateJobExperience> jobExperience;
	
	@OneToMany(mappedBy = "candidateCv", fetch = FetchType.LAZY)
    private List<CandidateLanguage> languages;
	
	
	
	
}
