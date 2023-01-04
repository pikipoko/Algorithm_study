import sys
input = sys.stdin.readline

in_text = input().rstrip()

M = int(input())
cursor = len(in_text)
COMMAND = 0
PARAMETER = 2

# L     : 커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
# D     : 커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
# B     : 커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨)
#         삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로임
# P $   : $라는 문자를 커서 왼쪽에 추가함

for i in range(M):
    cmd = input()
    if cmd[COMMAND] == 'L':
        if cursor <= 0:
            continue
        cursor -= 1
    elif cmd[COMMAND] == 'D':
        if cursor >= len(in_text):
            continue
        cursor += 1
    elif cmd[COMMAND] == 'B':
        if cursor <= 0:
            continue
        cursor -= 1
        in_text = in_text[:cursor] + in_text[cursor+1:]
    elif cmd[COMMAND] == 'P':
        in_text = in_text[:cursor] + cmd[PARAMETER] + in_text[cursor:]
        cursor += 1
    else:
        continue

print(in_text)