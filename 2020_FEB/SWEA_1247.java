package day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1247 {

	static int[] board;
	static int N,K;
	static int[] src;
	//static ArrayList<Integer>arr;
	static int ans =0;
	
	static void bit_powerset() {
		int n = src.length;
		
		for(int i=0;i<(1<<n);i++) {
			int sum =0;
			//ArrayList<Integer> arr = new ArrayList<>();
			for(int j=0;j<n;j++) {
				if((i&(1<<j)) != 0) {
					sum +=src[j];
					if(sum >K)
						break;
					//arr.add(src[j]);
					}
			}
			if(sum == K)
				ans++;
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		StringBuilder sb= new StringBuilder();
		
		for(int t=1;t<=tc;t++) {
			ans =0;
			sb.append("#").append(t).append(" ");
			N = sc.nextInt();
			K = sc.nextInt();
			
			src = new int[N];
			
			for(int i=0;i<N;i++) {
				src[i] = sc.nextInt();
			}
			//System.out.println(Arrays.toString(src));
			bit_powerset();
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}

}
