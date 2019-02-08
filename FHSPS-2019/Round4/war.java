import java.util.*;
import java.io.*;

public class war {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(System.in);
		PrintWriter out = new PrintWriter(new File("war.out"));
		int t = scan.nextInt();
		for(int q = 1; q <= t; q++) {
			int n = scan.nextInt();
			int m = scan.nextInt();
			ArrayList<Edge>[] graph = new ArrayList[n];
			for(int i = 0; i < n; i++) graph[i] = new ArrayList<Edge>();
			for(int i = 0; i < m; i++) {
				int u = scan.nextInt()-1;
				int v = scan.nextInt()-1;
				long w = scan.nextLong();
				graph[u].add(new Edge(v, w));
				graph[v].add(new Edge(u, w));
			}
			long[] A = new long[n];
			long[] B = new long[n];
			Arrays.fill(A, Long.MAX_VALUE);
			Arrays.fill(B, Long.MAX_VALUE);
			Dijkstra(graph, A, 0);
			Dijkstra(graph, B, 1);
			out.print("War #"+q+": ");
			for(int i = 0; i < n; i++) {
				if(A[i] < B[i]) out.print("A");
				else if(B[i] < A[i]) out.print("B");
				else out.print("N");
			}
			out.println();
		}
		out.flush();
	}
	
	static void Dijkstra(ArrayList<Edge>[] graph, long[] v, int start) {
		v[start] = 0;
		PriorityQueue<Node> q = new PriorityQueue<Node>();
		q.add(new Node(start, 0));
		while(!q.isEmpty()) {
			Node p = q.poll();
			if(p.dist > v[p.n]) continue;
			for(int i = 0; i < graph[p.n].size(); i++) {
				Edge e = graph[p.n].get(i);
				long d = e.w+p.dist;
				if(v[e.to] > d) {
					v[e.to] = d;
					q.add(new Node(e.to, d));
				}
			}
		}
	}
	
	static class Edge{
		
		int to;
		long w;
		
		public Edge(int to, long w) {
			this.to = to;
			this.w = w;
		}
	}
	
	static class Node implements Comparable<Node>{
		
		int n;
		long dist;
		
		public Node(int n, long dist) {
			this.n = n;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(this.dist, o.dist);
		}
	}
}
