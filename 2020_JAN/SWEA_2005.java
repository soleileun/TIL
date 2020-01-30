package date20200130;

import java.util.Scanner;

public class SWEA_2005 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for(int t=1;t<=10;t++) {
			sb.append("#").append(t).append("\n");
			int target = sc.nextInt();
			
			int[][] board = new int[target][target];
			//int count =1;
			for(int i=0;i<target;i++) {
				for(int j=0;j<i+1;j++) {
					if(j==0)
						{board[i][j] =1; continue;}
					
					if(j==i) 
						{board[i][j] =1; continue;}
					
					board[i][j] = board[i-1][j-1] + board[i-1][j];
					
				}
				
			}

			for(int i=0;i<target;i++) {
				for(int j=0;j<i+1;j++) {
					sb.append(board[i][j]).append(" ");
				}
				sb.append("\n");
			}
		
		}
		System.out.println(sb);
	
	}

}
