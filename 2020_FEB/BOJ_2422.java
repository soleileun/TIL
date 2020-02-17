package cheerUp;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2422 {
	static int N,M;
	static int[]arr = new int[3];
	static int[][] board;
	static int ans = 0;
	
	public static boolean check() {
		int len = arr.length;
		for(int i=0;i<len;i++) {
			for(int j=0;j<len;j++) {
				if(board[arr[i]][arr[j]] == 1)
					return false;
			}
		}
		return true;
	}
	
	public static void go(int idx, int before) {
		if(idx == 3) {
			//System.out.println(Arrays.toString(arr));
			
			boolean flag = check();
			if(flag) {
				//System.out.println(Arrays.toString(arr));
				ans++;
				return ;
				}else
					return;
			
		}else {
			for(int i=before;i<=N;i++) {
				arr[idx] = i;
				go(idx+1, i+1);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		board = new int[202][202];
		for(int i=0;i<M;i++) {
		int x =sc.nextInt();
		int y = sc.nextInt();
		board[x][y] =1;
		board[y][x] =1;
		}
		go(0,1);
		System.out.println(ans);
				
	}

}
