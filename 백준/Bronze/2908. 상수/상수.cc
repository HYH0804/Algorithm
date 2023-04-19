#include <iostream>
#include <string>
#include <cmath> //pow(a,b) a^b 리턴형 double / sqrt 
using namespace std;

int isOrder(int a[]);

int main(int argc, char *argv[])
{
	int a,b;
	int new_a,new_b;
	cin>> a >>b;
	int arr_a[3]={0,};
	int arr_b[3]={0,};
	for (int i=0; i<3; i++){
		arr_a[2-i]=(int)(a/pow(10,2-i))%10; //정수형 각자리 수 분해 
		arr_b[2-i]=(int) (b/pow(10,2-i))%10;
		/*
		arr_a[i] = a % 10 ;
		a /= 10;
		arr_b[i] = b % 10;
		b /= 10;
		*/
	}
	new_a = arr_a[0]*100+arr_a[1]*10+arr_a[2];
	new_b = arr_b[0]*100+arr_b[1]*10+arr_b[2];
	
	if (new_a>new_b){
		cout<<new_a;
		}
		else
		cout<<new_b;
}
