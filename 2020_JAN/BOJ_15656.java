package date20200130;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15656 {
	static int n,m;
	static int [] arr;
	static int [] src;
	static boolean [] check;
	static StringBuilder sb = new StringBuilder();
	
	public static void print(int[] a) {
		for(int i=0;i<a.length;i++)
			sb.append(arr[i]).append(" ");
		sb.append("\n");
	}
	
	public static void go(int idx)
	{
		if(idx==m) {
			print(arr);return;
		}
		for(int i=0;i<src.length;i++) {
			arr[idx] = src[i];
			go(idx+1);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		src = new int[n];
		arr = new int[m];
		for(int i=0;i<n;i++)
			src[i] = sc.nextInt();
		
		Arrays.sort(src);
		go(0);
		System.out.println(sb);

	}

}
