import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, map[][], min;
	static boolean[][] visited;
	static int[] di = {-1, 0, 1, 0};
	static int[] dj = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited = new boolean[N][N];
		min = 0;
		for(int i = 0; i < N; i++) {
			char[] c = br.readLine().toCharArray();
			for(int j = 0; j < N; j++) {
				map[i][j] = c[j] - '0';
			}
		}//end input
		//dfs로 최소값을 갱신하자
		bfs();
		System.out.println(min);
	}
	static void bfs() {
		PriorityQueue<Point> pq = new PriorityQueue<Point>();
		visited[0][0] = true;
		pq.add(new Point(0, 0, 0));
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			if(p.i == N - 1 && p.j == N - 1) {
				min = p.count;
				return;
			}
			for(int d = 0; d < 4; d++) {
				int ni = p.i + di[d];
				int nj = p.j + dj[d];
				if(ni >= 0 && nj >= 0 && ni < N && nj < N && !visited[ni][nj]) {
					if(map[ni][nj] == 0) {
						visited[ni][nj] = true;
						pq.add(new Point(ni, nj, p.count + 1));						
					}else {
						visited[ni][nj] = true;
						pq.add(new Point(ni, nj, p.count));	
					}
				}
			}
		}
	}
	static class Point implements Comparable<Point>{
		int i, j, count;
		public Point(int i, int j, int count) {
			super();
			this.i = i;
			this.j = j;
			this.count = count;
		}
		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return this.count - o.count;
		}
	}
}