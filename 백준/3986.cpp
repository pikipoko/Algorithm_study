#include <cstdlib>
#include <iostream>
#include <vector>

using std::cin;
using std::cout;
using std::endl;
using std::string;
using std::vector;

int main()
{
    int cnt = 0;
    int N;
    cin >> N;

    string word;

    for(int i = 0; i < N; i++)
    {
        vector<char> ABs;

        cin >> word;
        int len = word.size();
        if(word.size() % 2 == 1)
            continue;

        for(int l = 0; l < len; l++)
        {
            if(ABs.empty())
                ABs.push_back(word[l]);
            else
            {
                if(ABs[ABs.size() - 1] == word[l])
                {
                    ABs.pop_back();
                }
                else
                ABs.push_back(word[l]);
            }
        }
        if(ABs.empty())
        {
            cnt++;
        }
    }
    
    cout << cnt << endl;

    return EXIT_SUCCESS;
}