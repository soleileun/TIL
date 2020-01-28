
/**************************************************************
    Problem: 1169
    User: raemong21
    Language: Java
    Result: Success
    Time:381 ms
    Memory:20068 kb
****************************************************************/
 
import java.util.Scanner;
 
public class Main {
    static int n;
    static int[] dices;
    static boolean[] v;
    public static void print(int[] arr) {
        for(int i=0;i<dices.length;i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
     
    public static void game1(int idx) {
        if(idx==n) {
            print(dices);
            return ;
        }
         
        for(int i=1;i<=6;i++) {
            dices[idx] = i;
            game1(idx + 1);
        }
             
    }
     
    public static void game2(int idx,int before) {
        if(idx == n) {
            print(dices);
            return ;
        }
        for(int i=before; i<=6 ; i++) {
            dices[idx] =i;
            game2(idx+1, i);
        }
    }
     
    public static void game3(int idx, boolean[] visit) {
        if(idx == n) {
            print(dices);
            return ;
        }
         
        for(int i=1;i<=6;i++) {
            if(!visit[i])
            {   
                visit[i] = true;
                dices[idx] = i;
                game3(idx+1, visit);
                visit[i] = false;
            }
             
             
        }
         
    }
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
 
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dices = new int[n];
        int m = sc.nextInt();
         
         
        switch (m) {
        case 1:
            game1(0);
            break;
 
 
        case 2:     
            game2(0,1);
            break;
             
        case 3:
            game3(0, new boolean [7]);
            break;
        default:
            break;
        }
         
         
    }
 
}
