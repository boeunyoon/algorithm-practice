import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, count;
	static Integer crane[], box[];
	static List<Integer> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		crane = new Integer[N];
		count = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			crane[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
//		box = new int[M];
		list = new ArrayList<Integer>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		//내림 차순 정렬
		Arrays.sort(crane, Collections.reverseOrder());
		Collections.sort(list, Collections.reverseOrder());
		//박스를 다 옮길 수 없음
		if(crane[0] < list.get(0)) {
			System.out.println(-1);
			System.exit(0);
		}
		while(true) {
			int boxId = 0;
			for(int i = 0; i < N;) {
				if(boxId == list.size()) {
					break;
				}
				int b = list.get(boxId);
				int c = crane[i];
				if(c >= b) { //박스 옮기기 가능
					list.remove(boxId);
					i++;
				}else {
					boxId++; //더 작은 박스 찾기
				}
			}
			count++; //모든 크레인 한번 작업 완료
			if(list.size() == 0) {
				break;
			}
		}
		System.out.println(count);
	}
}