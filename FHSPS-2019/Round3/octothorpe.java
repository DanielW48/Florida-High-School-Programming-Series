import java.util.*;

public class octothorpe {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int q = 1; q <= t; q++) {
			long n = scan.nextLong()-1;
			long kk = scan.nextLong();
			if(kk >= 26) {
				System.out.println("Request #"+q+": .");
				continue;
			}
			int k = (int)kk;
			System.out.println("Request #"+q+": "+solve(n, k));
		}
	}

	static char solve(long n, int k) {
		long pp = pow(k);
		long nr = n/pp;
		long nc = n%pp;
		if(k == 1) return (nr%2 == 1 || nc % 2 == 1)? '#' : '.';
		pp /= 5;
		
		int quadrantR = (int)(nr/pp);
		int quadrantC = (int)(nc/pp);
		if(quadrantR % 2 == 0 && quadrantC % 2 == 0) return '.';
		
		nr = nr%pp;
		nc = nc%pp;
		return solve(nr*pp+nc, k-1);
	}

	static long pow(int k) {
		if(k == 0) return 1;
		return 5*pow(k-1);
	}
}
