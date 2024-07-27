import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int V, E, parent[];
	static Node[] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		tree = new Node[E];
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			Node node = new Node(a, b, cost);
			tree[i] = node;
		}//end input
		Arrays.sort(tree); //가중치 순으로 정렬
		int count = 0;
		int weight = 0;
		make();
		for (Node node : tree) {
			if(!union(node.from, node.to)) continue; //사이클 발생
			weight += node.cost;
			if(++count == V - 1) break; //최소신장트리 완성
		}
		System.out.println(weight);
		
	}
	static void make() {
		parent = new int[V + 1];
		for(int i = 1; i < V + 1; i++) {
			parent[i] = i; //모든 정점을 자신이 대표자로
		}
	}
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) { //같은 트리면 union이 불필요
			return false;
		}
		parent[bRoot] = aRoot;
		return true;
	}
	static int find(int a) { //a가 속한 트리의 루트찾
		if(parent[a] == a) {
			return a;
		}
		return parent[a] = find(parent[a]);
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