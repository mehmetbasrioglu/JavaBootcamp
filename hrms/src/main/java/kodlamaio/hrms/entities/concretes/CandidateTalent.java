package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="candidates_talent")
public class CandidateTalent {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@JsonProperty(access = Access.WRITE_ONLY)
    @ManyToOne(targetEntity = CandidateCv.class)
    @JoinColumn(name="candidates_cv_id")
    private CandidateCv candidateCv;
	
	/*
	 * @Column(name="talents_id")
	private int talentsId;
	 */
	
	@ManyToOne
	  @JoinColumn(name = "talents_id")
	   private Talent talent;
}
