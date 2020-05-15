import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2636_치즈 {
	static int N,M;
	static int[][] board,temp;
	static boolean[][] visit;
	static int checkBoard(int[][] board) {
		int cnt =0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(board[i][j] == 1) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};

	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int before = 0;
		board = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 1) before++;
			}
		}
		int time =0;
		while(true) {
			time ++;
			visit = new boolean[N][M];
			Queue<Point> q = new LinkedList<>();
			Stack<Point> stack = new Stack<>();
			
			temp  = new int[N][M];
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					
					if(board[i][j] == 1 || visit[i][j]) continue;
				
					boolean outside = false;
					q.offer(new Point(i,j));
					visit[i][j] = true;
					stack.add(new Point(i,j));
					
					while(!q.isEmpty()) {
						Point tmp = q.poll();
						
						for(int dir=0;dir<4;dir++) {
							int nx = tmp.x + dx[dir];
							int ny = tmp.y + dy[dir];
							if(nx<0||nx>=N||ny<0||ny>=M) continue;
							if(visit[nx][ny]) continue;
							if(board[nx][ny]==1) continue;
							
							if(nx == 0 || nx == N-1 ||ny ==0 ||ny == M-1)
								outside = true;
							
							q.offer(new Point(nx,ny));
							visit[nx][ny] = true;
							stack.add(new Point(nx,ny));
						}
					}
					
					if(!outside) {
						while(!stack.isEmpty()) {
							Point p = stack.pop();
							temp[p.x][p.y] = 2;
						}
					}else {
						stack.clear();
					}
				}
			}
			
			q.clear();
			visit = new boolean[N][M];
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					
					if(board[i][j] == 0 || visit[i][j]) continue;
					q.offer(new Point(i,j));
					visit[i][j] = true;
					
					while(!q.isEmpty()) {
						Point tmp = q.poll();
						int touch =0;

						for(int dir=0;dir<4;dir++) {
							int nx = tmp.x + dx[dir];
							int ny = tmp.y + dy[dir];
							if(nx<0||nx>=N||ny<0||ny>=M) continue;
							if(visit[nx][ny]) continue;
							
							if(board[nx][ny]==0) 
								{
								if(temp[nx][ny] ==0) {touch ++; continue;}
								else if(temp[nx][ny] == 2) continue;
								}
							q.offer(new Point(nx,ny));
							visit[nx][ny] = true;
							
						}
						
						if(touch >0) {
							temp[tmp.x][tmp.y] =1;
						}
					}
					
				}
			} 
		
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(board[i][j] == 0 || temp[i][j] == 1 || temp[i][j] ==2)
						board[i][j] =0;
				}
			}
			int tmp = checkBoard(board);
			if(tmp == 0) {
				System.out.println(time);
				System.out.println(before);
				return;
			}else {
				before =tmp;
			}
			
		}
		
	}
}
