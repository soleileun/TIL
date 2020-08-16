import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11724_연결요소의개수 {
	static int N,M;
	static boolean[] visit;
	static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<ArrayList<Integer>>();
public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	N = Integer.parseInt(st.nextToken());
	M = Integer.parseInt(st.nextToken());
	
	for(int i=0;i<N;i++) {
		arrayList.add(new ArrayList<Integer>());
	}
	
	for(int i=0;i<M;i++) {
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken())-1;
		int y = Integer.parseInt(st.nextToken())-1;
		arrayList.get(x).add(y);
		arrayList.get(y).add(x);
	}
	
	Queue<Integer> q = new LinkedList<Integer>();
		
	visit = new boolean[N];
	boolean flag = false;
int cnt=0;
	while(true) {
		for(int i=0;i<visit.length;i++) {
			if(visit[i]== false ) {
				q.add(i);
				visit[i] = true;
				break;
			}
			if(i == visit.length-1)flag=true;
		}
		if(flag) break;
	while(!q.isEmpty()) {
		int tmp = q.poll();
		for(int i=0;i<arrayList.get(tmp).size();i++) {
			if(!visit[arrayList.get(tmp).get(i)]) {
				q.add(arrayList.get(tmp).get(i));
				visit[arrayList.get(tmp).get(i)] =true;
			}
		}
	}
	cnt ++;
	}
	
	
	System.out.println(cnt);
	
}
}
