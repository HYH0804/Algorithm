#include <string>
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
bool compare(string &a, string &b){
    if(a.length()==b.length()){
        return a<b;
    }
    else {
        return a.length()<b.length();
    }
}

int main() {
    int n;
    string str;
    vector<string> v;
    cin >> n;
    for (int i =0; i< n; i++){
        cin >> str ;
        v.push_back(str);
    }
    sort(v.begin(),v.end(),compare);
    cout<<v[0] << '\n';
    for(int i=1;i<n;i++){
        if(v[i-1]==v[i]){
            continue;
        }
        cout<<v[i]<<'\n';
    }
}