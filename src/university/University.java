package university;

import java.util.Arrays;

public class University {
	private class Rector {
		private String nome;
		private String cognome;

	}

	private String name;
	private Rector rector;
	public static final int MAX_STUDENTS = 1000;
	private static int STUD_OFFSET = 10000;
	private static int COUR_OFFSET = 10;
	private Student[] students = new Student[1000];
	private Course[] courses = new Course[100];

	public University(String name) {
		this.name = name;
		this.rector = new Rector();
	}

	public String getName() {
		return name;
	}

	public void setRector(String first, String last) {
		this.rector.nome = first;
		this.rector.cognome = last;
	}

	public String getRector() {
		return rector.nome + " " + rector.cognome;
	}

	public int enroll(String first, String last) {
		int index = 0;
		for (Student s : students) {
			if (s == null) {
				students[index] = new Student(first, last);
				return index + STUD_OFFSET;
			}
			index++;
		}
		return -1;

	}

	public String student(int id) {
		return String.valueOf(id) + " "
				+ students[id - STUD_OFFSET].getFirstname() + " "
				+ students[id - STUD_OFFSET].getLastname();
	}

	public int activate(String title, String teacher) {
		int index = 0;
		for (Course c : courses) {
			if (c == null) {
				courses[index] = new Course(title, teacher);
				return index + COUR_OFFSET;
			}
			index++;
		}
		return -1;
	}

	public String course(int code) {
		return String.valueOf(code - COUR_OFFSET) + " "
				+ courses[code - COUR_OFFSET].getName() + " "
				+ courses[code - COUR_OFFSET].getTeachername();
	}

	public void register(int studentID, int courseCode) {
		courses[courseCode - COUR_OFFSET].addStudent(students[studentID
				- STUD_OFFSET]);
	}

	public String listAttendees(int courseCode) {
		int i = 0;
		Student s;
		StringBuilder sb = new StringBuilder();
		while ((s = courses[courseCode - COUR_OFFSET].getStudent(i)) != null) {
			sb.append(s.getFirstname() + " " + s.getLastname() + "\n");
			i++;
		}
		return sb.toString();
	}

	public String studyPlan(int studentID) {
		Student s1 = students[studentID - STUD_OFFSET];
		Student s2;
		int index;
		StringBuilder sb = new StringBuilder();
		for (Course c : courses) {
			if (c == null)
				break;
			index = 0;
			while ((s2 = c.getStudent(index++)) != null) {
				if (s1.equals(s2)) {
					sb.append(c.getName() + "\n");
					break;
				}
			}
		}
		return sb.toString();
	}
}
