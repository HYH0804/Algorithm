import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        quickSort(arr,0,N-1,K-1);
        br.close();
    }
    public static void quickSort(int[] arr, int startIndex, int endIndex, int K){
        int pivot = (startIndex+endIndex)/2;
        swap(arr,pivot,startIndex);
        pivot=startIndex;

        int low=startIndex+1;
        int high=endIndex;
        while(low<=high){
            while(startIndex+1<=high && arr[pivot]<arr[high]){
                high--;
            }
            while(low<=endIndex&& arr[pivot]>arr[low]){
                low++;
            }
            if(high>=low){
                swap(arr,high--,low++);
            }
        }
        swap(arr,pivot,high);
        if(high==K){
            System.out.printf("%d",arr[high]);
            return;
        }
        else if(high>K){
            quickSort(arr,startIndex,high-1,K);
        }
        else{
            quickSort(arr,high+1,endIndex,K);
        }


    }
    public static void swap(int[] arr,int p , int q){
        int temp = arr[p];
        arr[p]=arr[q];
        arr[q]=temp;
    }

}