package _0521;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14891_톱니바퀴 {
	
	static int K;
	static int[][] board ;
	//시계방향
	static void roll(int idx, int dir) {
		
		if(dir == 1 ) {
		int last = board[idx][7];
		int before = board[idx][0];int before2=-1;
		
		for(int i=1;i<8;i++) {
			before2=board[idx][i];
			board[idx][i] = before;
			before = before2;
		}
		board[idx][0] = last;
		}else if( dir == -1) {
			int first = board[idx][0];
			int before = board[idx][0];int before2=-1;
			
			for(int i=7;i>=0;i--) {
				before2=board[idx][i];
				board[idx][i] = before;
				before = before2;
			}
			board[idx][7] = first;
		}
	}
	//반시계
//	static void rollback(int idx) {
//		int first = board[idx][0];
//		int before = board[idx][0];int before2=-1;
//		
//		for(int i=7;i>=0;i--) {
//			before2=board[idx][i];
//			board[idx][i] = before;
//			before = before2;
//		}
//		board[idx][7] = first;
//	}
	

	static void go(int idx) {
		
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader( System.in ));
		
		int tc = 1;
		
		for(int t=1;t<=tc;t++) {
		
			board = new int[4][8];
		
			for(int i=0;i<4;i++) {
				String s = br.readLine();
				for(int j=0;j<8;j++) {
					board[i][j] = Integer.parseInt(s.substring(j,j+1));
				}
			}
			K = Integer.parseInt(br.readLine());
			for(int k=0;k<K;k++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken())-1;
				int dir = Integer.parseInt(st.nextToken());
				int left =-1; int right = -1;
				
				for(int i=num;i>=1;i-- ) {
					if(board[i][6] != board[i-1][2])
						left = i-1;
					else break;
				}
				for(int i=num;i<3;i++) {
					if(board[i][2] != board[i+1][6])
						right = i+1;
					else
						break;
				}
				
				if(left != -1) {
					
					for(int i=left;i<num;i++) {
						if(i%2 == num%2)
						{
							roll(i, dir);
						}else {
							if(dir == -1) {
								roll(i,1);
							}else if(dir == 1) {
								roll(i,-1);
								}
						}
					}
					
				}
				if(right != -1) {
					for(int i=num+1;i<=right;i++) {
						if(i%2 == num%2)
						{
								roll(i, dir);
						}else {
							if(dir == -1)
								roll(i,1);
							else if(dir == 1)
								roll(i,-1);
						}
					}
				}
				roll(num,dir);
			}
			
			int sum =0;
			if(board[0][0] == 1) sum += 1;
			if(board[1][0] == 1) sum += 2;
			if(board[2][0] == 1) sum += 4;
			if(board[3][0] == 1) sum += 8;
			System.out.println(sum);
		
		}
		
	}
}
