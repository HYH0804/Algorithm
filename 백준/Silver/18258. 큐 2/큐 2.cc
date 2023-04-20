#include <iostream>
#include <string>
using namespace std;

const int MAX = 2000000;
int queue[MAX];
int front_ind =0; //앞
int back_ind =0 ; //끝 

void push(int num){
    queue[back_ind++]=num;
    
}
void pop(){
    if (front_ind == back_ind)
        cout<< -1 << '\n';   //char형으로써 이스케이프 시퀀스로 쓰인다는 것을 기억하자. "/n"
    else 
    cout << queue[front_ind++]<<'\n';
}

void size(){
    cout << back_ind- front_ind << '\n';
}

void empty(){
     if (front_ind == back_ind)
        cout<< 1 << '\n';
    else 
        cout << 0 << '\n';
}

void front(){
    if (front_ind == back_ind)
        cout<< -1 << '\n';
    else 
        cout << queue[front_ind]<<'\n';
}
void back(){
     if (front_ind == back_ind)
        cout<< -1 << '\n';
    else 
        cout << queue[back_ind-1]<<'\n';
}

int main(void){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int count;
    string str;
    cin >> count;
    while(count--){
        cin >> str;
        if (str =="push"){
            int num;
            cin >> num;
            push(num);
        }
        else if(str == "front"){
            front();
        }
        else if(str == "pop"){
            pop();
        }
        else if(str == "size"){
            size();
        }
        else if(str == "empty"){
            empty();
        }
        else if(str == "back"){
            back();
        }

    }
}