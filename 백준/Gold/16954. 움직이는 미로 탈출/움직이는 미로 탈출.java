import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int N = 8;
	static char[][] map;
	static char[][] copy;
	static int[] di = {0, 1, 0, -1, 1, -1, -1, 1, 0};
	static int[] dj = {1, 0, -1, 0, 1, 1, -1, -1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		map = new char[N][N];
		for(int i = 0; i < N; i++) {
			char[] c = br.readLine().toCharArray();
			map[i] = c;
		}//end input
		boolean flag = bfs();
		if(flag) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
		
	}
	static boolean bfs() {
		Queue<Point> q = new ArrayDeque<Point>();
		q.add(new Point(N-1, 0));
		boolean[][] visited;
		while(!q.isEmpty()) {
			int size = q.size();
			visited = new boolean[N][N];
			for(int s = 0; s < size; s++) {
				Point p = q.poll();
				if(map[p.i][p.j] == '#') continue;
				if(p.i == 0 && p.j == N - 1) {
					return true;
				}
				for(int d = 0; d < 9; d++) {
					int ni = p.i + di[d];
					int nj = p.j + dj[d];
					if(ni >= 0 && nj >= 0 && ni < N && nj < N && !visited[ni][nj] && map[ni][nj] != '#') {
						q.add(new Point(ni, nj));
						visited[ni][nj] = true;
					}
				}
			}
			updateMap();
		}
		return false;
		
	}
	static void updateMap() {
		for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '#') {
                    map[i][j] = '.';

                    if (i != 7) {
                        map[i + 1][j] = '#';
                    }
                }
            }
        }	
	}
	static class Point{
		int i, j;

		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
		
	}
}