import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Solution {
     
 
     
    static class Ver implements Comparable<Ver>{
         
        Integer x;
        Integer y;
        Long dist;
         
        public Ver(Integer x, Integer y, Long dist) {
            super();
         
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
 
        @Override
        public int compareTo(Ver v) {
            if(this.dist>v.dist)
                return 1;
            else
                return -1;
        }
         
         
         
    }
     
    static int getParent(int[] visit, int x) {
        if(visit[x] == x) return x;
        return visit[x] = getParent(visit,visit[x]);
    }
     
    static void unionParent(int[] visit, int a, int b) {
        a=getParent(visit, a);
        b= getParent(visit, b);
        if(a<b) visit[b] =a;
        else
            visit[a] = b;
    }
     
    static boolean find(int[] visit, int a, int b) {
        a= getParent(visit, a);
        b = getParent(visit, b);
        if(a==b)
            return true;
        else
            return false;
                 
    }
 
 
 
 
    static int N;
    public static void main(String[] args) throws IOException {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(st.nextToken());
         
         
        for(int t=1;t<=tc;t++) {
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            Ver[] v = new Ver[N];
            Integer[] X = new Integer[N]; 
            Integer[] Y = new Integer[N]; 
            int[] visited = new int[N];
            int idx=0;
             
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++) {
                    X[idx++] = Integer.parseInt(st.nextToken()); 
                }
                idx =0;
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++) {
                    Y[idx++] = Integer.parseInt(st.nextToken()); 
                }
             
             
             
            st = new StringTokenizer(br.readLine());
            double percent = Double.parseDouble(st.nextToken());
            int cnt=0;
            int now = 0;
            Double result = 0.0;
            ArrayList<ArrayList<Ver>> arr = new ArrayList<ArrayList<Ver>>();
            PriorityQueue<Ver> pv = new PriorityQueue<>();
             
            for(int i=0;i<N;i++) {
                v[i] = new Ver(X[i],Y[i],(long)0);
                //System.out.println(v[i].x + " " + v[i].y + " " );
            }
             
             
             
            for(int i=0;i<N;i++) {
                for(int j=i+1;j<N;j++) {
                    Long dist = ( (long)((long)(v[j].x- v[i].x)*(long)(v[j].x -v[i].x))+(long)((long)(v[j].y -v[i].y)*(long)(v[j].y -v[i].y)));
                    //System.out.println(dist);
                    pv.offer(new Ver(i,j,dist));
                }
            }
            for(int i=0;i<N;i++) {
                visited[i] = i;
            }
             
            Double d = 0.0;
            while(!pv.isEmpty()) {
                Ver tmp = pv.poll();
             
                if(!find(visited,tmp.x,tmp.y)) {
                    d += tmp.dist * percent;
                    unionParent(visited, tmp.x, tmp.y);
                }
                 
            }
             
            sb.append(Math.round(d)).append("\n");
             
 
    }
System.out.println(sb);
}
}
