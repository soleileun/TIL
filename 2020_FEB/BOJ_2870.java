package date20200206;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_2870 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<String> ans = new ArrayList<>();
		int n = sc.nextInt();
		ArrayList<BigInteger> bi = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			String s = sc.next();
			StringBuilder sbb = new StringBuilder();
			
			for(int len =0;len<s.length();len++) {
				char tmp = s.charAt(len);
				if(tmp -'0' >=0 && tmp-'0'<=9) {
					sbb.append(tmp -'0');
				}else {
					if(sbb.length() != 0) {
						StringBuilder how = new StringBuilder();
						boolean flag=false;
						for(int z=0;z<sbb.length();z++) {
							if(sbb.charAt(z) != '0')
								flag = true;
							if(flag)
								how.append(sbb.charAt(z));
						}
						
						sbb=how;
						if(sbb.length() == 0)
							sbb.append(0);
						
						bi.add(new BigInteger(sbb.toString()));
						sbb.delete(0, sbb.length());
					}
				
				}
			}
				if(sbb.length() != 0) {
					StringBuilder how = new StringBuilder();
					boolean flag=false;
					for(int z=0;z<sbb.length();z++) {
						if(sbb.charAt(z) != '0')
							flag = true;
						if(flag)
							how.append(sbb.charAt(z));
					}
					
					sbb=how;
					if(sbb.length() == 0)
						sbb.append(0);
				
				bi.add(new BigInteger(sbb.toString()));
				sbb.delete(0, sbb.length());
				}
				
			
	}
		
	bi.sort(null);
	
	for(int i=0;i<bi.size();i++) {
		System.out.println(bi.get(i));
	}

//		ans.sort(new Comparator<String>() {
//
//			@Override
//			public int compare(String o1, String o2) {
//				if(o1.length() - o2.length() <0) return -1;
//				else if( o1.length() == o2.length()) {
//					
//					if(Integer.parseInt(o1) - Integer.parseInt(o2) <0) return -1;
//					else return 0;
//				}
//				
//				return 0;
//			}
//		});
//		
//		for(int i=0;i<ans.size();i++)
//			System.out.println(ans.get(i));

}
}
