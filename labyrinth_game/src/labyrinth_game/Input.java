package labyrinth_game;

import java.util.Scanner;

public class Input {
	Scanner scanner = new Scanner(System.in);
	
	public String strEnt(String print) {
		System.out.println(print);
		return scanner.nextLine().toLowerCase().trim();
	}
	
	public int intEnt(String print) {
		System.out.println(print);
		int num = scanner.nextInt();
		scanner.nextLine();
		return num;
	}

	public void clearScreen() {
		for(int i = 0; i < 75; i++) {
			System.out.println();
		}
	}
}
