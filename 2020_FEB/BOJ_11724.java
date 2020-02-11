package day10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_11724 {
	
	static boolean[] visited;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		visited = new boolean [N+1];
		ArrayList< ArrayList<Integer>> arr = new ArrayList< ArrayList<Integer>>();
		
		for(int i=0; i<N+1; i++) {
			arr.add(new ArrayList<Integer>());
        }

		for(int i=1;i<=M;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr.get(x).add(y);
			arr.get(y).add(x);
		}
		Queue<Integer> q= new LinkedList<Integer>();
				
		visited[0] = true;
		int count =0;
		for(int i=0;i<visited.length;i++) {
			if(visited[i] == true) continue;
			count++;
			//여기서 탐색하기 ^-^
			q.offer(i);
			while(!q.isEmpty()) {
				int tmp = q.poll();
				
				for(int j=0;j<arr.get(tmp).size();j++) {
					int temp = arr.get(tmp).get(j);
					if(visited[temp] == true) continue;
					
					visited[temp] =true;
					q.offer(temp);
					
					
				}
				
			}
			
		}
		System.out.println(count);
		
	}

}
