package coffeontheplan;

import java.util.Scanner;

public class BOJ_10809 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int[] board = new int[26];
		for(int i=0;i<26;i++)
			board[i] = -1;
		
		for(int i=0;i<s.length();i++) {
			char tmp = s.charAt(i);
			if(board[tmp -'a'] == -1)
				board[tmp-'a'] =i;
			else
				continue;
		}
		
		
		for(int i=0;i<26;i++)
			System.out.print(board[i] + " ");
		
	}

}
