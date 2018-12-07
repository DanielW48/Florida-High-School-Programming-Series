import java.util.*;
import java.io.*;

public class staircase {

	public static void main(String[] args) throws FileNotFoundException {
		//Scanner scan = new Scanner(new File("staircase.in"));
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int q = 1; q <= t; q++){
			int n = scan.nextInt();
			int k = scan.nextInt();
			HashMap<Integer, Edges> graph = new HashMap<Integer, Edges>();
			for(int i = 0; i < n; i++){
				int a = scan.nextInt();
				int b = scan.nextInt();
				if(graph.containsKey(a)){
					Edges e = graph.get(a);
					e.to.add(b);
				}
				else{
					Edges e = new Edges(a);
					e.to.add(b);
					graph.put(a, e);
				}
				if(graph.containsKey(b)){
					Edges e = graph.get(b);
					e.to.add(a);
				}
				else{
					Edges e = new Edges(b);
					e.to.add(a);
					graph.put(b, e);
				}
			}
			HashSet<Integer> v = new HashSet<Integer>();
			ArrayDeque<Integer> bfs = new ArrayDeque<Integer>();
			v.add(0);
			bfs.add(0);
			while(bfs.size() > 0) {
				int p = bfs.poll();
				if(!graph.containsKey(p)) continue;
				Edges e = graph.get(p);
				for(Integer i : e.to) {
					if(!v.contains(i)) {
						v.add(i);
						bfs.add(i);
					}
				}
			}
			if(!v.contains(k)) System.out.println("Staircase #"+q+": Impossible");
			else System.out.println("Staircase #"+q+": Possible");
		}
	}
	
	static class Edges{
		
		int me;
		HashSet<Integer> to = new HashSet<Integer>();
		
		public Edges(int x){
			this.me = x;
		}
	}
}
