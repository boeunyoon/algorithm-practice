import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		//자신의 기준 왼쪽의 자신보다 보다 높은 탑의 위치를 반환하라
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());		
		Stack<int[]> stack = new Stack<>();
		
		int num = 0;
		int index = 0;
		for(int i = 0; i < N; i++) {
			int[] arr = new int[] {Integer.parseInt(st.nextToken()), i+1};
			num = arr[0];
			if(stack.isEmpty()) {
				sb.append(0).append(" ");
			}else {
				while(true) {
					int[] data = stack.peek();
					int id = data[1];
					int tall = data[0];
					if(tall < num) {
						stack.pop();
					}else {
						sb.append(id).append(" ");
						break;
					}
					if(stack.isEmpty()) {
						sb.append(0).append(" ");
						break;
					}
					
				}
			}
			stack.push(arr);
			
			
		}
		System.out.println(sb);
	}
}