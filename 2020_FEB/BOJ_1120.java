package date20200206;

import java.util.Scanner;

public class BOJ_1120 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	Scanner sc = new Scanner(System.in);
	String s1 = sc.next();
	String s2 = sc.next();
	int max =Integer.MIN_VALUE ;
	for(int i=0;i<=s2.length()-s1.length();i++) {
		int count = 0;
		
		for(int j=0;j<s1.length();j++) {
			if(s1.charAt(j) == s2.charAt(i+j))
				count++;
		}
		
		if(max<count)
			max =count;
		
	}
	System.out.println(s1.length()-max);
		
	}

}
