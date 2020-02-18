package day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_1780 {

	static int[][] board;
	static int N;
	static boolean[][] visit;
	static int[] ans = new int[3];
	
	static boolean checkBoard(int n,int x, int y) {
		int tmp = board[x][y];
		
		
		for(int i=x;i<x+n;i++) {
			for(int j=y;j<y+n;j++) {
				if(i<0||i>=N||j<0||j>=N) return false;
				if(board[i][j] == tmp) continue;
				else 
					return false;
			}
		}
		ans[tmp+1]++;
		return true;
	}
	
	static void go(int size, int x, int y) {
		boolean flag = checkBoard(size, x, y);
		if(flag) {
			int tmp = board[x][y];
			for(int i=x;i<x+size;i++) {
				for(int j=y;j<y+size;j++) {
					visit[i][j] = true;
				}
			}
			}
		else
			go(size/3, x, y);
	}
	
	static class Point{
		int size;
		int x;
		int y;
		public Point(int size, int x, int y) {
			super();
			this.size = size;
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Point [size=" + size + ", x=" + x + ", y=" + y + "]";
		}
		
		
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		 N = Integer.parseInt(st.nextToken());
		board = new int[N][N];
		visit = new boolean[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Queue<Point> q = new LinkedList<>();
		
		q.offer(new Point(N,0,0));
		
		while(!q.isEmpty()) {
			Point tmp  =q.poll();
			//System.out.print(tmp.toString());
			boolean flag = checkBoard(tmp.size, tmp.x, tmp.y);
			//System.out.println(flag);
			if(flag == false) {
				for(int i=tmp.x;i<tmp.x+tmp.size;i+=tmp.size/3) {
					for(int j=tmp.y;j<tmp.y+tmp.size;j+=tmp.size/3) {
						q.offer(new Point ((tmp.size/3),i,j));
					}
				}
			}
			
		}
		
		
		for(int i=0;i<ans.length;i++) {
			System.out.print(ans[i] + " ");
		}
		
		
	}
}
