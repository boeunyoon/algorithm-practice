import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N, T;
	static String[] cal = {"+", "-", " "};
	static StringBuilder sb;
	static List<String> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for(int tc = 0; tc < T; tc++) {
			sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			list = new ArrayList<String>();
			makeZero(1, "1");
			Collections.sort(list);
			for (String string : list) {
				System.out.println(string);
			}
			System.out.println();
		}
	}
	static void makeZero(int count, String ss) {
		if(count == N) {
			String string = ss.replaceAll(" ", "");
			if(check(string)) {
				list.add(ss);
			}
			return;
		}
		for(int i = 0; i < 3; i++) {
			makeZero(count + 1, ss+cal[i]+Integer.toString(count+1));
		}
	}
	static boolean check(String str) {
		StringTokenizer st = new StringTokenizer(str, "-|+", true);
		int sum = Integer.parseInt(st.nextToken());
		while(true) {
			if(!st.hasMoreElements()) {
				break;
			}
			String s = st.nextToken();
			if(s.equals("+")) {
				sum += Integer.parseInt(st.nextToken());
			}else if(s.equals("-")){
				sum -= Integer.parseInt(st.nextToken());
			}
		}
		if(sum == 0) {
			return true;			
		}
		return false;
	}
}