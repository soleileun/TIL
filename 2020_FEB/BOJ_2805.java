package date20200206;

import java.util.Queue;
import java.util.Scanner;

public class BOJ_2805 {
	
	public static void main(String[] args) {

		
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			sb.append("#").append(t).append(" ");
		int N = sc.nextInt();
		boolean[][] visited = new boolean[N][N];
		int[][] board = new int[N][N];
		
		
		
		int start = N/2;
		for(int i=0;i<N;i++) {
			String s = sc.next();
			for(int j=0;j<N;j++) {
				board[i][j] = s.charAt(j)-'0';
			}
		}
		
		for(int i=0;i<=N/2;i++) {
			for(int j=start-i;j<=start+i;j++) {
				visited[i][j] = true;
			}
		}
		for(int i=N;i>=N/2+1;i--) {
			for(int j=start-(N-i)+1;j<start+(N-i);j++)
				visited[i][j] = true;
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++)
				System.out.print(visited[i][j] + " ");
		System.out.println();
		}
		int sum=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(visited[i][j])
					sum += board[i][j];
			}
		}
		sb.append(sum).append("\n");
	}
		System.out.println(sb);
	}
}
