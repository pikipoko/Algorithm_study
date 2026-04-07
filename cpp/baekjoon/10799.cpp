#include <cstdlib>
#include <iostream>
#include <vector>
#include <string>

using std::cout;
using std::cin;
using std::endl;
using std::vector;
using std::string;

int main()
{
    string str;
    cin >> str;
    char prev = '(';
    int len = str.size();

    vector<char> lines;
    vector<int> line;

    int pieces = 0;

    for(int l = 0; l < len; l++)
    {
        lines.push_back('(');

        if(str[l] == ')')
        {
            if(lines[lines.size() - 1] == '(')
            {
                pieces += lines.size()-1;
            }
            else
            {

            }

        }
        prev = str[l];
    }

    cout << pieces << " ";

    return EXIT_SUCCESS;
}