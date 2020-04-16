package cheerUp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2579_계단오르기 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		
		int N = Integer.parseInt(st.nextToken());
		int[] stairs = new int[N+10];
	
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			stairs[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[N+10];
		dp[1] = stairs[1];
		dp[2] = Integer.max(stairs[1]+stairs[2], stairs[2]);
		dp[3] = Integer.max(stairs[1]+stairs[3], stairs[2]+stairs[3]);
		for(int i=4;i<=N;i++) {
			dp[i] = Integer.max(dp[i-3] + stairs[i-1] + stairs[i], dp[i-2] + stairs[i]);
	     
	      
		}
		
		System.out.println(dp[N]);
	
	}
}
