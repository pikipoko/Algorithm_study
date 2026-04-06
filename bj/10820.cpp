#include <cstdlib>
#include <iostream>
#include <string>

using std::cin;
using std::cout;
using std::string;
using std::endl;
using std::getline;

int main()
{
    int N = 0;
    
    string str[100];

    for(int i = 0; i < 100; i++)
    {
        getline(cin, str[i]);
        if(str[i].size() <= 0)
            break;
        N++;
    }

    for(int i = 0; i < N; i++)
    {
        int len = str[i].size();

        int s_alpb_cnt = 0;
        int b_alpb_cnt = 0;
        int number_cnt = 0;
        int blanks_cnt = 0;

        for(int j = 0; j < len; j++)
        {
            if(str[i][j] >= 'a' && str[i][j] <= 'z')
                s_alpb_cnt++;
            else if(str[i][j] >= 'A' && str[i][j] <= 'z')
                b_alpb_cnt++;
            else if(str[i][j] >= '0' && str[i][j] <= '9')
                number_cnt++;
            else if(str[i][j] == ' ')
                blanks_cnt++;
        }
        
        printf("%d %d %d %d\n", s_alpb_cnt, b_alpb_cnt, number_cnt, blanks_cnt);
    }

    return EXIT_SUCCESS;
}