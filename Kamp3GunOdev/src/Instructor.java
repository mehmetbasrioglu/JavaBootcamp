
public class Instructor  extends User{
	
	private Integer studentCount;
	public Course[] course;
	private String details;

	
	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Course[] getCourse() {
		return course;
	}

	public void setCourse(Course[] course) {
		this.course = course;
	}

	public Integer getStudentCount() {
		return studentCount;
	}

	public void setStudentCount(Integer studentCount) {
		this.studentCount = studentCount;
	}

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param studentCount
	 */
	public Instructor(int id, String firstName, String lastName,String Details, Course[] course) {
		super(id, firstName, lastName);
		this.course = course;
		this.details = Details;
		
		
	}

	

	
	
	
	
	
}
