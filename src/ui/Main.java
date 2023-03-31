package ui;

import java.util.Scanner;
import model.Controller;

public class Main {

	private Scanner reader;
	private Controller controller;

	public Main() {

		reader = new Scanner(System.in);
		controller = new Controller();
	}

	public static void main(String[] args) {

		Main exe = new Main();
		int option = exe.menu();

		while (option != 11) {
			exe.executeOption(option);
			option = exe.menu();
		}
		System.out.println("\nHAVE A GREAT DAY!!");
		exe.reader.close();

	}

	// Incomplete
	public int menu() {
		int option = 0;
		do {
			System.out.println("----Welcome----"

					+ "\n---Projects---\n" +

					"\n1. Create a project " +
					"\n2. Search project after date" +
					"\n3. Search project before date " +
					"\n\n11. SALIR DEL PROGRAMA");
			System.out.print("\n>> ");
			option = validateIntegerInput();
			if (option < 1 || option > 11) {
				System.out.println("Please select a valid option \n");
			}
		} while (option < 1 || option > 11);
		return option;
	}

	// Incomplete
	public void RegisterProject() {

	}

	// Incomplete
	public void searchProjectsAfterDate() {

	}

	// Incomplete
	public void searchProjectsBeforeDate() {

	}

	/**
	 * This option is the one encharged of running the option inserted by the user
	 * in the Menu
	 * 
	 * @param option -> It will be a number between 1 and 6 representing what the
	 *               user want's to do with the software.
	 * @return The program return nothing since it will only execute an option.
	 */
	public void executeOption(int option) {
		switch (option) {

			case 1:
				if (controller.getFirtsValidPosition() == -2) {
					System.out.println("You can't craete more projects, the projects are full.");
				} else {
					RegisterProject();
				}
				break;
			case 2:
				if (controller.getProjects()[0] != null) {
					searchProjectsAfterDate();
				} else {
					System.out.println("\nThere is no current projects.\n");
				}
				break;
			case 3:
				if (controller.getProjects()[0] != null) {
					searchProjectsBeforeDate();
				} else {
					System.out.println("\nThere is no current projects.\n");
				}
				break;
			default:
				System.out.println("Option not recognized.");
		}

	}

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

}
