package date20200130;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15655 {

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
	
	public static void go(int idx, int[]src, int before) {
		if(idx == m) {
			print(arr);return;
		}
		else {
			for(int i=before;i<src.length;i++) {
				arr[idx] = src[i];
				go(idx+1,src,i+1);
			}
		}
			
		}
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		src = new int[n];
		arr = new int[m];
		//check = new boolean[n];
		
		for(int i=0;i<n;i++)
			src[i] = sc.nextInt();
		
		Arrays.sort(src);
		//System.out.println(Arrays.toString(src));
		
		go(0,src,0);
		System.out.println(sb);
		

	}
}
