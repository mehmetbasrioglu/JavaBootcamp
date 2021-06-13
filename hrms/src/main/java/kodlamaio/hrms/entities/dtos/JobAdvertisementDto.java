package kodlamaio.hrms.entities.dtos;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.hrms.entities.concretes.City;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.concretes.JobTitle;
import kodlamaio.hrms.entities.concretes.WorkHour;
import kodlamaio.hrms.entities.concretes.WorkType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class JobAdvertisementDto {
	
	@JsonIgnore
	private int id;
	
	private int employerId;
	
	private int jobtitleId;

	private int cityId;
	
	private String description;
	private int quota;
	
	//Kapanma Tarihi
	private LocalDateTime appealExpirationDate;
	
	private LocalDateTime createdDate=LocalDateTime.now();
	
	private Double minSalary;
	
	private Double maxSalary;
	
	private boolean isActive;
	
	private boolean isConfirmed;
	
	private int workHourId;
	
	private int workTypeId;
	

	
	
}
