package date20200130;

import java.util.Scanner;

public class BOJ_2920 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[8];
		
		boolean a_flag = true;
		boolean d_flag = true;
		boolean m_flag = false;

		for(int i=0;i<8;i++) {
			arr[i] = sc.nextInt();
		}

		for(int i=0;i<8;i++) {
			if(i+1 == arr[i])
				continue;
			else {
				a_flag = false;
				m_flag = true;
				break;
				
			}
		}
		
		for(int i=0;i<8;i++) {
			if(8-i == arr[i])
				continue;
			else {
				d_flag = false;
				if(a_flag) break;
				else {
					m_flag = true;
				break;}
				
			}
		}
		
		if(d_flag)
			m_flag = false;

		if(a_flag) System.out.println("ascending");
		if(d_flag) System.out.println("descending");
		if(m_flag) System.out.println("mixed ");
		
			}
	
}
