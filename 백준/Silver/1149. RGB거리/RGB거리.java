import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int[] memoR = new int[N];
		int[] memoG = new int[N];
		int[] memoB = new int[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int G = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			if(i == 0) {
				memoR[i] = R;
				memoG[i] = G;
				memoB[i] = B;
				continue;
			}
			memoR[i] = Math.min(memoB[i-1], memoG[i-1]) + R;
			memoG[i] = Math.min(memoR[i-1], memoB[i-1]) + G;
			memoB[i] = Math.min(memoR[i-1], memoG[i-1]) + B;
		}
		System.out.println(Math.min(Math.min(memoR[N - 1], memoG[N - 1]), memoB[N - 1]));
	}
}