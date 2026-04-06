#include <iostream>
#include <cstdlib>

using std::cout;
using std::cin;
using std::string;
using std::endl;

int main()
{
    string str;
    cin >> str;

    int len = str.size();
    int l = len / 2 + len % 2;
    int res = 1;

    for(int i = 0; i < l; i++)
    {
        if(str[i] != str[len - i - 1])
        {
            res = 0;
            break;
        }
    }
    cout << res << endl;

    return EXIT_SUCCESS;
}