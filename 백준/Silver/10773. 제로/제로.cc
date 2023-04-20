#include <iostream>
#include <string>
using namespace std;

const int MAX = 100000;
int stack[MAX];
int pos=0;

void push(int num){
    stack[pos++] = num;
}

void pop(){
    if(pos==0)
        ;
    else
        --pos;
}

int size(){
    return pos;
}

/*void empty(){
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
*/


int main(void){
    int count;
    int n;
    int sum=0;
    cin >> count;
    for(int i =0; i<count; i++){
        cin >> n;
        if(n==0){
            pop();
        }
        else 
            push(n);
    }
    for (int j=0; j<size();j++){
        sum += stack[j];
    }
    cout << sum << endl;
}

