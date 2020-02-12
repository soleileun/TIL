package cheerUp;

import java.util.Scanner;

public class BOJ_11328 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc =new Scanner(System.in);
		int N = sc. nextInt();
		
		for(int i=0;i<N;i++) {
			String org = sc.next();
			String comp = sc.next();
			int[] o = new int[28];
			int[] c = new int[28];
			for(int j=0;j<org.length();j++) {
				o[org.charAt(j)-'a']++;
			}
			for(int j=0;j<comp.length();j++) {
				c[comp.charAt(j)-'a']++;
			}
			boolean f =true;
			for(int j=0;j<28;j++) {
				if(c[j] == o[j])
					continue;
				else
				{
					f=false;
					break;
				}
				
				
			}
			if(f)
				System.out.println("Possible");
			else
				System.out.println("Impossible");
	
			
			
		}
			
			
	}

}
