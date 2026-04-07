#include <cstdlib>
#include <iostream>
#include <string>
#include <map>

using std::cin;
using std::cout;
using std::endl;
using std::string;
using std::map;

int main()
{
    string s;
    cin >> s;

    map<string, int> result;

    for(int i = 0; i < s.length() - 9; i++)
    {
        string temp = s.substr(i, 10);

        result[temp]++;
    }

    for (const auto& it : result) {
        if (it.second > 1)
            cout << it.first << " : " << it.second << endl;
    }

    return EXIT_SUCCESS;
}