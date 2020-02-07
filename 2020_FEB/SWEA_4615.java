package date20200206;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_4615 {

	static int[] dx = {-1,1,0,0,-1,-1,1,1};
	static int[] dy = {0,0,1,-1,1,-1,1,-1};
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		
		for(int t=1;t<=tc;t++) {
		sb.append("#").append(t).append(" ");
		int N = sc.nextInt();
		int n = sc.nextInt();
		int[][] board = new int[N][N];
		board[N/2][N/2] = 2;
		board[N/2-1][N/2] =1;
		board[N/2-1][N/2-1] = 2;
		board[N/2][N/2-1] = 1;
		int sum1=0;int sum2 =0;

		for(int i=0;i<n;i++) {
			
			int x = sc.nextInt() -1;
			int y = sc.nextInt() -1;
			int turn = sc.nextInt();
			board[x][y] = turn;
			
			int tmp =-1;
			if(turn ==1) tmp =2;
			else if(turn ==2) tmp =1;
			
			for(int dir=0;dir<8;dir++) {
				int nx= x+dx[dir];
				int ny= y+dy[dir];
				
				if(nx<0||nx >=N||ny<0|| ny>=N) continue;
				if(board[nx][ny] == turn) continue;
				if(board[nx][ny] == 0) continue;
				if(board[nx][ny] != turn) {
					
					
					int iter =2;
					int next_x = x+(dx[dir])*iter;
					int next_y = y+(dy[dir])*iter;
					boolean f= false;
					
					while(true) {
						next_x = x+(dx[dir])*iter;
						next_y = y+(dy[dir])*iter;
						if(next_x<0||next_x >=N||next_y<0|| next_y>=N) break;
						if(board[next_x][next_y] == tmp){
							iter++;continue;
						}
						else if(board[next_x][next_y] == turn) 
							{f=true;break;}
						else if(board[next_x][next_y] == 0) break;
					}
					
					if(f) {
					for(int it=1;it<iter;it++) {
						board[x+(dx[dir])*it][y+(dy[dir])*it] = turn;
					}
					}
					
					
				}
			}
		int a1 =0; int a2=0;
			for(int a =0;a<N;a++) {
				for(int b=0;b<N;b++)
					{if(board[a][b] == 1)
						a1++;
					else if  (board[a][b] == 2)
						a2++;
					}
			}
			sum1=a1;sum2=a2;
			
		}
		sb.append(sum1).append(" ").append(sum2).append("\n");
		
	}
		System.out.println(sb);
}
}
