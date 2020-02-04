package date20200203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;



public class JO_1809{

	public static class Building{
		int index;  // 몇번째 건물인지 
		int height; // 건물 높이는 얼마인지 
		
		public Building(int index, int height) {
			//super();
			this.index = index;
			this.height = height;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		//Scanner sc = new Scanner(System.in);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		 
		int iter = Integer.parseInt(br.readLine());    
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		
		Stack<Building> st = new Stack<>();
		//ArrayList<Integer> ans = new ArrayList<Integer>();
	
		for(int i=1;i<=iter;i++) {
			
			int tmp = Integer.parseInt(stk.nextToken());
			
			if(st.isEmpty()) //스택이 비었다면 처음이거나 신호를 받아줄 건물이 없는 것
				sb.append(0).append(" ");
			else {	// 건물이 하나라도 있다면
				while(!st.empty()) {
				int top = st.peek().height;
				if(tmp<top) {
					sb.append(st.peek().index).append(" "); //건물이 높으면 넣고
					break;
					}
				else {
					st.pop(); //아니면 빼버리고
					if(st.empty()) sb.append(0).append(" "); //빼다가 없으면 0
					
				}
				}
					
			}
			Building b = new Building(i,tmp);
			st.push(b);
			
		}
		br.close();
		System.out.println(sb);
	}

	
}
