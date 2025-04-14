#include <cstdlib>
#include <iostream>
#include <string>
#include <set>

using std::cout;
using std::cin;
using std::endl;
using std::string;
using std::set;

int main()
{
    string s;
    int k;

    cin >> s;
    cin >> k;

    int cnt = 1;
    int kk = k;
    while(kk > 0)
    {
        cnt *= 2;
        kk--;
    }

    set<string> result;

    if(s.size() < k)
        return false;
    for(int i  = 0; i < s.size() - k + 1; i++)
    {
        string temp = s.substr(i, k);
        result.insert(temp);
    }

    return EXIT_SUCCESS;
}