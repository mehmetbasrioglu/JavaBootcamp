package kodlamaio.hrms.entities.dtos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateJobExperienceDto {
	private int id;
	private String workplaceName;
	private Date entryDate;
	private Date exitDate;
	private int jobTitleId;
	private int cvId;
	private boolean isContinue;
	private String jobDetail;
	
}
