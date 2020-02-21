package hyoukang;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_16198 {

	static int[] src;
	static int[] arr;
	static boolean[] vs;
	static int N;
	static int [] marble;
	static boolean[] visit;
	static int max = Integer.MIN_VALUE;
	
	static void go(int idx) {
		if(idx == src.length ) {
			visit = new boolean[src.length+2];
			int sum =0;
			for(int i=0;i<arr.length;i++) {
				visit[arr[i]] = true;
				int tmp_l = arr[i]-1;
				while(true) {
					if(visit[tmp_l] == false)
						break;
					tmp_l--;
					
				}
				int tmp_r = arr[i]+1;
				while(true) {
					if(visit[tmp_r] == false)
						break;
					tmp_r++;
					
				}
				sum += marble[tmp_l] * marble[tmp_r];	
			}
			
			if(max<sum)
				max = sum;
			
			
		}else {
			for(int i=0;i<src.length;i++) {
				if(!vs[i]) {
					vs[i] = true;
					arr[idx] = src[i];
					go(idx+1);
					vs[i] = false;
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		marble = new int[N];
		for(int i=0;i<N;i++){
			marble[i] = sc.nextInt();
		}
		src = new int[N-2];
		arr = new int[N-2];
		vs = new boolean[N-2];
		
		
		
		int cnt =1;
		for(int i=0;i<N-2;i++)
			src[i] = cnt++;
		
		go(0);

		System.out.println(max);
	}

}
