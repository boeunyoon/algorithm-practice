import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, dp[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int[] time = new int[N + 1];
        int[] price = new int[N + 1];
        int max = 0;
		dp = new int[N + 1];
		for(int i = 0; i < N; i++) {
			 st = new StringTokenizer(br.readLine());
			 time[i] = Integer.parseInt(st.nextToken());
			 price[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i <= N; i++) {
            max = Math.max(max, dp[i]);

            int ni = i + time[i];
            if (ni <= N) {
                dp[ni] = Math.max(dp[ni], max + price[i]);
            }

//            for (int t : dp) {
//                System.out.print(t + " ");
//            }
//            System.out.println();
        }

        System.out.println(max);
	}
}