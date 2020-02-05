package cheerUp;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_11179 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long original = sc.nextInt();
		long sum = 0;
		long i = 1;
		Stack<Integer> st = new Stack<>();
		
		
		while(original>0) {
			st.push((int) (original%2));
			original /=2;
		}
		
		while(!st.empty()) {
			int tmp = st.pop();
			tmp *= i;
			i *=2;
			sum +=tmp;
			original /=2;
		}
		System.out.println(sum);
		
		
	}
}
