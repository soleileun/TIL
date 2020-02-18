package day2;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_2817 {

	static int[] arr;
	static boolean[] v;
	static int N;
	static int min = Integer.MAX_VALUE;
	static Point comp,home;
	static class Point{
		int x;
		int y;
		public Point() {}
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static Point[] map;
	static void go(int idx) {
		if(idx ==N) {
		//	System.out.println(Arrays.toString(arr));
			int sum =0;
			for(int i=0;i<arr.length-1;i++) {
				int tmp =Math.abs(map[arr[i]].x-map[arr[i+1]].x) + Math.abs(map[arr[i]].y-map[arr[i+1]].y) ;
				sum +=tmp;
			}
			int tmp = Math.abs(map[arr[0]].x-comp.x) + Math.abs(map[arr[0]].y-comp.y) ;
			sum +=tmp;
			tmp = Math.abs(map[arr[arr.length-1]].x-home.x) + Math.abs(map[arr[arr.length-1]].y-home.y) ;
			sum +=tmp;
			//System.out.println(sum);
			if(min>sum)
				min = sum;
		}
		else {
			for(int i=0;i<N;i++) {
				if(v[i]==false) {
					v[i]=true;
					arr[idx] = i;
					go(idx+1);
					v[i] = false;
				}
			}
		}
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		StringBuilder sb=new StringBuilder();
		
		
		for(int t=1;t<=tc;t++) {
		sb.append("#").append(t).append(" ");
		min = Integer.MAX_VALUE;
		N= sc.nextInt();
		arr = new int[N];
		v = new boolean[N];
		map = new Point[N];
		comp = new Point(sc.nextInt(), sc.nextInt());
		home = new Point(sc.nextInt(), sc.nextInt());		
		for(int i=0;i<N;i++) {
			map[i] = new Point();
			map[i].x = sc.nextInt();
			map[i].y =sc.nextInt();
		}
		
		
		go(0);
		
		
		sb.append(min).append("\n");
		
		}
		System.out.println(sb);
	}

}
