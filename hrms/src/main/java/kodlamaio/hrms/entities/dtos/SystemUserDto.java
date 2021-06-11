package kodlamaio.hrms.entities.dtos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import kodlamaio.hrms.entities.concretes.SystemUser;
import kodlamaio.hrms.entities.concretes.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="system_users")
public class SystemUserDto {
	
	@Id
	@Column(name="id")
	private int id;
	@Column(name="user_id")
	private int userId;
	
	
}
