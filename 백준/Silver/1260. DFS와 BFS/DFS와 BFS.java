import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //N받고, M 받고 , start 받고 
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        
        //방문배열 N DFS, '' BFS , 방문체크배열 DFS BFS
        boolean[] isExploreDFS = new boolean[N + 1];
        boolean[] isExploreBFS = new boolean[N + 1];
        int[] orderDFS=new int[N+1];
        int[] orderBFS=new int[N+1];
        
        //N에 맞는 인접리스트 배열
        List<Integer>[] arr = new ArrayList[N+1];
        //M번 돌면서 인접리스트 초기화
        for(int i=1; i<=N; i++){
            arr[i]=new ArrayList<Integer>();
        }
        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            arr[k].add(j);
            arr[j].add(k);
        }
        for(int i=1; i<=N; i++){
            Collections.sort(arr[i],Collections.reverseOrder());
        }
        
        //DFS(스택)
        //start True , 스택에 넣고, count=1;
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        int count=1;
        while(!stack.isEmpty()){
            int k = stack.pop();
            if(isExploreDFS[k]==false){
                isExploreDFS[k]=true;
                orderDFS[count++]=k;
            }
            for(int num : arr[k]){
            //인접리스트[k]에 있는 것들 가져와서
            //if(방문체크배열[인접리스트[k]]==false)
                if(isExploreDFS[num]==false){
                    stack.push(num);
                }
            }
        }

        for(int i=1; i<=N; i++){
            Collections.sort(arr[i]);
        }
        //BFS(큐)
        Queue<Integer> queue= new LinkedList<>();
        queue.add(start);
        isExploreBFS[start]=true;
        count=1;
        while(!queue.isEmpty()){
        int k = queue.poll();
        orderBFS[count++]=k;
        for(int num : arr[k]){
        //인접리스트[k]에 있는 것들 가져와서
        //if(방문체크배열[인접리스트[k]]==false)
            if(isExploreBFS[num]==false){
                isExploreBFS[num]=true;
                queue.add(num);
            }
        }
        }

        for(int i=1; i<=N&&orderDFS[i]!=0; i++){
            System.out.printf("%d ",orderDFS[i]);
        }
        System.out.println();
        for(int i=1; i<=N&&orderBFS[i]!=0; i++){
            System.out.printf("%d ",orderBFS[i]);
        }
    }
}