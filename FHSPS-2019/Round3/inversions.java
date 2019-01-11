import java.util.*;

public class inversions {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int q = 1; q <= t; q++) {
			int n = scan.nextInt();
			String s = scan.next();
			long ans = 0;
			long[] freq = new long[26];
			for(int i = 0; i < n; i++) {
				int c = s.charAt(i)-'a';
				for(int j = 25; j > c; j--)
					ans += freq[j];
				freq[c]++;
			}
			System.out.println("String #"+q+": "+ans);
		}
	}
}
