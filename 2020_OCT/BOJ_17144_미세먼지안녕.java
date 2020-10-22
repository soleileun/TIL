import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class BOJ_17144_미세먼지안녕 {
	static int R,C,T;
	static int[][] board,temp;
	static int dx[] = {0,-1,0,1};
	static int dy[] = {1,0,-1,0};
	static Point up,down;
	static class Point{
		int x;
		int y;
		int v;
		public Point(int x, int y,int v) {
			this.x = x;
			this.y =y;		
			this.v =v;
		}
	}
	
	static void up() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(up.x,up.y,up.v));
		for(int dir=0;dir<4;dir++) {
			while(!q.isEmpty()) {
				Point tmp = q.poll();
				int nx = tmp.x+dx[dir];
				int ny = tmp.y +dy[dir];
				if(nx<0||ny<0||nx>=R||ny>=C) {
					q.add(tmp);
					break;
				}
				if(board[nx][ny] == -1)
					continue;
				q.add(new Point(nx,ny,board[nx][ny]));
				if(tmp.v == -1)
					board[nx][ny] =0;
				else
					board[nx][ny]=tmp.v;
			}
		}
	
	}
	
	static void down() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(down.x, down.y, down.v));
		for(int dir=4;dir>0;dir--) {
			int idx =0;
			if(dir>=4) idx=dir%4;
			else idx = dir;
			while(!q.isEmpty()) {
				Point tmp = q.poll();
				int nx = tmp.x+dx[idx];
				int ny = tmp.y +dy[idx];
				if(nx<0||ny<0||nx>=R||ny>=C) {
					q.add(tmp);
					break;
				}
				if(board[nx][ny] == -1)
					continue;
				q.add(new Point(nx,ny,board[nx][ny]));
				if(tmp.v == -1)
					board[nx][ny] =0;
				else
					board[nx][ny]=tmp.v;
			}
		}
	
	}
	
	static void print() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				System.out.print(board[i][j] + " ");
			}System.out.println();
		}System.out.println();
	}
	
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		T = sc.nextInt();
		board = new int[R][C];
		
		for(int r=0;r<R;r++) {
			for(int c=0;c<C;c++) {
				board[r][c] = sc.nextInt();
				if( board[r][c] == -1) {
					if(up == null)
						up = new Point(r,c,board[r][c]);
					else
						down = new Point(r,c,board[r][c]);
				}
			}
		}

		
		for(int t=0;t<T;t++) {
			//미세먼지 확산 
			temp = new int[R][C];
			for(int r=0;r<R;r++) {
				for(int c=0;c<C;c++) {
					if(board[r][c] != 0) {
						int cnt=0;
						for(int dir=0;dir<4;dir++) {
							int nx = r+dx[dir];
							int ny = c+dy[dir];
							if(nx<0||nx>=R||ny<0||ny>=C) continue;
							if(board[nx][ny] == -1) continue;
							cnt++;
							temp[nx][ny] += board[r][c]/5;
						}
						board[r][c] -= (board[r][c]/5)*cnt;
					}
				}
			}
			for(int r=0;r<R;r++) {
				for(int c=0;c<C;c++) {
					board[r][c] += temp[r][c];
				}
			}
			
//			System.out.println(t+"번째 확산");
//			print();
			//공기청정기가 작동한다 

			up();
			down();
			
//			System.out.println(t+"번째 작동");
//			print();
//			
			
		}
		int sum =0;
		for(int r=0;r<R;r++) {
			for(int c=0;c<C;c++) {
				sum +=board[r][c] ;
			}
		}
		System.out.println(sum+2);
	}
}
