import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, K, M;
	static int[] values, child, person;
	static List<Integer> valueList, personList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		values = new int[N + 1]; //짐의 값역할을 한다.
		child = new int[N + 1]; 
		person = new int[N + 1]; //짐의 무게역할을 한다.
		personList = new ArrayList<Integer>();
		valueList = new ArrayList<Integer>();
		
		
		Arrays.fill(person, 1);
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			child[i] = i; //그룹 집합
			values[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			union(x, y); //합집합을 만들어준다.
		}//end input
		
		makeGroup(); //그룹을 만들어 각 그룹의 값의 합을 만들어 준다.
		
		System.out.println(kanpsack());
	}
	
	static int kanpsack() {
//		long[][] dp = new long[personList.size() + 1][K];
//		for(int i = 1; i < personList.size() + 1; i++) {
//			int personCount = personList.get(i - 1); //그룹 별 사람 수
//			long val = valueList.get(i - 1); //그룹 별 사탕 수
//			for(int j = 0; j < K; j++) {
//				if(personCount <= j) {
//					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - personCount] + val);
//				}else {
//					dp[i][j] = dp[i - 1][j];
//				}
//			}
//		}
//		return dp[personList.size()][K - 1];
		int [] dp = new int[K + 1];
		for(int i = 0; i < personList.size(); i++) {
			int personCount = personList.get(i); //그룹 별 사람 수
			int val = valueList.get(i); //그룹 별 사탕 수
			for(int j = K; j >= 0; j--) {
				int pre = j- personCount;
				if(pre < 0) {
					break;
				}
				dp[j] = Math.max(dp[pre] + val, dp[j]);
			}
		}
		return dp[K-1];
	}
	
	static void makeGroup() {
		//대표자들이 아닌요소들의 값들을 대표자들에 더해준다 -> 나중에 그룹의 합을 구하기 위함
		for(int i = 1; i <= N; i++) {
			if(child[i] != i) {
				int p = find(i);
				values[p] += values[i];
				person[p] += person[i];
			}
		}
		//집합의 대표자들만 리스트에 담아준다.
		for(int i = 1; i <= N; i++) {
			if(child[i] == i) {
				personList.add(person[i]); //그룹에 포함되는 사람 수
				valueList.add(values[i]); //같은그룹의 총 사탕을 더한 값
			}
		}
	}
	
	static void union(int x, int y) {
		int xParent = find(x);
		int yParent = find(y);
		if(xParent > yParent) child[xParent] = yParent;
		else child[yParent] = xParent;
	}
	
	static int find(int x) {
		if(child[x] == x) return x;
		return child[x] = find(child[x]);
	}
}