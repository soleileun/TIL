package day10;

import java.util.Scanner;

public class JUNGOL_1810 {
	static int[] src =new int[9];
	static int[] arr = new int[7];
	static boolean[] v =new boolean[9];

	static int calcul(int[] arr) {
		int sum = 0;
		for(int i=0;i<arr.length;i++)
			sum += src[arr[i]];
		return sum;
			
	}
	static void print(int[] arr) {
		for(int i=0;i<arr.length;i++)
			
			System.out.println(src[arr[i]]);
					
		System.out.println();
	}
	
	static void go1(int idx,int before) {
		if(idx == 7) {
			int tmp = calcul(arr);
			if(tmp ==100) {
				print(arr);
				return;
				}
		}else {
			for(int i=before;i<src.length;i++) {
				if(!v[i]) {
					arr[idx] = i;
					v[i] = true;
					go1(idx+1,i);
					v[i] = false;
				}
			}
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<9;i++) {
			src[i] = sc.nextInt();
		}
		go1(0,0);
	}

}
