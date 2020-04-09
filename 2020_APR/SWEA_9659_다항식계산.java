package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_9659_다항식계산 {


	public static void main(String[] args) throws Exception {
		
		BufferedReader br= new BufferedReader( new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb= new StringBuilder();
		
		int tc = Integer.parseInt(st.nextToken());
		long mod = 998244353;
		for(int t=1;t<=tc;t++)
		{
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			int[] T =new int[N+1];
			int[] a =new int[N+1];
			int[] b =new int[N+1];
			for(int n=2;n<N+1;n++) {
				st = new StringTokenizer(br.readLine());
				T[n] = Integer.parseInt(st.nextToken());
				a[n] = Integer.parseInt(st.nextToken());
				b[n] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			long[] x = new long[M];
			st = new StringTokenizer(br.readLine());
			for(int m=0;m<M;m++)
				x[m] = Integer.parseInt(st.nextToken());
			//입력 다 받았음. 
			
			for(int m=0;m<M;m++) {
				long[] memo = new long[N+1];
				memo[0] = 1;
				memo[1] = x[m];
				for(int n=2;n<N+1;n++) {
					if(T[n] == 1) {
						memo[n] = (memo[a[n]]+memo[b[n]])%mod;
					}else if(T[n] ==2) {
						memo[n] =(a[n]*memo[b[n]])%mod;
					}else if(T[n] == 3) {
						memo[n] = (memo[a[n]]*memo[b[n]])%mod;
					}
				}
				
				sb.append(memo[N]);
				sb.append(" ");
				
			}
			sb.append("\n");
			
			
		}
		System.out.println(sb);
	}
}
