import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static char[] command;
	static int N;
//	static LinkedList<Integer> numbers;
	static int[] numbers;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 0; tc < T; tc++) {
			StringBuilder sb = new StringBuilder();
			command = br.readLine().toCharArray();
			N = Integer.parseInt(br.readLine());
			String numberInput = br.readLine();
			String[] numberStrings = numberInput.replaceAll("[\\[\\]\\s]", "").split(",");
//			numbers = new LinkedList<Integer>();
			numbers = new int[N];
			for(int i = 0; i < N; i++) {
				numbers[i] = Integer.parseInt(numberStrings[i]);
			}//end input
			int elCount = N;
			int dir = 1;
			int start = 0;
			int end = N - 1;
			boolean errFlag = true;
			for(int i = 0; i < command.length; i++) {
				if(command[i] == 'R') {
					if(dir == 1) {
						dir = -1;
					}else {
						dir = 1;
					}
				}else {
					if(elCount != 0) {
						elCount--;
						if(dir == 1) {
							start++;
						}else {
							end--;
						}
					}else {
						errFlag = false;
						break;
					}
				}
			}
			if(!errFlag) {
				sb.append("error");
			}else {
				sb.append("[");
				if(dir == 1) {
					for(int i = start; i <= end; i++) {
						if(i == end) sb.append(numbers[i]);
						else sb.append(numbers[i]).append(",");
					}					
				}else {
					for(int i = end; i >= start; i--) {
						if(i == start) sb.append(numbers[i]);
						else sb.append(numbers[i]).append(",");
					}	
				}
				sb.append("]");
			}
			System.out.println(sb.toString());
		}
	}
}