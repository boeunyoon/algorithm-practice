import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
	static int N, K;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new ArrayDeque<>();
		for(int i = 1; i <= N; i++) {
			q.add(i);
		}
		sb.append("<");
		while(q.size() != 1) {
			for(int i = 0; i < K - 1; i++) {
				int n = q.poll();
				q.add(n);
			}
			int n = q.poll();
			sb.append(n + ", ");
		}
		sb.append(q.poll());
		sb.append(">");
		System.out.println(sb.toString());
	}
}