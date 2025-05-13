#include <cstdlib>
#include <iostream>
#include <vector>

using namespace std;

int main()
{
    while(true)
    {

        int N, M;
        int cnt = 0;
    
        cin >> N >> M;

        if(N == 0 && M == 0)
            break;
    
        vector<int> Ns(N), Ms(M);

        for(int i = 0; i < N; i++)
            cin >> Ns[i];
        for(int i = 0; i < M; i++)
            cin >> Ms[i];

        int i = 0, j = 0;
        while(i < N && j < M)
        {
            if(Ns[i] == Ms[j])
            {
                cnt++;
                i++;
                j++;
            }
            else if(Ns[i] < Ms[j])
            {
                i++;
            }
            else
            {
                j++;
            }
        }
        cout << cnt << endl;
    }

    return EXIT_SUCCESS;
}