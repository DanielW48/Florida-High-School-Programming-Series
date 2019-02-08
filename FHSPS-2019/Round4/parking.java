import java.util.*;

public class parking {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int q = 1; q <= t; q++) {
			//System.out.println("new testcase");
			Vector me = new Vector(scan.nextInt(), scan.nextInt());
			int n = scan.nextInt();
			double min = Integer.MAX_VALUE;
			int[][] in = new int[4][n];
			int ans = 0;
			for(int i = 0; i < n; i++) {
				int minx = scan.nextInt();
				int miny = scan.nextInt();
				int maxx = scan.nextInt();
				int maxy = scan.nextInt();
				in[0][i] = minx;
				in[1][i] = miny;
				in[2][i] = maxx;
				in[3][i] = maxy;
				
				if(me.x <= maxx && me.x >= minx && me.y <= maxy && me.y >= miny) {
					System.err.println("Invalid test case : "+q+" / start in garage "+(i+1));
				}
				
				if(minx >= maxx || miny >= maxy) {
					System.err.println("Invalid test case : "+q+" / line : "+(i+1));
				}
				
				Vector bl = new Vector(minx, miny);
				Vector tl = new Vector(minx, maxy);
				Vector br = new Vector(maxx, miny);
				Vector tr = new Vector(maxx, maxy);
				
				double m = Integer.MAX_VALUE;
				m = Math.min(m, pointLineSegDist(bl, tl, me));
				m = Math.min(m, pointLineSegDist(bl, br, me));
				m = Math.min(m, pointLineSegDist(tr, tl, me));
				m = Math.min(m, pointLineSegDist(br, tr, me));
				
				if(m < min) {
					min = m;
					ans = i;
				}
			}
			for(int i = 0; i < n; i++) {
				if(i == ans) continue;
				Vector bl = new Vector(in[0][i], in[1][i]);
				Vector tl = new Vector(in[0][i], in[3][i]);
				Vector br = new Vector(in[2][i], in[1][i]);
				Vector tr = new Vector(in[2][i], in[3][i]);
				
				double m = Integer.MAX_VALUE;
				m = Math.min(m, pointLineSegDist(bl, tl, me));
				m = Math.min(m, pointLineSegDist(bl, br, me));
				m = Math.min(m, pointLineSegDist(tr, tl, me));
				m = Math.min(m, pointLineSegDist(br, tr, me));
				
				if(Math.abs(m-ans) < -1e6) {
					System.err.println("Invalid test case : "+q+" / answer too close!");
				}
			}
			System.out.println("Day #"+q+": Garage "+(char)(ans+'A'));
		}
	}
	
	static class Vector{
		
		double x;
		double y;
		
		public Vector(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public Vector(double x, double y) {
			this.x = x;
			this.y = y;
		}
		
		public Vector add(Vector v) {
			return new Vector(this.x+v.x, this.y+v.y);
		}
		
		public Vector sub(Vector v) {
			return new Vector(this.x-v.x, this.y-v.y);
		}
		
		public double dot(Vector v) {
			return this.x*v.x+this.y*v.y;
		}
		
		public double mag(){
			return Math.sqrt(dot(this));
		}
		
		public Vector scale(double t) {
			return new Vector(this.x*t, this.y*t);
		}
	}
	
	static double pointLineSegDist(Vector l1, Vector l2, Vector p) {
        Vector line = l2.sub(l1); double l = line.dot(line);
        double t = p.sub(l1).dot(line) / l;
        if (t < 0) return l1.sub(p).mag(); // Remove this line
        else if(t > 1) return l2.sub(p).mag(); // & this for pointLineDist
        return line.scale(t).add(l1).sub(p).mag();
    }
}
