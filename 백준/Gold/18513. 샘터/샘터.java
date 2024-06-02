import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static Queue<Point> q;
	static HashSet<Integer> hs;
	static int N, K;
	static int[] dir = {-1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		q = new ArrayDeque<Point>();
		hs = new HashSet<Integer>();
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int s = Integer.parseInt(st.nextToken());
			q.add(new Point(s, 0));
			hs.add(s);
		}//end input
		long answer = bfs();
		System.out.println(answer);
		
	}
	static long bfs() {
		long dist = 0;
		int count = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s = 0; s < size; s++) {
				Point p = q.poll();
				for(int d = 0; d < 2; d++) {
					int next = p.pos + dir[d];
					if(!hs.add(next)) continue;
					q.add(new Point(next, p.dist + 1));
					count++;
					dist += p.dist + 1;
					if(count == K) {
						return dist;
					}
				}
			}
		}
		return dist;
	}
	static class Point{
		int pos;
		int dist;
		public Point(int pos, int dist) {
			super();
			this.pos = pos;
			this.dist = dist;
		}
	}
}