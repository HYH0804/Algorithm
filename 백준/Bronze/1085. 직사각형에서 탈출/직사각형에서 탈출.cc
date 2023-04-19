#include <iostream>
#include <string>

using namespace std;
//max, min 함수


int main(int argc, char *argv[])
{
	int x , y , w , h ;
    cin >> x >> y >> w >> h;
    int d_bot_y = y;
    int d_left_x = x;
    int d_top_y= h-y;
    int d_right_x=w-x;
    
    cout << min(min(d_left_x,d_right_x),min(d_bot_y,d_top_y));

}