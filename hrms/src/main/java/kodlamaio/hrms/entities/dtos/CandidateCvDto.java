package kodlamaio.hrms.entities.dtos;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateCvDto {
	private int id;
	private int candidateId;
	private String linkedinAddress;
	private String githubAddress;
	private String coverLetter;
	private boolean isActive;
	private String avatarUrl;
}
