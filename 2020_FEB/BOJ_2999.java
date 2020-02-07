package date20200206;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_2999 {
	
	static char[][] ch ;

	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		int len = s.length();
		
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i=1;i<=len;i++) {
			if(len%i == 0)
				arr.add(i);
		}
		//System.out.println(arr); 

		int max = Integer.MIN_VALUE;
		for(int i=0;i<arr.size();i++) {
			int c = len/arr.get(i);
			int r = arr.get(i);
			//System.out.println(r + " , " +c);
			if(r<=c)
			{
				if(r>max)
					max=r;
			}
		}
		
		int r= max;
		int c = len/r;
		ch = new char[r][c];
		
		int count=0;
		for(int i=0;i<c;i++) {
			for(int j=0;j<r;j++) {
				ch[j][i] = s.charAt(count++);
			}
		}
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				sb.append(ch[i][j]);
			}
		}
	
		System.out.println(sb);
		
		
		
	}

}
