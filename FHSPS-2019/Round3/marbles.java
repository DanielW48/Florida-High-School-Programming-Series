import java.util.*;
import java.math.*;

/*
Since the marbles are arranged along a circle, the order that lines are drawn does not matter as the polygon is convex
Therefore the number of ways to make polygons is equal to the number of ways to make triangles+quadrilaterals+pentagons+...
So the formula is the summation of n choose 3 + n choose 4 + n choose 5 + ... + n choose n
Which is equal to 2^n - n choose 2 - 1
reminder: n choose 2 = n*(n+1)/2

Special case when n < 3 as no polygons can be made
*/

public class marbles {
	
	static long mod = 1_000_000_007;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int q = 1; q <= t; q++) {
			long n = scan.nextLong();
			if(n < 3) {
				System.out.println("Marble Set #"+q+": 0");
				continue;
			}
			BigInteger a = new BigInteger(n+"");
			BigInteger b = new BigInteger((n+1)+"");
			BigInteger ab = a.multiply(b);
			ab = ab.divide(new BigInteger("2"));
			long nchoose2 = ab.mod(new BigInteger("1000000007")).longValue();
			long p = pow(2L, n);
			long ans = p-nchoose2-1;
			while(ans < 0) ans += mod;
			System.out.println("Marble Set #"+q+": "+(ans%mod));
		}
	}
	
	static long pow(long a, long b) {
		long x = 1, y = a;
		while(b > 0) {
			if(b % 2 > 0) {
				x = (x*y)%mod;
			}
			y = (y*y)%mod;
			b /= 2;
		}
		return x%mod;
	}
}
