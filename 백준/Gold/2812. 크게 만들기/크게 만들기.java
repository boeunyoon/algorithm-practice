import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int[] numberArray = new int[N];
		String number = br.readLine();//end input
		for(int i = 0; i < N; i++) {
			numberArray[i] = number.charAt(i) - '0';
		}
		//완전탐색은 시간 초과가 발생할거다. Greedy? 
		//그렇다면 뒤에서 K자리 이후에 있는 가장 큰수를 고르면 가장 큰 자리수가 골라지는데?
		
		//아니다 Stack이구나?? 깨달았다. 
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		int k = K;
		for(int i = 0; i < N; i++) {
			while(true) {
				if(k == 0) {
					break;
				}
				if(stack.isEmpty()) {
					break;
				}
				//top 의 숫자보다 큰 숫자가 오면 pop
				if(stack.peek() >= numberArray[i]) {
					break;
				}
				stack.pop();
				k--;
			}
			//일단 다 들어와 like 황정민
			stack.add(numberArray[i]);
		}
		//왜 계속 틀릴까? 
		
		//아 깨달았다!! 
		//K만큼 pop을 하지 않는경우 발생 레전드 비상상황!!! 삐용삐용 
		while(true) {
			if(k == 0) {
				break;
			}
			stack.pop();
			k--;
		}
		while (!stack.empty()) {
			sb.append(stack.pop());
		}
		sb.reverse();
		System.out.println(sb.toString());
	}
}