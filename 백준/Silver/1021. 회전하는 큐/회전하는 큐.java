import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int N, M, count, start, end;
	static Deque<Integer> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		q = new ArrayDeque<Integer>();
		count = 0;
		for (int i = 1; i <= N; i++) {
			q.addLast(i);
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			int index = findIndex(num);
			start = index;
			end = q.size() - index;
			if (start <= end) {
				one(num);
			}else {
				two(num);
			}
		} // end input
		System.out.println(count);
	}

	static void one(int num) {
		while (true) {
			if (q.getFirst() == num) {
				q.removeFirst();
				break;
			}
			int n = q.removeFirst();
			q.addLast(n);
			count++;
		}
	}

	static void two(int num) {
		while (true) {
			if (q.getLast() == num) {
				count++;
				q.removeLast();
				break;
			}
			int n = q.removeLast();
			q.addFirst(n);
			count++;
		}
	}

	static int findIndex(int num) {
		int index = 0;
		for (Integer i : q) {
			if (i == num) {
				return index;
			}
			index++;
		}
		return -1;
	}
}