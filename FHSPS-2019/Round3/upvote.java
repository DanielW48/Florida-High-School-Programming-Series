import java.util.*;

public class upvote {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int q = 1; q <= t; q++) {
			int[] bots = new int[1440];
			int n = scan.nextInt();
			for(int z = 0; z < n; z++) {
				int b = scan.nextInt();
				String in1 = scan.next();
				String in2 = scan.next();
				int t1 = convert(in1);
				int t2 = convert(in2);
				if(t1 > t2) {
					for(int i = t1; i < 1440; i++) bots[i] += b;
					for(int i = 0; i <= t2; i++) bots[i] += b;
				}
				else for(int i = t1; i <= t2; i++) bots[i] += b;
			}
			int max = 0;
			for(int i = 0; i < 1440; i++) max = Math.max(max, bots[i]);
			System.out.println("Blog #"+q+": "+max);
		}
	}

	static int convert(String s) {
		String[] x = s.split(":");
		int a = Integer.parseInt(x[0])*60;
		int b = Integer.parseInt(x[1]);
		return a+b;
	}
}
