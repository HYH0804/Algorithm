#include <iostream>
#include <string>

int main(void){
    using namespace std;
    int max=0;
    int index =0;
    int count[26] = {0,};   //A부터 Z까지 대문자를 0부터 26까지 배열로 저장
    string str;
    cin >> str;
    for(int i =0; i<str.length();i++){
        if(str.at(i)<97) //대문자
            ++count[str.at(i)-65]; //A "65"    z > 90-65 = 25 ++z(25) 
        else if(str.at(i)>96) //소문자 
            ++count[str.at(i)-97]; //a "97"        z > 122-97 = 25 ++z(25)  ++z(0)    1 0 0 0 ... 2
    }

    for(int j=0; j<26; j++){
        if(max < count[j]){
            max = count[j];
            index = j;
        }
    }
    for (int z =0; z<26;z++){
        if(max == count[z] && z!=index){
        cout << "?";
        return 0;
        }
    }
    cout << (char)(index + 65) << endl;
}