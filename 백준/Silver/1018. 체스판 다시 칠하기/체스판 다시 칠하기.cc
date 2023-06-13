#include <iostream>
using namespace std;

char white[8][8] = {{'W','B','W','B','W','B','W','B'},
                    {'B','W','B','W','B','W','B','W'},
                    {'W','B','W','B','W','B','W','B'},
                    {'B','W','B','W','B','W','B','W'},
                    {'W','B','W','B','W','B','W','B'},
                    {'B','W','B','W','B','W','B','W'},
                    {'W','B','W','B','W','B','W','B'},
                    {'B','W','B','W','B','W','B','W'}};

char black[8][8] = {{'B','W','B','W','B','W','B','W'},
                    {'W','B','W','B','W','B','W','B'},
                    {'B','W','B','W','B','W','B','W'},
                    {'W','B','W','B','W','B','W','B'},
                    {'B','W','B','W','B','W','B','W'},
                    {'W','B','W','B','W','B','W','B'},
                    {'B','W','B','W','B','W','B','W'},
                    {'W','B','W','B','W','B','W','B'}};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int row,col,mini=65,count_white=0,count_black=0;
    char input;
    cin >> row >> col;
    char board[row][col] = {0,};
    for(int i =0; i<row; i++){
        for (int j=0; j<col; j++){
            cin >> input;
            board[i][j] = input;
        }
        cin.clear();
    }
    
for (int i = 0; i<row-7; i++){
    for(int j=0; j<col-7; j++){
        count_white=0;
        count_black=0;
        for(int z=0; z<8;z++){
            for(int p=0; p<8;p++){
                if(board[z+i][p+j]!=white[z][p])
                    count_white++;
                if(board[z+i][p+j]!=black[z][p])
                    count_black++;
            }
        }
        if(mini > min(count_black,count_white))
            mini=min(count_black,count_white);
        
    }
}
cout << mini<<'\n';
}
