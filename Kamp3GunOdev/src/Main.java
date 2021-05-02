
public class Main {

	public static void main(String[] args) {
		

		Course kurs1 = new Course(1,"C# Angular");
		Course kurs2 = new Course(2,"JAVA REACT");
		
		Course[] kurslar = {kurs1,kurs2};
		CourseManager courseManager = new CourseManager();
		
		
	   
		Instructor[] egitmenler = {
				 new Instructor(1,"Engin","Demiroð",
						 "Üniversite hayatýma ÖSS 2003 Türkiye derecesiyle baþladým. Sýrasýyla Baþkent ve ODTÜ'de Yönetim Biliþim Sistemleri (Lisans-Burslu) ve Týp Biliþimi(Yüksek Lisans) okudum. Profesyonel iþ hayatýma ise henüz üniversite birinci sýnýftayken baþladým.",
						 courseManager.getCourse(kurslar, new int[] {1,2}))
				, new Instructor(2,"Engin","Demiroð","Üniversite hayatýma ÖSS 2003 Türkiye derecesiyle baþladým. Sýrasýyla Baþkent ve ODTÜ'de Yönetim Biliþim Sistemleri (Lisans-Burslu) ve Týp Biliþimi(Yüksek Lisans) okudum. Profesyonel iþ hayatýma ise henüz üniversite birinci sýnýftayken baþladým."
						,courseManager.getCourse(kurslar, new int[] {2}))
		};
		
		
		Vote yorum1 = new Vote();
		yorum1.content="Harika";
		yorum1.id = 1;
	
		
		Image image1 = new Image();
		image1.path = "images/uploads/1.jpg";
		
		Image image2 = new Image();
		image2.path = "images/uploads/2.jpg";
				
		Image[] images = {image1,image2};
		
		
		yorum1.imagePaths = images;
		
		Vote[] ratings = {yorum1};
		
		
		
		
		
		Schedule dersProgrami = new Schedule("Ödev 1"); // Ödev Veya Ders Programý Oluþtur
			
		Student ogrenci1 = new Student(1,"Mehmet","Basrioðlu",egitmenler); // Öðrenci Oluþtur
		ogrenci1.setRating(ratings);
		yorum1.user = ogrenci1;

		
		
		InstructorManager instructorManager = new InstructorManager();
		instructorManager.listCourses(egitmenler,1); // Eðitmenin Kurslarýný Listele
		System.out.println("\n");
		 //instructorManager.showInfos(egitmenler, 1); // Eðitmenin Sitedeki Bilgisi
		
		
		
		System.out.println("\n");
		System.out.println("Kullanýcýlarýn Yaptýðý Ýþlemler: ");
		
		StudentManager manager = new StudentManager();
		manager.add(ogrenci1);
		
		StudentManager.joinCourse(kurs1,ogrenci1); // Kursa katýl buttonu
		StudentManager.registeredCourse(dersProgrami,ogrenci1); // Bitir ve Devam et buttonu
		
	
		System.out.println("\n");
		System.out.println("Kullanýcýlarýn Yaptýðý Yorumlar: ");
		for(int i=0;i<ratings.length;i++) {
			for(int j=0;j<images.length;j++) {
				if(ratings[i]!=null&&images[i]!=null) {
					System.out.println(ratings[i].user+ " Yorum: "+ ratings[i].content +"   Resimler: "+images[j].path);
				}
			}
			
		}

		
		
		
		
		
	   
		
		
		
		
		
		
	
		
		
		
		
	}

}
