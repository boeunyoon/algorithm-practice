import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, map[][], min, copy[][];
	static List<Point> virus;
	static Point[] result;
	static boolean[] visit;
	static int[] di = {-1, 0, 1, 0};
	static int[] dj = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		map = new int[N][N];
		virus = new ArrayList<Point>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) virus.add(new Point(i, j));
			}
		}//end input
		result = new Point[M];
		visit = new boolean[virus.size()];
		combi(0, 0);
		System.out.println(min == Integer.MAX_VALUE ? -1 : min - 1);
	}
	static void combi(int start, int count) {
		if(count == M) {
//			System.out.println(Arrays.toString(result));
			deepCopy();
			int time = bfs();
			boolean flag = true;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(copy[i][j] == 0 || copy[i][j] == 2) {
						flag = false;
						break;
					}
				}
			}
			if(flag) min = Math.min(min, time);
			return;
		}
		for(int i = start; i < virus.size(); i++) {
			if(visit[i]) continue;
			visit[i] = true;
			result[count] = virus.get(i);
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
		Queue<Point> q = new ArrayDeque<Point>();
		for(int i = 0; i < M; i++) {
			Point p = result[i];
			copy[p.i][p.j] = 3;
			q.add(p);
		}
		int time = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s = 0; s < size; s++) {
				Point p = q.poll();
				for(int d = 0; d < 4; d++) {
					int ni = p.i + di[d];
					int nj = p.j + dj[d];
					if(ni >= 0 && nj >= 0 && ni < N && nj < N && copy[ni][nj] != 1 && copy[ni][nj] != 3) {
						q.add(new Point(ni, nj));
						copy[ni][nj] = 3;
					}
				}
			}
			time++;
		}
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