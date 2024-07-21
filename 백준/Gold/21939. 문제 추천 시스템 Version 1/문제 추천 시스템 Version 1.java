import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static int N, P;
	static TreeSet<Problem> pq;
	public static Map<Integer,Integer> map = new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		pq = new TreeSet<Problem>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int p1 = Integer.parseInt(st.nextToken());
			int n1= Integer.parseInt(st.nextToken());
			Problem p = new Problem(p1, n1);
			pq.add(p);
			map.put(p1, n1);
		}
		st = new StringTokenizer(br.readLine());
		P = Integer.parseInt(st.nextToken());
		for(int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			if(command.equals("recommend")) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 1) {
					System.out.println(pq.last().num);
				}else {
					System.out.println(pq.first().num);
				}
			}else if(command.equals("add")) {
				int P = Integer.parseInt(st.nextToken());
				int L = Integer.parseInt(st.nextToken());
				Problem p = new Problem(P, L); 
				pq.add(p);
				map.put(P, L);
			}else {
				int P = Integer.parseInt(st.nextToken());
				int L = map.get(P);
				pq.remove(new Problem(P, L));
			}
		}//end input
		
	}
	static class Problem implements Comparable<Problem>{
		int num, difficulty;
		public Problem(int num, int difficulty) {
			this.num = num;
			this.difficulty = difficulty;
		}
		@Override
		public int compareTo(Problem o) {
			// TODO Auto-generated method stub
			if(this.difficulty == o.difficulty) {
				return this.num - o.num;
			}
			return this.difficulty - o.difficulty;
		}
	}
}