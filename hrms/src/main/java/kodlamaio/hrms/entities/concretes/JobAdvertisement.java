package kodlamaio.hrms.entities.concretes;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="job_advertisements")
@Entity
public class JobAdvertisement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	/*
	 * @Column(name="employer_id")
	private int employerId;
	 */
	
/*
 * 	@Column(name="job_title_id")
	private int jobtitleId;
 */
	
//	@Column(name="city_id")
//	private int cityId;
	
	@Column(name="description")
	private String description;
	@Column(name="quota")
	private int quota;
	//appeal_expiration_date
	@Column(name="appeal_expiration_date")
	private LocalDateTime appealExpirationDate;
	
	@Column(name="created_date")
	private LocalDateTime createdDate;
	
	@Column(name="min_salary")
	private Double minSalary;
	
	@Column(name="max_salary")
	private Double maxSalary;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@Column(name="is_confirmed_by_admin")
	private boolean isConfirmed;
	
	 @ManyToOne
	  @JoinColumn(name = "city_id")
	   private City city;
	 
	 @ManyToOne
	  @JoinColumn(name = "job_title_id")
	   private JobTitle jobtitle;
	 
	 @ManyToOne
	  @JoinColumn(name = "employer_id")
	   private Employer employer;
	 
	 @ManyToOne
	  @JoinColumn(name = "work_hours_id")
	   private WorkHour workHour;
	 
	 @ManyToOne
	  @JoinColumn(name = "work_types_id")
	   private WorkType workType;
	 
	 @JsonIgnore
	 @OneToMany(mappedBy = "jobAdvertisement", fetch = FetchType.LAZY)
	    private List<Favourites> favourites;
	 
	 
	
	
	
	
	
}
