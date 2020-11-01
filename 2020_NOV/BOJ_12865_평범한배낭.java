import java.util.Scanner;

public class BOJ_12865_평범한배낭 {


	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int item[][] = new int[2][N];
		
		for(int i=0;i<N;i++) {
			item[0][i] = sc.nextInt(); //w
			item[1][i] = sc.nextInt(); //v
			
		}
		int ans = -1;
        int[][] dp = new int[N+1][K+1];
        
        for(int i=1;i<=N;i++) {
        	for(int j=1;j<=K;j++) {
        		if(item[0][i-1] <= j)
        			dp[i][j] = Math.max(item[1][i-1] + dp[i-1][j-item[0][i-1]], dp[i-1][j]);
        		else
        			dp[i][j] = dp[i-1][j];
        		if(dp[i][j] > ans)
        			ans = dp[i][j];
        	}
        }
        System.out.println(ans);
        
	}
}
