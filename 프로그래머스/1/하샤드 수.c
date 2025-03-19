#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

bool solution(int x) {
    bool answer = true;
    int sum = 0;
    int org = x;
    
    while(x > 0)
    {
        sum += x%10;
        x /= 10;
    }
    
    answer = org % sum == 0;
    return answer;
}