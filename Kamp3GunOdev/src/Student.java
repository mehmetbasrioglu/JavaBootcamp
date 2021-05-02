
public class Student  extends User{
	
	private  Instructor[] courseInstructor;
	
	public Student() {
		
	}

	public Student(int id, String firstName, String lastName, Instructor[] egitmenler) {
		super(id, firstName, lastName);
		this.courseInstructor = egitmenler;
	}
	
	

	public Instructor[] getCourseInstructor() {
		return courseInstructor;
	}

	public void setCourseInstructor(Instructor[] courseInstructor) {
		this.courseInstructor = courseInstructor;
	}
	public Instructor getInstructor(int id) {
		return this.courseInstructor[id];
	}



	


	
}
