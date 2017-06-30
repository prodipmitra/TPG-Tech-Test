package tpg.tech.test.pm;

import java.util.Comparator;

public class Student implements Comparable<Student>{ 

	private int id;
	private String name;
	private double gpa;
	
	public Student(int id, String name, double gpa) {
		super();
		this.id = id;
		this.name = name;
		this.gpa = gpa;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	
	static Comparator<Student> getStudentGPAComparator() {
        return new Comparator<Student>() {

            @Override
            public int compare(Student Student1, Student Student2) {
                if(Student1.getGpa() < Student2.getGpa())
                    return 1;
                else
                    return -1;
            }
            // compare using Student GPA
        };
    }
	
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
