import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}//end input
		Arrays.sort(arr);
		int start = 0;
		int end = 1;
		int ans = Integer.MAX_VALUE;
		while(true) {
			if(start == N - 1 || end == N) break;
			if(arr[end] - arr[start] < M) {
				end++;
			}else {
				ans = Math.min(ans, arr[end] - arr[start]);
				start++;
			}
		}
		System.out.println(ans);
	}
}