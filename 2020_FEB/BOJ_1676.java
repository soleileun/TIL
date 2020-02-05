package date20200205;

import java.util.Scanner;

public class BOJ_1676 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int tc = 1;
		
		for(int t=0;t<tc;t++) {
			int tmp = sc.nextInt();
			int sum =0;
			
			for(int i=5;i<=tmp;i=i*5)
				sum += tmp/i;
			
			System.out.println(sum);
			
		}

		
	}

}


