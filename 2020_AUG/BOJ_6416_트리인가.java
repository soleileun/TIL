import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_6416_트리인가 {
	static int max =-1;
	static int unit[];
	static boolean check[];
	
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	static int find(int x) {
		if(x == unit[x]) return x;
		else return unit[x] = find(unit[x]);
			
	}
	static boolean union(int x,int y) {
		x = find(x);
		y = find(y);
		if(x == y) return true;
		else return false;
		
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Point> input = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		int tc = 1;
	
		while(true) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			if(x < 0 && y<0) {
				System.out.println(sb);break;
			}
			if(max < x)	max = x;
			if(max < y)	max = y;
			
			if(x == 0 && y == 0) {
				int root = -1;
				boolean flag = false;
				unit = new int[max+1];
				check = new boolean[max+1];
				if(input.size() <1) {
				sb.append("Case ").append(tc++).append(" is a tree.").append("\n");
				input.clear();	max=-1;
				continue;
				}
				if(input.size() == 1) {
					if(input.get(0).x == input.get(0).y) {
						sb.append("Case ").append(tc++).append(" is not a tree.").append("\n");
					}else {
					sb.append("Case ").append(tc++).append(" is a tree.").append("\n");}
					input.clear();	max=-1;
					continue;
				}
				for(int i=1;i<unit.length;i++) { 	
					unit[i] =i;
				}
				for(int i=0;i<input.size();i++) {
					Point tmp = input.get(i);
					check[tmp.x] = true;check[tmp.y]=true;
					if(unit[tmp.y] == tmp.y)
					{
						if(tmp.y == find(tmp.x)) {
							sb.append("Case ").append(tc++).append(" is not a tree.").append("\n");
							flag =true;input.clear();max =-1;		
							break;
						}
						unit[tmp.y] = find(tmp.x);
						
					}
					else {
						sb.append("Case ").append(tc++).append(" is not a tree.").append("\n");
						flag =true;input.clear();max =-1;		
						break;
					}
				}
				if(!flag) {
					for(int i=0;i<unit.length;i++) {
						unit[i] = find(unit[i]);
					}

					for(int i=1;i<unit.length;i++) {
						if(!check[i])continue;
						if(root == -1) root=unit[i];
						if(root != unit[i]) {
							sb.append("Case ").append(tc++).append(" is not a tree.").append("\n");
							flag =true;input.clear();		max=-1;
							break;	
						}
					}
				for(int i=0;i<input.size();i++) {
					if(union(input.get(i).x, input.get(i).y))
						continue;
					else {
						sb.append("Case ").append(tc++).append(" is not a tree.").append("\n");
						flag =true;input.clear();		max=-1;
						break;				
					}
				}
				if(flag) continue;
				sb.append("Case ").append(tc++).append(" is a tree.").append("\n");
				input.clear();	max=-1;
				}
			}
			else
				input.add(new Point(x,y));
		}
	}
}
