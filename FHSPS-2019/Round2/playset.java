import java.util.*;

public class playset {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int q = 1; q <= t; q++) {
			int n = scan.nextInt();
			int m = scan.nextInt();
			int[] arr = new int[n];
			for(int i = 0; i < n; i++) arr[i] = scan.nextInt();
			int[] freq = new int[n+1];
			for(int x = 1; x <= m; x++) {
				int count = 0;
				for(int i = 0; i < n; i++)
					if(x%arr[i] == 0) count++;
				freq[count]++;
			}
			int max = -1;
			int count = -1;
			for(int i = 0; i <= n; i++) {
				if(freq[i] > 0) {
					max = i;
					count = freq[i];
				}
			}
			System.out.println("Week #"+q+": "+max+" "+count);
		}
	}
}

/*
10 25
2 2 2 2 2 23 23 23 23 23

*/