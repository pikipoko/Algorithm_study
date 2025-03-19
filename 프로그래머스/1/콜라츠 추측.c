#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int num) {
    int answer = -1;
    int i = 0;
    long tmp = num;
    
    for(; i < 500; i++)
    {
        if(tmp == 1)
            break;
        if(tmp % 2 == 0)
        {
            tmp /= 2;
            continue;
        }
        tmp *= 3;
        tmp += 1;
    }
    if(i < 500)
        answer = i;
    return answer;
}