import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class absolute {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(System.in);
		PrintWriter out = new PrintWriter("absolute.out");
		int t = scan.nextInt();
		for(int q = 1; q <= t; q++) {
			int n = scan.nextInt();
			Num[] arr = new Num[n];
			for(int i = 0; i < n; i++) {
				int m = scan.nextInt();
				arr[i] = new Num(m, Math.abs(m));
			}
			Arrays.sort(arr);
			out.print("Array #"+q+":");
			for(int i = 0; i < n; i++) out.print(" "+arr[i].n);
			out.println();
		}
		out.flush();
	}
	
	static class Num implements Comparable<Num>{
		
		int n;
		int abs;
		
		public Num(int n, int abs) {
			this.n = n;
			this.abs = abs;
		}

		@Override
		public int compareTo(Num arg0) {
			if(this.abs == arg0.abs) return this.n-arg0.n;
			return this.abs-arg0.abs;
		}
	}
}
