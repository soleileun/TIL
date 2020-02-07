package date20200206;

import java.util.Scanner;

public class SWEA_5603 {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t=1;t<=tc;t++){
		sb.append("#").append(t).append(" ");
		int n = sc.nextInt();
		int[] arr = new int[n];
		int sum=0;
		for(int i=0;i<n;i++) {
			arr[i] =sc.nextInt();
			sum +=arr[i];
		}
		int av = sum/n;
		int total =0;
		for(int i=0;i<n;i++) {
			if(arr[i] >= av) {
				total += arr[i]-av;
			}
		}
		sb.append(total).append("\n");
		}
		System.out.println(sb);
	}
}
