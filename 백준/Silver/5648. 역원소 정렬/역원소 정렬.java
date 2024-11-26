import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n= Integer.parseInt(st.nextToken());
        long[] arr = new long[n];
        long[] newArr = new long[n];
        int count =0;
        while(count<n){
            while(st.hasMoreTokens()){
                String temp ="";
                String k = st.nextToken();
                for(int i=k.length()-1; i>=0; i--){
                    temp+=k.charAt(i);
                }
                newArr[count++]=Long.parseLong(temp);
            }
            if(count>=n){
                break;
            }
            st=new StringTokenizer(br.readLine());
        }
        Arrays.sort(newArr);
        for(int i=0; i<n; i++){
            System.out.printf("%d\n",newArr[i]);
        }

        
    }
}