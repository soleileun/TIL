package date20200217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10972 {

	private static int[] src;

	
	public static void swap(int a, int b) {
		int tmp= src[a];
		src[a] = src[b];
		src[b] =tmp;
		
	}
	
	public static boolean nextPermutation() {
		int i;
		for(i= src.length-2;i>=0;i--) {
			if(src[i] <src[i+1]) break;
		}
		if(i<0) return false;
		int j;
		for(j=src.length-1;j>i;j--)
		{
			if(src[i] <src[j]) break;
		}
		swap(i,j);
		
		for(int a=i+1,b=src.length-1;a<b;a++,b--)
			swap(a,b);
		
		return true;
		
	}
	
	static void print(int[] arr) {
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		src = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			src[i] = Integer.parseInt(st.nextToken());
		}
		
		if(nextPermutation())
		{
			print(src);
		}else {
			System.out.println("-1");
		}

	}

}
