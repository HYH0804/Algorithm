#include <iostream>
#include <string>
using namespace std;

int main(void){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    string ch;
    cin >> ch;
    bool flag=false;
    while(ch != "0"){

        if(ch.length()==1){
            cout<<"yes"<<'\n';
        }
        else if(ch.length()%2 != 0){
            for(int i=0; i<=(ch.length()-2)/2; i++){
                if(ch[i]!=ch[ch.length()-1-i]){
                    cout<<"no"<<'\n';
                    flag=true;
                    break;
                }
            }
            if (flag == false)
                cout<<"yes"<<'\n';
        }
        else {
            for(int i=0; i<=(ch.length()-1)/2; i++){
                if(ch[i]!=ch[ch.length()-1-i]){
                    cout<<"no"<<'\n';
                    flag=true;
                    break;
                }
            }
            if (flag == false)
                cout<<"yes"<<'\n';
        }
        cin >> ch;
        flag = false;
    }
}
