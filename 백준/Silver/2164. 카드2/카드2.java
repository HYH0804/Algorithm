import java.util.*;
import java.lang.*;
import java.io.*;
// The main method must be in a class named "Main".
class Main {
    static int front=1000000;
    static int rear=1000001;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[2000000];

        for(int i=n; i>=1; i--){
            add(arr,n-i+1);
        }
        while(front!=rear){
            poll(arr); //제일 위 카드 제거하고
            int temp = peek(arr);
            poll(arr);
            add(arr,temp);
        }
        System.out.printf("%d",peek(arr));
    }
    public static void poll(int[] arr){
        front--;
    }
    public static void add(int[] arr,int num){
        if(front==1000000){
            arr[++front]=num;
        }
        else{
            arr[--rear]=num;
        }

    }

    public static int peek(int[] arr){
        return arr[front];
    }
}