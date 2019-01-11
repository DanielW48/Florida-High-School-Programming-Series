import java.util.ArrayList;
import java.util.Scanner;

public class quantum {
	
	static long mod = 1_000_000_007;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int q = 1; q <= t; q++) {
			int n = scan.nextInt();
			int m = scan.nextInt();
			int p = scan.nextInt()-1;
			int k = scan.nextInt();
			ArrayList<Integer>[] graph = new ArrayList[n];
			for(int i = 0; i < n; i++) graph[i] = new ArrayList<Integer>();
			for(int i = 0; i < m; i++) {
				int u = scan.nextInt()-1;
				int v = scan.nextInt()-1;
				graph[u].add(v);
				graph[v].add(u);
			}
			long[][] dp = new long[n][k+1];

			for(int i = 0; i < n; i++)
				dp[i][0] = modInv(n);
			
			for(int j = 1; j <= k; j++){
				for(int i = 0; i < n; i++) {
					if(i == p) continue;
					for(int ii = 0; ii < graph[i].size(); ii++) {
						int to = graph[i].get(ii);
						dp[to][j] += dp[i][j-1]*modInv(graph[i].size());
						dp[to][j] %= mod;
					}
				}
			}

			long ans = 0;
			for(int i = 0; i <= k; i++) {
				ans += dp[p][i];
				ans %= mod;
			}
			System.out.println("Network #"+q+": "+ans);
		}
	}
	
	static long modInv(long n) {
		return pow(n, mod-2);
	}
	
	static long pow(long a, long b) {
		long x = 1, y = a;
		while(b > 0) {
			if(b % 2 > 0) {
				x = (x*y)%mod;
			}
			y = (y*y)%mod;
			b /= 2;
		}
		return x%mod;
	}
}

/*
1
5 6 2 14
1 2
2 3
4 5
5 1
1 3
4 3

2
3 2 1 3
1 2
2 3
3 2 2 3
1 2
2 3
 */