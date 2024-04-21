import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ans = 0;
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}//end input
		
		Arrays.sort(arr);
		for(int i = 0; i < N; i++) {
			int target = arr[i];
			int start = 0;
			int end = N - 1;
			while(true) {
				if(start >= end) break;
				if(arr[start] + arr[end] == target) {
					if(start == i) {
						start++;
					}else if(end == i) {
						end--;
					}else {
						ans++;
						break;
					}
				}else if(arr[start] + arr[end] > target) {
					end--;
				}else {
					start++;
				}
			}
		}
		System.out.println(ans);
	}
}