package university;

public class Person {
	private static int OLDEST = 0;

	private int age, id;
	private String email, firstName, middleName, lastName, ssn;

	private Person() {
		this(0, "", "", "", "", "");
	}
	public Person(	int age, String email, String firstName, String middleName, String lastName,
					String ssn) {
		this.age = age;
		this.email = email;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.ssn = ssn;

		this.id = this.hashCode();

		if (age > OLDEST) OLDEST = age;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof Person)) return false;
		Person other = (Person) obj;
		if (age != other.age) return false;
		if (email == null) {
			if (other.email != null) return false;
		} else if (!email.equals(other.email)) return false;
		if (firstName == null) {
			if (other.firstName != null) return false;
		} else if (!firstName.equals(other.firstName)) return false;
		if (lastName == null) {
			if (other.lastName != null) return false;
		} else if (!lastName.equals(other.lastName)) return false;
		if (middleName == null) {
			if (other.middleName != null) return false;
		} else if (!middleName.equals(other.middleName)) return false;
		if (ssn == null) {
			if (other.ssn != null) return false;
		} else if (!ssn.equals(other.ssn)) return false;
		return true;
	}
	public int getAge() {
		return age;
	}
	public int getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public String getEmailDomain() {
		return email.substring(email.lastIndexOf('@') + 1);
	}
	public String getFirstName() {
		return firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getLast4Ssn() {
		return ssn.substring(ssn.length() - 4);
	}
	public String getSsn() {
		return ssn;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((middleName == null) ? 0 : middleName.hashCode());
		result = prime * result + ((ssn == null) ? 0 : ssn.hashCode());
		return result;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	@Override
	public String toString() {
		return String.format("%s %s %s", firstName, middleName, lastName);
	}

	public static int getOldest() {
		return OLDEST;
	}
	public static boolean validateAge(int age) {
		return age >= 16 && age <= 150;
	}
	public static boolean validateEmail(String email) {
		/*
		 * People have been writing RFC-compliant RegExs that attempt to validate emails
		 * for years now, and the only one that I've seen actually work and not be
		 * overly restrictive is one that is over 4 pages in length at 12 point font.
		 * 
		 * Proper email validation should always be done by actually sending an email to
		 * that address and letting the email daemon figure it out. Send them a link and
		 * have them click it to validate themselves. If they actually (probably) own
		 * that email address, then it doesn't matter what that email address is, since
		 * they can use it in some way. If they can't click the link, then they either
		 * don't own that address, or that address doesn't exist (whether or not it is
		 * valid).
		 * 
		 * The concept of address-based email validation is trying to answer the wrong
		 * problem with the wrong solution. Hence, this method validates against a 
		 * considerably smaller set of possible emails becacuse we can't actually email
		 * whatever fake email we put in as mock data.
		 * 
		 * This regex is taken from <emailregex.com>.
		 */

		//@formatter:off
		return email.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
		//@formatter:on
	}
	public static boolean validateSsn(String ssn) {
		return ssn.matches("\\d{3}-\\d{2}-\\d{4}");
	}
}
