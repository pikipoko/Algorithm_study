import sys
input = sys.stdin.readline

N = int(input())

result = 2

while N > 1:
    if N % result == 0:
        N = int(N / result)
        print(result)
    else:
        result = result + 1