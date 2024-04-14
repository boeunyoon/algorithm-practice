import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int N, min;
	static char[][] map;
	static Log start, end;
	static int[] di = { -1, 1, 0, 0, 0 };
	static int[] dj = { 0, 0, -1, 1, 0 };
	static boolean[][][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		map = new char[N][N];
		visited = new boolean[N][N][2];
		start = new Log(-1, -1, -1, 0);
		end = new Log(-1, -1, -1, 0);
		int Bcount = 1, Ecount = 1;
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'B') {
					if (Bcount == 1) {
						start.j = j;
						start.i = i;
						Bcount++;
					} else if (Bcount == 2) {
						if (start.j == j)
							start.type = 0;
						else
							start.type = 1;
						start.j = j;
						start.i = i;
						Bcount++;
					}
				}

				if (map[i][j] == 'E') {
					if (Ecount == 1) {
						end.j = j;
						end.i = i;
						Ecount++;
					} else if (Ecount == 2) {
						if (end.j == j)
							end.type = 0;
						else
							end.type = 1;
						end.j = j;
						end.i = i;
						Ecount++;
					}
				}
			}
		} // end input
		visited[start.i][start.j][start.type] = true;
		bfs();
	}

	static void bfs() {
		Queue<Log> q = new ArrayDeque<Log>();
		q.add(start);
		while (!q.isEmpty()) {
			Log log = q.poll();
			int curI = log.i;
			int curJ = log.j;
			if (curI == end.i && curJ == end.j && log.type == end.type) {
				System.out.println(log.count);
				return;
			}
			for (int d = 0; d < 5; d++) {
				int ni = curI + di[d];
				int nj = curJ + dj[d];
				if (ni >= 0 && nj >= 0 && ni < N && nj < N) {
					if(selectDir(d, ni, nj, log.type)) {
						if(d == 4 && log.type == 0) {
							q.add(new Log(ni, nj, 1, log.count+1));
						}else if(d == 4 && log.type == 1) {
							q.add(new Log(ni, nj, 0, log.count+1));
						}else {
							q.add(new Log(ni, nj, log.type, log.count+1));
						}
					}
				}
			}
		}
		System.out.println(0);
	}

	static boolean selectDir(int d, int ni, int nj, int type) {
		boolean flag = false;
		switch (d) {
		case 0:
			flag = up(d, ni, nj, type);
			break;
		case 1:
			flag = down(d, ni, nj, type);
			break;
		case 2:
			flag = left(d, ni, nj, type);
			break;
		case 3:
			flag = right(d, ni, nj, type);
			break;
		case 4:
			flag = turn(d, ni, nj, type);
			break;
		}
		return flag;
	}

	static boolean up(int d, int ni, int nj, int type) {
		if(type == 0) { //수직
			if(ni > 0 && map[ni-1][nj] != '1') {
				if(!visited[ni][nj][type]) {
					visited[ni][nj][type] = true;
					return true;
				}
			}
		}else if(type == 1){//수평
			if(map[ni][nj-1] != '1' && map[ni][nj] != '1' && map[ni][nj+1] != '1') {
				if(!visited[ni][nj][type]) {
					visited[ni][nj][type] = true;
					return true;
				}
			}
		}
		return false;
	}

	static boolean down(int d, int ni, int nj, int type) {
		if(type == 0) { //수직
			if(ni < N-1 && map[ni+1][nj] != '1') {
				if(!visited[ni][nj][type]) {
					visited[ni][nj][type] = true;
					return true;
				}
			}
		}else if(type == 1){//수평
			if(map[ni][nj-1] != '1' && map[ni][nj] != '1' && map[ni][nj+1] != '1') {
				if(!visited[ni][nj][type]) {
					visited[ni][nj][type] = true;
					return true;
				}
			}
		}
		return false;
	}

	static boolean left(int d, int ni, int nj, int type) {
		if(type == 0) { //수직
			if(map[ni-1][nj] != '1' && map[ni][nj] != '1' && map[ni+1][nj] != '1') {
				if(!visited[ni][nj][type]) {
					visited[ni][nj][type] = true;
					return true;
				}
			}
		}else if(type == 1){//수평
			if(nj-1 >= 0 && map[ni][nj-1] != '1') {
				if(!visited[ni][nj][type]) {
					visited[ni][nj][type] = true;
					return true;
				}
			}
		}
		return false;
	}

	static boolean right(int d, int ni, int nj, int type) {
		if(type == 0) { //수직
			if(map[ni-1][nj] != '1' && map[ni][nj] != '1' && map[ni+1][nj] != '1') {
				if(!visited[ni][nj][type]) {
					visited[ni][nj][type] = true;
					return true;
				}
			}
		}else if(type == 1){//수평
			if(nj+1 < N && map[ni][nj+1] != '1') {
				if(!visited[ni][nj][type]) {
					visited[ni][nj][type] = true;
					return true;
				}
			}
		}
		return false;
	}
	static boolean turn(int d, int ni, int nj, int type) {
		if(nj != 0 && nj != N - 1 && ni != 0 && ni != N - 1) {
			if(type == 0) { //수직
				if (map[ni][nj - 1] != '1' && map[ni - 1][nj - 1] != '1' && map[ni + 1][nj - 1] != '1'
						&& map[ni][nj + 1] != '1' && map[ni - 1][nj + 1]  != '1'
						&& map[ni + 1][nj + 1] != '1') {
					if(!visited[ni][nj][1]) {
						visited[ni][nj][1] = true;
						return true;
					}
				}
			}else if(type == 1){//수평
				if (map[ni - 1][nj - 1] != '1' && map[ni - 1][nj] != '1' && map[ni - 1][nj + 1] != '1'
						&& map[ni + 1][nj - 1] != '1' && map[ni + 1][nj] != '1'
						&& map[ni + 1][nj + 1] != '1') {
					if(!visited[ni][nj][0]) {
						visited[ni][nj][0] = true;
						return true;
					}
				}
			}
		}
		return false;
	}

	static class Log {
		int i, j, count;
		int type;

		public Log(int i, int j, int type, int count) {
			super();
			this.i = i;
			this.j = j;
			this.type = type;
			this.count = count;
		}
	}
}