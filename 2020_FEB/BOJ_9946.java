package swea_prob;

import java.util.Scanner;

public class BOJ_9946 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int count =1;
		while(true) {
			String s = sc.next();
			int [] alpha1 = new int[28];
			int [] alpha2 = new int[28];
			if(s.equals("END")) {
				//System.out.println("END");
				return;
				}
			else
			{
				
				for(int i=0;i<s.length();i++) {
					alpha1[s.charAt(i)-'a']++;
				}
				String ss = sc.next();
				for(int i=0;i<ss.length();i++) {
					alpha2[ss.charAt(i)-'a'] ++;
				}
				boolean f = true;
				for(int i=0;i<alpha1.length;i++) {
					if(alpha1[i] == alpha2[i])
						continue;
					else {
						f=false;
						break;
					}
				}
				
				if(f)
					System.out.println("Case " +count++ + ": same");
				else
					System.out.println("Case " +count++ + ": different");
			}
		}
		
		

	}

}
