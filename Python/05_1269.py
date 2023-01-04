import sys
input = sys.stdin.readline

num_A, num_B = map(int, input().split())

As = set(input().split())
Bs = set(input().split())
intersection_len = len(As & Bs)

result = len(As) + len(Bs) - 2 * intersection_len
print(result)