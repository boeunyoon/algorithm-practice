import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, map[][], min, copy[][], blank;
//	static List<Point> virus;
	static Point[] virus;
	static Point[] result;
	static boolean[] visit;
	static Queue<Point> q;
	static int[] di = {-1, 0, 1, 0};
	static int[] dj = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		map = new int[N][N];
		blank = 0;
//		virus = new ArrayList<Point>();
		virus = new Point[10];
		int count = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					virus[count++] = new Point(i, j);
				}else if(map[i][j] == 0) {
					blank++;
				}
			}
		}//end input
		result = new Point[M];
		visit = new boolean[10];
		combi(0, 0);
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}
	static void combi(int start, int count) {
		if(count == M) {
//			System.out.println(Arrays.toString(result));
			deepCopy();
			int time = bfs();
			min = Math.min(min, time);
			return;
		}
		for(int i = start; i < 10; i++) {
			if(virus[i] == null) return;
			if(visit[i]) continue;
			visit[i] = true;
			result[count] = virus[i];
			combi(i + 1, count + 1);
			visit[i] = false;
		}
	}
	static void deepCopy() {
		copy = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				copy[i][j] = map[i][j];
			}
		}
	}
	static int bfs() {
		q = new ArrayDeque<Point>();
		for(int i = 0; i < M; i++) {
			Point p = result[i];
			copy[p.i][p.j] = 1;
			q.add(p);
		}
		int time = 0;
		int count = blank;
		if(blank == 0) return 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s = 0; s < size; s++) {
				Point p = q.poll();
				for(int d = 0; d < 4; d++) {
					int ni = p.i + di[d];
					int nj = p.j + dj[d];
					if(ni >= 0 && nj >= 0 && ni < N && nj < N && copy[ni][nj] != 1) {
						if(copy[ni][nj] == 0) {
							count--;
						}
						q.add(new Point(ni, nj));
						copy[ni][nj] = 1;
					}
				}
				if(count == 0) return time + 1;
			}
			time++;
		}
		if(count != 0) return Integer.MAX_VALUE;
		return time;
	}
	static class Point{
		int i, j;
		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
		@Override
		public String toString() {
			return "Point [i=" + i + ", j=" + j + "]";
		}
	}
}