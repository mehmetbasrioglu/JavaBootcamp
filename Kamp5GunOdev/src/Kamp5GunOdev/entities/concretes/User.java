package Kamp5GunOdev.entities.concretes;

import Kamp5GunOdev.entities.abstracts.Entity;

public class User implements Entity {
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String verificationCode;
	private boolean isVerified;
	


	public User() {
		
	}
	

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param password
	 */
	public User(Integer id, String firstName, String lastName, String email, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getIsVerified() {
		return isVerified;
	}


	public void setIsVerified(Boolean isVerified) {
		this.isVerified = isVerified;
	}


	public String getVerificationCode() {
		return this.verificationCode =  this.id +"" +this.firstName.substring(0, 1) + ""+(int)Math.floor(Math.random()*(10-0+1)+0) +"" + this.lastName.substring(0,1)+(int)Math.floor(Math.random()*(10-0+1)+0) +""+ this.firstName.substring(1, 2);
	}



	
}
