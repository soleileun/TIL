package hyoukang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2589 {
	
	static class Point{
		int x;
		int y;
		int step;
		public Point(int x, int y, int step) {
			super();
			this.x = x;
			this.y = y;
			this.step = step;
		}
		
		
	}
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] board = new int[N][M];
		int[][] check = new int[N][M];
		//boolean[][] visit = new boolean[N][M];
		boolean f = false;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			String[] tmp = st.nextToken().split("");
			
			for(int j=0;j<M;j++) {
				
				if(tmp[j].equals("W")) 
					board[i][j] =1;
					
				else
					board[i][j] =0;
			}
		}
		
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<M;j++) {
//				System.out.print(board[i][j]  + " " );
//			
//			}System.out.println();
//		}
//		
//		
//		
		
		Queue<Point>q = new LinkedList<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(board[i][j] == 1 ) continue;
				
				boolean[][] visit = new boolean[N][M];
				
				Queue<Point> roll = new LinkedList<>();
				q.offer(new Point(i,j,0));
				visit[i][j] = true;
				
			
					
				int cnt=0;
				
				while(!q.isEmpty()) {
					Point tmp = q.poll();
					//check[tmp.x][tmp.y] = tmp.step;
					cnt=tmp.step;
					for(int dir =0;dir<4;dir++) {
						int nx = tmp.x + dx[dir];
						int ny = tmp.y + dy[dir];
						
						if(nx<0||nx>=N||ny<0||ny>=M) continue;
						if(board[nx][ny] == 1 || visit[nx][ny]) continue;
						
						q.offer(new Point(nx,ny,tmp.step+1));
						visit[nx][ny] = true;
					}
				}
				check[i][j] = cnt;
//				if(cnt>max)
//					max =cnt;
//				
			
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
//				System.out.print(check[i][j]  + " " );
				if(check[i][j]>max)
					max =check[i][j];
			
			}
			//System.out.println();
		}
		if(max == Integer.MIN_VALUE)
			System.out.println("0");
		else 
			System.out.println(max);
		
		
	}

}
