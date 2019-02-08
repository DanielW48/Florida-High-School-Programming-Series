import java.util.*;

public class rap {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		scan.nextLine();
		for(int q = 1; q <= t; q++) {
			String[] s = scan.nextLine().split(" ");
			boolean flow = true;
			for(int i = 1; i < s.length; i++) {
				String a = s[i];
				char c1 = a.charAt(0);
				String b = s[i-1];
				char c2 = b.charAt(b.length()-1);
				if(c1 != c2) flow = false;
			}
			if(flow) System.out.println("Sentence #"+q+": Flow");
			else System.out.println("Sentence #"+q+": No go");
		}
	}

}
