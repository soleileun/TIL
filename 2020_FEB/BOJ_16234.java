package hyoukang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234 {
	
	static class Point{
		int x;
		int y;
		int p;
		
		public Point(int x, int y, int p) {
			super();
			this.x = x;
			this.y = y;
			this.p = p;
		}
		
	}

	static int N,L,R;
	static int[][] board;
	static int[] dy = {0,0,1,-1};
	static int[] dx  = {1,-1,0,0};
	static int ans;
	
	static boolean checkBoard() {
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				
				for(int dir=0;dir<4;dir++) {
					int nx = i+dx[dir];
					int ny = j +dy[dir];
					
					if(nx<0||nx>=N||ny<0||ny>=N) continue;
					int gap = Math.abs(board[i][j] - board[nx][ny]);
					if(gap>=L && gap<=R) 
						return false;
					
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	
	N = Integer.parseInt(st.nextToken());
	L = Integer.parseInt(st.nextToken());
	R = Integer.parseInt(st.nextToken());
	board = new int[N][N];
	for(int i=0;i<N;i++) {
		st = new StringTokenizer(br.readLine());
		for(int j=0;j<N;j++) {
			board[i][j] = Integer.parseInt(st.nextToken());
		}
	}
	
	
	while(true) {
		
		if(checkBoard())
			break;
		
	boolean[][] visit = new boolean[N][N];
		
	for(int i=0;i<N;i++) {
		for(int j=0;j<N;j++) {
			if(visit[i][j]) continue;
			int sum=0;int count=0;
			Queue<Point> q = new LinkedList<>();
			Queue<Point> temp = new LinkedList<>();
			 
			q.offer(new Point(i,j,board[i][j]));
			visit[i][j] = true;
			count++;
			while(!q.isEmpty()) {
				Point tmp = q.poll();
				temp.offer(tmp);
				sum += tmp.p;
				for(int dir = 0;dir<4;dir++) {
					int nx = tmp.x + dx[dir];
					int ny = tmp.y + dy[dir];
					
					if(nx<0||nx>=N||ny<0||ny>=N) continue;
					if(visit[nx][ny]) continue;
					int gap = Math.abs(tmp.p - board[nx][ny]);
					if(gap<L || gap>R) continue;
					
					q.offer(new Point(nx,ny,board[nx][ny]));
					visit[nx][ny] = true;
					count++;		
					
				}
				
			}
		int result = sum/count;
		
		while(!temp.isEmpty()) {
			Point tmp = temp.poll();
			board[tmp.x][tmp.y] = result;
		}
		}
	}
	
	
//	System.out.println(ans);
//	for(int i=0;i<N;i++) {
//		for(int j=0;j<N;j++) {
//			System.out.print(board[i][j] + " ");
//		}System.out.println();
//	}
//	
	ans++;
	if(checkBoard())
		break;
	
	
	}
		System.out.println(ans);
		
	}

}
