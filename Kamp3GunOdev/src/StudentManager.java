
public class StudentManager extends UserManager {
	
	
	@Override
	public void add(User user) {
		System.out.println("Öðrenci Eklendi");
	}
	
	public static void joinCourse(Course course,Student user) {
		System.out.println(" "+course.getCourseName()+" Kursuna yeni biri kayýt oldu :"+user);
	}
	
	public static void registeredCourse(Schedule schedule, Student user) {
		System.out.println("Baþarýyla "+schedule.getLesson()+" Bitir ve devam et yapýldý :"  +user);
	}
	
	
	
	
	public static void getInstructors(Student ogrenci) {
		for(Instructor instructor : ogrenci.getCourseInstructor() ) {
			System.out.println(instructor.getFirstName() );
		}
	}
	
	
	
	
}
