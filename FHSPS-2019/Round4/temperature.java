import java.util.*;

public class temperature {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int q = 1; q <= t; q++) {
			int n = scan.nextInt();
			int m = scan.nextInt();
			char[][] grid = new char[n][m];
			HashMap<Integer, Integer> id = new HashMap<Integer, Integer>();
			int unknown = 0;
			for(int i = 0; i < n; i++) {
				grid[i] = scan.next().toCharArray();
				for(int j = 0; j < m; j++) {
					if(grid[i][j] == '?') {
						int ix = i*m+j;
						id.put(ix, unknown);
						unknown++;
					}
				}
			}
			int[] dr = {1, 0, -1, 0};
			int[] dc = {0, 1, 0, -1};
			double[][] mat = new double[unknown][unknown+1];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(grid[i][j] == '?') {
						int me = id.get(i*m+j);
						int cnt = 0;
						int eq = 0;
						for(int k = 0; k < 4; k++) {
							int r = i+dr[k];
							int c = j+dc[k];
							if(r < n && c < m && r >= 0 && c >= 0) {
								cnt++;
								if(grid[r][c] == '?') {
									int ix = r*m+c;
									int idx = id.get(ix);
									mat[me][idx] = -1;
								}
								else eq += grid[r][c]-'0';
							}
						}
						mat[me][me] = cnt;
						mat[me][unknown] = eq;
					}
				}
			}
			if(unknown > 0) gaussian(mat);
			System.out.println("Hotel #"+q+":");
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(grid[i][j] != '?') System.out.print(grid[i][j]);
					else {
						int idx = id.get(i*m+j);
						System.out.printf("%.0f", mat[idx][unknown]);
					}
				}
				System.out.println();
			}
			System.out.println();
		}
	}

	public static void gaussian(double[][] m) {
		int r = m.length, c = m[0].length;
		int pc = 0, pr = 0;
		while(pr < r && pc < c) {
			int sr = pr;
			for(int j = pr+1; j < r; j++)
				if(Math.abs(m[j][pc]) > Math.abs(m[sr][pc]))
					sr = j;
			swap(m, sr, pr);
			if(Math.abs(m[pr][pc]) < 1e-7) {
				pc++;
				continue;
			}
			double piv = m[pr][pc];
			for(int j = pc; j < c; j++)
				m[pr][j] /= piv;
			for(int j = 0; j < r; j++) {
				if(j == pr) continue;
				double ratio = -m[j][pc];
				for(int k = pc; k < c; k++) {
					m[j][k] += m[pr][k]*ratio;
				}
			}
			pc++;
			pr++;
		}
	}

	public static void swap(double[][] m, int sr, int pr) {
		double[] temp = m[sr];
		m[sr] = m[pr];
		m[pr] = temp;
	}
}
