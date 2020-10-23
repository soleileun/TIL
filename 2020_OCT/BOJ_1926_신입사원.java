
import java.util.Scanner;
import java.util.ArrayList;
public class BOJ_1926_신입사원 {
	
	static class Person implements Comparable<Person>{
		int x;
		int y;
		public Person(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Person o) {
			return this.x-o.x;
		}

	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int t=0;t<T;t++) {
			int num = sc.nextInt();
			ArrayList<Person> arr = new ArrayList<>();
			for(int n=0;n<num;n++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				arr.add(new Person(x,y));
			}
			arr.sort(null);
			
		
			int cnt =0;
			int min = 987654321;
			for(int i=0;i<arr.size();i++) {
				Person temp = arr.get(i);
				if(temp.y < min) {
					cnt++;
					min = temp.y;
				}
			}
			sb.append(cnt).append("\n");
			
		}
		System.out.println(sb);
	}

}
