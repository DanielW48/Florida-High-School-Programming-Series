import java.util.*;

public class journey {
	
	static long mod = 1_000_000_007;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int q = 1; q <= t; q++) {
			int n = scan.nextInt();
			int m = scan.nextInt();
			int k = scan.nextInt();
			boolean[][] can = new boolean[n+1][m+1];
			int[][] dp = new int[n+1][m+1];
			for(int i = 0; i <= n; i++) Arrays.fill(can[i], true);
			for(int i = 0; i < k; i++) {
				int r = scan.nextInt();
				int c = scan.nextInt();
				if(r <= n && c <= m)
					can[r][c] = false;
			}
			if(can[0][0]) dp[0][0] = 1;
			for(int i = 1; i <= n; i++) {
				if(can[i][0]) dp[i][0] = dp[i-1][0];
			}
			for(int i = 1; i <= m; i++) {
				if(can[0][i]) dp[0][i] = dp[0][i-1];
			}
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= m; j++) {
					if(can[i][j]) dp[i][j] = dp[i-1][j]+dp[i][j-1];
					dp[i][j] %= mod;
				}
			}
			System.out.println("Journey #"+q+": "+dp[n][m]);
		}
	}
}
