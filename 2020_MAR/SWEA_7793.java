package coffeontheplan;

import java.awt.Checkbox;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_7793 {

	
	static int N,M,ans;
	static int [][] board, stepBoard ;
	static boolean [][] visit ;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	
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
	
	static void print(int[][] board) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(board[i][j] + " ");
			
			}
			System.out.println();
		}
	}
	public static void main(String[] args) throws IOException {


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(st.nextToken());
		
		for(int t=1;t<=tc;t++) {
			st = new StringTokenizer(br.readLine());
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			board = new int[N][M];
			stepBoard = new int[N][M];
			visit = new boolean[N][M];
					
			Point god = null;
			Point me =null;
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				String s =st.nextToken();
				for(int j=0;j<M;j++) {
					char ch = s.charAt(j);
					if(ch == 'D') {
						god = new Point(i,j,0);
						board[i][j] = 2;
						}
					else if(ch == 'S') {
						me = new Point(i,j,0);
						board[i][j] = 3;
						}
					else if(ch == '*')
						board[i][j] = 4;
					else if( ch == '.')
						board[i][j] = 0;
					else if( ch=='X')
						board[i][j] =1;
				}
			}
			
			Queue<Point> q= new LinkedList<>();
			q.offer(me);
			
			Queue<Point> tq = new LinkedList<>();
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(board[i][j] == 4) {
						tq.offer(new Point(i,j,0));
							
						}
					}
					
				}
		
		
			while(!tq.isEmpty()) {
				Point qt = tq.poll();
				for(int dir=0;dir<4;dir++) {
					int nx = qt.x +dx[dir];
					int ny = qt.y + dy[dir];
					if(nx<0||nx>=N||ny<0||ny>=M) continue;
					if(board[nx][ny] == 0 || board[nx][ny] == 3)
						board[nx][ny]=4;
				}
			
		}
			
		
			
			
			//count를 같이 가주면서 풀어야할까???
			
			visit[me.x][me.y] = true;
			ans = -1;
			int count = 1;
			while(!q.isEmpty()) {
				
				//print(stepBoard);
	
				
				Point tmp = q.peek();
				
			
				//stepBoard[tmp.x][tmp.y] = tmp.step;
				
				if(tmp.x ==god.x && tmp.y == god.y)
				{	
					ans = tmp.step;
					break;
				}
				
				
				
				if(tmp.step == count) {
				
					for(int i=0;i<N;i++) {
						for(int j=0;j<M;j++) {
							if(board[i][j] == 4) {
								tq.offer(new Point(i,j,0));
									
								}
							}
							
						}
				
				
					count++;
					while(!tq.isEmpty()) {
						Point qt = tq.poll();
						for(int dir=0;dir<4;dir++) {
							int nx = qt.x +dx[dir];
							int ny = qt.y + dy[dir];
							if(nx<0||nx>=N||ny<0||ny>=M) continue;
							if(board[nx][ny] == 0)
								board[nx][ny]=4;
						}
					
				}
				
					
				}
				
				
				else {
					
					tmp = q.poll();
					
//					if(tmp.x == me.x && tmp.y == me.y)
//						board[me.x][me.y] =0;
					
					
					for(int dir=0;dir<4;dir++) {
						int nx= tmp.x+ dx[dir];
						int ny = tmp.y + dy[dir];
						
						if(nx<0||nx>=N||ny<0||ny>=M) continue;
						if(visit[nx][ny]) continue;
						if(board[nx][ny] == 1 || board[nx][ny] == 4) continue;
						
						q.offer(new Point(nx,ny,tmp.step+1));
						visit[nx][ny] = true;
						
					}
					
					
					
				}
					
			}
			
			if(ans == -1)
				sb.append("GAME OVER").append("\n");
			else
				sb.append(ans).append("\n");
			
			
		}
		
		
		
		System.out.println(sb);
	}

}
