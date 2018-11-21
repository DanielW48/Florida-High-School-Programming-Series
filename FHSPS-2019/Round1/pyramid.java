import java.util.*;

public class pyramid {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int q = 1; q <= t; q++) {
			int n = scan.nextInt();
			int[] w = new int[n];
			int[] l = new int[n];
			int[] h = new int[n];
			int[] v = new int[n];
			for(int i = 0; i < n; i++) {
				w[i] = scan.nextInt();
				l[i] = scan.nextInt();
				h[i] = scan.nextInt();
				v[i] = w[i]*l[i]*h[i];
			}
			boolean ok = true;
			for(int i = 1; i < n; i++) {
				if(v[i-1] >= v[i]) ok = false;
				if(w[i-1] >= w[i]) ok = false;
				if(l[i-1] >= l[i]) ok = false;
			}
			if(ok) System.out.println("Pyramid #"+q+": Proper Pyramid");
			else System.out.println("Pyramid #"+q+": Improper Pyramid");
		}
	}
}
