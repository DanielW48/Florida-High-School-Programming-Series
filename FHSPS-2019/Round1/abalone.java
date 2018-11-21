import java.util.*;

public class abalone {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int q = 1; q <= t; q++) {
			char[][] in = new char[9][9];
			for(int i = 0; i < 9; i++) in[i] = scan.next().toCharArray();
			//Convert input into hexagonal grid
			char[][] grid = new char[9][18];
			int start = 0;
			for(int i = 4; i >= 0; i--) {
				for(int j = 0; j < in[i].length; j++) {
					grid[i][start+j*2] = in[i][j];
				}
				start++;
			}
			start = 1;
			for(int i = 5; i < 9; i++) {
				for(int j = 0; j < in[i].length; j++) {
					grid[i][start+j*2] = in[i][j];
				}
				start++;
			}

			int ans = 0;

			int[] dx = {2, 1, -1, -2, -1, 1};
			int[] dy = {0, 1, 1, 0, -1, -1};

			//For each border cell, if it is white, loop through all six directions
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 18; j++) {
					if(grid[i][j] == 'W') {
						for(int k = 0; k < 6; k++) {
							if(!inbounds(i+dy[k],j+dx[k],grid) || grid[i+dy[k]][j+dx[k]] == 0) {
								ans += ways(i,j,-dy[k],-dx[k],grid);
							}
						}
					}
				}
			}
			System.out.println("Game #"+q+": "+ans);
		}
	}

	static int ways(int sr, int sc, int dr, int dc, char[][] grid) {
		//three cases:
		//1 pushed by 2
		//1 pushed by 3
		//2 pushed by 3
		//number of ways is equal to #black-#white
		int white = 1;

		//if the adjacent cell is white then there are 2 whites
		if(!inbounds(sr+dr,sc+dc,grid)) return 0;
		if(grid[sr+dr][sc+dc] == 'W') {
			white++;
			sr += dr;
			sc += dc;
		}

		int black = 0;
		while(inbounds(sr+dr,sc+dc,grid)) {
			if(grid[sr+dr][sc+dc] == 'B') black++;
			else break;
			sr += dr;
			sc += dc;
		}
		black = Math.min(black, 3);
		return black > white? black-white : 0;
	}

	static boolean inbounds(int r, int c, char[][] grid) {
		return r < grid.length && c < grid[0].length && r >= 0 && c >= 0;
	}
}

/*
 
2
..WW.
..BB..
..BB...
...B....
.........
........
.......
......
.....
.....
......
W.....B
W.....W.
.WW..BBBW
WW...B..
....B..
......
.....

1
.....
.....W
......B
.......B
........B
........
.......
......
.....

1
W....
.....W
......B
.......B
........B
........
.......
......
.....

 */