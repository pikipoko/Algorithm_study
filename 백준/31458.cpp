#include <cstdlib>
#include <iostream>
#include <string>

using std::cin;
using std::cout;
using std::endl;
using std::string;
using std::getline;

int main()
{
    int T;

    cin >> T;

    for(int i = 0; i < T; i++)
    {
        string str;
        int len;

        bool isFactorial = false;
        int isReversed = 0;
        int result;

        cin >> str;
        len = str.size();

        for(int j = 0; j < len; j++)
        {
            if(str[j] != '!')
            {
                result = str[j] - '0';
                isFactorial = true;
                continue;
            }
            if(isFactorial)
                result = 1;
            else
                isReversed++;
        }
        isReversed %= 2;

        if(isReversed)
            result = (result + 1) % 2;
        
        cout << result << endl;
    }

    return EXIT_SUCCESS;
}