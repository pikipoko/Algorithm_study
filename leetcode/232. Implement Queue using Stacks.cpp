#include <iostream>
#include <cstdlib>
#include <vector>

using std::cout;
using std::endl;
using std::vector;

class MyQueue {
    public:
        
        MyQueue* next;
        int val;
        int size;
        int org;

        MyQueue() {
            next = NULL;
            size = 0;
        }
        
        void push(int x) {
            if(size <= 0)
            {
                size++;
                val = x;
                return;
            }
            size++;

            if(next == NULL)
            {
                MyQueue* newQ = new MyQueue();
                newQ->val = x;
                next = newQ;
                return;
            }

            MyQueue* temp = next;

            while(temp->next != NULL)
            {
                temp = temp->next;
            }

            MyQueue* newQ = new MyQueue();
            newQ->val = x;
            temp->next = newQ;
        }
        
        int pop() {
            if(size == 0)
            {
                return 0;
            }
            org = val;
            size--;
            
            if(next == NULL)
            {
                val = 0;
                return org;
            }

            val = next->val;
            MyQueue* temp = next;
            MyQueue* prev = this;

            while(temp->next != NULL)
            {
                prev = prev->next;
                temp->val = temp->next->val;
                temp = temp->next;
            }

            temp->val = 0;
            free(temp);
            prev->next = NULL;

            return org;
        }
        
        int peek() {
            return val;
        }
        
        bool empty() {
            return size <= 0;
        }

        void printq()
        {
            cout << "[" << val << "]";
            if(next != NULL)
            {
                cout << "-";
                next->printq();
            }
        }
    };
    
int main()
{

    // Your MyQueue object will be instantiated and called as such:
    MyQueue* obj = new MyQueue();
    obj->push(1);
    obj->push(2);
    obj->push(3);
    obj->printq();
    cout << endl;
    int param_1 = obj->peek();
    int param_2 = obj->pop();
    obj->printq();
    cout << endl;
    int param_3 = obj->peek();
    obj->printq();
    cout << endl;
    cout << param_1 << endl;
    cout << param_2 << endl;
    cout << param_3 << endl;
    // bool param_4 = obj->empty();
    // obj->printq();
    
}