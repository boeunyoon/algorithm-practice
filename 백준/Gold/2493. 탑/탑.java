import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		Stack<Point> stack = new Stack<Point>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int h = Integer.parseInt(st.nextToken());
			if(stack.isEmpty()) {
				sb.append("0 ");
				stack.push(new Point(i, h));
			}else {
				while(true) {
					if(stack.isEmpty()) {
						sb.append("0 ");
						stack.push(new Point(i, h));
						break;
					}
					Point p = stack.peek();
					if(p.height > h) {
						sb.append(p.idx + 1 + " ");
						stack.push(new Point(i, h));
						break;
					}else {
						stack.pop();
					}
				}
			}
		}
		System.out.println(sb.toString());
	}
	static class Point{
		int idx, height;

		public Point(int idx, int height) {
			super();
			this.idx = idx;
			this.height = height;
		}
		
	}
}