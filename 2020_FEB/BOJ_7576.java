import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_7576 {
	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};	
	static int[][]  board;
	static int ans = Integer.MIN_VALUE;
	static class Point{
		int x;
		int y;
		int day;
		public Point(int x, int y,int d) {
			super();
			this.x = x;
			this.y = y;
			this.day = d;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		board = new int[N][M];
		Queue<Point> q = new LinkedList<>();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				board[i][j] = sc.nextInt();
				if(board[i][j] == 1) q.offer(new Point(i,j,1));	
			}
		}
		
		while(!q.isEmpty()) {
			
			Point tmp = q.poll();
			
			for(int dir=0;dir<4;dir++) {
				int nx = tmp.x+dx[dir];
				int ny = tmp.y+dy[dir];
			
				if(nx<0||nx>=N||ny<0|ny>=M) continue;
				if(board[nx][ny] == -1) continue;
				if(board[nx][ny] != 0 ) continue;
				
				q.offer(new Point(nx,ny,tmp.day+1));
				board[nx][ny] = tmp.day+1;
			}
			
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if( board[i][j] == 0) {
					System.out.println("-1");
					return;}
				
				if(board[i][j]>ans)
					ans = board[i][j];
					}
		}
		System.out.println(ans-1);
		
	}

}