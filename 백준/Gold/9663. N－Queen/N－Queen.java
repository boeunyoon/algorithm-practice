import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, ans;
	static boolean[] visited, visited1, visited2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		visited = new boolean[N];
		visited1 = new boolean[N + N]; //좌하, 우상 대각
		visited2 = new boolean[N + N]; //좌상, 우하 대각
		ans = 0;
		rec(0);
		System.out.println(ans);
	}
	static void rec(int count) {
		if(count == N) { //종료 조건
			ans++;
			return;
		}
		//가능한 부분을 체크한다. 행에는 퀀이 무조건 1개 -> 행은 생각할 필요 없음, 열과 대각선만 체크하면된다.
		for(int i = 0; i < N; i++) {
			if(visited[i] || visited1[i + count] || visited2[count - i + N - 1]) continue;
			visited[i] = true;
			visited1[i + count] = true;
			visited2[count - i + N - 1] = true;
			rec(count + 1);
			visited[i] = false;
			visited1[i + count] = false;
			visited2[count - i + N - 1] = false;
		}
	}
}