import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static long N, P, Q, arr[];
	static HashMap<Long, Long> hm;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		hm = new HashMap<Long, Long>();
		N = Long.parseLong(st.nextToken());
		P = Long.parseLong(st.nextToken());
		Q = Long.parseLong(st.nextToken());
		long ans = rec(N);
		System.out.println(ans);
	}
	static long rec(long n) {
		if(n == 0) return 1;
		if(hm.containsKey(n)) {
			return hm.get(n);
		}
		long a = (long)(n / P);
		long b = (long)(n / Q);
		hm.put(n, rec(a) + rec(b));
		return hm.get(n);
	}
}