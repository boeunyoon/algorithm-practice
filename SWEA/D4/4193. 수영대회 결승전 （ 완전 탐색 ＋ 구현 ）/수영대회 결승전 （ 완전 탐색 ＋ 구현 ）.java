import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N, map[][], time;
	static Queue<Point> q;
	static boolean[][] visited;
	static int[] di = {-1, 0, 1, 0};
	static int[] dj = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			q = new ArrayDeque<Point>();
			visited = new boolean[N][N];
			st = new StringTokenizer(br.readLine());
			int startI = Integer.parseInt(st.nextToken());
			int startJ = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int endI = Integer.parseInt(st.nextToken());
			int endJ = Integer.parseInt(st.nextToken());
			//end input
			q.add(new Point(startI, startJ));
			visited[startI][startJ] = true;
			if(bfs(endI, endJ)) {
				System.out.println("#" + tc + " " + time);				
			}else {
				System.out.println("#" + tc + " " + -1);								
			}
		}
	}
	static boolean bfs(int endI, int endJ) {
		time = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s = 0; s < size; s++) {
				Point p = q.poll();
				if(p.i == endI && p.j == endJ) {
					return true;
				}
				for(int d = 0; d < 4; d++) {
					int ni = p.i + di[d];
					int nj = p.j + dj[d];
					if(ni >= 0 && nj >= 0 && ni < N && nj < N && !visited[ni][nj]) {
						if(map[ni][nj] == 0) { //빈칸
							q.add(new Point(ni, nj));
							visited[ni][nj] = true;
						}else if(time % 3 == 2 && map[ni][nj] == 2) { //소용돌이 
							q.add(new Point(ni, nj));
							visited[ni][nj] = true;
						}else if(time % 3 != 2 && map[ni][nj] == 2) {
							q.add(new Point(p.i, p.j));
						}
					}
				}
			}
			time++;
		}
		return false;
	}
	static class Point{
		int i;
		int j;
		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}
}