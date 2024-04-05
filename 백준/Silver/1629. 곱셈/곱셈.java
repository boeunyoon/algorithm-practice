import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int A, B;
	static long C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Long.parseLong(st.nextToken());
		System.out.println(pow(A, B));
	}

	public static long pow(long A, long B) {

		if (B == 1) {
			return A % C;
		}
		long x = pow(A, B / 2);
		if (B % 2 == 1) {
			return (x * x % C) * A % C;
		}
		return x * x % C;

	}
}