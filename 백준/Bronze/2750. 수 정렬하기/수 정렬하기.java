import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
//버블정렬 O(n^2) 100 0000
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        for(int i=0; i<N; i++){
            //i는 정렬 완료 갯수
            for(int j=0; j<N-i-1; j++){
                //j와 j+1 비교. j+1
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
        printArray(arr);
    }
    public static void swap(int[] arr , int i , int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void printArray(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.printf("%d\n",arr[i]);
        }
    }
}
