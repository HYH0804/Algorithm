import java.util.*;
import java.io.*;

public class Main {
    
    static int a[];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        a = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        
        quickSort(a, 0, n - 1, k - 1);
        System.out.print(a[k - 1]);
    }
    
    public static void quickSort(int a[], int s, int e, int k) {
        if(s < e) {
            int p = partition(a, s, e);
            if(k == p) {
                return;
            }else if(k < p) {
                quickSort(a, s, p - 1, k);
            }else {
                quickSort(a, p + 1, e, k);
            }
        }
    }
    
    public static int partition(int a[], int s, int e) {
        if(s + 1 == e) {
            if(a[s] > a[e]) {
                swap(a, s, e);
            }
            return e;
        }
        
        int m = (s + e) / 2;
        
        swap(a, s, m);
        int p = a[s];
        int i = s + 1;
        int j = e;
        while(i <= j) {
            while(a[j] > p && j >= s + 1) {
                j--;
            }
            while(a[i] < p && i <= e) {
                i++;
            }
            if(i <= j) {
                swap(a, i++, j--);
            }
        }
        
        a[s] = a[j];
        a[j] = p;
        return j;
    }
    
    public static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp; 
    }
}