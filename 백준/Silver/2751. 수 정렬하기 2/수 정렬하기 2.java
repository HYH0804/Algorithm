import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n =Integer.parseInt(st.nextToken());
      int[] arr= new int[n];
      for(int i=0; i<n; i++){
        st = new StringTokenizer(br.readLine());
        arr[i]=Integer.parseInt(st.nextToken());
      }
      mergeSort(arr,0,arr.length-1);
      for(int i=0; i<arr.length; i++){
        bw.write(arr[i]+"\n");
      }
      bw.flush();
      bw.close();

  }
  public static void mergeSort(int[] arr, int start, int end){
    if(start==end){
      return;
    }
    
    int[] temp = new int[end-start+1];
    
    int s1 = start;
    int mid = (start+end)/2;
    int s2 = mid+1;
    int index =0;
    
    mergeSort(arr,s1,mid);
    mergeSort(arr,mid+1,end);
    
    //투포인터
    while(s1<=mid && s2<=end){
      if(arr[s1]>arr[s2]){
        temp[index++]=arr[s2++];
      }
      else {
        temp[index++]=arr[s1++];
      }
    }
    if(s1>mid){
      while(s2<=end){
        temp[index++]=arr[s2++];
      }
    }
    else if(s2>end){
      while(s1<=mid){
        temp[index++]=arr[s1++];
      }
    }
    int copyIndex = start;
    for(int i=0; i<temp.length; i++){
      arr[copyIndex++]=temp[i];
    }
  }
  

  
}