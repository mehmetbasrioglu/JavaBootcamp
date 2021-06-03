package kodlamaio.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="candidates_job_experiences")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","candidateCv"})
public class CandidateJobExperience {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="workplace_name")
	private String workplaceName;
	@Column(name="entry_date")
	private Date entryDate;
	@Column(name="exit_date")
	private Date exitDate;
	@ManyToOne
	  @JoinColumn(name = "job_titles_id")
	   private JobTitle jobtitle;
	 
	/**
	 * 
	@Column(name="candidates_cv_id")
	private int candidateCvIds;
	
	 */
	@JsonProperty(access = Access.WRITE_ONLY)
    @ManyToOne()
    @JoinColumn(name="candidates_cv_id")
    //@NotFound(action=NotFoundAction.IGNORE)
    private CandidateCv candidateCv;
	
	@Column(name="is_continue")
	private boolean isContinue;
	
}
