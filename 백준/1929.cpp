#include <iostream>
#include <cstdlib>
#include <vector>

using std::cin;
using std::cout;
using std::endl;
using std::vector;


int main()
{
    int M, N;

    cin >> M >> N;

    vector<bool> isPrime(N + 1, true);

    isPrime[0] = isPrime[1] = false;

    for(int i = 2; i*i <= N; i++)
    {
        for(int j = i*i; j <= N; j+=i)
        {
            isPrime[j] = false;
        }
    }

    for(int i = M; i <= N; i++)
    {
        if(isPrime[i])
            cout << i << endl;
    }
    return EXIT_SUCCESS;
}
