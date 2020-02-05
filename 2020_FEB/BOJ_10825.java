package date20200205;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_10825 {

	static class Student{
		String name = null;
		int kor = -1;
		int eng = -1;
		@Override
		public String toString() {
			return "Student [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + "]";
		}
		int math= -1;
	}
	
	static Student[] st; 
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		st = new Student[size];
		
		for(int i=0;i<size;i++) {
			st[i] = new Student();
	
			st[i].name =sc.next();
			st[i].kor = sc.nextInt();
			st[i].eng = sc.nextInt();
			st[i].math = sc.nextInt();
		}
		
		Arrays.sort(st, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				if(o1.kor > o2.kor) return -1;
				else if(o1.kor == o2.kor) {
					if(o1.eng < o2.eng) return -1;
					else if(o1.eng == o2.eng) {
						if(o1.math> o2.math) return -1;
						else if(o1.math == o2.math) {
							return o1.name.compareTo(o2.name);
						}
					}
				}
				return 1;
			}
		});
		
	
		
		for(int i=0;i<st.length;i++) {
			sb.append(st[i].name + "\n");
		}
		System.out.println(sb);
	}

}
