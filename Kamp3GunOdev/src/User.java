
public class User {
	private int id;
	private String firstName;
	private String lastName;
	private Vote[] rating;
	




	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 */
	public User(int id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	
	
	public User() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	

	public Vote[] getRating() {
		return rating;
	}



	public void setRating(Vote[] rating) {
		this.rating = rating;
	}

	
	
	
}
