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
		int[] numbers = new int[N];
		rec(0, "");
	}
	static void rec(int count, String st) {
		if(count == N) {
			System.out.println(st);
			System.exit(0);
			return;
		}
		for(int i = 1; i <= 3; i++) {
			if(check(st + i)) {
				//나쁜 문자열이 아니면 진행
				rec(count + 1, st + i);
			}
		}
	}
	static boolean check(String st) {
		//동일한 문자열이 반복되는지 확인한다. 
		//반복되는 최대 길이는 N/2
		int length = st.length() / 2;
		//N-1에서 N까지와 N-3에서 N-2까지의 문자열과 같이 전부 절반의 길이 부터 최대길이까지 비교하여 나쁜 문자열인지 확인한다. 
		//이전꺼는 비교할 필요 없음 -> 유효했으니까 -> 새로운 문자열이 붙은 부분만 비교
		for (int i = 1; i <= length; i++) {
            if (st.substring(st.length() - i).equals(st.substring(st.length() - 2 * i, st.length() - i))) {
                return false;
            }
        }
        return true;
	}
}