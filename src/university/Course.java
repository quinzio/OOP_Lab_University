package university;

public class Course {
	private String name;
	private String teachername;
	private Student students[] = new Student[University.MAX_STUDENTS];

	public Course(String name, String teachername) {
		this.name = name;
		this.teachername = teachername;
	}

	public void addStudent(Student s) {
		int index = 0;
		for (Student el:students) {
			if (el == null) {
				students[index] = s;
				break;
			}
			index++;
		}
	}

	public String getName() {
		return name;
	}

	public String getTeachername() {
		return teachername;
	}

	public Student getStudent(int code) {
		return students[code];
	}
	
}
