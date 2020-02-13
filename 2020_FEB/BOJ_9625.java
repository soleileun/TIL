package swea_prob;

import java.util.Scanner;

public class BOJ_9625 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		long[][] board = new long[51][2];
		
		board[0][0] = 1;
		board[0][1] = 0;
		board[1][0] = 0;
		board[1][1] = 1;
		if(N==1)
		{	System.out.println(board[1][0] +" "+ board[1][1]);
		return;}
		if(N==0) {
			System.out.println(board[0][0] +" "+ board[0][1]);
		}
			
		for(int i=2;i<=50;i++) {
			board[i][0] = board[i-1][0] + board[i-2][0];
			board[i][1] = board[i-1][1] + board[i-2][1];
		//	System.out.println(board[i][0] +" "+ board[i][1]);
		}
		
		System.out.println(board[N][0] +" "+ board[N][1]);
	}

}
