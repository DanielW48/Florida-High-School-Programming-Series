import java.util.*;

public class pizza {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int q = 1; q <= t; q++) {
			int n = scan.nextInt();
			int ans = 0;
			for(int i = 0; i < n; i++) {
				int a = scan.nextInt();
				int b = scan.nextInt();
				ans += Math.max(0, a-b);
			}
			System.out.println("Neighborhood #"+q+": "+ans);
		}
	}
}
