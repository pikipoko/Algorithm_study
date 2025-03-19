#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
char* solution(const char* s) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    int i = 0, j, a;
    int len = strlen(s);
    int alen = 'z' - 'a' + 1;
    char* answer = (char*)malloc(len+1);
    char* scnt = (char*)malloc(alen);
    char* bcnt = (char*)malloc(alen);
    
    memset(scnt, 0, alen);
    memset(bcnt, 0, alen);
    memset(answer, 0x00, len+1);
    
    for(; i < len; i++)
    {
        if(s[i] >= 'a' && s[i] <= 'z')
        {
            scnt[s[i] - 'a']++;
        }
        else
        {
            bcnt[s[i] - 'A']++;
        }
    }
    
    for(i = alen - 1, a = 0; i >= 0; i--)
    {
        for(j = 0; j < scnt[i]; j++)
        {
            answer[a++] = 'a' + i;
        }
    }
    
    for(i = alen - 1; i >= 0; i--)
    {
        for(j = 0; j < bcnt[i]; j++)
        {
            answer[a++] = 'A' + i;
        }
    }
    
    return answer;
}