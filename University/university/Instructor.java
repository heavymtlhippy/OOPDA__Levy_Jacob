package university;

public class Instructor extends Person {
	private String department;

	public Instructor(	int age, String email, String firstName, String middleName, String lastName,
						String ssn, String department) {
		super(age, email, firstName, middleName, lastName, ssn);

		this.department = department;
	}

	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	// @Override
	// public String toString() {
	// return String.format("Prof. %s (%s)", super.toString(), department);
	// }
}
