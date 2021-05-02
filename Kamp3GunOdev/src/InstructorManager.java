



public class InstructorManager extends UserManager{
	public void createExercise(Schedule schedule) {
		System.out.println("Created New Exercise: "+schedule.getLesson());
	}
	
	public void add(User user) {
		System.out.println("Eðitmen Eklendi");
	}
	
	
	public void showInfos(Instructor[] instructor, int id) {
		for(int i = 0; i < instructor.length; i++) {
		if(instructor[i].getId() == id) {
			System.out.println(instructor[i].getDetails());
		}
		}
	}
	
	public void listCourses(Instructor[] instructor, int id) {
	   
		  for(int i = 0; i < instructor.length; i++) {
			if(instructor[i].getId() == id) {
				System.out.printf(instructor[i].getFirstName() + " "+ instructor[i].getLastName() + " Vermiþ Olduðu Kurslar :");
				for(Course courses : instructor[i].getCourse()) {
					System.out.printf("  " + courses.getCourseName());
				}
			}
		}
		
	}

}
