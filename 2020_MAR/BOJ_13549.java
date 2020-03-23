package woxorgkrtmq;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_13549 {

	static class Step{
		int r;
		int step;
		public Step(int r, int step) {
			super();
			this.r = r;
			this.step = step;
		}
		
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		boolean[] visit = new boolean[100007];
		Queue<Step> q = new LinkedList<Step>();
		
		q.offer(new Step(N,0));
		visit[N] = true;
		
		while(!q.isEmpty()) {
			Step tmp = q.poll();
		//	System.out.println(tmp.r +  " " + tmp.step);
			if (tmp.r == K)
			{
				System.out.println(tmp.step);
				return;
			}
			
			if((tmp.r*2) >= 0 && (tmp.r*2) <=100000 ) {
				if(visit[tmp.r*2] == false)
				{
					q.offer(new Step(tmp.r*2,tmp.step));
					visit[tmp.r*2]=true;
				}
			}
			if(tmp.r -1 >= 0 && tmp.r-1 <=100000 ) {
				if(visit[tmp.r-1] == false)
				{
					q.offer(new Step(tmp.r-1,tmp.step+1));
					visit[tmp.r-1]=true;
				}
			}
			
			
			if(tmp.r +1 >= 0 && tmp.r+1 <=100000 ) {
				if(visit[tmp.r+1] == false)
				{
					q.offer(new Step(tmp.r+1,tmp.step+1));
					visit[tmp.r+1]=true;
				}
			}
			
	
		
			
		}
		
		
	}
}
