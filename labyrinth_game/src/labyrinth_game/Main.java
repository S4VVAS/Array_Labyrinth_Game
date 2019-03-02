package labyrinth_game;

public class Main {
	Input inpt = new Input();
	private int x;
	private int y;
	private int totalScore = 0;

	public void printMap(Labyrinth map) {
		String[][] getMap = map.player.getMap();

		for (int x = 0; x < this.x; x++) {
			for (int y = 0; y < this.y; y++) {
				System.out.print(getMap[x][y] + "");
			}
			System.out.println();
		}
	}

	private void move() {
		Labyrinth pl = new Labyrinth(x, y);

		while (pl.player.endCond == 0) {

			printMap(pl);

			String dir = inpt.strEnt("Go: ");
			pl.player.move(dir);
			inpt.clearScreen();
		}
		if (pl.player.score == 1) {
			totalScore++;
		}
		if (pl.player.endCond == 1) {
			totalScore++;
		}

		System.out.println("Your total score is now " + totalScore + "!");
		System.out.println("It is now a little harder :)\n");

	}

	private void multiplier() {
		x = x + totalScore * 2;
		y = y + totalScore * 2;
	}

	public static void main(String[] args) {
		Main main = new Main();

		System.out.println("Welcome to the maze game!");

		while (true) {
			main.x = 10 + 2;
			main.y = 10 + 2;
			String user = main.inpt.strEnt("1 - New Game\n2 - Custom Game\n3 - Settings(not working)\n0 - exit");

			if (user.equals("exit") || user.equals("0"))
				break;

			main.multiplier();

			if (user.equals("2") || user.equals("custom game")) {
				main.y = main.inpt.intEnt("Enter map size (x)") + 2;
				main.x = main.inpt.intEnt("Enter map size (y)") + 2;
			}

			main.move();

		}
		
		System.out.println("\n\ncya!");

	}

}
