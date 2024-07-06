import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static long A, B;
	static boolean[] prime;
	static Map<Long, Boolean> hm;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		int fb = (int)Math.sqrt(B);
		hm = new HashMap<Long, Boolean>();
		prime = new boolean[fb + 1];
		prime[0] = true;
		prime[1] = true;
		System.out.println(isPrime(fb));
	}
	static int isPrime(int fb) {
		for(int i = 2; i * i <= fb; i++) {
			if(!prime[i]) {
				for(int j = i * i; j <= fb; j+=i) {
					prime[j] = true;
				}
			}
		}
		int count = 0;
		for(int i = 2; i <= fb; i++) {
			if(!prime[i]) {
				int cnt = 2;
				long t = i;
				do {
					t = (long)Math.pow(i, cnt++);					
				}while(t < A);
				
				while(true) {
					if(t > B) break;
					else {
						if(hm.containsKey(t)) {
							hm.put(t, true);
						}else {
							count++;
						}
					}
					t = (long)Math.pow(i, cnt++);
				}
			}
		}
		return count;
	}
}