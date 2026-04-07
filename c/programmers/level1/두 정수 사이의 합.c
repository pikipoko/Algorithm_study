#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

long long solution(int a, int b) {
    long long answer = 0;
    long long big = b;
    long long small = a;
    
    if(a > b)
    {
        big = a;
        small = b;
    }
    
    answer = ((big + 1) * big) / 2 - (small * (small - 1)) / 2;
    
    return answer;
}