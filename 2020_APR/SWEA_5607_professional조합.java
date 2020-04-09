package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5607_professional조합 {
   private static final int mod = 1234567891;
   public static void main(String[] args) throws NumberFormatException, IOException {
      // TODO Auto-generated method stub
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      int T = Integer.parseInt(br.readLine());
      long arr[] = new long [1000001];
      arr[0] = 1;
      for(int i=1;i<1000001;i++) {
         arr[i] = (arr[i-1] * i )%mod;
      }
      for(int tc=1;tc<=T;tc++) {
         st = new StringTokenizer(br.readLine());
         int n = Integer.parseInt(st.nextToken());
         int r = Integer.parseInt(st.nextToken());
         long temp = (arr[n-r] * arr[r])%mod;

         long p = pow(temp,mod-2);
         long result = (arr[n]*p)%mod;
         System.out.println("#"+tc+" "+result);
      }
   }
   public static long pow(long a,int b) {
        if(b==0) {
            return 1;
        }
        else if(b%2==1) {
            long temp = pow(a,b/2);
            temp = (temp*temp)%mod;
            temp = (temp*a)%mod;
            return temp;
        }
        else {
            long temp = pow(a,b/2);
            temp = (temp*temp)%mod;
            return temp;
        }
    }
}