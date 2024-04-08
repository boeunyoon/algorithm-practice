import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int A, B, C;
    static boolean[][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Queue<Water> q = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        visited = new boolean[A+1][B+1][C+1];
        q.offer(new Water(0, 0, C));
        while(!q.isEmpty()) {
            Water w = q.poll();
            if(visited[w.a][w.b][w.c]) continue;
            visited[w.a][w.b][w.c] = true;
            if(w.a == 0) {
                pq.add(w.c);
            }
            //A -> B
            if(w.a + w.b <= B) {
                q.offer(new Water(0, w.a+ w.b, w.c));
            }else {
                q.offer(new Water((w.a + w.b) - B, B , w.c));
            }
            //A -> C
            if(w.a + w.c <= C) {
                q.offer(new Water(0, w.b, w.a + w.c));
            }else {
                q.offer(new Water((w.a + w.c) - C, w.b , C));
            }
            //B -> A
            if(w.a + w.b <= A) {
                q.offer(new Water(w.a + w.b, 0, w.c));
            }else {
                q.offer(new Water(A, (w.a + w.b) - A, w.c));
            }
            //B -> C
            if(w.c + w.b <= C) {
                q.offer(new Water(w.a, 0, w.b + w.c));
            }else {
                q.offer(new Water(w.a, (w.b + w.c) - C, C));
            }
            //C -> A
            if(w.c + w.a <= A) {
                q.offer(new Water(w.a + w.c, w.b, 0));
            }else {
                q.offer(new Water(A, w.b, (w.a + w.c) - A));
            }
            //C -> B
            if(w.c + w.b <= B) {
                q.offer(new Water(w.a, w.b + w.c, 0));
            }else {
                q.offer(new Water(w.a, B, (w.c + w.b) - B));
            }
        }
        while(!pq.isEmpty()) {
            sb.append(pq.poll() + " ");
        }
        System.out.println(sb.toString());
    }
    static class Water{
        int a, b, c;
        public Water(int a, int b, int c) {
            super();
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}