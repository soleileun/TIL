package date20200130;

import java.awt.Container;
import java.util.ArrayList;
import java.util.Scanner;

public class SWEA_1220 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=10;t++) {
			sb.append("#").append(t).append(" ");
			int pass = sc.nextInt();int cnt =0;
			int[][] board = new int[pass][pass];
			//System.out.println(pass);
			
			for(int i=0;i<pass;i++) {
				for(int j=0;j<pass;j++) {
					board[i][j]=sc.nextInt();
					//System.out.println(cnt++);
				}
			}
			
			//System.out.println("fine");
			// 1.N극 2.S극
			int sum=0;
			for(int i=0;i<pass;i++) {
				ArrayList<Integer> tmp = new ArrayList<>();
				int count =0;
				for(int j=0;j<pass;j++) {
					if(board[j][i] == 0) continue;
					else 
						tmp.add(board[j][i]);
					
				}
				//System.out.println(tmp.toString());
				if(tmp.size() ==1) { 
					sum += count;
					//System.out.println("0이라서 강종");
					continue;}
				
				int target=1;
				for(int k=0;k<tmp.size();k++) {
					boolean s = false;
					if(tmp.get(k) == target) {
						if(target ==1)
							{
							target =2;}
						else
							target =1;
						count++;
						continue;
						}
					else
						continue;
					
				}
				sum += count/2;
				//System.out.println(count/2);
			}
			
			
			sb.append(sum).append("\n");
		}
System.out.println(sb);
	}

}
