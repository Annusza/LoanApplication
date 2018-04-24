package domain;

import java.util.Date;

public class Person {

	private String firstName;
	private String surname;
	private Date dob;
	private String pesel;

	public String getFirstName() {

		return firstName;
	}

	public void setFirstName(String firstName) {

		this.firstName = firstName;
	}

	public String getSurname() {

		return surname;
	}

	public void setSurname(String surname) {

		this.surname = surname;
	}

	public Date getDob() {

		return dob;
	}

	public void setDob(Date dob) {

		this.dob = dob;
	}

	public String getPesel() {

		return pesel;
	}

	public void setPesel(String pesel) {

		this.pesel = pesel;
	}

	public boolean isAlpha() {

		return (isValidFirstName(firstName) && isValidSurname(surname) && isValidPesel(pesel));

	}

	public static boolean isValidFirstName(String firstName) {

		return firstName != null && firstName.matches("[^\\d\\s\\p{Punct}]{2,}");

	}

	public static boolean isValidSurname(String surname) {

		return surname != null && surname.matches("[^\\d\\s\\p{Punct}]{2,}");

	}

	public static boolean isValidPesel(String pesel) {

		return pesel != null && pesel.matches("[0-9]{11}");

	}
}
