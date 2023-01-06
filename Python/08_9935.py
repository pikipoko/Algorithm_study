import sys
input = sys.stdin.readline

norm = list(input().rstrip())
boom = input().rstrip()
result = ''

# 문자열이 폭발 문자열을 포함하고 있는 경우에, 모든 폭발 문자열이 폭발하게 된다.
# 남은 문자열을 순서대로 이어 붙여 새로운 문자열을 만든다.
# 남아 있는 문자열이 없는 경우 FRULA 출력
# 폭발 문자열은 같은 문자를 두 개 이상 포함X

while len(norm) > 0:
    pre = ''
    last_idx = len(boom) - 1
    for i in range(len(boom)-1, 0, -1):
        
        pre += norm.pop()
