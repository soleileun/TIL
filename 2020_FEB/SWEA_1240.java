package date20200217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


public class SWEA_1240 {

	static int[] board;
	static boolean fini =false;
	static int return_number(String s) {
		int n=-1;
		switch (s) {
	    case "0001101":  n=0;
	             break;
	    case "0011001":  n = 1;
	             break;
	    case "0010011":  n = 2;
	             break;
	    case "0111101":  n = 3;
	             break;
	    case "0100011":  n = 4;
	             break;
	    case "0110001":  n = 5;
	             break;
	    case "0101111":  n = 6;
	             break;
	    case "0111011":  n = 7;
	             break;
	    case "0110111":  n = 8;
	             break;
	    case "0001011": n = 9;
	             break;
	}
		return n;
		
	}
	
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb= new StringBuilder();
		//BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		//int N = Integer.parseInt(st.nextToken());
		//int  M = Integer.parseInt(st.nextToken());
		
		Scanner sc=new Scanner(System.in);
		int TC = sc.nextInt();
		for(int T=1;T<=TC;T++) {
		sb.append("#").append(T).append(" ");
		int N=sc.nextInt();
		int M = sc.nextInt();
		
				
		String ss= new String();
		//st = new StringTokenizer(br.readLine(), "");
		for(int t=0;t<N;t++) {
			String ang = sc.next();
		//	String s = st.toString();
			boolean f =false;
			for(int i=0;i<ang.length();i++) {
				int tmp = ang.charAt(i) - '0';
				if(tmp == 1) {
					f =true;ss=ang;
					//System.out.println(ss);
					}
				if(f) break;
			}
			if(f) continue;
		}
			
		int strlen = ss.length();
		//System.out.println(strlen);

		int idx = -1;
		for(int i=strlen-1;i>=0;i--) {
			int temp = ss.charAt(i)-'0';
			if(temp == 1) {
				idx = i;
				break;
			}
		}
		
		//System.out.println(idx); //59
		idx ++;
		board = new int[8];
		for(int i=0;i<8;i++) {
			//System.out.println(ss.substring(idx-7, idx));
			board[7-i] = return_number(ss.substring(idx-7, idx));
			//System.out.println(board[7-i]);
			idx -= 7;
		}

		int sum1=0; int sum2=0;
		for(int i=0;i<7;i++) {
			if(i%2==0)
				sum1+=board[i];
			else
				sum2+=board[i];
		}
		int tsum = sum1*3 +sum2+board[7];
		int total =0;
		if(tsum %10 ==0) {
			for(int i=0;i<board.length;i++)
				total +=board[i];
		}
			
		
		sb.append(total).append("\n");
		
		}
		
			System.out.println(sb);
		
	}
		
	}


