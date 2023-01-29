import sys
input = sys.stdin.readline

N, M, K = map(int, input().split())
nums = list(map(int, input().split()))

nums.sort()

result = (nums[N-1] * K + nums[N-2])*(int(M / (K+1))) + (M % (K+1)) * nums[N-1]

print(result)
