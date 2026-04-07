#include <cstdlib>
#include <iostream>
#include <vector>
#include <set>

using namespace std;

int main()
{
    vector<int> nums1 = {1, 2, 2, 1};
    vector<int> nums2 = {2, 2};
    vector<int> result;

    set<int> set1;
    set<int> set2;
    for(int i = 0; i < nums1.size(); i++)
    {
        set1.insert(nums1[i]);
    }

    for(int i = 0; i < nums2.size(); i++)
    {
        if(set1.count(nums2[i]))
            set2.insert(nums2[i]);
    }

    for(const auto& tmp : set2)
    {
        result.push_back(tmp);
    }

    for(int i =0; i < result.size(); i++)
    {
        cout << result[i] << endl;
    }

    return EXIT_SUCCESS;
}