package date20200206;

import java.util.Scanner;

public class SWEA_2001 {
	static int [][] board;


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			sb.append("#").append(t).append(" ");
			int max = Integer.MIN_VALUE;
			int N = sc.nextInt();
			int M = sc.nextInt();
			board = new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					board[i][j] = sc.nextInt();
				}
			}
			int x=0,y=0;
			while(true) {
				//System.out.println("시작점 x : "+x+" y :" + y);
				int sum=0;
				for(int i=0;i<M;i++) {
					for(int j=0;j<M;j++) {
						sum += board[x+i][y+j];
						
					}
				}
				
				if(sum>max)
					max = sum;
				y++;
				
				if(y == N-M+1) {x++;y=0;}
				if(x == N-M+1 ) break;
				//System.out.println("현재결과 : " + sum + " " +"MAX : " +max);
			}
	
			sb.append(max).append("\n");
		}
		
		System.out.println(sb);
	}	
	
}
