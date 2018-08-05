import java.util.Scanner;

public class consoleMenu {

	private Scanner scanner;

	public consoleMenu() {
		scanner = new Scanner(System.in);
	}

	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	public void startMenu() {
		int choice;
		boolean flag;
		flag = true;
		// First Menu Select tool
		do {
			choice = firstMenu();
			// 1. Class finder 2.Exit
			switch (choice) {
			case 1:// 2nd Menu Select Game
				secondMenu();
				break;
			case 2:// exit
				exitProgramm();
			}
		} while (flag);
	}

	// Select tool
	public int firstMenu() {
		String message;
		int choice;
		boolean check;
		message = "What you want to do?\n1.Best Class Finder  2.Exit\n";
		System.out.print("Welcome to Dark Souls tools\n");
		System.out.print(message);
		// first input check if choice is 1 or 2
		do {
			choice = checkIfInt(message);// check if innpu has int
			check = checIfRightValue(choice, 1, 2, message);// check input right values
		} while (check);
		return choice;
	}

	// Select Game
	public void secondMenu() {
		String message;
		int choice;
		boolean check, flag;
		flag = true;
		do {
			message = "           Select Game\n1.Dark Souls I    2.Dark Souls II\n3.Dark Souls III  4.Main Menu \n";
			System.out.print(message);
			// Select game
			do {
				choice = checkIfInt(message);// check if innpu has int
				check = checIfRightValue(choice, 1, 4, message);// check input right values
			} while (check);
			switch (choice) {
			case 1:// Dark souls I
				System.out.print("TODO\n");
				break;
			case 2:// Dark souls II
				System.out.print("TODO\n");
				break;
			case 3:// Dark souls III
				flag = ds3BestClass();
				break;
			case 4:// Main menu
				flag = false;
				System.out.print("\n");
				break;
			}
		} while (flag);
	}

	// 3rdMenu Find best class
	public boolean ds3BestClass() {
		String message;
		int choice;
		boolean check, flag;
		message = "                Select an option\n" + "1.Select your stats             5.Show classes Soul Level\n"
				+ "2.Change one stat               6.Reset Stats\n" + "3.Select class and show stats   7.Back\n"
				+ "4.Show your prefered stats      8.Main Menu\n";
		flag = true;
		ds3ClassOptimizer ds3class;
		ds3class = new ds3ClassOptimizer();
		ds3class.setBasicStats();
		ds3class.storeTheBaseStats();
		ds3class.setNameOfStats();
		do {
			System.out.print("\n" + message);
			do {
				choice = checkIfInt(message);// check if input has int
				check = checIfRightValue(choice, 1, 8, message);// check input right values
			} while (check);
			// Select feature of ds3 class optimizer
			switch (choice) {
			case 1:// Select one by one the stats
				oneByOneStats(ds3class);
				break;
			case 2:// Change specific stat
				changeSpecificStat(ds3class);
				break;
			case 3:// Show stats by class

			case 4:// Show your prefered stats

			case 5:// Show classes Soul Level

			case 6:// Reset Stats
				ds3class.setBasicStats();
				System.out.println("Stats have been reseted");
				break;
			case 7:// Back
				flag = false;
				break;
			case 8:// Main Menu
				System.out.println("\n");
				;
				return false;
			}
		} while (flag);
		return true;
	}

	// One by one stat input
	public void oneByOneStats(ds3ClassOptimizer ds3class) {
		int vgr, att, end, vit, stg, dex, inte, fth, lck;
		System.out.print("1Enter Vigor(0 = Dont care) : ");
		vgr = checkIfInt("Enter Vigor(0 = Dont care) : ");// check if input has int
		ds3class.newVigor(vgr);
		System.out.print("Enter Attunement(0 = Dont care) : ");
		att = checkIfInt("Enter Attunement(0 = Dont care) : ");// check if input has int
		ds3class.newAttunemen(att);
		System.out.print("Enter Endurance (0 = Dont care) : ");
		end = checkIfInt("Enter Endurance (0 = Dont care) : ");// check if input has int
		ds3class.newEndurance(end);
		System.out.print("Enter Vitality (0 = Dont care) : ");
		vit = checkIfInt("Enter Vitality (0 = Dont care) : ");// check if input has int
		ds3class.newVitality(vit);
		System.out.print("Enter Strenth (0 = Dont care) : ");
		stg = checkIfInt("Enter Strenth (0 = Dont care) : ");// check if input has int
		ds3class.newStrentgh(stg);
		System.out.print("Enter Dexterity (0 = Dont care) : ");
		dex = checkIfInt("Enter Dexterity (0 = Dont care) : ");// check if input has int
		ds3class.newDexterity(dex);
		System.out.print("Enter Intelligence (0 = Dont care) : ");
		inte = checkIfInt("Enter Intelligence (0 = Dont care) : ");// check if input has int
		ds3class.newIntelligence(inte);
		System.out.print("Enter Faith (0 = Dont care) : ");
		fth = checkIfInt("Enter Faith (0 = Dont care) : ");// check if input has int
		ds3class.newFaith(fth);
		System.out.print("Enter Luck (0 = Dont care) : ");
		lck = checkIfInt("Enter Luck (0 = Dont care) : ");// check if input has int
		ds3class.newLuck(lck);
		ds3class.newLevelCreate();
		ds3class.newLevelSohrt();
		printClassByLvl(ds3class);
	}

	public void changeSpecificStat(ds3ClassOptimizer ds3class) {
		
		System.out.println("    Select Stat   ");
		System.out.format("%-15s %-1s%n","Stat" , "Value");
		for (int j = 1; j < ds3ClassOptimizer.NUMBER_OF_STATS; j++) {
			System.out.format("%-15s %-1s%n", ds3class.getSpecificNameOfSkills(j),
			ds3class.getSpecificUserChoice(j));
		}
		
	
	}
	
	// print Stats
	public static void printClassByLvl(ds3ClassOptimizer ds3class) {
		int j;
		int pointer;
		j = 1;
		System.out.print("\n        Results\n");
		System.out.format("%-15s %-10s %-1s%n", "Class", "Soul Level", "Your selected stats");
		for (int i = 0; i < 10; i++) {
			pointer = ds3class.getSpecificClassPointer(i);
			System.out.format("%-14s  %-10s", ds3class.getspecificAllClasses(pointer).getName(),
					(ds3class.getspecificAllClasses(pointer).getSpecificStat(0)));
			if (j < 10) {
				System.out.format(" %-15s %-1s%n", ds3class.getSpecificNameOfSkills(j),
						ds3class.getSpecificUserChoice(j));
				j++;
			}
		}
		System.out.print("\n");
	}

	// check if input is int or not
	public int checkIfInt(String message) {
		boolean check;
		int choice = -9;
		do {
			if (scanner.hasNextInt()) {
				choice = scanner.nextInt();
				check = true;
			} else {
				System.out.print("Error wrong input. Please try again and enter a number!");
				System.out.print("\n" + message);
				check = false;
				scanner.next();
			}
		} while (!(check));
		return choice;
	}

	// check if right values
	public boolean checIfRightValue(int choice, int low, int high, String message) {
		boolean check = false;
		if (choice < low || choice > high) {
			System.out.print("Error wrong choice. Pls try again!");
			System.out.print("\n" + message);
			check = true;
		}
		return check;
	}

	// exit program
	public static void exitProgramm() {
		System.out.print("\nGoodbye!!");
		System.exit(0);
	}

}