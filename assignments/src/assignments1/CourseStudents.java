package assignments1;

public class CourseStudents {

	public static void main(String[] args) {
		Student s = new Student();
		s.setName( "Ann River" );
		s.grade1 = 2.5;
		s.grade2 = 3;
		
		Student s2 = new Student();
		s2.setName( "Bill Smith" );
		s2.grade1 = 4;
		s2.grade2 = 5;
		
		System.out.println(s.getName() + " average " + s.average());
		System.out.println(s2.getName() + " average " + s2.average());
	}

}
