package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.lang.Math;

public class Controller {

	private Project[] projects;

	public Controller() {

		projects = new Project[10];

	}

	public Project[] getProjects() {
		return projects;
	}

	/**
	 * The project get all the informations needed to create a project and then it
	 * creates it and adds it
	 * to the projects array
	 * 
	 * @param projectName  The name of the project
	 * @param clientName   The name of the client
	 * @param projectType  What is the type of the project
	 * @param startingDate The date of starting of the project
	 * @param endingDate   The date where the project ends
	 * @param budget       The budget of the project
	 * @throws ParseException
	 */
	public void RegisterProject(String projectName, String clientName, String projectType, String startingDate,
			String endingDate, double budget) throws ParseException {

		Calendar initialDate = stringToCalendar(startingDate);
		Calendar finalDate = stringToCalendar(endingDate);
		projects[getFirtsValidPosition()] = new Project(projectName, clientName, initialDate, finalDate, budget,
				projectType);

	}

	/**
	 * 
	 * Returns a string containing information about all projects that end before a
	 * given date.
	 * 
	 * @param projectDate The date to search for projects that end before it.
	 * 
	 * @return A string containing information about projects that end before the
	 *         given date, or a message
	 * 
	 *         indicating that no such project was found.
	 * 
	 * @throws ParseException if the input date string is not in the expected
	 *                        format.
	 */
	public String searchProjectsAfterDate(String projectDate) throws ParseException {

		String msg = "";
		Calendar date = stringToCalendar(projectDate);
		for (int i = 0; i < Math.abs(getFirtsValidPosition()); i++) {
			if (projects[i].getFinalDate().compareTo(date) < 0) {
				msg += "\n" + projects[i].getProjectInfo();
			}
		}
		if (msg.equalsIgnoreCase("")) {
			msg = "Threre is not a project that starts before this date";
		}
		return msg;

	}

	/**
	 * 
	 * Returns a string containing information about all projects that start before
	 * a given date.
	 * 
	 * @param projectDate The date to search for projects that start before it.
	 * 
	 * @return A string containing information about projects that start before the
	 *         given date, or a message
	 * 
	 *         indicating that no such project was found.
	 * 
	 * @throws ParseException if the input date string is not in the expected
	 *                        format.
	 */
	public String searchProjectsBeforeDate(String projectDate) throws ParseException {

		String msg = "";
		Calendar date = stringToCalendar(projectDate);
		for (int i = 0; i < Math.abs(getFirtsValidPosition()); i++) {
			if (projects[i].getInitialDate().compareTo(date) > 0) {
				msg += "\n" + projects[i].getProjectInfo();
			}
		}
		if (msg.equalsIgnoreCase("")) {
			msg = "Threre is not a project that starts before this date";
		}
		return msg;

	}

	/**
	 * 
	 * Converts a String to a Calendar object.
	 * 
	 * @param fechaString The string to convert.
	 * @return A Calendar object representing the given date string.
	 * @throws ParseException if the input date string is not in the expected
	 *                        format.
	 */
	public Calendar stringToCalendar(String fechaString) throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Calendar fechaCalendar = Calendar.getInstance();
		fechaCalendar.setTime(formato.parse(fechaString));
		return fechaCalendar;
	}

	/**
	 * 
	 * Returns the index of the first null element in the projects array.
	 * That represents the valid position to add a new project
	 * 
	 * @return The index of the first null element in the projects array.
	 */
	public int getFirtsValidPosition() {
		boolean isFound = false; // flag
		int pos = projects.length * -1;
		for (int i = 0; i < projects.length && !isFound; i++) {
			if (projects[i] == null) {
				isFound = true;
				pos = i;
			}
		}
		return pos;
	}
}
