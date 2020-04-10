package _0410;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

import _0410.최단경로.Edge;

public class BOJ_4485_녹색옷입은애가젤다지 {

	static class Point implements Comparable<Point>{
		int x;
		int y;
		int w;
		public Point(int x, int y, int w) {
			super();
			this.x = x;
			this.y = y;
			this.w = w;
		}
		@Override
		public int compareTo(Point o) {
			if(this.w<o.w)
				return -1;
			else if(this.w> o.w)
				return 1;
			return 0;
		}
		
	}
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int cnt = 1;
		while(true){
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int INF = 987654321;
		int N = Integer.parseInt(st.nextToken());
		if(N==0) break;
		
		int[][] board = new int[N][N];
		//int[][] result = new int[125][125];
		//boolean[][] visit = new boolean[125][125];
		for(int i=0 ; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		PriorityQueue<Point> pq = new PriorityQueue<>();
		int[][] dist = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				dist[i][j] = INF;
			}
		}
		
		dist[0][0] =board[0][0];
		pq.offer(new Point(0,0,board[0][0]));
		
		while( !pq.isEmpty() ) {
			Point tmp = pq.poll();
			
			for(int dir=0;dir<4;dir++) {
				int nx = tmp.x+dx[dir];
				int ny = tmp.y+dy[dir];
				
				if(nx<0||nx>=N||ny<0||ny>=N) continue;
				
				//System.out.println("d");
				
				if(dist[nx][ny] > dist[tmp.x][tmp.y] + board[nx][ny]) {
					dist[nx][ny] = dist[tmp.x][tmp.y] + board[nx][ny];
					pq.offer(new Point(nx,ny,dist[nx][ny]));
				}
				
			}
		}
		sb.append("Problem ").append(cnt++).append(": ").append(dist[N-1][N-1]).append("\n");
		}

		System.out.println(sb);
	}
}
