#include <cstdlib>
#include <iostream>

using std::cout;
using std::cin;
using std::endl;
using std::string;

class Solution {
    public:
        bool digitCount(string num) {
            const int len = num.size();

            string cnt = num;

            for(int i = 0; i < len; i++)
            {
                cnt[i] = '0';
            }

            for(int i = 0; i < len; i++)
            {
                cnt[num[i] - '0']++;
            }

            if(cnt == num)
                return true;
            else
                return false;
        }
    };

int main()
{
    Solution* sol = new Solution;
    cout << sol->digitCount("1210") << endl;
    cout << sol->digitCount("030") << endl;
    return EXIT_SUCCESS;
}