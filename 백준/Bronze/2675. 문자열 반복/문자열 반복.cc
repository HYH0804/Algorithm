#include <iostream>
#include <string>

int main(void){
    using namespace std;
    int n, count;
    int i=0;
    string s ;
    cin >> count;
    while (i < count){
    cin >> n >> s;
    for (int i=0; i<s.length(); i++){
        for(int j=0; j<n;j++){
            cout<< s.at(i);
        }
    }
    cout<<endl;
    i++;
    }
 }
    

