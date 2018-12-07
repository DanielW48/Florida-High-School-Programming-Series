import java.util.*;

public class trolley {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int q = 1; q <= t; q++) {
			int n = (1 << scan.nextInt());
			long[] arr = new long[n+1];
			for(int i = 1; i <= n; i++) arr[i] = scan.nextInt();
			int left = 1;
			int right = n;
			while(left < right) {
				int mid = (left+right)/2;
				long up = 0;
				long down = 0;
				for(int i = left; i <= mid; i++) up += arr[i];
				for(int i = mid+1; i <= right; i++) down += arr[i];
				if(up >= down)
					right = mid;
				else
					left = mid+1;
			}
			System.out.println("Trolley #"+q+": "+left);
		}
	}
}
