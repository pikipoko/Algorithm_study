#include <cstdlib>
#include <iostream>
#include <vector>

using std::cin;
using std::cout;
using std::endl;
using std::vector;

int main()
{
    int K;
    cin >> K;
    
    vector<int> nums;

    for(int i = 0; i < K; i++)
    {
        int n;
        cin >> n;
        
        if(n == 0)
            nums.pop_back();
        else
            nums.push_back(n);
    }

    int result = 0;
    for(int i = 0; i < nums.size(); i++)
    {
        result += nums[i];
    }

    cout << result << endl;

    return EXIT_SUCCESS;
}