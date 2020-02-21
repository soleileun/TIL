package hyoukang;

import java.util.Scanner;

public class BOJ_2884 {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		if(y -45 <0) {
			y = y+15;
			x--;}
		else {
			y-=45;
		}
		
		if(x<0)
			x+=24;
		
		System.out.println(x +" " +y);
	}

}
