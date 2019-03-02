package labyrinth_game;

public class Player {
	private String[][] map;
	private int x, y;
	private String player, start, block, wall, end, point;
	public int score = 0, endCond = 0;
	
	public Player(String[][] map, String player, String start, String block, String wall, String end, String point) {
		this.map = map;
		this.player = player;
		this.start = start;
		this.block = block;
		this.wall = wall;
		this.end = end;
		this.point = point;

		placePlayer();
	}

	public String[][] getMap() {
		String[][] newMap = map;
		return newMap;
	}
	
	private void placePlayer() {
		for (int y = 0; y < map.length; y++) {
			for (int x = 0; x < map[1].length; x++) {
				if (map[y][x].equals(start)) {
					map[y][x] = player;
					this.x = x;
					this.y = y;
					System.out.println(x + " "+ y);
					return;
				}
			}
		}
	}

	public void move(String dir) {
		
		
		
		if (dir.equals("d")) {
			
			if(map[x][y + 1].equals(point)) {
				score = 1;
			}
				
			if(map[x][y + 1].equals(end)) {
				endCond = 1;
			}
			
			if(!map[x][y + 1].equals(wall)) {
				map[x][y] = block;
				y = y + 1;
				map[x][y] = player;
			}
			
			
			
			while (true) {
				if(map[x][y + 1].equals(point)) {
					score = 1;
				}
					
				if(map[x][y + 1].equals(end)) {
					endCond = 1;
				}
				if (!map[x - 1][y].equals(wall) || map[x][y + 1].equals(wall) || !map[x + 1][y].equals(wall)) {
					return;
				}

				map[x][y] = block;
				y = y + 1;
				map[x][y] = player;

			}
		}
		else if (dir.equals("a")) {
			
			if(map[x][y - 1].equals(point)) {
				score = 1;
			}
				
			if(map[x][y - 1].equals(end)) {
				endCond = 1;
			}
			
			if(!map[x][y - 1].equals(wall)) {
				map[x][y] = block;
				y = y - 1;
				map[x][y] = player;
			}
			
			
			while (true) {
				if(map[x][y - 1].equals(point)) {
					score = 1;
				}
					
				if(map[x][y - 1].equals(end)) {
					endCond = 1;
				}
				if (!map[x - 1][y].equals(wall) || map[x][y - 1].equals(wall) || !map[x + 1][y].equals(wall)) {
					return;
				}

				map[x][y] = block;
				y = y - 1;
				map[x][y] = player;

			}
		}
		else if (dir.equals("w")) {
			
			if(map[x - 1][y].equals(point)) {
				score = 1;
			}
				
			if(map[x - 1][y].equals(end)) {
				endCond = 1;
			}
			
			if(!map[x - 1][y].equals(wall)) {
				map[x][y] = block;
				x = x - 1;
				map[x][y] = player;
			}
			
			
			while (true) {

				if(map[x - 1][y].equals(point)) {
					score = 1;
				}
					
				if(map[x - 1][y].equals(end)) {
					endCond = 1;
				}
				
				if (!map[x][y - 1].equals(wall) || map[x - 1][y].equals(wall) || !map[x][y + 1].equals(wall)) {
					return;
				}

				map[x][y] = block;
				x = x - 1;
				map[x][y] = player;

			}
		}
		else if (dir.equals("s")) {
			
			if(map[x + 1][y].equals(point)) {
				score = 1;
			}
				
			if(map[x + 1][y].equals("X ")) {
				endCond = 1;
			}
			
			if(!map[x + 1][y].equals(wall)) {
				map[x][y] = block;
				x = x + 1;
				map[x][y] = player;
			}
				
			while (true) {
				if(map[x + 1][y].equals(point)) {
					score = 1;
				}
					
				if(map[x + 1][y].equals("X ")) {
					endCond = 1;
				}
			
				if (!map[x][y - 1].equals(wall) || map[x + 1][y].equals(wall) || !map[x][y + 1].equals(wall)) {
					return;
				}

				map[x][y] = block;
				x = x + 1;
				map[x][y] = player;

			}
		}else {
			System.out.println("Cant do that!");
		}
	}
}
