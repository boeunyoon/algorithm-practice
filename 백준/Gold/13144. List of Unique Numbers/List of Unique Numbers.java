import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, visited[], arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = 0;
        long ans = 1;
        visited = new int[N + 1];
        while(true) {
            //end를 증가
        	end += 1;
        	if(end == N) {
        		break;
        	}
        	int endNum = arr[end];
//        	System.out.println(endNum);
        	boolean flag = true;
        	for(int i = start; i < end; i++) {
                if(endNum == arr[i]) {
                	flag = false;
                	break;
                }
            }
//            System.out.println(start + " " + end);
//            System.out.println(flag);
            if(flag) {//중복되지 않은 경우
            	ans += (end - start) + 1;
//                System.out.println(end - start);
            }else{ //중복된 수열일 경우
                start += 1;
                end -= 1;
            }
        }
        System.out.println(ans);
    }
}