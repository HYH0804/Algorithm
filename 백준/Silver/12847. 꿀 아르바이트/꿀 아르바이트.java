import java.util.*;
import java.lang.*;
import java.io.*;
//A C G T
// The main method must be in a class named "Main".
class Main {
    static int end=0;
    static int start =0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long max =0;
        
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        long total =0;
        for(int i=0; i<m; i++){
            total = addElement(arr,total);
            max=total;
        }
        while(end<n){
            long temp = addElement(arr,total);
            temp = removeElement(arr,temp);
            if(temp>max){
                max=temp;
            }
            total=temp;
        }
        System.out.printf("%d",max);

    }
    public static long addElement(int[] arr,long total){
        long temp =0 ;
        temp= total + arr[end];
        end++;
        return temp;
    }

    public static long removeElement(int[] arr , long total){
        long temp=0;
        temp=total-arr[start];
        start++;
        return temp;
    }
}