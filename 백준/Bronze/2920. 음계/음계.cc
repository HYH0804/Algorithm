#include <iostream>
#include <string>

using namespace std;

int isOrder(int a[],int n);

int main(void)
{
	int array[8];
	for(int i=0;i<8;i++){
		cin>>array[i];
	}
	int check=isOrder(array,8);
	if (check==1)
		cout<<"ascending";
	else if(check==0)
		cout<<"descending";
	else 
		cout<< "mixed";
}

int isOrder(int a[],int n){
	int count=0;   //https://woo-dev.tistory.com/170 인자로 배열을 받으면 크기를 구하지 못한다. 
	for (int j=0;j<n-1;j++){
		if(a[j+1]-a[j]==1){
			count++;
			continue;
			}
		else if (a[j+1]-a[j]==-1){
			count--;
			continue;
			}
		}
		if (count==7)
		return 1;
		else if (count==-7)
		return 0;
		else
		return -1;
}