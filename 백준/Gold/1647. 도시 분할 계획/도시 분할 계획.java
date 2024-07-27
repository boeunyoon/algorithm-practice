import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, parents[];
	static Node[] nodes;
	//MST를 완성시키고 마지막 간선을 제거하라
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nodes = new Node[M];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			nodes[i] = new Node(a, b, cost);
		}//end input
		Arrays.sort(nodes);
		make();
		int ans = 0;
		int weight = 0;
		int count = 0;
		for (Node node : nodes) {
			if(!union(node.from, node.to)) continue;
			ans += node.cost;
			if(++count == N - 1) {
				ans -= node.cost;
				break;
			}
		}
		System.out.println(ans);
	}
	static void make() {
		parents = new int[N + 1];
		for(int i = 0; i < N + 1; i++) {
			parents[i] = i;
		}
	}
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) {
			return false;
		}
		parents[bRoot] = aRoot;
		return true;
	}
	static int find(int a) {
		if(parents[a] == a) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}
	static class Node implements Comparable<Node>{
		int from, to, cost;
		public Node(int from, int to, int cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
}