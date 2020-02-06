package date20200206;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11502 {

	static ArrayList<Integer> memo;
	static int[] ans = new int[3];
	static int target;
	static boolean flag = false;
	static int getSum(int[] arr) {
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
		}
		return sum;
	}
	
	static void print(int[] arr) {
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	static void dfs(int idx) {
		if(idx == 3) {
			if(!flag) {
			if(getSum(ans) == target) {
				print(ans);
				flag=true;
				return;
				}
			}
			else
				return;
		}
		else {
			if(flag) return;
			for(int i=0;i<memo.size();i++) {
				ans[idx] = memo.get(i);
				dfs(idx+1);
			}
		}
	}
	
	static boolean[] check ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=1001;
		check = new boolean[n];
		check[0] = true;
		check[1] = true;
		memo = new ArrayList<>();
		//ArrayList<Integer> ai= new ArrayList<>();
		for(int i=1;i<n;i++) {
			if(check[i] == false) {
				memo.add(i);
				int tmp = i;
				check[tmp] = true;
				if(i==2||i==3||i==5||i==23) {
					for(int multi=1;multi<=n/i;multi++) {
						check[multi *i] = true;
				}
				}else {
				for(int multi=1;multi<n/i;multi++) {
						check[multi *i] = true;
				}
			}
			
		}else 
			continue;
		}
		
		
		Scanner sc= new Scanner (System.in);
		int tc = sc.nextInt();
		
		for(int i=0;i<tc;i++) {
			target = sc.nextInt();
			dfs(0);
			if(flag == false)
				System.out.println("0");
			flag=false;
		}
		
		

}
}
