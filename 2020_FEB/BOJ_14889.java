package cheerUp;

import java.util.Scanner;

public class BOJ_14889 {
	
	static int[] arr;
	static int N;
	static int ans = Integer.MAX_VALUE;
	static int score(int[] arr) {
		boolean[] team = new boolean[N];
		for(int i=0;i<arr.length;i++) {
			team[arr[i]] = true;
		}
		int[] bteam = new int[N-arr.length];
		int id=0;
		for(int i=0;i<N;i++) {
			if(team[i] == false)
				bteam[id++] = i; 
		}
		int sum1 =0;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				sum1 +=board[arr[i]][arr[j]];
			}
		}
		int sum2=0;
		for(int i=0;i<bteam.length;i++) {
			for(int j=0;j<bteam.length;j++) {
				sum2 +=board[bteam[i]][bteam[j]];
			}
		}
		int total = sum1-sum2;
		if(total<0) return total*(-1);
		else return total;
	}
	

	static void go(int idx , int target, int before) {
		if(idx == target) {
			//print(arr);
			int tmp = score(arr);
			//System.out.println("점수 차이" + tmp);
			if(tmp <ans)
				ans = tmp;
		}else {
			for(int i=before;i<N;i++) {
				arr[idx] = i;
				go(idx+1, target, i+1);
			}
		}
	}
	
	static int[][] board ;

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		N = sc.nextInt();
		board = new int[N][N+1];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				board[i][j] = sc.nextInt();
			}
		}
		arr = new int[N/2];
		go(0,N/2,0);
		
		System.out.println();
		System.out.println(ans);
	}

}
