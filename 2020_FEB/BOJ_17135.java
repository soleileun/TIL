package date20200217;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_17135 {

	static int N,M,D;
	static int board[][];
	static int arr[] = new int[3];
	static Point copy[];
	static Queue<Point> q;
	static int max= Integer.MIN_VALUE;
	
	static void print(int[] arr) {
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	
	static void print(Point[] arr) {
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i].x + ", " + arr[i].y + "  / ");
		System.out.println();
	}


	static class Point{
		int x;
		int y;
		boolean death;
		public Point() {}

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
			this.death = false;

		}
	}

	static void go(int idx, int before) {
		if(idx == 3) {
			//System.out.println("현재 궁수의 위치 : ");
//			System.out.print("현재 상태 : ");
//			print(arr);
			//int arrr[] = new int[3];

			Queue<Point> tq = new LinkedList<>();
			int qs = q.size();
			for(int i=0;i<qs;i++) {
				Point pt = q.poll();
				tq.offer(pt); q.offer(pt);
			}
			int death_count = 0;

			while(!tq.isEmpty()) {
				Point[] temp = targeting(arr, tq);
//				print(temp);
				for(int i=0;i<temp.length;i++) {
					if(temp[i].death == true) {
						death_count++;
//						System.out.println(temp[i].x + ", " + temp[i].y+" is dead");
						
						continue;
					}else {
						if((temp[i].x+1)>=N) {
//							System.out.println(temp[i].x + ", " + temp[i].y+" is out");
							continue;
						}
						else
						{

							tq.offer(new Point(temp[i].x+1, temp[i].y));
							continue;
						}
					}
				}
			}
//			System.out.println("몇명죽었나 : " + death_count);
			if(death_count>max)
				max = death_count;
		}else
		{
			for(int i=before;i<M;i++) {
				arr[idx] = i;
				go(idx+1,i+1);
			}
		}
	}


	static Point[] targeting(int arr[], Queue<Point> qq) {
		//int arrr[] = {0,1,3};
		int size = qq.size();
		copy = new Point[size];
		for(int i=0;i<size;i++) {

			Point tmp = qq.poll();
			copy[i] = new Point();
			copy[i] = tmp;
			copy[i].death = false;
		}

		//System.out.print("target: ");
		for(int i=0;i<3;i++) {
			int dist = Integer.MAX_VALUE;
			int target =-1;
			//boolean kill=false;
			for(int j=0;j<copy.length;j++) {
				int tx = (N) - copy[j].x ;
				int ty = arr[i] -copy[j].y;
				if( tx<0 ) tx *= -1;
				if (ty<0 ) ty *= -1;
				int sum = tx+ty;
				if(sum<=D) {
					if(dist>sum) {
						dist = sum;
						target = j;
					}
				}
			}
			if(target == -1) {
				continue;
			}
			//System.out.print(copy[target]+" ");
			copy[target].death = true;
		}
		//System.out.println();
		return copy;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N= sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();
		q = new LinkedList<>();
		board = new int[N][M];
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++) {
				board[i][j] = sc.nextInt();
				
			}
		}
		
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(board[j][i] ==1)
						q.offer(new Point(j,i));
			}
		}

		go(0,0);


		System.out.println(max);

	}

}