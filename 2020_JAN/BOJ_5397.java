package date20200130;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_5397 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int t=0;t<tc;t++) {
			Stack<Character> left = new Stack<>();
			Stack<Character> right = new Stack<>();
			String s = sc.next();
			int len = s.length();
			
			for(int i=0;i<len;i++) {
				char tmp = s.charAt(i);
				if(tmp == '<') {
					if(left.empty()) // 배열이 비었는지확인
						continue;
					else {
						right.push(left.pop());
					
					}
				}else if(tmp == '>') {
					if(right.empty()) // 배열이 비었는지확인
						continue;
					else {
						left.push(right.pop());
					}
					
				}
				else if(tmp == '-') {
					if(left.empty()) continue;
					else left.pop();
				}else {
					left.push(tmp);
				}
			}
			  for (Character character : left) {
		            sb.append(character);
		        }
		        // 오른쪽 스택의 값 저장
		        while(!right.isEmpty())
		            sb.append(right.pop());
			sb.append("\n");
			
		}
		System.out.println(sb);
	
	}

}
