import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
         
        for(int t=1;t<=10;t++) {
            int skip = sc.nextInt();
            sb.append("#").append(skip).append(" ");
            int[][] board = new int[100][100];
             
            for(int i=0;i<100;i++) {
                for(int j=0;j<100;j++) {
                    board[i][j] = sc.nextInt();
                }
            }
            //가로합 최대구하기
            int max =Integer.MIN_VALUE;
            for(int i=0;i<100;i++) {
                int sum=0;
                 
                for(int j=0;j<100;j++) {
                    sum +=board[i][j];
                }
         
                if(max<sum)
                    max= sum;
            }
            //세로합 최대구하기 
             
            for(int i=0;i<100;i++) {
                int sum=0;
                 
                for(int j=0;j<100;j++) {
                    sum +=board[j][i];
                }
                //int tmp = sum/100;
                if(max<sum)
                    max= sum;
            }
            int sum=0;
            int i=0; int j=0;
            // 대각선 오른쪽
            while(true) {
                 
                sum += board[i][j];
                i++;j++;
                if(j==100) break;
            }
            //int tmp = sum/100;
            if(max<sum)
                max= sum;
             
            //대각선 왼쪽 
            sum =0; i=0;j =99;
            while(true) {
                 
                sum += board[i][j];
                i++;j--;
                if(j<0) break;
            }
            //tmp = sum/100;
            if(max<sum)
                max= sum;
             
             
            sb.append(max).append("\n");
        }
         
        System.out.println(sb);
    }
 
}
