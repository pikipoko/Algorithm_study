#include <cstdlib>
#include <iostream>
#include <vector>

using std::cout;
using std::cin;
using std::endl;
using std::vector;

class MyHashMap {
public:
    
    int k;
    int v;
    MyHashMap* next;
    MyHashMap* prev;

    MyHashMap() {
        k = -1;
        v = -1;
        next = NULL;
        prev = NULL;
    }
    
    void put(int key, int value) {
        if(next == NULL)
        {
            MyHashMap* new_next = new MyHashMap();

            new_next->k = key;
            new_next->v = value;
            next = new_next;
            new_next->prev = this;
            return;
        }

        MyHashMap* n = next;
        MyHashMap* p = prev;

        while(n != NULL)
        {
            if(n->k == key)
            {
                n->v = value;
                return;
            }
            p = n;
            n = n->next;
        }

        MyHashMap* new_next = new MyHashMap();
        new_next->k = key;
        new_next->v = value;
        p->next = new_next;
        new_next->prev = p;
    }
    
    int get(int key) {
        
        MyHashMap* temp = next;

        while(temp != NULL)
        {
            if(temp->k == key)
            {
                return temp->v;
            }
            temp = temp->next;
        }

        return -1;
        
    }
    
    void remove(int key) {
        MyHashMap* temp = next;

        while(temp != NULL)
        {
            if(temp->k == key)
            {
                temp->prev->next = temp->next;
                if(temp->next != NULL)
                {
                    temp->next->prev = temp->prev;
                }
                return;
            }
            temp = temp->next;
        }
    }

    void print()
    {
        MyHashMap* temp = next;

        while(temp != NULL)
        {
            cout << "[" << temp->k << "," << temp->v << "] ";
            temp = temp->next;
        }
        cout << endl;
    }
};

int main()
{

    MyHashMap* myM = new MyHashMap();

    myM->put(1, 1);
    myM->put(2, 2);
    cout << myM->get(1) << endl;
    
    cout << myM->get(3) << endl;
    myM->put(2,1);
    cout << myM->get(2) << endl;
    myM->remove(2);
    cout << myM->get(2) << endl;
    
    return EXIT_SUCCESS;
}