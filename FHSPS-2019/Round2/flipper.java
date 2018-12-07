import java.util.*;

public class flipper {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int q = 1; q <= t; q++) {
			int n = (int)(scan.nextLong()%10);
			int c = 0;
			while(n != 6 && n != 7) {
				n += 2;
				n %= 10;
				c++;
			}
			if(n == 6) c++;
			System.out.println("Input #"+q+": "+c);
		}
	}
}
