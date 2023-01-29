import sys
input = sys.stdin.readline

N, K = map(int, input().split())

cnt = 0

# while N % K != 0:
#     N = N - 1
#     cnt = cnt + 1
#     print(N)
# while N > 1:
#     N = (N / K)
#     cnt = cnt + 1
#     print(N)
while N > 1:
    if N % K == 0:
        N = (N / K)
        cnt += 1
    else:
        N = N - (N % K)
        cnt += N % K
    print(N)
print(cnt)
