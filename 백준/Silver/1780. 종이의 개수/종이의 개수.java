import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, map[][], oneCount, moneCount, zCount;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		oneCount = moneCount = zCount = 0;
		map = new int[N + 1][N + 1];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}//end input
		rec(N, 1, 1);
		System.out.println(moneCount);
		System.out.println(zCount);
		System.out.println(oneCount);
	}
	static void rec(int n, int startI, int startJ) {
//		System.out.println(startI + " " + startJ);
		if(n == 1) { //종이의 크기가 1이면 종료
			if(map[startI][startJ] == -1) {
				moneCount++;
			}else if(map[startI][startJ] == 0) {
				zCount++;
			}else {
				oneCount++;
			}
			return;
		}
		//종이가 전부 같은 종이인지 확인한다. 
		boolean flag = true;
		int p = map[startI][startJ];
		out: for(int i = startI; i < startI+ n; i++) {
			for(int j = startJ; j < startJ + n; j++) {
				if(map[i][j] != p) {
					flag = false;
					break out;
				}
			}
		}
		//같은 종이가 아니라면
		if(!flag) {
			int m = n / 3;
			rec(m, startI, startJ);
			rec(m, startI + m, startJ);
			rec(m, startI + m + m, startJ );
			rec(m, startI, startJ + m);
			rec(m, startI, startJ + m + m);
			rec(m, startI + m, startJ + m);
			rec(m, startI + m + m, startJ + m);
			rec(m, startI + m, startJ + m + m);
			rec(m, startI + m + m, startJ + m + m);
		}
		else {//같은 종이라면 끝
			if(p == -1) {
				moneCount++;
			}else if(p == 0) {
				zCount++;
			}else if(p == 1) {
				oneCount++;
			}
			return;
		}
	}
}