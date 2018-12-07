import java.util.*;

public class shuriken {
	
	static final double PI = 3.14159265358979;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int q = 1; q <= t; q++) {
			int n = scan.nextInt();
			int s = scan.nextInt();
			int h = scan.nextInt();
			int d = scan.nextInt();
			double tri = n*s*h*0.5;
			double a = s*0.5/Math.tan(PI/(double)n);
			double poly = n*s*a*0.5;
			double circ = d*d*0.25*PI;
			double total = tri+poly-circ;
			System.out.printf("Shuriken #%d: %.2f\n",q,total);
		}
	}
}
