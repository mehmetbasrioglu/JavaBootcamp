
public class CourseManager {
	public Course[] getCourse(Course[] course,int[] kursId) {
		Course[] newCourse = new Course[kursId.length];

	    for(int i = 0; i < kursId.length; i++) {
	    	for(int j = 0; j < course.length; j++) {
	    		if(kursId[i] == course[j].id) {
	    			newCourse[i] = course[j];
	    		}
	    	}
	    }
	    
	    return newCourse;
		
	}
}
