import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, ans, arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		ans = Integer.MAX_VALUE;
		arr = new int[26];
		for(int i = 0; i < N; i++) {
			char[] c = br.readLine().toCharArray();
			for(int j = 0; j < c.length; j++) {
				arr[c[j] - 'A'] += Math.pow(10, c.length - j - 1);
			}
		}
		Arrays.sort(arr);
		int ans = 0;
	    int num = 9;
	    for (int i = 25 ; i >= 0 ; i--) {
	      ans += arr[i] * num;
	      num--;
	    }
	    System.out.println(ans);
	}
}