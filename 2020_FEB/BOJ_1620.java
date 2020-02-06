package date20200206;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ_1620 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<String, Integer> name = new HashMap<String, Integer>();
		Map<Integer, String> index = new HashMap<Integer, String>();

		Scanner sc=new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		for(int i=1;i<=n;i++)
		{
			String s = sc.next();
			index.put(i, s);
			name.put(s,i);
			
		}
		
		for(int i=0;i<m;i++) {
			String tmp = sc.next();
			if(tmp.charAt(0)-'0' >=0 && tmp.charAt(0)-'0' <=9) { 
			if(Integer.parseInt(tmp)>=0 &&(Integer.parseInt(tmp)<=n)) {
				System.out.println(index.get(Integer.parseInt(tmp)));
			}
			}
			else{
				System.out.println(name.get(tmp));
			}
		}
		
	}

}
