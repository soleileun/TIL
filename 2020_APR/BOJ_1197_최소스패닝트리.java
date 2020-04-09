package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1197_최소스패닝트리 {
	
	static class Edge implements Comparable<Edge>{
		int v1;
		int v2;
		int w;
		@Override
		
		public int compareTo(Edge o) {
			if(o.w <this.w)
				return 1;
			else if( o.w> this.w) 
				return -1;
			return 0;	
		}
		public Edge(int v1, int v2, int w) {
			super();
			this.v1 = v1;
			this.v2 = v2;
			this.w = w;
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
 

	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//int tc = Integer.parseInt(st.nextToken());
		
		for(int t=1;t<=1;t++) {
		//	sb.append("#").append(t).append(" ");
		
			PriorityQueue<Edge> pq = new PriorityQueue<>();
		//	st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 정점 개수
			int m = Integer.parseInt(st.nextToken()); // 간선 개수
			
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
				pq.add(new Edge(x,y,z));
			}
 			
			long ans =0;
			int[] visited = new int[n+1];
			for(int i=1;i<=n;i++) {
				visited[i] = i;
			}
			
			while(!pq.isEmpty()) {
                Edge tmp = pq.poll();
             
                if(!find(visited,tmp.v1,tmp.v2)) {
                    ans += tmp.w;
                    unionParent(visited, tmp.v1, tmp.v2);
                }
                 
            }
			
			System.out.println(ans);
			
		}
		System.out.println(sb);
	}
	
	
}
