template <class T>
void ChangeSize1D(T*&a , const int oldSize , const int newSize)
{
    if(newSize < 0) throw "Error";
    T * temp = new T[newSize];
    int number = min(oldSize , newSize);
    copy(a,a+number,temp);
    delete[] a;
    a=temp;
}
---------------------------------------------------------------------------------------------
template <class T>
class Bag {
    public:
        Bag(int bagcapacity=10);
        ~Bag();
        bool IsEmpty() ;
        int Size();
        T& Element();
        void Push(const T&);
        void Pop();
    private:
        int capacity;
        T *array;
        int top;
}

template <class T>
Bag<T>::Bag(int bagcapacity=10): capacity(bagcapacity) {
    if(bagcapacity<1) throw "Error";
    array = new T[capacity];
    top = -1;
}

template <class T>
Bag<T>::IsEmpty() { 
    return top == -1; 
}

template <class T>
int Bag<T>::Size(){
    return top;
}

template <class T>
T& Bag<T>::Element(){
    if(IsEmpty()) throw "Error";
    return array[0];
}

template <class T>
void Bag<T>::Push(const T& obj){
    if(top == capacity-1) 
        ChangeSize1D(array,capacity,capacity*2);
    capacity*=2;
    array[++top]=obj;
    

}

template <class T>
void Bag<T>::Pop(){
    if(IsEmpty()) throw "Error";
    int deletePos = top/2;
    copy(array+deletePos + 1 , array + top +1 , array+deletePos);
    top--;
}
-------------------------------------------------------------------------------------------------

template <class T>
class Stack{
    public:
        Stack(int stackCapacity=10): capacity(stackCapacity) ;
        bool IsEmpty();
        T& Top();
        void Pop();
        void Push(const T&);
    private:
        int capacity;
        int top;
        T * array;

        
}

template <class T>
Stack<T>::Stack(int stackCapacity=10): capacity(stackCapacity){
        if(stackCapacity<1) throw "Error";
        array = new T[capacity];
        top = -1;
}

template <class T>
bool Stack<T>::IsEmpty()
    return top==-1;

template <class T>
T& Stack<T>:: Top() {
    if(IsEmpty()) throw "Error";
    return array[top];
}

template <class T>
void Stack<T>::Pop(){
    if(IsEmpty()) throw "Error";
    array[top--].~T(); 
}

template <class T>
void Stack<T>::Push(const T& obj){
    if(top == capacity-1) {
        Changesize1D(stack,capacity,2*capacity);
        capacity *=2;
    }
    stack[++top]=obj;
}

----------------------------------------------------------------------------------------

template <class T>
class Queue {
    public:
        Queue(int queueCapacity=10);
        T& front(); 
        T& rear();
        bool IsEmpty();
        void Pop();
        void Push(const T&);
    private:
        T * array;
        int capacity;
        int rear;
        int front;
}
template <class T>
Queue<T>::Queue(int queueCapacity=10): capacity(queueCapacity){
    if(queueCapacity<1) throw "Error";
    array = new T[capacity];
    front = rear = 0;
}

template <class T>
bool Queue<T>::IsEmpty() { return front == rear };

template <class T>
T& Queue<T>::front(){
    if(IsEmpty()) throw "Error";
    return array[(front+1)%capacity];
}

template <class T>
T& Queue<T>::rear(){
    if(IsEmpty()) throw "Error";
    return array[rear];
}

void Queue<T>::Pop(){
    if(IsEmpty()) throw "Error";
    front= (front+1)%capacity;
    array[front].~T();
    
}
// ���� ŵ
void Queue<T>::Push(const T & obj){
    if(((rear+1)%capacity) == front )
    {//ť�� �����̸� ũ�� �ι�� ����� �ڵ�
        T * newQueue = new T[2*capacity];

        int start = (front+1)%capacity;
        if(start<2)
            copy(array+start,array+start+capacity-1 , newQueue);
        else 
        {
            copy(array+start,array+capacity,newQueue);
            copy(array,array+rear+1,newQueue+capacity-start);
        }

     }
    rear = (rear+1)%capacity;
    array[rear]=obj;
}