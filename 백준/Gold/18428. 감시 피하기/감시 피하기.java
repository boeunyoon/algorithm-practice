import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	//3개의 장애물을 설치하여 모든 학생이 감시에서 피할 수 있도록 장애물을 설치해라
	//선생님은 장애물에 막히기 전까지 학생들을 모두 볼 수 있다. 
	// 조합을 이용하여 
	static int N;
	static char[][] map, copy;
	static int[] di = {-1, 0, 1, 0};
	static int[] dj = {0, 1, 0, -1};
	static List<Point> list, teacher;
	static Point[] result;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new char[N][N];
		result = new Point[3];
		flag = false;
		list = new ArrayList<Point>();
		teacher = new ArrayList<Point>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0);
				if(map[i][j] == 'X') {
					list.add(new Point(i, j));
				}else if(map[i][j] == 'T') {
					teacher.add(new Point(i, j));
				}
			}
		}//end input
		combi(0, 0);
		if(!flag) System.out.println("NO");
	}
	static void combi(int start, int count) {
		if(count == 3) {
//			System.out.println(Arrays.toString(result));
			deepCopy(); //복사
			for(int i = 0; i < 3; i++) {
				Point p = result[i];
				copy[p.i][p.j] = 'R';
			}//장애물 설치
			//학생 찾기
			flag = findStudent();
			if(flag) {
				System.out.println("YES");
				System.exit(0);
			}
			return;
		}
		for(int i = start; i < list.size(); i++) {
			result[count] = list.get(i);
			combi(i + 1, count + 1);
		}
	}
	static void deepCopy() {
		copy = new char[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				copy[i][j] = map[i][j];
			}
		}
	}
	static boolean findStudent() {
		for(int i = 0; i < teacher.size(); i++) {
			Point cur = teacher.get(i);
			int curI = cur.i;
			int curJ = cur.j;
			//상 
			int nextI = curI;
			while(true) {
				if(nextI < 0 || copy[nextI][curJ] == 'R') { //통과
					break;
				}
				if(copy[nextI][curJ] == 'S') {
					return false;
				}
				nextI--;
			}
			//하
			nextI = curI;
			while(true) {
				if(nextI >= N || copy[nextI][curJ] == 'R') { //통과
					break;
				}
				if(copy[nextI][curJ] == 'S') {
					return false;
				}
				nextI++;
			}
			//좌
			int nextJ = curJ;
			while(true) {
				if(nextJ < 0 || copy[curI][nextJ] == 'R') { //통과
					break;
				}
				if(copy[curI][nextJ] == 'S') {
					return false;
				}
				nextJ--;
			}
			//우
			nextJ = curJ;
			while(true) {
				if(nextJ >= N || copy[curI][nextJ] == 'R') { //통과
					break;
				}
				if(copy[curI][nextJ] == 'S') {
					return false;
				}
				nextJ++;
			}
		}
		return true;
	}
	static class Point{
		int i, j;
		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
		@Override
		public String toString() {
			return "Point [i=" + i + ", j=" + j + "]";
		}
	}
}