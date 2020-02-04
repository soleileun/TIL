package date20200203;


import java.util.Scanner;
import java.util.Stack;

public class BOJ_1252 {


	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		StringBuilder sb = new StringBuilder();
		
		Stack<Character> st1 = new Stack<>();
		Stack<Character> st2 = new Stack<>();
		Stack<Integer> ans = new Stack<>();
		
		for(int i=0;i<s1.length();i++) {
			st1.push(s1.charAt(i));
		}
		
		for(int i=0;i<s2.length();i++) {
			st2.push(s2.charAt(i));
		}
		
		int z=0;
		while(true) {
			int x =0;int y=0;
			//if(st1.empty() && st2.empty()) break;
			if(st1.empty() && !st2.empty())
				{x=0;y = st2.pop()-'0';}
			else if(st2.empty()&& !st1.empty())
				{y=0;x = st1.pop()-'0';}
			else if(st1.empty() && st2.empty()) break;
			else 
			{
			x = st1.pop()-'0';
			y = st2.pop()-'0';
			}
			int tmp  =x+y+z;
			if(tmp == 0 || tmp == 1) {
				ans.push(tmp);
				z=0;
				}
			else if(tmp ==2) {
				ans.push(0);
				z=1;
			}
			else if(tmp ==3) {
				ans.push(1);
				z=1;
			}
			if(st1.empty() && st2.empty()) break;
			
		}
		
		if(z==1)
			ans.push(1);
		

		while(!ans.empty())
			sb.append(ans.pop());
			
	
		
		StringBuilder sbb = new StringBuilder();
		boolean flag = false;
		for(int i=0;i<sb.length();i++) {
			if((sb.charAt(i) == '1') )
					flag = true;
			if(flag)
				sbb.append(sb.charAt(i));
			else
				continue;
			}
		
		if(sbb.length() == 0)
			System.out.println("0");
		else
			System.out.println(sbb);
		
	}

}

