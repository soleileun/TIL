package date20200130;

import java.util.Scanner;

public class BOJ_2562 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k=0;
		int max =Integer.MIN_VALUE;
		int max_idx = -1;
		for(int i=1;i<=9;i++)
		{
			int tmp = sc.nextInt();
			if(max<tmp) {
				max = tmp;
				max_idx= i;
			}
		}
		System.out.println(max);
		System.out.println(max_idx);
	}
}
