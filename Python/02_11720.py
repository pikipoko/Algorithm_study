import sys
input = sys.stdin.readline

N = int(input())
Ns = input()
result = 0
for i in range(N):
    result = result + int(Ns[i])
print(result)