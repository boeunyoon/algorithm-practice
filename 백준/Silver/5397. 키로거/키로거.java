import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		//backspace -> -, arrow -> <, > , and the others 
		for(int tc = 0; tc < T; tc++) {
			LinkedList<Character> list = new LinkedList<Character>();
			StringBuilder sb = new StringBuilder();
			String fullPassword = br.readLine();
			char[] passArr = fullPassword.toCharArray();
			int cursor = 0;
			Stack<Character> left = new Stack<Character>();
			Stack<Character> right = new Stack<Character>();
			for(int i = 0; i < passArr.length; i++) {
				char c = passArr[i];
				if(c == '<') {
					if(!left.isEmpty()) {
						right.push(left.pop());
					}
				}else if(c == '>') {
					if(!right.isEmpty()) {
						left.push(right.pop());
					}
				}else if(c == '-') {
					if(!left.isEmpty()) {
						left.pop();
					}
				}else {
					left.push(c);
				}
			}
			while(true) {
				if(right.isEmpty()) {
					break;
				}
				left.push(right.pop());
			}
			for (char c : left) {
				sb.append(c);
			}
			System.out.println(sb.toString());
		}
	}
}