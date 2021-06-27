package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateSchoolDto {
	private int id;
	private String schoolName;
	private LocalDate entryDate;
	private LocalDate graduationDate;
	private String department;
	private int candidateCvId;
}
