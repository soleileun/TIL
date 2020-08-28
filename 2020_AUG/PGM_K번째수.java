import java.util.Arrays;

public class K¹øÂ°¼ö {
public static void main(String[] args) {
	int[] arr = {1,5,2,6,3,7,4};
	int[][] cmd= {{2,5,3},{4,4,1},{1,7,3}};
	int[] ans = new int[cmd.length];
	for(int i=0;i<cmd.length;i++) {
		int[] tmp = Arrays.copyOfRange(arr, cmd[i][0]-1, cmd[i][1]);
		Arrays.sort(tmp);
		ans[i] = tmp[cmd[i][2]-1];
		
	}
System.out.println(Arrays.toString(ans));

}
}
