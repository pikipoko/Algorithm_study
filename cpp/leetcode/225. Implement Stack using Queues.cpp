#include <cstdlib>
#include <iostream>

using std::cout;
using std::endl;

class MyStack {
public:

    int val;
    MyStack* next;
    int size;

    MyStack() {
        next = NULL;
        size = 0;
    }
    
    void push(int x) {
        size++;
        if(size == 1)
        {
            val = x;
            return;
        }

        if(next == NULL)
        {
            MyStack* newS = new MyStack();
            newS->val = x;
            next = newS;
            return;
        }

        MyStack* temp = next;

        while(temp->next != NULL)
        {
            temp = temp->next;
        }

        MyStack* newS = new MyStack();
        newS->val = x;
        temp->next = newS;
        return;

    }
    
    int pop() {
        if(size < 1)
            return 0;

        size--;

        if(size == 0)
        {
            int org = val;
            val = 0;
            next = NULL;
            return org;
        }

        MyStack* temp = this;
        while(temp->next->next != NULL)
        {
            temp = temp->next;
        }
        // temp->next->next;
        int org = temp->next->val;
        temp->next->val = 0;
        temp->next = NULL;
        return org;
    }
    
    int top() {
        if(size < 1)
            return 0;

        if(size == 1)
        {
            return val;
        }

        MyStack* temp = this;
        while(temp->next != NULL)
        {
            temp = temp->next;
        }
        
        return temp->val;
    }
    
    bool empty() {
        return size <= 0;
    }

    void printS()
    {
        cout << val;
        MyStack* temp = next;
        while(temp != NULL)
        {
            cout << "-" << temp->val;
            temp = temp->next;
        }
        cout << endl;
    }
};

int main()
{
    MyStack* myStack = new MyStack();
    myStack->push(1);
    myStack->push(2);
    myStack->push(3);
    int t = myStack->top();
    cout << t << endl;
    myStack->printS();
    myStack->pop();
    t = myStack->top();
    myStack->printS();
    cout << t << endl;
    return EXIT_SUCCESS;
}