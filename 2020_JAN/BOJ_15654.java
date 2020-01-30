package date20200130;

import java.util.Arrays;
import java.util.Scanner;

	

public class BOJ_15654 {
	
	static int n,m;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	static boolean[] check;
	
	public static void print(int[] arr1) {
		for(int i=0;i<arr1.length;i++)
			sb.append(arr1[i]).append(" ");
		sb.append("\n");
	}
	
	public static void go(int idx, int[] s) {
		if(idx == m) {
			print(arr); return;
		}else {
			for(int i=0;i<s.length;i++) {
				if(check[i] == false) {
					arr[idx] = s[i];
					check[i] = true;
					go(idx+1, s);
					check[i] = false;
				
				}
				}
		}
			
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[m];
		int[] src = new int [n];
		check =new boolean [n];
		for(int i=0;i<n;i++)
			src[i] = sc.nextInt();
	
		Arrays.sort(src);
		//System.out.println(Arrays.toString(src));
		go(0,src);
		System.out.println(sb);
		
		
		
		
	}

}
