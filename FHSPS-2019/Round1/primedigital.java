import java.util.*;

public class primedigital {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int q = 1; q <= t; q++){
			long l = scan.nextLong();
			long r = scan.nextLong();
			long s = count(l-1);
			long a = count(r);
			System.out.println("Range #"+q+": "+(a-s));
		}
	}

	static long count(long x){
		if(x == 0 || x == 1) return 0;
		x = fix(x);
		x = mask(x);
		String s = x+"";
		int l = s.length();
		int i = 1;
		long ans1 = 0;
		while(i < l){
			ans1 += (long)Math.pow(4, i);
			i++;
		}
		long ans2 = 0;
		int pos = l-1;
		for(int n = 0; n < l-1; n++){
			int m = s.charAt(n)-'0';
			ans2 += (m-1)*Math.pow(4, pos);
			pos--;
		}
		ans2 += s.charAt(l-1)-'0';
		return ans1+ans2;
	}

	private static long fix(long x) {
		char[] s = (x+"").toCharArray();
		for(int i = 0; i < s.length; i++){
			int n = s[i]-'0';
			if(!isPrime(n)){
				if(n == 0 || n == 1){
					boolean found = false;
					int k = 0;
					for(int j = i-1; j >= 0; j--){
						k = j;
						if(s[j] != '2'){
							found = true;
							if(s[j] == '3'){
								s[j] = '2';
							}
							else if(s[j] == '5'){
								s[j] = '3';
							}
							else{
								s[j] = '5';
							}
							break;
						}
					}
					if(!found){
						String res = "";
						for(int j = 1; j < s.length; j++){
							res += "7";
						}
						return Long.parseLong(res);
					}
					else{
						String res = "";
						for(int j = 0; j <= k; j++){
							res += s[j];
						}
						for(int j = k+1; j < s.length; j++){
							res += "7";
						}
						return Long.parseLong(res);
					}
				}
				if(n == 4){
					String res = "";
					for(int j = 0; j < i; j++){
						res += s[j];
					}
					res += "3";
					for(int j = i+1; j < s.length; j++){
						res += "7";
					}
					return Long.parseLong(res);
				}
				if(n == 6){
					String res = "";
					for(int j = 0; j < i; j++){
						res += s[j];
					}
					res += "5";
					for(int j = i+1; j < s.length; j++){
						res += "7";
					}
					return Long.parseLong(res);
				}
				if(n == 8 || n == 9){
					String res = "";
					for(int j = 0; j < i; j++){
						res += s[j];
					}
					res += "7";
					for(int j = i+1; j < s.length; j++){
						res += "7";
					}
					return Long.parseLong(res);
				}
			}
		}
		return x;
	}

	static long mask(long x){
		String s = x+"";
		String b = "";
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == '2') b += 1;
			else if(s.charAt(i) == '3') b += 2;
			else if(s.charAt(i) == '5') b += 3;
			else b += 4;
		}
		return Long.parseLong(b);
	}

	static boolean isPrimedigital(long x){
		String s = x+"";
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) != '2' &&
					s.charAt(i) != '3' &&
					s.charAt(i) != '5' &&
					s.charAt(i) != '7') return false;
		}
		return true;
	}

	static boolean isPrime(int x){
		return x == 2 || x == 3 || x == 5 || x == 7;
	}

}
