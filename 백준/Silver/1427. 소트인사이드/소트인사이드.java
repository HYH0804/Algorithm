import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
//선택정렬
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        char[] tempArr = str.toCharArray();
        int[] arr = new int[tempArr.length];
        for(int i=0; i<arr.length; i++){
            arr[i]=(int)(tempArr[i]-'0');
        }
        //가장 큰거 
        int start_index =0;
        for(int i=0;i<arr.length; i++){
            int max_index = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j]>arr[max_index]){
                    max_index=j;
                }
            }
            swap(arr,max_index,start_index);
            start_index++;
        }
        printArr(arr);
        
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    } 
    public static void printArr(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.printf("%d",arr[i]);
        }
    }
}