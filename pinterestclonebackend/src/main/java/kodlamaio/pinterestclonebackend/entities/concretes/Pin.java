package kodlamaio.pinterestclonebackend.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="pins")
@NoArgsConstructor
@AllArgsConstructor
public class Pin {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="user_id")
	private int userId;
	@Column(name="image_url")
	private String imageUrl;
	@Column(name="image_header")
	private String imageHeader;
	@Column(name="detail")
	private String detail;
}
