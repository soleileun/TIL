package woxorgkrtmq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_1812 {

	
	static class Rectangle implements Comparable<Rectangle>{
	
		int min, max;
		
		public Rectangle(int w, int h){
			if(w<h) {
				min = w;
				max = h;
			}else {
				min = h;
				max = w;
			}
		}

		@Override
		public int compareTo(Rectangle o) {
			return o.min - this.min;
		}
		
	}
	
	static int N,M,size[],cnt;
	static PriorityQueue<Rectangle> pq;
	static void cut() {
		Arrays.sort(size);
		pq = new PriorityQueue<>();
		pq.offer((new Rectangle(M, M)));
		cnt++;
		//오름차순의 결과니까 
		for(int i=N-1;i>=0;i--) {
			go(1<<size[i]); // 1<<2니까 4가됨 
		}
	}
	
	private static void go(int size) {
		//q에서 poll해서 최소값이 최대인 직사각형이 뽑아진다. 
		//직사각형의 최소변이 size보다 같거나 크면 원하는 크기의 정사각형을 만들 수 있다.
		Rectangle r = pq.poll();
				
		if(r.min>=size) {
			pq.offer((new Rectangle(r.min-size, size)));
			pq.offer((new Rectangle(r.min, r.max-size)));
		}else {
			pq.offer(r);
			pq.offer(new Rectangle(M-size, size));
			pq.offer(new Rectangle(M, M-size));
			cnt++;
		}
		
	}

	public static void main(String[] args) throws Exception, IOException {


		BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=tc;t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			size = new int[N];
			cnt =0;
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0;i<N;i++) {
			size[i] = Integer.parseInt(st.nextToken());
			}
			
			cut();
			
			sb.append(cnt).append("\n");
			
		
			
		}
		
		System.out.println(sb);
		
		
	}

}
