import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n =Integer.parseInt(st.nextToken());
        int max =0;
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String iDigit = st.nextToken();
            int N = iDigit.toCharArray().length;
            if(N>max){
                max=N;
            }
            arr[i]= Integer.parseInt(iDigit);
        }
        int[] anw = radixSort(arr,max);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<n; i++){
            bw.write(anw[i]+"\n");
        }
        bw.flush();
        bw.close();

    }
    public static int[] radixSort(int[] arr, int max){
        //bucket 0~9까지 넣고
        //bucket에서 빼서 재정렬
        //합 배열
        // 10 21 49 28 17 19 59 22 34
        // 10 21 22 34 17 28 49
        //                   19
        //                   59
        //  1  1  1  0  1 0 0 1 1 3
        //  1  2  3  3  4 4 4 5 5 8
        // 뒤부터 돌면서 temp =A[배열[i]%10]--
        // new배열[temp-1]
        // new 배열을 배열로 복사
        // 이걸 max 자릿수만큼 반복
        int l = 1;
        for(int i=0 ; i<max; i++){
            int[] bucket= new int[10];
            int[] newArr = new int[arr.length];
            for(int j=0; j<arr.length; j++){ //n번
                bucket[arr[j]/l%10]++;
            }
            for(int j=1; j<10; j++){  //10번
                bucket[j]+=bucket[j-1];
            }
            for(int j=arr.length-1; j>=0; j--){ //n번
                int temp = bucket[arr[j]/l%10]--;
                newArr[temp-1]=arr[j];
            }
            for(int j=0; j<arr.length; j++){ //n번
                arr[j]=newArr[j];
            }
            l=l*10;
        }
        return arr;
    }
}