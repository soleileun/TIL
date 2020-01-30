package date20200130;

import java.util.Scanner;

public class BOJ_2675 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=tc;t++) {
			int tmp = sc.nextInt();
			String s = sc.next();
			
			for(int i=0;i<s.length();i++) {
				for(int j=0;j<tmp;j++)
					sb.append(s.charAt(i));
			}
			sb.append("\n");
		}
System.out.println(sb);
	}

}
