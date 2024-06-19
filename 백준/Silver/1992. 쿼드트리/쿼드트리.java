import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, map[][];
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			char[] c = br.readLine().toCharArray();
			for(int j = 0; j < N; j++) {
				map[i][j] = c[j] - '0';
			}
			
		}//end input
		rec(N, 0, 0);
		System.out.println(sb.toString());
	}
	static void rec(int size, int x, int y) {
		if(size == 1) {
			sb.append(map[y][x]);
			return;
		}
		boolean flag = true;
		int first = map[y][x];
		//같은 숫자인지 체크
		for(int i = y; i < y + size; i++) {
			for(int j = x; j < x + size; j++) {
				if(first != map[i][j]) {
					flag = false;
					break;
				}
			}
		}
		int nextSize = size / 2;
		if(flag) {
			//같은 숫자만 있음
			sb.append(first);
		}else {
			//분할해서 다시 호출
			sb.append("(");
			rec(nextSize, x, y);
			rec(nextSize, x + nextSize, y);
			rec(nextSize, x, y + nextSize);
			rec(nextSize, x + nextSize, y + nextSize);
			sb.append(")");
		}
	}
}