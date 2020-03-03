package hyoukang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1018 {
	static int N,M;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		char[][] board = new char[N][M];
		char[][] whiteBoard = new char[8][8];
		char[][] blackBoard = new char[8][8];
		
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if((i+j) %2==0) {
				whiteBoard[i][j] = 'W';
				blackBoard[i][j] = 'B';
				}
				if((i+j) %2 ==1)
				{
					whiteBoard[i][j] = 'B';
					blackBoard[i][j] = 'W';
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			for(int j=0;j<M;j++) {
				char tmp = s.charAt(j);
				board[i][j] = tmp;
			}
		}
		
		
		for(int i=0;i<N-7;i++) {
			for(int j=0;j<M-7;j++) {
				
				int w_change = 0;
				for(int x=0;x<8;x++) {
					for(int y=0;y<8;y++) {
						if(board[i+x][j+y] == whiteBoard[x][y])
							continue;
						else
							w_change++;
					}
				}
				
				int b_change = 0;
				for(int x=0;x<8;x++) {
					for(int y=0;y<8;y++) {
						if(board[i+x][j+y] == blackBoard[x][y])
							continue;
						else
							b_change++;
					}
				}
				
				
				int min = Integer.min(w_change, b_change);
				ans = Integer.min(ans, min);
			}
		}
		
		System.out.println(ans);
	}

}
