import java.util.*;

public class birthday {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int q = 1; q <= t; q++) {
			int n = scan.nextInt();
			int m = scan.nextInt();
			int[] arr = new int[n];
			HashSet<Integer> set = new HashSet<Integer>();
			for(int i = 0; i < n; i++) arr[i] = scan.nextInt();
			for(int i = 0; i < m; i++) set.add(scan.nextInt());
			int ans = 0;
			for(int i = 0; i < n; i++) if(set.contains(arr[i])) ans++;
			System.out.println("Birthday #"+q+": "+ans);
		}
	}
}
