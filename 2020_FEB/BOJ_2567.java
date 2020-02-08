package cheerUp;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2567 {

	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		int N = sc.nextInt();	
		int[][] board = new int[101][101];
		for(int i=0;i<N;i++) {
			int x= sc.nextInt();
			int y = sc.nextInt();
			for(int k=x;k<x+10;k++) {
				for(int j=y;j<y+10;j++)
					board[k][j] = 1;
			}
		}
		
		int count =0;
		for(int i=0;i<101;i++) {
			for(int j=0;j<101;j++) {
				if(board[i][j] ==0)continue;
				else {
					for(int dir=0;dir<4;dir++) {
						int nx =i+dx[dir];
						int ny = j+dy[dir];
						if(board[nx][ny] == 0)
							count++;
					}
				}
			}
		}
	
	System.out.println(count);
	
	}
}
