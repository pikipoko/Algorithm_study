#include <iostream>
#include <cstdlib>

using std::cin;
using std::endl;
using std::cout;
using std::string;

int main()
{
    int N;
    cin >> N;

    string str1;
    string str2;

    cin >> str1;
    int len = str1.size();

    for(int r = 1; r < N; r++)
    {
        cin >> str2;
        
        for(int i = 0; i < len; i++)
        {
            if(str1[i] == '?')
                continue;
            if(str1[i] != str2[i])
                str1[i] = '?';
        }

    }
    cout << str1 << endl;

    return EXIT_SUCCESS;
}