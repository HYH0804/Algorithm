import java.util.*;
import java.lang.*;
import java.io.*;

/*
총 S개 >> index S-1 
0 1 2 3 4 5 6 7 8 (9, 4) : 6개 
P개
0 1 2 3 
1 2 3 4 
2 3 4 5

for (n=0; n<S-P+1; n++) 시작 인덱스 i , 끝 인덱스 i+P-1 , 끝 인덱스 S-1 , 횟수 :  P-1 ~ S-1  : S-P+1
시작 index = 0;
끝 index = 시작 index+P-1;
for(i=start_index; i<start_index+P-1; i++) >> O(P*(S)) >> O(P*S) == 1 0000 0000 0000 >> 불가능
*/


/*
전체 배열을 부분문자열만큼 정해서 순회하는건 불가피함. 여기서 for문 한개
들어오는 문자열, 나가는 문자열만 확인해야 여기서 for문을 또 안씀
*/

class Main {
    //체크 갯수 기준 배열
    static int[] checkArr = new int[4];
    //현재 배열에서의 체크 현황 배열
    static int[] myArray = new int[4];
    static int checkSecret=0;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        char[] arrayS=new char[S];
        int P = Integer.parseInt(st.nextToken());
        int result=0;

        arrayS=br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            checkArr[i]=Integer.parseInt(st.nextToken());
            if(checkArr[i]==0)
                checkSecret++;
        }

        for(int i=0; i<P; i++){
            add(arrayS[i]);
        }     

        if(checkSecret==4){
            result++;
        }

        for(int i=P; i<S; i++){
            add(arrayS[i]);
            remove(arrayS[i-P]); 

            if(checkSecret==4){
                result++;
            }
        }
        System.out.println(result);
        
        
    }
    static void add(char c){ //A C G T 
        switch (c) {
            case 'A':
                myArray[0]++;
                if(myArray[0]==checkArr[0])
                    checkSecret++;
                break;
            case 'C':
                myArray[1]++;
                if(myArray[1]==checkArr[1])
                    checkSecret++;
                break;
            case 'G':
                myArray[2]++;
                if(myArray[2]==checkArr[2])
                    checkSecret++;
                break;
            case 'T':
                myArray[3]++;
                if(myArray[3]==checkArr[3])
                    checkSecret++;
                break;
        }
    }

    static void remove(char c){
        switch (c) {
            case 'A':
                if(myArray[0]==checkArr[0])
                    checkSecret--;
                myArray[0]--;
                break;
            case 'C':
                if(myArray[1]==checkArr[1])
                    checkSecret--;
                myArray[1]--;
                break;
            case 'G':
                if(myArray[2]==checkArr[2])
                    checkSecret--;
                myArray[2]--;
                break;
            case 'T':
                if(myArray[3]==checkArr[3])
                    checkSecret--;
                myArray[3]--;
                break;
        }
    }
}