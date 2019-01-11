import java.util.*;

//Solution runtime on test data: 1.4s
//Time limit: 3s

public class limebike {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int q = 1; q <= t; q++) {
			int n = scan.nextInt();
			int m = scan.nextInt();
			ArrayList<Edge>[] graph = new ArrayList[n];
			for(int i = 0; i < n; i++) graph[i] = new ArrayList<Edge>();
			int[][] in = new int[2][m];
			for(int i = 0; i < m; i++) {
				int a = scan.nextInt()-1;
				int b = scan.nextInt()-1;
				in[0][i] = a;
				in[1][i] = b;
				graph[a].add(new Edge(i, b));
				graph[b].add(new Edge(i, a));
			}
			int blocked = scan.nextInt()-1;
			boolean[] v = new boolean[n];
			long tot = go(v, in[0][blocked], graph, -1);
			v = new boolean[n];
			long a = go(v, in[0][blocked], graph, blocked);
			v = new boolean[n];
			long b = go(v, in[1][blocked], graph, blocked);
			long ans = a == tot? 0 : a*b;
			System.out.println("Day #"+q+": "+ans);
		}
	}
	
	static int go(boolean[] v, int i, ArrayList<Edge>[] graph, int blocked) {
		int c = 0;
		v[i] = true;
		ArrayDeque<Integer> bfs = new ArrayDeque<Integer>();
		bfs.add(i);
		while(!bfs.isEmpty()) {
			int x = bfs.poll();
			c++;
			for(int j = 0; j < graph[x].size(); j++) {
				Edge e = (Edge) graph[x].get(j);
				if(!v[e.to] && e.idx != blocked) {
					v[e.to] = true;
					bfs.add(e.to);
				}
			}
		}
		return c;
	}
	
	static class Edge{
		
		int idx;
		int to;
		
		public Edge(int i, int to) {
			this.idx = i;
			this.to = to;
		}
	}
}
