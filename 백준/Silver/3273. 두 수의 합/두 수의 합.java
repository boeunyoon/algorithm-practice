import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, X;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		int start = 0;
		int end = N - 1;
		int count = 0;
		Arrays.sort(arr);
		while(true) {
			if(start >= end) {
				break;
			}
			int sum = arr[start] + arr[end];
			if(sum < X) {
				start++;
			}else if(sum > X) {
				end--;
			}else {
				count++;
				start++;
				end--;
			}
		}
		System.out.println(count);
	}
}