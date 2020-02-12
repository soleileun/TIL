package cheerUp;

import java.util.ArrayList;
import java.util.Scanner;

public class JUNGOL_1071 {

	public static void main(String[] args) {
		int v = Integer.MIN_VALUE;
		Scanner sc = new Scanner (System.in);
		int N = sc.nextInt();
		int[] arr =new int[N];
		int sum =0; int mul=0;
		
		for(int i=0;i<N;i++)
			arr[i] = sc.nextInt();
		
		int M = sc.nextInt();
		
		
		for(int i=0;i<N;i++) {
			int tmp = arr[i];
			if(tmp<=M) {
				if(M%tmp ==0)
					sum +=tmp;
			}
			
			if(tmp>=M) {
				if(tmp%M ==0 )
					mul+=tmp;
			}
				
		}
		
	
		System.out.println(sum);
		System.out.println(mul);
	}

}
