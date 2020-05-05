package _0501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3015_돌던지기 {

	static int[][] board;
	static int N,M,K;
	
	//돌 입력받는 형태 
	static void move(int y) {
		
		for(int x=0;x<N;x++) {
			
			if( x+1 == N) {
				board[x][y] = 2; 
				break;
			}
			
			if(board[x+1][y] == 1) {
				board[x][y] = 2; 
				break;
			}else if(board[x+1][y]==0) {
				continue;
			}else if(board[x+1][y] ==2) {
				if(x+1 >=0 && x+1<N && y-1 >=0&& y-1<M) {
					if(board[x][y-1] == 0 && board[x+1][y-1] == 0){
						y=y-1;
						continue;
					}
				}
				
				if(x+1 >=0 && x+1 <N && y+1>=0 && y+1<M) {
					if(board[x][y+1] == 0 && board[x+1][y+1] == 0) {
						y=y+1;
						continue;
					}
				}
				
				board[x][y]=2;
			}
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int tc =1;
		
		for(int t=1;t<=tc;t++) {
		//	sb.append("# ").append(t).append(" \n");
		//	st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			board = new int[N][M];
			for(int i=0;i<N;i++) {
				String s = br.readLine();
				for(int j=0;j<M;j++) {
					
					if(s.charAt(j)=='.')
						board[i][j] = 0;
					else if(s.charAt(j)=='X')
						board[i][j] = 1;
				}
			}
			
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
		
			for(int i=0;i<K;i++) {
				st = new StringTokenizer(br.readLine());
				int now = Integer.parseInt(st.nextToken())-1;
				move(now);
			}
		
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(board[i][j] == 0)
						sb.append(".");
					else if(board[i][j] == 1)
						sb.append("X");
					else if(board[i][j]==2)
						sb.append("O");
				}
				sb.append("\n");
			}
			
		}
		
		System.out.println(sb);
	}
}
