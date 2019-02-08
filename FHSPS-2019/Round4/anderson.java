import java.util.*;

public class anderson {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int q = 1; q <= t; q++) {
			int n = scan.nextInt();
			int k = scan.nextInt();
			boolean spill = false;
			for(int i = 0; i < n; i++) {
				int m = scan.nextInt();
				if(m % k == 0) spill = true;
			}
			System.out.print("Day #"+q+": ");
			if(spill) System.out.println("Anderson, please!");
			else System.out.println("Hey Andy!");
		}
	}
}
