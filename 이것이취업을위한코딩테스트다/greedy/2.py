import sys
import time
input = sys.stdin.readline

N, M = map(int, input().split())


####
result = 0
sum_time = 0
for i in range(N):
    data = list(map(int, input().split()))
    start_time = time.time()
    min_value = min(data)
    result = max(result, min_value)
    end_time = time.time()
    sum_time = sum_time + end_time - start_time

print(result, "min, max 걸린 시간 :", sum_time)

####
result = 0
sum_time = 0
for i in range(N):
    data = list(map(int, input().split()))
    start_time = time.time()
    min_value = 10001
    for a in data:
        min_value = min(min_value, a)
    result = max(result, min_value)
    end_time = time.time()
    sum_time = sum_time + end_time - start_time

print(result, "2중 반복문 걸린 시간 :", sum_time)

# 내가 짠 코드
biggest = [0, 0]
sum_time = 0
for i in range(N):
    cards = list(map(int, input().split()))
    start_time = time.time()
    cards.sort()
    if (biggest[1] < cards[0]):
        biggest[0] = i
        biggest[1] = cards[0]
    end_time = time.time()
    sum_time = sum_time + end_time - start_time

print(biggest[1], "걸린 시간 :", sum_time)
