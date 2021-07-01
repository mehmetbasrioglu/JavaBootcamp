package kodlamaio.hrms.entities.dtos;

import java.sql.Date;

import kodlamaio.hrms.entities.dtos.abstracts.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerDto extends UserDto{
	private int id;
	private String company_name;
	private String webAddress;
	private String phoneNumber;
	private String avatarUrl;
	private String industry;
	private Date foundYear;
}
