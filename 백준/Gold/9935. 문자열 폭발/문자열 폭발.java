import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Main {
	static Stack<Character> stack;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		stack = new Stack<Character>();
		char[] string = br.readLine().toCharArray();
		char[] bomb = br.readLine().toCharArray();
		int bLength = bomb.length;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < string.length; i++) {
			stack.add(string[i]);
			if(stack.size() >= bLength) {
				boolean flag = true;
				for(int j = 0; j < bLength; j++) {
					if(stack.get(stack.size() - bLength + j) != bomb[j]) {
						flag = false;
						break;
					}
				}
				if(flag) {
					for(int j = 0; j < bLength; j++) {
						stack.pop();
					}
				}
			}
		}
		if(stack.empty()) {
			sb.append("FRULA");
		}else {
			while(!stack.empty()) {
				sb.append(stack.pop());
			}
			sb.reverse();
		}
		System.out.println(sb.toString());
	}
}