#include <string>
#include <iostream>
using namespace std;

bool solution(string s)
{
    bool answer = false;
    
    int pcnt = 0;
    int ycnt = 0;
    
    for(int i = 0; i < s.size(); i++)
    {
        if(s[i] == 'p' || s[i] == 'P')
            pcnt++;
        else if(s[i] == 'y' || s[i] == 'Y')
            ycnt++;
    }
    if(pcnt == ycnt)
        answer = true;
    
    return answer;
}