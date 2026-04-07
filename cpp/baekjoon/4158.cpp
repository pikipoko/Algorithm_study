#include <cstdio>
#include <vector>

int main() {
    while (true) {
        int N, M;
        if (scanf("%d %d", &N, &M) != 2) break;
        if (N == 0 && M == 0) break;

        std::vector<int> Ns(N), Ms(M);
        for (int i = 0; i < N; ++i)
            scanf("%d", &Ns[i]);
        for (int i = 0; i < M; ++i)
            scanf("%d", &Ms[i]);

        int i = 0, j = 0, cnt = 0;
        while (i < N && j < M) {
            if (Ns[i] == Ms[j]) {
                cnt++;
                i++;
                j++;
            } else if (Ns[i] < Ms[j]) {
                i++;
            } else {
                j++;
            }
        }

        printf("%d\n", cnt);
    }
    return 0;
}
