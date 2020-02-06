package date20200206;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_1929 {
	
	static ArrayList<Integer> memo;
	static int[] ans = new int[3];
	static int target;
	static boolean flag = false;
	static boolean[] check ;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n=1000007;
		check = new boolean[n];
		check[0] = true;
		check[1] = true;
		//check[1000] = true;
		int N = sc.nextInt();
		int M = sc.nextInt();
		memo = new ArrayList<>();
		//ArrayList<Integer> ai= new ArrayList<>();
		for(int i=1;i<n;i++) {
			if(check[i] == false) {
				memo.add(i);
				int tmp = i;
				check[tmp] = true;
				
				int mt = 1;
				int cnt = 1;
				while(true) {
					mt = cnt*i;
					if(mt >=n) break;
					if(check[mt] == false)
						check[mt] = true;
					mt = (i*cnt++) ;
							}
			
		}else 
			continue;
		}
		
		for(int i=0;i<memo.size();i++) {
			int tmp = memo.get(i);
			if(tmp >= N && tmp <=M)
				System.out.println(tmp);
			
		}
		

	}

}
