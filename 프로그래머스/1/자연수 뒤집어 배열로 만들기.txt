#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int* solution(long long n) {
    // 리턴할 값은 메모리를 동적 할당해주세요.
    long long m = n;
    int len = 0;
    int* answer;
    int i = 0;
    
    while(n)
    {
        len++;
        n /= 10;
    }
    
    answer = (int*)malloc(sizeof(int)*len);
    
    for(; i < len; i++)
    {
        answer[i] = m % 10;
        m /= 10;
    }
    
    return answer;
}