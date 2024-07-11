import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean[] prime;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		prime = new boolean[10001];
		for(int i = 2; i * i < 10001; i++) {
			if(!prime[i]) {
				for(int j = i * i; j < 10001; j+=i) {
					prime[j] = true;
				}
			}
		}// 소수 구하기
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			//2보다 큰 짝수는 두수의 합으로 나타낼 수 있음
			//두 소수 차이가 가장 작은 것을 출력한다.
			//합 구하기
			for(int i = N / 2; i > 0; i--) {
				int num = N - i;
				if(!prime[num] && !prime[i]) {
					sb.append(i + " " + num).append("\n");
					break;
				}
			}
		}
		System.out.println(sb.toString());
	}
}