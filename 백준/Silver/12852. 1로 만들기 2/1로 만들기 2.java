import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int X, dp[], route[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		dp = new int[X + 1];
		route = new int[X + 1];
		for(int i = 2; i < X + 1; i++) {
			dp[i] = dp[i - 1] + 1;
			route[i] = i - 1;
			if(i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
				dp[i] = dp[i / 3] + 1;
				route[i] = i / 3;
			}
			if(i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
				dp[i] = dp[i / 2] + 1;
				route[i] = i / 2;
			}
		}
		System.out.println(dp[X]);
		int x = X;
		while(true) {
			if(x == 1) {
				sb.append(x).append(" ");
				break;
			}
			sb.append(x).append(" ");
			x = route[x];
		}
		System.out.println(sb.toString());
	}
}