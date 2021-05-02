
public class StudentManager extends UserManager {
	
	
	@Override
	public void add(User user) {
		System.out.println("��renci Eklendi");
	}
	
	public static void joinCourse(Course course,Student user) {
		System.out.println(" "+course.getCourseName()+" Kursuna yeni biri kay�t oldu :"+user);
	}
	
	public static void registeredCourse(Schedule schedule, Student user) {
		System.out.println("Ba�ar�yla "+schedule.getLesson()+" Bitir ve devam et yap�ld� :"  +user);
	}
	
	
	
	
	public static void getInstructors(Student ogrenci) {
		for(Instructor instructor : ogrenci.getCourseInstructor() ) {
			System.out.println(instructor.getFirstName() );
		}
	}
	
	
	
	
}
