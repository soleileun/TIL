package cheerUp;

import java.util.Scanner;

public class BOJ_17286 {

	static boolean[] visit = new boolean[4] ;
	static int[] arr = new int[4];
	static int min = Integer.MAX_VALUE;
	
	static class Point {
		int x;
		int y;
	}
	
	static Point[] board ;
	static double calcul(int[] arr) {
		double sum =0;
	
		for(int i=1;i<=3;i++) {
			sum += Math.sqrt((board[arr[i]].x-board[arr[i-1]].x)*(board[arr[i]].x-board[arr[i-1]].x) 
					+(board[arr[i]].y-board[arr[i-1]].y) * (board[arr[i]].y-board[arr[i-1]].y));
		}
		return sum;
	}
	
	static void go(int idx) {
		if(idx == 4) {
		//	System.out.println(arr[0] + " " + arr[1] + " " +arr[2] + " " + arr[3]);
			
			int tmp = (int)calcul(arr);
		//	System.out.println(tmp);
			if(tmp <min)
				min = tmp;
		}else {
			for(int i=1;i<=3;i++) {
				if(!visit[i-1]) {
					visit[i-1] = true;
					arr[idx] = i;
					go(idx+1);
					visit[i-1] =false;
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		board =new Point[4];
		for(int i=0;i<board.length;i++) {
			board[i] = new Point();
			board[i].x = sc.nextInt();
			board[i].y = sc.nextInt();
		}
		
		
		//visit[0] = true;
		arr[0] = 0;
		go(1);
		
		System.out.println(min);
	}

}
