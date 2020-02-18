package day2;

import java.util.Scanner;

public class SWEA_7965 {


	
	static long go(int idx ,int i) {
		if(idx ==0)
			return 1;
		//if(idx ==1) return i;
		
		if(idx%2==0) {
			long t = ((go(idx/2,i)%1000000007));
			return t* t %1000000007;
			}
		else {long t = ((go(idx/2,i)%1000000007));
			return ((t*t)%1000000007 * i %1000000007);}
		
	}

//	static long [] arr = new long[M];
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc= new Scanner(System.in);
		StringBuilder sb= new StringBuilder();
		
		int tc = sc.nextInt();
		

		
		for(int t=1;t<=tc;t++) {
			sb.append("#").append(t).append(" ");
			int N = sc.nextInt();
			long sum =0;
			for(int i=1;i<=N;i++) {
				
			sum = (sum+go(i,i))%1000000007;
				
				
			}
		sb.append(sum).append("\n");
			
			
		}
	System.out.println(sb);
		
	}

}

