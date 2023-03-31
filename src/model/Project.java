package model;

import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.text.ParseException;

public class Project {

	private String name;
	private String clientName;
	private String projectType;
	private Calendar initialDate;
	private Calendar finalDate;
	private double budget;

	private DateFormat formatter;

	public Project(String name, String clientName, Calendar initialDate, Calendar finalDate, double budget,
			String projecType) {

		this.formatter = new SimpleDateFormat("dd/MM/yyyy");

		this.name = name;
		this.clientName = clientName;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
		this.budget = budget;
		this.projectType = projecType;
	}

	public String getName() {
		return name;
	}

	public String getClientName() {
		return clientName;
	}

	public Calendar getInitialDate() {
		return initialDate;
	}

	public String getInitialDateFormated() throws ParseException {
		return formatter.format(this.initialDate.getTime());
	}

	public Calendar getFinalDate() {
		return finalDate;
	}

	public String getFinalDateFormated() throws ParseException {
		return formatter.format(this.finalDate.getTime());
	}

	public double getBudget() {
		return budget;
	}

	/**
	 * 
	 * @return The informations about the project
	 * @throws ParseException
	 */
	public String getProjectInfo() throws ParseException {
		return "\nName: " + name + "\nClient: " + clientName + "\nType: " + this.projectType + "\nInitial Date: "
				+ getInitialDateFormated() +
				"\nFinal Date: " + getFinalDateFormated() + "\nTotalBudget: " + budget + ".\n";
	}
}
