package ui;

import java.text.ParseException;
import java.util.Scanner;
import model.Controller;

public class Main {

	private Scanner reader;
	private Controller controller;

	// Constructor
	public Main() {

		reader = new Scanner(System.in);
		controller = new Controller();
	}

	public static void main(String[] args) throws ParseException {

		Main exe = new Main();
		int option = exe.createMenu();

		while (option != 4) {
			exe.executeOption(option);
			option = exe.createMenu();
		}
		System.out.println("\nHAVE A GREAT DAY!!");
		exe.reader.close();

	}

	/**
	 * This method displays the main menu of the program and makes the user choose
	 * one of the available options
	 * 
	 * @return
	 */
	public int createMenu() {
		int option = 0;
		do {
			System.out.println("----Welcome----"

					+ "\n---Projects---\n" +

					"\n1. Create a project " +
					"\n2. Search a project that ends before a date" +
					"\n3. Search a project that start before a date" +
					"\n\n4. Exit the program");
			System.out.print("\n>> ");
			option = validateIntegerInput();
			if (option < 1 || option > 4) {
				System.out.println("Please select a valid option \n");
			}
		} while (option < 1 || option > 4);
		return option;
	}

	/**
	 * This method ask the users for the information nedeed to crate a project and
	 * then send
	 * the order to the controller to create the project
	 */
	public void RegisterProject() {
		int projectTypeNumber = -1;
		String projectName;
		String clientName;
		String[] projectType = { "DEVELOPMENT", "MAINTANCE", "DEPLOYMENT" };
		String startingDate;
		String endingDate;
		double budget = -1;

		System.out.println("Please insert the project's name: ");
		reader.nextLine();
		projectName = reader.nextLine();
		System.out.println("\nPlease insert the client's name: ");
		clientName = reader.nextLine();
		System.out.println("\n TYPE OF PROJECT: \n" +
				"1.DEVELOPMENT\n" +
				"2.MAINTANCE\n" +
				"3.DEPLOYMENT");
		do {
			projectTypeNumber = validateIntegerInput() - 1;
			reader.nextLine();
		} while (projectTypeNumber < 0 || projectTypeNumber > 2);
		System.out.println("\nInsert the starting date with the following format: (dd/MM/yyyy), ex: 01/02/2003");
		startingDate = reader.nextLine();
		System.out
				.println("\nInsert the ending date with the following format: (dd/MM/yyy), ex: 01/02/2003");
		endingDate = reader.nextLine();

		System.out.println("\nProject's budget: ");
		while (budget == -1) {
			budget = validateDoubleInput();
		}

		try {
			controller.RegisterProject(projectName, clientName, projectType[projectTypeNumber], startingDate,
					endingDate, budget);
			System.out.println("The project was succesfully created: \n"
					+ controller.getProjects()[Math.abs(controller.getFirtsValidPosition()) - 1].getProjectInfo());
		} catch (ParseException e) {
			System.out.println("Please insert a valid date following the format. ");
		}
	}

	/**
	 * This method ask the user for an specific date and then send the date to the
	 * controller
	 * class to find the projects that end before and specific date.
	 */
	public void searchProjectsAfterDate() {
		String projectDate = "0/0/0000";
		System.out.println("Insert the date with the format: (dd/MM/yyyy) ex. 01/02/2004");
		reader.nextLine();
		projectDate = reader.nextLine();
		try {
			System.out.println(controller.searchProjectsAfterDate(projectDate));
		} catch (ParseException e) {
			System.out.println("Please insert a valid date following the format.");
		}
	}

	/**
	 * This method ask the user for an specific date and then send the date to the
	 * controller
	 * class to find the projects that start before and specific date.
	 */
	public void searchProjectsBeforeDate() {
		String projectDate = "0/0/0000";
		System.out.println("Insert the date with the format:  (dd/MM/yyyy) ex. 01/03/2004");
		reader.nextLine();
		projectDate = reader.nextLine();
		try {
			System.out.println(controller.searchProjectsBeforeDate(projectDate));
		} catch (ParseException e) {
			System.out.println("Please insert a valid date following the format.");
		}

	}

	/**
	 * This option is the one encharged of running the option inserted by the user
	 * in the Menu
	 * 
	 * @param option -> It will be a number between 1 and 6 representing what the
	 *               user want's to do with the software.
	 * @return The program return nothing since it will only execute an option.
	 * @throws ParseException
	 */
	public void executeOption(int option) throws ParseException {
		switch (option) {

			case 1:
				if (controller.getFirtsValidPosition() == (controller.getProjects().length * -1)) {
					System.out.println("You can't craete more projects, the projects are full.");
				} else {
					RegisterProject();
				}
				break;
			case 2:
				if (controller.getProjects()[0] != null) {
					searchProjectsAfterDate();
				} else {
					System.out.println("\nThere is no current projects\n");
				}
				break;
			case 3:
				if (controller.getProjects()[0] != null) {
					searchProjectsBeforeDate();
				} else {
					System.out.println("\nThere is no current projects\n");
				}
				break;
			default:
				System.out.println("Option not recognized");
		}

	}

	/**
	 * The function get the data from the user and validates that it is an int input
	 * 
	 * @return the integer number digited by the user
	 */
	public int validateIntegerInput() {
		int option = 0;
		if (reader.hasNextInt()) {
			option = reader.nextInt();
		} else {
			reader.nextLine();// clean the Scanner
			option = -1;
			System.out.println("Insert a numeric value.");
		}
		return option;
	}

	/**
	 * The function get the data from the user and validates that it is a double
	 * input
	 * 
	 * @return the double number digited by the user
	 */
	public double validateDoubleInput() {
		double option = 0;
		if (reader.hasNextDouble()) {
			option = reader.nextDouble();
		} else {
			reader.nextLine();// clean the Scanner
			option = -1;
			System.out.println("Insert a numeric value.");
		}
		return option;
	}

}
