#include <cstdlib>
#include <iostream>
#include <vector>
#include <string>
#include <sstream>
using namespace std;

bool isTop(vector<int>& arr, int n)
{
    if(arr[n-1] < arr[n] && arr[n] > arr[n+1])
        return true;
    
    return false;
}

int main()
{
    vector<int> arr;

    string line;
    getline(cin, line);

    istringstream iss(line);

    string n;
    while(iss >> n)
    {
        arr.push_back(stoi(n));
    }

    int a = 0;
    int b = arr.size() - 1;
    int result = arr.size() / 2;

    while(!isTop(arr, result))
    {    
        if(arr[result-1] > arr[result+1])
        {
            b = result;
            result = (a +  b) / 2;
            continue;
        }
            
        if(arr[result-1] < arr[result+1])
        {
            a = result;
            result = (a +  b) / 2;
            continue;
        }
    }

    cout << result << endl;

    return EXIT_SUCCESS;
}