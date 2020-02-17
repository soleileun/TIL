package cheerUp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2606 {

	static boolean[] visit;
	static ArrayList<ArrayList<Integer>> arr ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		visit = new boolean[N+1];
		arr =  new ArrayList<ArrayList<Integer>>();

		for(int i=0;i<N+1;i++) {
			arr.add(new ArrayList<>());
		}
		
		for(int i=0;i<M;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr.get(x).add(y);
			arr.get(y).add(x);
		}
		
		Queue<Integer> q= new LinkedList<Integer>();
		
		q.offer(1);
		while(!q.isEmpty()) {
			int tmp = q.poll();
			visit[tmp] = true;
			for(int i=0;i<arr.get(tmp).size();i++) {
				if(visit[arr.get(tmp).get(i)] == false)
				q.offer(arr.get(tmp).get(i));
			}
			
		}
		int sum =0;
		for(int i=0;i<visit.length;i++) {
			if(visit[i] == true)
				sum ++;
		}
		
		System.out.println(sum-1);
		
		
		
	}

}
