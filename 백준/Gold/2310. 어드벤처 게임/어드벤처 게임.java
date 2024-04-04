import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, totalPrice;
    static int visited[];
    static ArrayList[] list;
    //인접 리스트??
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        while(true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            list = new ArrayList[N + 1];
            visited = new int[N + 1];
            totalPrice = 0;
            if(N == 0) break;
            Arrays.fill(visited, -1);
            for(int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                list[i] = new ArrayList<Point>();
                String alpha = st.nextToken();
                int price = Integer.parseInt(st.nextToken());
                while(true) {
                    int num = Integer.parseInt(st.nextToken());
                    list[i].add(new Point(i, num, price, alpha, false));
                    if(num == 0) break;
                }
            }// end input
            if(dfs(1, 0)) {
            	System.out.println("Yes");
            }else {
            	System.out.println("No");
            }
        }
    }
    static boolean dfs(int level, int totalPrice) {
    	Point p1 = (Point)list[level].get(0);
    	if(p1.alpha.equals("T")) {
    		totalPrice -= p1.price;
    	}else if(p1.alpha.equals("L")) {
    		totalPrice = Math.max(totalPrice, p1.price);
    	}
    	if(totalPrice < 0 && level == N) return false;
        if(level == N) {
        	return true;
        }
        
        for(int i = 0; i < list[level].size(); i++) {
        	Point p = (Point) list[level].get(i);
        	if(p.next == 0) continue;
        	if(visited[p.next] >= totalPrice) continue;
        	visited[p.next] = totalPrice;
        	if(dfs(p.next, totalPrice)) {
        		return true;
        	}
        }
        return false;
    }
    static class Point{
        int level;
        int next;
        int price;
        String alpha;
        boolean visit;
        public Point(int level, int next, int price, String alpha, boolean visit) {
            this.level = level;
            this.next = next;
            this.price = price;
            this.alpha = alpha;
            this.visit = visit;
        }
        @Override
        public String toString() {
            return "Point [level=" + level + ", next=" + next + ", price=" + price + ", alpha=" + alpha + "]";
        }
    }
}