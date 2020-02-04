package day7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1225 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner sc = new Scanner (System.in);
		StringBuilder sb = new StringBuilder();
		
		for(int t=1;t<=10;t++) {
			
		sb.append("#").append(t).append(" ");
		int n = sc.nextInt();
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=0;i<8;i++) {
		 int tmp = sc.nextInt();
		 q.offer(tmp);
		}
		int minus =1;

		while(true) {
			int tmp= q.poll();
			if(tmp - minus <= 0){
				tmp =0;
				
				}
			else
				tmp -= minus++;
			
			if(minus ==6)
				minus = 1;
			
			q.offer(tmp);
			if (tmp==0) break;
		}
		
		while(!q.isEmpty())
			sb.append(q.poll()).append(" ");
		
		
		sb.append("\n");		
		}

		System.out.println(sb);

}
}
