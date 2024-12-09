import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static boolean[] visited;
    static List<Integer>[] arr;
    static Stack<Integer> stack = new Stack<Integer>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count=0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());
        visited = new boolean[node+1];
        st=new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        arr = new ArrayList[node+1];
        for(int i=1; i<=node; i++){
            arr[i]=new ArrayList<Integer>();
        }
        for(int i=1; i<=v; i++){
            st=new StringTokenizer(br.readLine());
            int edge1=Integer.parseInt(st.nextToken());
            int edge2=Integer.parseInt(st.nextToken());
            arr[edge1].add(edge2);
            arr[edge2].add(edge1);
        }
        stack.push(1);
        visited[1]=true;
        while(!stack.isEmpty()){
            int k = stack.pop();
            for(int i =0; i<arr[k].size(); i++){
                int num = arr[k].get(i);
                if(visited[num]==false){
                    stack.push(num);
                    visited[num]=true;
                }
            }
        }
        for(int i=1; i<visited.length; i++){
            if(visited[i]==true&& i!=1){
                count++;
            }
        }
        System.out.printf("%d",count);


        
        
    }
}