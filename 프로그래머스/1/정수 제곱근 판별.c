#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

long long solution(long long n) {
    long long org = n;
    long long answer = 1;
    long long** cnt;
    long long i = 2;
    long long j, k, c;
    int divCnt = 0;
    
    while(n > 1)
    {
        if(n % i == 0)
        {
            divCnt++;
            n /= i;
            continue;
        }
        i++;
    }
    
    cnt = (long long**)malloc(sizeof(long long*) * divCnt);
    
    for(j = 0; j < divCnt; j++)
    {
        cnt[j] = (long long*)malloc(2);
        cnt[j][0] = 0;
        cnt[j][1] = 0;
    }
    
    i = 2;
    n = org;
    c = 0;
    
    while(n > 1)
    {
        if(n % i == 0)
        {
            if(cnt[c][0] != 0 && cnt[c][0] != i)
            {
                c++;
            }
            cnt[c][0] = i;
            cnt[c][1]++;
            n /= i;
            continue;
        }
        i++;
    }
    
    for(j = 0; j < divCnt; j++)
    {
        if(cnt[j][1] == 0)
            continue;
        if(cnt[j][1] % 2 == 0)
        {
            for(k = 0; k < cnt[j][1]/2; k++)
            {
                answer *= cnt[j][0];
            }
        }
        else
        {
            answer = -1;
            break;
        }
    }
    
    if(answer > -1)
        answer = (answer+1)*(answer+1);
    return answer;
}