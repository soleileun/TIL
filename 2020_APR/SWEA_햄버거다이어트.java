package _0423;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_햄버거다이어트 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(st.nextToken());
		
		for(int t=1;t<=tc;t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			int count = Integer.parseInt(st.nextToken());
			int limit = Integer.parseInt(st.nextToken());
			
			int[][] Food = new int[count+1][2];
			
			for(int i=1;i<=count;i++) {
				st = new StringTokenizer(br.readLine());
				Food[i][0] = Integer.parseInt(st.nextToken()); // 만족도
				Food[i][1] = Integer.parseInt(st.nextToken()); // 칼로리
			}
			
			int[][] dp = new int[count+1][limit+7];
			for(int i=1;i<=count;i++) {
				for(int j=1;j<=limit;j++) {
					  if(Food[i][1]>j){
						  dp[i][j] = dp[i-1][j];
	                    }
	                    else {
	                    	dp[i][j] = Integer.max(Food[i][0] + dp[i-1][j-Food[i][1]], dp[i-1][j]);
	                    }
	                   }

				}
			
			sb.append(dp[count][limit]).append("\n");
			}
		
		System.out.println(sb);
		}
	}

