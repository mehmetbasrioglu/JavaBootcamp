
public class Course {
	Integer id;
	String courseName;
	User[] egitmen;


	public Course() {
		super();
	}
	
	/**
	 * @param id
	 * @param courseName
	 */
	public Course(Integer id, String courseName) {
		super();
		this.id = id;
		this.courseName = courseName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
}
