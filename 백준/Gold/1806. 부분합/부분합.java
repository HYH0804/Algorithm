import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main". 
class Main {
    public static void main(String[] args) throws Exception {
        /*
        start ~ end 까지 더해서
        S>부분합
        끝

        S<부분합
        저장 
        start--
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        long S = Long.parseLong(st.nextToken());
        st= new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int start=0;
        int end = 0;
        int len =Integer.MAX_VALUE;
        long sum=sum(start,end,arr);
        while(end<arr.length && start<=end){
            if(sum>=S){
                int l=end-start+1;
                if(len>l){
                    len=l;
                }
                sum-=arr[start++];
            }
            else if(sum<S){
                if(end<arr.length-1){
                    sum+=arr[++end];
                }
                else{
                    end++;
                }
            }
            else{ //sum>S && start==end
                len=1;
                break;
            }
        }
        System.out.printf("%d", len==Integer.MAX_VALUE?0:len );
    }
    public static long sum(int start, int end,int arr[]){
        long sum=0;
        if(start!=end){
            for(int i=start; i<=end; i++){ 
            sum+=arr[i];
            }
        }
        else{
            sum=arr[start];
        }
        return sum;
    }
}