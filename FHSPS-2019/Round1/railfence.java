import java.util.*;

public class railfence {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		scan.nextLine();
		char[] ans = new char[n];
		String s = scan.nextLine();
		int add = 2*(k-1);
		int i = 0;
		int j = 0;
		while(i < n) {
			ans[i] = s.charAt(j);
			i += add;
			j++;
		}
		add -= 2;
		int inv = 2;
		for(int m = 1; m < k-1; m++) {
			i = m;
			int o = 0;
			while(i < n) {
				ans[i] = s.charAt(j);
				j++;
				if(o % 2 == 0) i += add;
				else i += inv;
				o++;
			}
			add -= 2;
			inv += 2;
		}
		i = k-1;
		add = 2*(k-1);
		while(i < n) {
			ans[i] = s.charAt(j);
			i += add;
			j++;
		}
		for(i = 0; i < n; i++) System.out.print(ans[i]);
		System.out.println();
	}
}

/*
11 3
horel ollwd
*/