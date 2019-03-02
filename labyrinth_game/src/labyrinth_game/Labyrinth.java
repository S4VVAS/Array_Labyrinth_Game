package labyrinth_game;

import java.util.Random;

public class Labyrinth {

	public Player player;
	private String[][] map;
	private String block = "  ";
	private String start = "O ";
	private String end = "X ";
	private String point = "P ";
	private String wall = "██";
	private String playericn = "()";

	Labyrinth(int x, int y) {
		map = new String[x][y];
		fillArr(x, y);
		generateBorders(x, y);

		int ex = 0;
		int why = 0;
		int count = 0;
		boolean con = true;

		for (int i = 0; i < x * y * y + x; i++) {
			while (con) {
				count = count + 1;
				ex = new Random().nextInt(x - 2) + 1;
				why = new Random().nextInt(y - 2) + 1;

				if (map[ex][why].equals(block)) {
					con = false;
				}
				/*if (count < 1000) {
					for (int p = 1; p < x - 1; p++) {
						for (int o = 1; o < y - 1; o++) {
							if (map[p][o].equals(block) && !map[p-1][o+1].equals(block) && !map[p-1][o-1].equals(block) && !map[p+1][o+1].equals(block) && !map[p+1][o-1].equals(block)) {
								ex = p;
								why = o;
								con = false;
							}
						}
					}
				}*/
			}
			con = true;

			generateMap(ex, why);
		}
		createStartAndEnd(x, y);
		createCheckPoint(x, y);
		player = new Player(map, playericn, start, block, wall, end, point);

	}

	public String[][] getMap() {
		String[][] newMap = map;
		return newMap;
	}

	private void generateBorders(int xx, int yy) {
		for (int x = 0; x < xx; x++) {
			for (int y = 0; y < yy; y++) {
				map[x][yy - 1] = block;
				map[x][0] = block;
				map[0][y] = block;
				map[xx - 1][y] = block;
			}
		}
		map[xx / 2][yy / 2] = block;
	}

	private void fillArr(int xx, int yy) {
		for (int x = 0; x < xx; x++) {
			for (int y = 0; y < yy; y++) {
				map[x][y] = wall;
			}
		}
	}

	private void generateMap(int xx, int yy) {
		genBlock(xx, yy, new Random().nextInt(4) + 1);

	}

	private void genBlock(int x, int y, int dir) {

		if (dir == 1 && !map[x][y - 1].equals(block) && !map[x - 1][y - 1].equals(block)
				&& !map[x + 1][y - 1].equals(block) && !map[x - 1][y - 2].equals(block) && !map[x][y - 2].equals(block)
				&& !map[x + 1][y - 2].equals(block)) {
			map[x][y - 1] = block;
			genBlock(x, y - 1, new Random().nextInt(4) + 1);

		} else if (dir == 2 && !map[x + 1][y].equals(block) && !map[x + 1][y + 1].equals(block)
				&& !map[x + 1][y - 1].equals(block) && !map[x + 2][y].equals(block) && !map[x + 2][y - 1].equals(block)
				&& !map[x + 2][y + 1].equals(block)) {
			map[x + 1][y] = block;
			genBlock(x + 1, y, new Random().nextInt(4) + 1);

		} else if (dir == 3 && !map[x][y + 1].equals(block) && !map[x - 1][y + 1].equals(block)
				&& !map[x - 1][y + 1].equals(block) && !map[x - 1][y + 2].equals(block) && !map[x][y + 2].equals(block)
				&& !map[x + 1][y + 2].equals(block)) {
			map[x][y + 1] = block;
			genBlock(x, y + 1, new Random().nextInt(4) + 1);

		} else if (dir == 4 && !map[x - 1][y].equals(block) && !map[x - 1][y + 1].equals(block)
				&& !map[x - 1][y - 1].equals(block) && !map[x - 2][y].equals(block) && !map[x - 2][y + 1].equals(block)
				&& !map[x - 2][y - 1].equals(block)) {
			map[x - 1][y] = block;
			genBlock(x - 1, y, new Random().nextInt(4) + 1);

		}
	}

	private void createStartAndEnd(int x, int y) {
		int startCounter = 0;
		int endx = 0;
		int endy = 0;

		for (int xx = 2; xx < x - 2; xx++) {
			for (int yy = 2; yy < y - 2; yy++) {
				if (map[xx][yy].equals(block)) {
					if (startCounter < 1) {
						startCounter++;
						map[xx][yy] = start;
					}
					if (xx > endx || yy > endy) {
						endx = xx;
						endy = yy;
					}
				}
			}
		}
		map[endx][endy] = end;
	}

	private void createCheckPoint(int x, int y) {

		while (true) {
			for (int xx = 3; xx < x - 3; xx++) {
				for (int yy = 3; yy < y - 3; yy++) {
					if (map[xx][yy].equals(block)) {
						if (!map[xx][yy].equals(start) || !map[xx][yy].equals(end)) {
							if (new Random().nextInt(10 * x) == x) {
								map[xx][yy] = point;
								return;
							}
						}
					}
				}
			}
		}
	}

}
