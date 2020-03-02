package hyoukang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ_3085 {
	
	static int[] dx = {0,1};
	static int[] dy = {1,0};
	static int[][] board;
	static int N;
	static int max = Integer.MIN_VALUE;
	
	static void getSum(int x, int y) {
		
		int tmp=1;
		int before = board[x][0];
		
		for(int i=1;i<N;i++) {
			if(before ==  board[x][i])
				tmp++;
			else {
				before = board[x][i];
				if(tmp>max)
					max = tmp;
				tmp=1;
			}
		}
		
		if(tmp>max)
			max = tmp;
		
		tmp =1;
		before = board[0][y];
		for(int i=1;i<N;i++) {
			if(before ==  board[i][y])
				tmp++;
			else {
				before = board[i][y];
				if(tmp>max)
					max = tmp;
				tmp=1;
			}
		}
		
		if(tmp>max)
			max = tmp;
		
	}


	static void swap(int[][] board,int x, int y, int nx, int ny) {
		int tmp = board[x][y];
		board[x][y] = board[nx][ny];
		board[nx][ny] = tmp;
	}
	
	public static void main(String [] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		board = new int [N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			
			for(int j=0;j<N;j++) {
				int x = s.charAt(j);
				if(x == 'C')
					board[i][j] =1;
				else if( x == 'P')
					board[i][j] = 2;
				else if ( x == 'Z')
					board[i][j] = 3;
				else if (x == 'Y')
					board[i][j] = 4;
			}
		}
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				
				int tmp = board[i][j];
				for(int dir =0;dir<2;dir++)
				{
					int nx = i+dx[dir];
					int ny = j+dy[dir];
					if(nx<0||nx>=N||ny<0||ny>=N) continue;
					
					swap(board,i,j,nx,ny);
					getSum(i, j);
					getSum(nx, ny);
					swap(board,i,j,nx,ny);
					
					
				}
			}
		}
		
		System.out.println(max);
		
	}
}
