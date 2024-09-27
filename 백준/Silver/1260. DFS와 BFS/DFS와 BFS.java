import java.util.*;
import java.lang.*;
import java.io.*;
public class Main {
	static int N, M, V;
	static List<Integer>[] arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		arr = new List[N + 1];
		
		for(int i = 1; i < N + 1; i++) {
			arr[i] = new ArrayList<>();
		}
	
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			arr[start].add(end);
			arr[end].add(start);
		}//end input
		
		for(int i = 1; i <= N; i++) {
			Collections.sort(arr[i]);
		}
		
		visited = new boolean[N + 1];
		visited[V] = true;
		sb.append(V + " ");
		dfs(V);
		sb.append("\n");
		visited = new boolean[N + 1];
		bfs();
		System.out.println(sb.toString());
	}
	static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(V);
		visited[V] = true;
		sb.append(V + " ");
		while(!q.isEmpty()) {
			int n = q.poll();
			for(int i = 0; i < arr[n].size(); i++) {
				if(!visited[arr[n].get(i)]) {
					sb.append(arr[n].get(i) + " ");
					q.add(arr[n].get(i));
					visited[arr[n].get(i)] = true;
				}
			}
		}
	}
	static void dfs(int v) {
		for(int i = 0; i < arr[v].size(); i++) {
			if(visited[arr[v].get(i)]) continue;
			sb.append(arr[v].get(i) + " ");
			visited[arr[v].get(i)] = true;
			dfs(arr[v].get(i));
		}
	}
}