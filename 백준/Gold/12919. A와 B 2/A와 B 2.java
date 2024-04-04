import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder S = new StringBuilder();
		StringBuilder T = new StringBuilder();
		S.append(br.readLine());
		T.append(br.readLine());
		flag = false;
		if(rec(S.toString(), T.toString())) System.out.println(1);
		else System.out.println(0);
	}
	//T를 줄이는 방식??
	//S를 늘리는 방식?? 뭐가 더 효율적일까?
	static boolean rec(String s, String t) {
//		System.out.println(s.toString() + " " + t.toString());
		if(s.length() == t.length()) {
			if(s.equals(t)) {
				return true;
			}
			return false;
		}
		if(t.charAt(t.length()-1) == 'A') {
			String string = t.substring(0, t.length()-1);
			if(rec(s, string)) {
				return true;
			}					
		}
		if(t.charAt(0) == 'B') {
			String string = t.substring(1);
			StringBuilder sb = new StringBuilder();
			sb.append(string);
			sb.reverse();
			if(rec(s, sb.toString())) {
				return true;
			}

		}
		//여기까지 안된다
		return false;
	}
}