import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
//2초면 2억번... N은 100, 100* 100 0000 00 / 100만까지
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bf.readLine());
        for(int i=0; i<testCase; i++){
            Queue<O> queue = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            int anslocation = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(bf.readLine());
            int locationNow = 0;
            Integer[] priorityArr = new Integer[N];
            for(int j=0; j<N; j++){
                int pNow = Integer.parseInt(st.nextToken());
                priorityArr[j]=pNow;
                O o = new O(pNow,locationNow++);
                queue.add(o);
            }
            Arrays.sort(priorityArr,Collections.reverseOrder());
            int count =1;
            int index=0;
            while(!queue.isEmpty()){
                O o = queue.poll();
                if(o.p==priorityArr[index] && o.location==anslocation){
                    System.out.printf("%d\n",count);
                    break;
                }
                else if(o.p==priorityArr[index] && o.location!=anslocation){
                    count++;
                    index++;
                }
                else if(o.p!=priorityArr[index]){
                    queue.add(o);
                }
            }
        }
        
    
    }
}
    class O {
        public int p;
        public int location;
        public O(int p , int location){
            this.p=p;
            this.location = location;
        }
    }
