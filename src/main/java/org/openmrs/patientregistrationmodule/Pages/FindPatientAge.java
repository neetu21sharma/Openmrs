package org.openmrs.patientregistrationmodule.Pages;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

//Program to calculate the age based on the birthdate provided
public class FindPatientAge {

	public static void main(String[] args) {

		String currentMonth = "MAY";
		// getValue() will get the month of the year
		System.out.println(Month.valueOf(currentMonth).getValue());
		System.out.println("**********************************************************");
		// printing specified date
		LocalDate birthdate = LocalDate.of(2001, 1, 16);
		System.out.println(birthdate);
		// gives the current date
		LocalDate currentDate = LocalDate.now();
		System.out.println(currentDate);
		System.out.println("***********************************************************");
		int age = calculateAge(birthdate, currentDate);

		System.out.println("Age: " + age + " " + "years");
	}

	public static int calculateAge(LocalDate birthdate, LocalDate currentDate) {
		// between() method of Period class will return the period between the
		// currentDate and the birthDate in terms of years
		Period period = Period.between(birthdate, currentDate);

		return period.getYears();
	}
}
