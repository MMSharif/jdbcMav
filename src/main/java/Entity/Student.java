package Entity;

import java.io.Serializable;

public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6743825221714997779L;

	private int id;
	private String name;
	private Address address;
	private static String school = "Alphonsas";

	public Student() {
		super();
	}

	public Student(int id, String name, Address address) {
		this.id = id;
		this.name = name;
		this.address = address;

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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public static String getSchool() {
		return school;
	}

	public static void setSchool(String school) {
		Student.school = school;
	}
	
	public String toString() {
		return "Student[id="+id+",name="+name+",address="+address+"]";
		
	}

}