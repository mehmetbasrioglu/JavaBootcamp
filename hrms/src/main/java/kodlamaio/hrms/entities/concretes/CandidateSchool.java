package kodlamaio.hrms.entities.concretes;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="candidates_cv_school")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","candidateCv"})
public class CandidateSchool {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="school_name")
	private String schoolName;
	@Column(name="entry_date")
	private LocalDate entryDate;
	@Column(name="graduation_date")
	private LocalDate graduationDate;
	@Column(name="department")
	private String department;
	
	/*
	 * 
	 * 
	@Column(name="candidates_cv_id")
	private int candidateCvIds;
	
	 */
	
//	@JsonProperty(access = Access.WRITE_ONLY)
    @ManyToOne(targetEntity = CandidateCv.class)
    @JoinColumn(name="candidates_cv_id")
    private CandidateCv candidateCv;
	
	
	@Column(name="is_continue")
	private boolean isContinue;
	
	
	
}
