#include <cstdlib>
#include <iostream>
#include <vector>
#include <climits>

using namespace std;

int main()
{
    long N, T; // N : 버스 개수, T : 영식이가 버스터미널에 도착한 시간

    scanf("%ld %ld", &N, &T);

    long result = LONG_MAX;

    for(long i = 0; i < N; i++)
    {
        long S;  // 버스의 시작 시각
        long I;  // 버스 간격
        long C;  // 버스 총 대수

        long tmp = -1;
        scanf("%ld %ld %ld", &S, &I, &C);

        if(T > S)
        {
            long diff = T - S;
            long count = (diff + I - 1) / I;
            if(count >= C )
            {
                continue;
            }
            tmp = S + count * I - T;
        }
        else
        {
            tmp = S - T;
        }

        if(tmp >= 0 && tmp < result)
            result = tmp;
    }

    if(result == LONG_MAX)
        result = -1;
    cout << result << endl;

    return EXIT_SUCCESS;
}