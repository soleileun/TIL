package hyoukang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11559 {
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int ans =0;
	static class Point{
		int x;
		int y;
		int c;
		public Point(int x, int y, int c) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
		}
		
	}
	
	static boolean flag;

	static void bfs(int[][] board) {
		
		for(int i=0;i<12;i++) {
			for(int j=0;j<6;j++) {
				if(board[i][j] == 0) continue;
				Queue<Point> q = new LinkedList<>();
				Queue<Point> tq = new LinkedList<>();
				boolean[][] visit = new boolean[12][6];
			
				q.offer(new Point(i,j,board[i][j]));
				tq.offer(new Point(i,j,board[i][j]));
				
				visit[i][j] = true;
				
				while(!q.isEmpty()) {
					Point tmp = q.poll();
					
					for(int dir=0;dir<4;dir++) {
						int nx = tmp.x + dx[dir];
						int ny = tmp.y + dy[dir];
						if(nx<0||nx>=12||ny<0||ny>=6) continue;
						if(board[nx][ny] != tmp.c) continue;
						if(visit[nx][ny]) continue;
						
						q.offer(new Point(nx,ny,tmp.c));
						tq.offer(new Point(nx,ny,tmp.c));
						visit[nx][ny] =true;
						
						
					}
					
				
				}
				if(tq.size() >=4)
				{
					flag = true;
					int size = tq.size();
					for(int s=0;s<size;s++) {
					Point temp = tq.poll();
					board[temp.x][temp.y] = 0;
					}
				}
				
				
				
			}
		}
		
	}
	
	static void arrange(int[][] board) {
		if(flag) {
			for(int j=0;j<6;j++) {
				for(int i=11;i>=0;i--) {
					if(board[i][j] != 0)
						continue;
					
					int t=i;t--;
					if(t<0)
						break;
					else {
					
					
					while(true) {
						if(board[t][j] ==0) {
							t--;
							if(t<0) 
								break;
						}
						else {
							int tnum = board[i][j];
							board[i][j] = board[t][j];
							board[t][j] = tnum;
							break;
						}
					}
					}
					
				}
			}
			}
	}
	
	static void print(int[][] board) {
		System.out.println("================================");
		for(int i=0;i<12;i++) {
			for(int j=0;j<6;j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("================================");
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] board = new int[12][6];
		
		for(int i=0;i<12;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			for(int j=0;j<6;j++) {
				char tmp = s.charAt(j);
				if(tmp == '.')
					board[i][j] = 0;
				else if(tmp == 'R')
					board[i][j] = 1;
				else if(tmp == 'G')
					board[i][j] =2;
				else if(tmp == 'B')
					board[i][j] =3;
				else if(tmp == 'P')
					board[i][j] =4;
				else if(tmp == 'Y')
					board[i][j] =5;
				
			}
		}
		
		
		
		//여기서부터 한바퀴~
		while(true){
			//System.out.println(ans);
			//print(board);
			

		flag = false;
		bfs(board);
		
		if(flag) {
			arrange(board);
		}

		if(flag)
			ans++;
		else
			break;
			
	}
		
		System.out.println(ans);
		
		
	}

}
