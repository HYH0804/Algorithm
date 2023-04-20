#include <iostream>
#include <string>
using namespace std;

const int MAX = 10000;
int stack[MAX];
int pos=0;

void push(int num){
    stack[pos++] = num;
}

void pop(){
    if(pos==0)
        cout<<-1<< endl;
    else
        cout << stack[--pos]<< endl;
}

void size(){
    cout << pos<<endl;
}

void empty(){
    if(pos == 0)
        cout<< 1<< endl;
    else 
        cout << 0<< endl;
}
void top(){
    if(pos == 0)
        cout<<-1<<endl;
    else 
        cout << stack[pos-1] << endl;
}



int main(void){
    int count;
    string str;
    cin >> count;
    for(int i =0; i<count; i++){
        cin >> str;
        if(str == "push"){
            int parameter;
            cin >> parameter;
            push(parameter);
        }
        else if (str =="pop"){
            pop();
        }

        else if (str =="size"){
            size();
        }
        else if (str == "empty"){
            empty();
        }
        else if (str == "top"){
            top();
        }
    }
}

