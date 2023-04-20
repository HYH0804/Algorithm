#include <iostream>
#include <string>
using namespace std;

const int MAX = 10000;
int queue[MAX];
int front_ind =0; //앞
int back_ind =0 ; //끝 

void push(int num){
    queue[back_ind++]=num;
    
}
void pop(){
    if (front_ind == back_ind)
        cout<< -1 << endl;
    else 
    cout << queue[front_ind++]<<endl;
}

void size(){
    cout << back_ind- front_ind << endl;
}

void empty(){
     if (front_ind == back_ind)
        cout<< 1 << endl;
    else 
        cout << 0 << endl;
}

void front(){
    if (front_ind == back_ind)
        cout<< -1 << endl;
    else 
        cout << queue[front_ind]<<endl;
}
void back(){
     if (front_ind == back_ind)
        cout<< -1 << endl;
    else 
        cout << queue[back_ind-1]<<endl;
}

int main(void){
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