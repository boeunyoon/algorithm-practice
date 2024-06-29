import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, ans;
	static Line[] lineArr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		lineArr = new Line[N];
		ans = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			lineArr[i] = new Line(a, b);
		}//end input
		
		//전깃줄이 교차하지 않는다는것은 왼쪽 전봇대의 번호가 증가하는 순서대로 오른쪽 전봇대에서도 번호가 증가하나다는 의미
		//LIS
		Arrays.sort(lineArr);
		int[] l = new int[N];
		for(int i = 0; i < N; i++) {
			l[i] = 1;
			for(int j = 0; j < i; j++) {
				if(lineArr[j].b < lineArr[i].b) {
					l[i] = Math.max(l[i], l[j] + 1);
				}
			}
		}
		for(int i = 0; i < N; i++) {
			ans = Math.max(ans, l[i]);
		}
		System.out.println(N - ans); //전체 개수에서 최댓값 뺀 제거 전깃줄 개수 구함
	}
	static class Line implements Comparable<Line>{
		int a, b;
		public Line(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}

		@Override
		public String toString() {
			return "Line [a=" + a + ", b=" + b + "]";
		}

		@Override
		public int compareTo(Line o) {
			// TODO Auto-generated method stub
			return this.a - o.a;
		}
		
	}
}