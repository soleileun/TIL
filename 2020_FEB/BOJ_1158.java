package day9;

//import java.util.ArrayList;
import java.util.LinkedList;
//import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1158 {
	
	static Queue<Integer> solders = new LinkedList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int P = sc.nextInt();
		for(int i=1;i<=P;i++)
			solders.offer(i);
		StringBuilder sb = new StringBuilder();
		
		//System.out.println(solders);
		int k=sc.nextInt();
		//int start = 2;
		
		for(int i=0;i<k-1;i++)
			solders.offer(solders.poll());
	sb.append("<");
		while(solders.size() >0) {
			int tmp = solders.poll();
			sb.append(tmp);
			if(solders.size() !=0) sb.append(", ");
			if(solders.size() == 0) break;
			for(int i=0;i<k-1;i++)
				solders.offer(solders.poll());
			//solders.offer(solders.poll());
			
			
			}
		
//		while(!solders.isEmpty()) {
//			int tmp = solders.poll();
//			System.out.println(tmp);
//			sb.append(solders.poll()).append(" ");
//		}
		sb.append(">");
	System.out.println(sb);	
	}

}
