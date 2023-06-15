#include <iostream>

using namespace std;
int main(void){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    string in;
    string arr[10] ={"0","0","ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"};
    int sum=0;
    int index ;
    cin >> in;
    for(int i=0; i<in.length();i++){
        for(int j=2; j<10; j++){
            index = arr[j].find(in[i]);
            if(index != -1){
                sum += j+1;
            }
        }
    }
    cout << sum;

}