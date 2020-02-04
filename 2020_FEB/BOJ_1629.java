package date20200203;

import java.util.Scanner;

public class BOJ_1629 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int p = sc.nextInt();
		
		long tmp = 1;
		
		for(int i=2;i<=n;i++) {
			tmp = tmp *i%p;
			
		}
		
		System.out.println(tmp);

	}

}
