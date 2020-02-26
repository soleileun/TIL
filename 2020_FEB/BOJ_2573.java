package hyoukang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import hyoukang.BOJ_16234.Point;

public class BOJ_2573 {
	static int N,M,ans;
	static int[][] board ;

	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static boolean checkZero() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(board[i][j] !=0)
					return false;
			}
		}
		return true;
	}
	
	static boolean bfs() {
		Queue<Point> q = new LinkedList<>(); 
		
		boolean[][] visit = new boolean[N][M];
		int cnt=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(board[i][j] == 0|| visit[i][j]) continue;
				
				q.offer(new Point(i,j));
				cnt++;
				if(cnt>=2) {
					System.out.println(ans);
					return true;
				}
				while(!q.isEmpty()) {
					Point temp = q.poll();
					
					for(int dir=0;dir<4;dir++) {
						int nx = temp.x +dx[dir];
						int ny = temp.y + dy[dir];
					if(nx<0||nx>=N||ny<0||ny>=M)continue;
					if(board[nx][ny] == 0 || visit[nx][ny]) continue;
					
					q.offer(new Point(nx,ny));
					visit[nx][ny] = true;
						
					
					}
					
					
				}
				
			}
		}
		return false;
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if(bfs()) {
			//System.out.println("0");
			return;
			}
		
		//boolean fini = false;
		//int ans =0;
		while(true) {
			ans++;
			int[][] tmp = new int[N][M];
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(board[i][j] == 0) continue;
					int count =0;
					for(int dir=0;dir<4;dir++) {
						int nx = i+dx[dir];
						int ny = j+dy[dir];
						if(nx<0||nx>=N||ny<0||ny>=M) continue;
						if(board[nx][ny] == 0) count++;
						else
							continue;
					}
					tmp[i][j] = -count;
					
				
				}
			}
			
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					board[i][j] +=tmp[i][j];
					if(board[i][j] <0)
						board[i][j] = 0;
				}
			}
			

			Queue<Point> q = new LinkedList<>(); 
			
			boolean[][] visit = new boolean[N][M];
			int cnt=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(board[i][j] == 0|| visit[i][j]) continue;
					
					q.offer(new Point(i,j));
					cnt++;
					if(cnt>=2) {
						System.out.println(ans);
						return;
					}
					while(!q.isEmpty()) {
						Point temp = q.poll();
						
						for(int dir=0;dir<4;dir++) {
							int nx = temp.x +dx[dir];
							int ny = temp.y + dy[dir];
						if(nx<0||nx>=N||ny<0||ny>=M)continue;
						if(board[nx][ny] == 0 || visit[nx][ny]) continue;
						
						q.offer(new Point(nx,ny));
						visit[nx][ny] = true;
							
						
						}
						
						
					}
					
				}
			}
			if(checkZero())
			{
				System.out.println("0");
				return;
			}
				
			
		}
		
		
		

	}

}
