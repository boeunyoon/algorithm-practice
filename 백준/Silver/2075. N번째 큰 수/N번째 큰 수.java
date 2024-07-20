import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(st.nextToken()));
		} //첫 줄은 그냥 입력
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(pq.peek() < num) { //가장 앞에 있는 값과 비교, 현재 값이 더 크면 교체
					pq.poll(); 
					pq.add(num);
				}
			}
		}// end input
		System.out.println(pq.poll());
	}
}