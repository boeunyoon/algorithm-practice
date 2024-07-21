import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			PriorityQueue<Long> pq = new PriorityQueue<Long>();
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < K; i++) {
				pq.add(Long.parseLong(st.nextToken()));
			}//end input
			long sum = 0;
			while(!pq.isEmpty()) {
				if(pq.size() == 1) break;
				long n1 = pq.poll();
				long n2 = pq.poll();
				long aSum = n1 + n2;
				sum += aSum;
				pq.add(aSum);
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb.toString());
	}
}