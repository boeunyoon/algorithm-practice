import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, count;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		count = 0;
		rec(1, 3, N);
		System.out.println(count);
		System.out.println(sb.toString());
	}
	static void rec(int A, int B, int n) {
		if(n == 1) {
			count++;
			sb.append(A + " " + B + "\n");
			return;
		}
		rec(A, 6 - A- B, n - 1); //A기둥에 있는 원판을  6 - A -B로 옮긴다.
		count++;
		sb.append(A + " " + B + "\n");
		rec(6 - A - B, B, n - 1); //B기둥에 있는 원판을 6 - A - B로 옮긴다.
	}
}