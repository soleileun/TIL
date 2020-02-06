package cheerUp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


public class BOJ_1920 {
	static ArrayList<Integer> ans = new ArrayList<Integer>();
	static ArrayList<Integer> ans2 =new ArrayList<Integer>();
	static int n,m,start;
	static ArrayList<ArrayList<Integer>> map;
	static boolean[] visit;
	
	static Queue<Integer> q = new LinkedList<Integer>();
	static Stack<Integer> st = new Stack<Integer>();
	
	static void dfs(int idx, int now) {
	 
			for(int i=0;i<map.get(now).size();i++) {
				if(visit[map.get(now).get(i)] == false)
				{
					visit[map.get(now).get(i)]=true;
					ans.add(map.get(now).get(i));
					dfs(idx+1,map.get(now).get(i));
				}
			}
		}
	

	
	static void bfs(int start) {
		int idx =0;
		q.offer(start);
		visit[start] = true;
		
		while(!q.isEmpty()) {
			int tmp = q.peek();q.poll();
			ans2.add(tmp);
			for(int i=0;i<map.get(tmp).size();i++) {
				if(visit[map.get(tmp).get(i)] ==false) {
					visit[map.get(tmp).get(i)]=true;
					q.offer(map.get(tmp).get(i));
				}
			}
			
		}
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		start = sc.nextInt();
		//int[][] map = new int[n+1][n+1];
		visit = new boolean[n+1];
		//ans = new int[n];
		map = new ArrayList<ArrayList<Integer>>();
		
		 for(int i=0; i<n+1; i++) {
	            map.add(new ArrayList<Integer>());
	        }
		 
		 

		for(int i=0;i<m;i++) {
			int x=sc.nextInt();
			int y = sc.nextInt();
			map.get(x).add(y);
			map.get(y).add(x);	
		}
		
		for(int i=0;i<map.size();i++)
			map.get(i).sort(null);
		//map 구성완료
		visit[start] = true;
		ans.add(start);
		dfs(1,start);
		for(int i=0;i<ans.size();i++)
			System.out.print(ans.get(i)+" ");
		System.out.println();
		for(int i=0;i<ans.size();i++)
			visit[ans.get(i)] = false;
		
		bfs(start);
		for(int i=0;i<ans2.size();i++){
			System.out.print(ans2.get(i) +" ");
		}
		
		
	}

}
