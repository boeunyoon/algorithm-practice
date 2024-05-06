import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
//N개의 추가 있을때 M개의 무게 비교 결과가 주어진다. 
//이때 무게비교 결과를 알 수 없는 물건의 개수
//앞의 물건이 뒤의 물건보다 무거움
public class Main {
	static int N, M; 
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][N + 1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); //무거움
			int b = Integer.parseInt(st.nextToken()); //가벼움
			arr[a][b] = 1;
			arr[b][a] = -1;
		}//end input
		//플로이드워샬
		//a1 > a2은  arr[a1][a2] =1 and a2 > a3 => arr[a2][a3]=1 ->  arr[a1][a3]
		// -1의 경우에도 마찬가지
		for(int k = 1; k < N + 1; k++) {
			for(int i = 1; i < N + 1; i++) {
				for(int j = 1; j < N + 1; j++) {
					if(arr[i][k] == 1 && arr[k][j] ==1) {
						arr[i][j] = 1;
					}
					
					if(arr[i][k] == -1 && arr[k][j] == -1) {
						arr[i][j] = -1;
					}
				}
			}
		}
		for(int i = 1; i < N + 1; i++) {
			int count = 0;
			for(int j = 1; j < N + 1; j++) {
				if(arr[i][j] != 0) {
					count++;
				}
			}
			sb.append((N - count - 1)+"\n");
			
		}
		System.out.println(sb.toString());
	}
}