import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, map[][], count, ans;
	static int[] di = {0, 1, 0, -1};
	static int[] dj = {1, 0, -1, 0};
	static int[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		visited = new int[N][N];
		map = new int[N][N];
		count = 0;
		ans = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}//end input
		int is = 1;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 1 && visited[i][j] == 0) {
					visited[i][j] = is;
					bfs(i, j, is);
					is++;
				}
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 1) {
					int min = bfs2(i, j);
					ans = Math.min(ans, min);
				}
			}
		}
		System.out.println(ans - 1);
	}
	static void bfs(int i, int j, int is) {
		Queue<Point> q = new ArrayDeque<Point>();
		q.add(new Point(i, j));
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int d = 0; d < 4; d++) {
				int ni = p.i + di[d];
				int nj = p.j + dj[d];
				if(ni >= 0 && nj >= 0 && ni < N && nj < N && visited[ni][nj] == 0 && map[ni][nj] == 1) {
					q.add(new Point(ni, nj));
					visited[ni][nj] = is;
				}
			}
		}
	}
	static int bfs2(int i, int j) {
		Queue<Point> q = new ArrayDeque<Point>();
		int island = visited[i][j];
		boolean[][] check = new boolean[N][N];
		check[i][j] = true;
		q.add(new Point(i, j, 0));
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(visited[p.i][p.j] != 0 && visited[p.i][p.j] != island) {
				return p.dist;
			}
			for(int d = 0; d < 4; d++) {
				int ni = p.i + di[d];
				int nj = p.j + dj[d];
				if(ni >= 0 && nj >= 0 && ni < N && nj < N && visited[ni][nj] != island && !check[ni][nj]) {
					check[ni][nj] = true;
					q.add(new Point(ni, nj, p.dist + 1));
				}
			}
		}
		return Integer.MAX_VALUE;
	}
	static class Point{
		int i, j, dist;
		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
		public Point(int i, int j, int dist) {
			this.i = i;
			this.j = j;
			this.dist = dist;
		}
	}
}