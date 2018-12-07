import java.util.*;

public class dance {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int q = 1; q <= t; q++) {
			int n = scan.nextInt();
			String s = scan.next();
			int c = 0;
			for(int i = 1; i < n; i++) {
				if(s.charAt(i-1) == s.charAt(i))
					c++;
			}
			System.out.println("Dance #"+q+": "+c);
		}
	}
}
