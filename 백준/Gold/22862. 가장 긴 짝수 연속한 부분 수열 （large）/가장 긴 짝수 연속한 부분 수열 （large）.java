import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K, arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}//end input
		//짝수가 연속된 수열에서 홀수를 K개 삭제한다는 의미는 최대 K개의 홀수가 담긴 배열의 크기를 찾는것과 같은 의미이다.
		//구간안에 K개의 홀수가 담겨있는지 체크한다.
		int ans = Integer.MIN_VALUE;
		int start = 0;
		int count = 0;
		int end = 0;
		while(true) {
			if(end == N) {
				break;
			}
			if(count <= K) {
				if(arr[end] % 2 == 1) {
					count++;
				}
				end++;
			}else if(count > K){
				if(arr[start] % 2 == 1) {
					count--;
				}
				start++;
			}
			if(count <= K) {
				ans = Math.max(ans, end - start - count);
			}
		}
		System.out.println(ans);
	}
}