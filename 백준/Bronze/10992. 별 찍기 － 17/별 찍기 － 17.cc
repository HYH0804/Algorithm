#include <iostream>

int main(void){
    using namespace std;
    int row;
    int count =1;
    cin >> row;
    if(row ==1 ){
        cout<<"*";
    }
    else if(row==2){
        cout << " *" << endl;
        cout << "***";
    }
    else {
        while(count<=row){
            for(int i =0;i<row-count;i++)
                cout << " ";
           
            if(count==1||count==row){
                for(int j=0;j<2*count-1;j++){
                    cout<<"*";
                    }
                cout<<endl;
                ++count;
                continue;
                
            }
            else {
                cout<<"*";
                for(int z=0;z<(2*count-3);z++)
                cout <<" ";
            }
            cout<<"*"<<endl;       
            count++;
        }
    }
}