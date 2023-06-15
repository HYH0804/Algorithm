#include <iostream>
#include <vector>
#include <string>

using namespace std;
int main(void){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int arr[10] = {0,};
    int max = 0 ;
    string in;
    cin >> in;
    for (auto i : in){
        arr[i-'0']++;
    }

    for (int i =0 ; i<10; i++){
        if(max < arr[i] && i!=6 && i!=9)
            max = arr[i];
    }
    int div = (arr[6]+arr[9])%2;
    int act = (arr[6]+arr[9])/2;
    if(div==0){
        if(max <act){
            cout << act;
        }
        else {
            cout << max;
        }
    }
    else{
        act++;
        if(max<act){
            cout << act;
        }
        else {
            cout << max;
        }
    } 


}