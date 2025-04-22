#include <cstdlib>
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
    vector<int> arr1 = {2, 1, 100, 3};
    vector<int> arr2 = {-5, -2, 10, -3, 7};
    int d = 6;
    int output = 0;

    sort(arr2.begin(), arr2.end());

    
    for(int i = 0; i < arr1.size(); i++)
    {
        int left = 0;
        int right = arr2.size();
        bool found = false;
        
        while(left <= right )
        {
            int mid = (left + right) / 2;
            int distance = arr1[i] - arr2[mid];
    
            if(distance < 0)
                distance = -distance;
    
            if(distance <= d)
            {
                found = true;
                break;
            }
            
            if(arr2[mid] < arr1[i])
            {
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }
        if(!found)
            output++;
    }

    cout << output << endl;

    return EXIT_SUCCESS;
}