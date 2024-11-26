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
        quickSort(newArr,0,newArr.length-1);
        for(int i=0; i<newArr.length; i++){
            System.out.printf("%d\n",newArr[i]);
        }
        

        
    }
    public static void quickSort(long[] arr, int start ,int end){
        if(start>=end){
            return;
        }
        int pivot= (end+start)/2;
        swap(arr,start,pivot);
        pivot=start;
        int startIndex=start+1;
        int endIndex=end;
        while(startIndex<=endIndex){
            while(startIndex<=end && arr[startIndex]<=arr[pivot]){
                startIndex++;
            }
            while(endIndex>=start+1 && arr[endIndex]>=arr[pivot]){
                endIndex--;
            }
            if(startIndex<=endIndex){
                swap(arr,startIndex++,endIndex--);
            }
        }
        swap(arr,endIndex,pivot);
        pivot=endIndex;
        quickSort(arr,start,pivot-1);
        quickSort(arr,pivot+1,end);
    }
    
    public static void swap(long[] arr, int a, int b){
        long temp = arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}