import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2146_다리만들기 {
	static int min = Integer.MAX_VALUE,N;
	static int[][] board;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static class Point{
		int x;
		int y;
		boolean possible;
		int step;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
			this.possible = false;
			this.step =0;
		}
		public Point(int x, int y, boolean possible) {
			super();
			this.x = x;
			this.y = y;
			this.possible = possible;
			this.step =0;
		}
		public Point(int x, int y, boolean possible, int step) {
			super();
			this.x = x;
			this.y = y;
			this.possible = possible;
			this.step = step;
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N= Integer.parseInt(st.nextToken());
		board = new int[N][N];
		map = new int[N][N];
		Point[][] Board = new Point[N][N];
		visit = new boolean[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int count =0;
		Queue<Point> q = new LinkedList<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(board[i][j] == 0 || visit[i][j]) continue;
				
				count++;
				q.offer(new Point(i,j));
				visit[i][j] = true;
				while(!q.isEmpty()) {
					Point tmp = q.poll();
					map[tmp.x][tmp.y] = count;
					
					for(int dir=0;dir<4;dir++) {
						int nx = tmp.x + dx[dir];
						int ny = tmp.y + dy[dir];
						
						if(nx<0||nx>=N||ny<0||ny>=N) continue;
						if(board[nx][ny] == 0 || visit[nx][ny]) continue;
						
						q.offer(new Point(nx,ny));
						visit[nx][ny] =true;
					}
				}
				
			}
		}
//		
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<N;j++) {
//				System.out.print(map[i][j] + " ");
//			}System.out.println();
//		}
//	
//		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(board[i][j] != 0) {
					boolean flag=false;
					for(int dir=0;dir<4;dir++) {
						int nx = i+dx[dir];
						int ny = j+dy[dir];
						
						if(nx<0||nx>=N||ny<0||ny>=N) continue;
						if(board[nx][ny] == 0) flag = true;
						
					}
					if(flag) Board[i][j] = new Point(i,j,true);
					else Board[i][j] = new Point(i,j,false);
				}else {
					Board[i][j] = new Point(i,j,false);
				}
			}
		}
//		
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<N;j++) {
//				System.out.print(Board[i][j].possible + " ");
//			}System.out.println();
//		}
//		
//		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				q.clear();
				visit = new boolean[N][N];
				if(Board[i][j].possible) {
					q.offer(new Point(i,j,Board[i][j].possible,0));
					visit[i][j] = true;
					
					while(!q.isEmpty()) {
						Point tmp = q.poll();
						for(int dir=0;dir<4;dir++) {
							int nx = tmp.x+dx[dir];
							int ny = tmp.y+dy[dir];
							if(nx<0||nx>=N||ny<0||ny>=N) continue;
							if(map[i][j] == map[nx][ny] || visit[nx][ny]) continue;
							if(map[nx][ny] == 0) {
								q.offer(new Point(nx,ny,Board[i][j].possible,tmp.step+1));
								visit[nx][ny] = true;
								continue;
							}
							if(map[i][j] != map[nx][ny]) {
								if(min >tmp.step)
									min = tmp.step;
								continue;
							}
						}
					}
				}
			}
		}
		
		System.out.println(min);
		
		
		
		
		
	}
}
