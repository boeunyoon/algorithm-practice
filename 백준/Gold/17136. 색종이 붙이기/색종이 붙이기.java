import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, map[][], min;
    static int paper[] = {0, 5, 5, 5, 5, 5};
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        map = new int[10][10];
        N = 10;
        min = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }//end input
        dfs(0, 0, 0);
        if(min ==Integer.MAX_VALUE) {
            System.out.println(-1);
        }else {
            System.out.println(min);
        }
    }
    static void dfs(int x, int y, int count) {
//        System.out.println(x + " " +  y);
        if(x == 9 && y == 10) {
            min = Math.min(min, count);
            return;
        }
        if(count >= min) return;
        if(y == 10) {
            dfs(x + 1, 0, count);
        }
        else if(map[x][y] == 1) {
            for(int i = 5; i >= 1; i--) {
                if(checkOne(x, y, i) && paper[i] > 0) {
                    change(x, y, i, 0);
                    paper[i]--;
                    dfs(x, y + 1, count+1);
                    change(x, y, i, 1);
                    paper[i]++;
                }
            }
        }else {
            dfs(x, y+1, count);
        }
    }
    static void change(int i, int j, int s, int state) {//찾은 색종이 바꾸기
        for(int k = 0; k < s; k++) {
            for(int z = 0; z < s; z++) {
                map[i + k][j + z] = state; //색종이 붙이기
            }
        }
    }
    static boolean checkOne(int startI, int startJ, int size) {//색종이를 붙일 수 있는지 확인
        for(int i = startI; i < startI + size; i++) {
            for(int j = startJ; j < startJ + size; j++) {
                if(i >= N || j >= N) return false;
                if(map[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}