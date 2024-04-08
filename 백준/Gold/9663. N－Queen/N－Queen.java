import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, ans;
	static int[][] map;
	static boolean[] visited1, visited2, visited3;
//	static int[] di = {-1, 0, 1, 0, 1, -1, 1}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited1 = new boolean[40];
		visited2 = new boolean[40];
		visited3 = new boolean[40];
		ans = 0;
		dfs(0);
		System.out.println(ans);
	}
	static void dfs(int count) {
		if(count == N) {
			ans++;
			return;
		}
		for(int i = 0; i < N; i++) {
			if(visited1[i] || visited2[i + count] || visited3[count - i + N - 1]) continue;
			visited1[i] = true;
			visited2[i + count] = true;
			visited3[count - i + N - 1] = true;
			dfs(count + 1);
			visited1[i] = false;
			visited2[i + count] = false;
			visited3[count - i + N - 1] = false;
	
		}
	}
}