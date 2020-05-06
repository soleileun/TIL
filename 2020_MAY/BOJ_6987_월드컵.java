import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6987_월드컵 {

	static int[] game1 = {1,1,1,1,1,2,2,2,2,3,3,3,4,4,5};
	static int[] game2 = {2,3,4,5,6,3,4,5,6,4,5,6,5,6,6};
	static int[] win =  new int[7];
	static int[] draw =  new int[7];
	static int[] lose =  new int[7];
	static boolean check;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int j=0;j<4;j++) {
			st =  new StringTokenizer(br.readLine());
			int total_win =0, total_draw =0, total_lose =0;
			check = false;
			for(int i=1;i<=6;i++) {
			win[i] = Integer.parseInt(st.nextToken());
			draw[i] = Integer.parseInt(st.nextToken());
			lose[i] = Integer.parseInt(st.nextToken());
			total_win += win[i]; total_draw += draw[i]; total_lose += lose[i];
			}
			
			if(total_draw + total_win + total_lose != 30) {
				check = false;
			}else {
				play(0);
			}
			if(check)
				sb.append("1");
			else
				sb.append("0");
			
			sb.append(" ");
		}
		System.out.println(sb);
	}

	private static void play(int turn) {
		if(check) return;
	
		if(turn == 15) {
			check = true;
			return;
		}
	
		int team1 = game1[turn];
		int team2 = game2[turn];
		
		if(win[team1] > 0 && lose[team2] >0) {
			win[team1]--; lose[team2]--;
			play(turn+1);
			win[team1]++; lose[team2]++;
		}
		
		if(draw[team1] >0 && draw[team2]>0) {
			draw[team1]--; draw[team2]--;
			play(turn+1);
			draw[team1]++; draw[team2]++;
		}
		
		if(lose[team1] > 0 && win[team2] >0) {
			lose[team1]--; win[team2]--;
			play(turn+1);
			lose[team1]++; win[team2]++;
		}
		
	}

}
