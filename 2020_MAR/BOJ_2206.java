package hyoukang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206 {
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int N,M;
	static int min = Integer.MAX_VALUE;
	static int [][] board;
	
	static class Point{
		int x;
		int y;
		int step;
		int push;
		public Point(int x, int y,int step,int push) {
			super();
			this.x = x;
			this.y = y;
			this.step = step;
			this.push = push;
		}
		
	}
	
	static void bfs() {
		
		Queue<Point> q = new LinkedList<>();
		boolean[][][] visit = new boolean[N][M][2];
		q.offer(new Point(0,0,1,0));
		
		boolean flag = false;
		//boolean push = false;
		int dis =-1;
		while(!q.isEmpty()) {
			Point tmp = q.poll();
			 dis = tmp.step;
	
			 
			if(tmp.x == N-1 && tmp.y == M-1) {
				flag = true;
				if(min>dis)
					min = dis;
				break;
			}
					
			for(int dir=0;dir<4;dir++) {
				
				int nx = tmp.x + dx[dir];
				int ny = tmp.y + dy[dir];
			
				if(nx<0||nx>=N||ny<0||ny>=M) continue;
				
			//	if(visit[nx][ny] < tmp.push) continue;
				
				if(tmp.push == 1) {
					
				
				if(visit[nx][ny][tmp.push] == false && board[nx][ny] == 0) {
					visit[nx][ny][tmp.push] = true;
					q.offer(new Point(nx,ny,tmp.step+1,tmp.push));
					}
				}else {
					
					if(board[nx][ny]== 1) {
						if(visit[nx][ny][tmp.push+1] == false) {
							visit[nx][ny][tmp.push +1] = true;
							q.offer(new Point(nx,ny,tmp.step+1,tmp.push+1));
						}
					}
					else if(board[nx][ny] == 0) {
						if(visit[nx][ny][tmp.push] == false) {
							visit[nx][ny][tmp.push] = true;
							q.offer(new Point(nx,ny,tmp.step+1,tmp.push));
						}
					}
					
					
					
				}
				
				
			}
			
			
		}
		
		
		
	}

	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		ArrayList<Point> arr = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			
			for(int j=0;j<M;j++) {
				int x = s.charAt(j)-'0';
				if(x == 1)
					arr.add(new Point(i,j,0,0));
				board[i][j] =x;
					
			}
		}
		
		bfs();

		if(min == Integer.MAX_VALUE)
			System.out.println("-1");
		else
			System.out.println(min);
		
		
	}

}
