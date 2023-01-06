import sys
input = sys.stdin.readline

N, M = map(int, input().split())

A = list(map(int, input().split()))
B = list(map(int, input().split()))

# 중복된 경우에는 2개 추가해줘야 됨.
i_A = 0
i_B = 0

result = list()

while i_A < len(A) and i_B < len(B):
    if A[i_A] < B[i_B]:
        result.append(A[i_A])
        i_A += 1
    else:
        result.append(B[i_B])
        i_B += 1
while i_A < len(A):
    result.append(A[i_A])
    i_A += 1
while i_B < len(B):
    result.append(B[i_B])
    i_B += 1

for i in range(len(result)):
    print(result[i], end=' ')
print()

# 집합으로 다시 -> 똑같으면 추가 안하는 게 아니라 똑같아도 추가해야됨.
# A = list(map(int, input().split()))
# B = list(map(int, input().split()))
# result = set(A)
# result.update(B)
# result = list(result)
# result.sort()
# for i in range(len(result)):
#     print(result[i], end=' ')
# print()

# 이렇게 풀면 시간 초과===========================================================
# A = list(map(int, input().split()))
# B = list(map(int, input().split()))

# insert_idx = 0

# for i in range(M):
#     if B[i] not in A:
#         A.append(B[i])
#         A.sort()

# for i in range(len(A)):
#     print(A[i], end=' ')
# print()


# 집합으로 풀면 안 풀림===========================================================
# N, M = map(int, input().split())

# A = list(map(int, input().split()))
# B = list(map(int, input().split()))

# result = list(set(A) | set(B))
# result.sort()
# for i in range(len(result)):
#     print(result[i], end=' ')
# print()