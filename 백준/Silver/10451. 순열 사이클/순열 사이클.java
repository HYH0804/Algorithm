import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int test=Integer.parseInt(st.nextToken());
        List<Integer> cycle = new ArrayList<Integer>();
        for(int i =0; i<test; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            List<Integer>[] arr = new ArrayList[n+1];
            boolean[] visited = new boolean[n+1];
            int count=0;
            for(int j=1; j<=n; j++){
                arr[j]=new ArrayList<Integer>();
            }
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                int k = Integer.parseInt(st.nextToken());
                arr[j].add(k);
            }
            for(int j=1; j<=n; j++){
                //1부터 돌면서 visited=true인지 확인;
                //true이면 패스;
                //false이면 DFS 호출;
                if(visited[j]==true){
                    continue;
                }
                else{
                    count++;
                    DFS(arr,visited,j);
                }
            }
            cycle.add(count);
        }
        for(int k: cycle){
            System.out.printf("%d\n",k);
        }

    }
    public static void DFS(List<Integer>[] arr,boolean[] visited,int n){
        //해당 값이 true인지 확인
        //true 이면 return
        if(visited[n]==true){
            return;
        }
        //false이면 다시 인접리스트 연결된 거 호출
        else{
            for(int k:arr[n]){
                visited[n]=true;
                DFS(arr,visited,k);
            }
        }
    }
}