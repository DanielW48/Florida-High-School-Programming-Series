import java.util.*;

public class grading {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int q = 1; q <= t; q++) {
			int n = scan.nextInt();
			if(n >= 0 && n <= 100)
				System.out.println("Grade #"+q+": No Change");
			else
				System.out.println("Grade #"+q+": Change");
		}
	}
}
