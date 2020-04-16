package cheerUp;

import java.util.Scanner;

public class BOJ_11727_2xn타일링2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
				
		int [] dp = new int[N+5];
		dp[1] = 1;
		dp[2] = 3;
		for(int i=3;i<=N;i++) {
			dp[i] =2*dp[i-2]%10007+dp[i-1]%10007; 
			dp[i] %=10007; 
		}
		
		System.out.println(dp[N]%10007);
		
		
		
	}
}
