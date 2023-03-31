package model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Controller {

	private Project[] projects;

	public Controller() {

		projects = new Project[10];

	}

	public Project[] getProjects() {
		return projects;
	}

	// Incomplete
	public boolean RegisterProject() {

		return false;
	}

	// Incomplete
	// Date class also has their own before() and after() method
	public String searchProjectsAfterDate() {

		String msg = "";

		return msg;

	}

	// Date class also has their own before() and after() method
	public String searchProjectsBeforeDate() {

		String msg = "";

		return msg;

	}

	public int getFirtsValidPosition() {
		boolean isFound = false; // flag
		int pos = -1;
		for (int i = 0; i < 10 && !isFound; i++) {
			if (projects[i] == null) {
				isFound = true;
				pos = i;
			}
		}
		return pos;
	}
}
