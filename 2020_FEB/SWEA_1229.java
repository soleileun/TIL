package day9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SWEA_1229 {

	
	public static void main(String[] args) {
	StringBuilder sb = new StringBuilder();
	Scanner sc = new Scanner(System.in);
	
	
	for(int t=1;t<=10;t++) {
		sb.append("#").append(t).append(" ");
		
		List<Integer> list = new ArrayList<Integer>();	
		int len = sc.nextInt();
		
		for(int i=0;i<len;i++) 
			list.add(sc.nextInt());
			
		int commend = sc.nextInt();
		
		for(int c =0; c<commend;c++) {
			String tmp = sc.next();
			if(tmp.equals("I")) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				List<Integer> t1 = new ArrayList<>();
				for(int iter=0;iter<y;iter++)
				{
					int z =sc.nextInt();
					list.add(x+iter, z);
				}
				//list.addAll(x, t1);
				
				
				
			}else if(tmp.equals("D")) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				for(int iter=0;iter<y;iter++)
					list.remove(x);
						
			}
			
		}
		
		for(int n=0;n<10;n++)
			sb.append(list.get(n)).append(" ");
			
			
		sb.append("\n");	
		}
	System.out.println(sb);
	}

}
