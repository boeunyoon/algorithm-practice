import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static Serial[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		arr = new Serial[N];
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			int num = 0;
			int si = s.length()-1;
			for(int j = 0; j < s.length(); j++) {
				if(Character.isDigit(s.charAt(j))) {
					int n = s.charAt(j) - '0';
//					int size = (int)Math.pow(10, si - j);
//					num += n * size;
					num += n;
				}
			}
			Serial serial = new Serial(s.length(), num, s);
			arr[i] = serial;
		}
		Arrays.sort(arr);
		for(int i = 0; i < N; i++) {
			sb.append(arr[i].sericalNumber).append("\n");
		}
		System.out.println(sb.toString());
	}
	static class Serial implements Comparable<Serial>{
		int p1, p2; //길이, 숫자합
		String sericalNumber;
		public Serial(int p1, int p2, String sericalNumber) {
			this.p1 = p1;
			this.p2 = p2;
			this.sericalNumber = sericalNumber;
		}
		@Override
		public int compareTo(Serial o) {
			if(this.p1 != o.p1) {
				return this.p1 - o.p1;
			}
			if(this.p2 != o.p2) {
				return this.p2 - o.p2;
			}
			return this.sericalNumber.compareTo(o.sericalNumber);
		}
		
		@Override
		public String toString() {
			return "Serial [p1=" + p1 + ", p2=" + p2 + ", sericalNumber=" + sericalNumber + "]";
		}
	}
}