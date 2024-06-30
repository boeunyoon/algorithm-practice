import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        int[] month= {0,31,59,90,120,151,181,212,243,273,304,334,365};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Period[] per = new Period[n];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int month_a = Integer.parseInt(s[0]);
            int day_a = Integer.parseInt(s[1]);
            int month_b = Integer.parseInt(s[2]);
            int day_b = Integer.parseInt(s[3]);
            per[i] = new Period(month[month_a-1]+day_a,month[month_b-1]+day_b);
        }
        Arrays.sort(per);
        int start_day = 60;
        int cnt = 0;
        int cur_max = 0;
        for (int i = 0; i < n; i++) {
            if(per[i].start<=start_day) {
                cur_max = Math.max(cur_max, per[i].end);
            }
            else {
                if(cur_max==0) {
                    System.out.println(0);
                    return;
                }
                if(cur_max>334) {
                    System.out.println(cnt+1);
                    return;
                }
                start_day = cur_max;
                cur_max= 0;
                i--;
                cnt++;
            }
        }
        if(cur_max>334) {
            System.out.println(cnt+1);
            return;
        }
        System.out.println(0);
//        System.out.println(cnt);
    }
    static class Period implements Comparable<Period>{
        int start, end;

        public Period(int start, int end) {
            super();
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Period [start=" + start + ", end=" + end + "]";
        }

        @Override
        public int compareTo(Period o) {
            return this.start-o.start;
        }
    }
    
}