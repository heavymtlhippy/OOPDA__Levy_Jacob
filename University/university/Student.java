package university;

public class Student extends Person {
	private String majour;

	public Student(	int age, String email, String firstName, String middleName, String lastName,
					String ssn, String majour) {
		super(age, email, firstName, middleName, lastName, ssn);

		this.majour = majour;
	}

	public String getMajour() {
		return majour;
	}
	public void setMajour(String majour) {
		this.majour = majour;
	}
	// @Override
	// public String toString() {
	// return String.format("%s (%s)", super.toString(), majour);
	// }
}
