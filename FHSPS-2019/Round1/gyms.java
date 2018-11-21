import java.util.*;

public class gyms {
	
	static boolean[][] superEffective;
	static String ans = "";

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int q = 1; q <= t; q++) {
			ans = "";
			int n = scan.nextInt();
			String[] name = new String[n];
			superEffective = new boolean[n][n];
			for(int i = 0; i < n; i++) {
				name[i] = scan.next();
				for(int j = 0; j < n; j++) {
					superEffective[i][j] = scan.nextInt() == 1;
				}
			}
			perm(0, new int[n], name, new boolean[n]);
			if(ans.isEmpty()) System.out.println("Type Chart #"+q+": Impossible");
			else System.out.println("Type Chart #"+q+": "+ans);
		}
	}
	
	static void perm(int u, int[] arr, String[] name, boolean[] used) {
		if(u == arr.length) {
			for(int i = 0; i < arr.length-1; i++)
				if(!superEffective[arr[i+1]][arr[i]]) return;
			String res = name[arr[0]];
			for(int i = 1; i < arr.length; i++) res += " "+name[arr[i]];
			if(ans.isEmpty()) ans = res;
			else
				if(res.compareTo(ans) < 0)
					ans = res;
		}
		for(int i = 0; i < arr.length; i++) {
			if(!used[i]) {
				used[i] = true;
				arr[u] = i;
				perm(u+1, arr, name, used);
				used[i] = false;
			}
		}
	}
}

/*

2
8
ROCK 0 0 0 0 0 0 1 0
WATER 1 0 0 0 0 0 1 0 
ELECTRIC 0 1 0 0 0 0 0 0
GRASS 1 1 0 0 0 0 0 1
POISON 0 0 0 1 0 0 0 0
PSYCHIC 0 0 0 0 1 0 0 0
FIRE 0 0 0 1 0 0 0 0
GROUND 1 0 1 0 1 0 1 0
8
FLYING 0 1 0 0 1 0 0 0
BUG 0 0 0 0 0 0 0 0
NORMAL 0 0 0 0 0 0 0 0
GHOST 0 0 0 0 0 0 0 0
FIGHTING 0 0 1 0 0 1 1 0
STEEL 0 0 0 0 0 0 1 0
ICE 1 0 0 0 0 0 0 1
DRAGON 0 0 0 0 0 0 0 1

*/