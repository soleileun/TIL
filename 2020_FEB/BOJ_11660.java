package date20200218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11660 {

	static int N,M;
	static int[][] board;
	

	
	public static int go2 (int x1,int x2, int y1, int y2) {
	
		int sum =0;
		
		for(int i=x1;i<=x2;i++) {
			sum += board[i][y2]- board[i][y1-1];
		}
		
		return sum;
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb= new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N+1][N+1];	
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int sum =0;
			for(int j=1;j<=N;j++) {
				int tmp =  Integer.parseInt(st.nextToken());
				board[i][j] = sum + tmp;
				sum +=tmp;
			}
		}
		
		

		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			

			sb.append(go2(x1,x2,y1,y2)).append("\n");
		}
		
		System.out.println(sb);

	}

}