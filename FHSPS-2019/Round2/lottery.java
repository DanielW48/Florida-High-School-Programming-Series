import java.util.*;
import java.io.*;

public class lottery {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		for(int q = 1; q <= t; q++) {
			int query = Integer.parseInt(br.readLine());
			Trie pre = new Trie();
			Trie suf = new Trie();
			boolean rev = false;
			out.println("Lottery #"+q+":");
			for(int i = 0; i < query; i++) {
				String[] in = br.readLine().split(" ");
				int type = Integer.parseInt(in[0]);
				if(type == 3) rev = !rev;
				else {
					String s = in[1];
					if(type == 1) {
						if(!rev) {
							pre.add(s);
							suf.addBack(s);
						}
						else {
							pre.addBack(s);
							suf.add(s);
						}
					}
					if(type == 2) {
						if(!rev) out.println(pre.countPrefix(s));
						else out.println(suf.countPrefix(s));
					}
				}
			}
			out.println();
		}
		out.flush();
	}
	
	static class Trie {
		// adjust size of map for range of characters
		// along with index making
		Trie[] map;
		char letter;
		int end, numStrings;

		public Trie() { this('$', 0); } // root constructor
		public Trie(char ll, int ee) {
			letter = ll;
			end = ee;
			map = new Trie[26];
			for(int i = 0 ; i < 26; i++) map[i] = null;
		}
		public Trie add(String s) {
			Trie root = this;
			root.numStrings++;
			for(int i = 0 ; i < s.length() ; i++) {
				int index = s.charAt(i) - 'a';
				if(root.map[index] == null)
					root.map[index] = new Trie(s.charAt(i), 0);
				root = root.map[index];
				root.numStrings++;
			}
			root.end++;
			return this;
		}
		public Trie addBack(String s) {
			Trie root = this;
			root.numStrings++;
			for(int i = s.length()-1 ; i >= 0; i--) {
				int index = s.charAt(i) - 'a';
				if(root.map[index] == null)
					root.map[index] = new Trie(s.charAt(i), 0);
				root = root.map[index];
				root.numStrings++;
			}
			root.end++;
			return this;
		}
		public int countPrefix(String s) {
			Trie root = this;
			for(int i = 0; i < s.length(); i++) {
				int index = s.charAt(i) - 'a';
				if(root.map[index] == null) return 0;
				root = root.map[index];
			}
			return root.numStrings;
		}
	}
}
