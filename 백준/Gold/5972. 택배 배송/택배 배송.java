import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static List[] map;
	static boolean[] visited;
	static int[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new LinkedList[N + 1];
		for(int i = 1; i <= N; i++) {
			map[i] = new LinkedList<Point>();
		}
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			map[r1].add(new Point(r2, v));
			map[r2].add(new Point(r1, v));
		}//end input
		search();
		System.out.println(visit[N]);
	}
	static void search() {
		PriorityQueue<Point> pq = new PriorityQueue<Point>();
		visit = new int[N + 1];
		Arrays.fill(visit,Integer.MAX_VALUE);
		pq.add(new Point(1, 0));
		visit[1] = 0;
		int sum = 0;
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			for(int i = 0; i < map[p.next].size(); i++) {
				Point next = (Point)map[p.next].get(i);
				if(visit[next.next] <= visit[p.next]+ next.val) continue;
				visit[next.next] = visit[p.next]+ next.val;
				pq.add(next);
			}
		}
	}
	static class Point implements Comparable<Point>{
		int next, val;
		public Point(int next, int val) {
			this.next = next;
			this.val = val;
		}
		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return this.val - o.val;
		}
	}
}