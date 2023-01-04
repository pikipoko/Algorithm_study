import sys
input = sys.stdin.readline

lstk = list(input().rstrip())
rstk = list()

COMMAND = 0
PARAMETER = 2

# L     : 커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
# D     : 커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
# B     : 커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨)
#         삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로임
# P $   : $라는 문자를 커서 왼쪽에 추가함

for _ in range(int(input())):
    cmd = input()
    if cmd[COMMAND] == 'L':
        if lstk:
            rstk.append(lstk.pop())

    elif cmd[COMMAND] == 'D':
        if rstk:
            lstk.append(rstk.pop())
    elif cmd[COMMAND] == 'B':
        if lstk:
            lstk.pop()
    elif cmd[COMMAND] == 'P':
        lstk.append(cmd[PARAMETER])
    else:
        continue
lstk.extend(reversed(rstk))
print(''.join(lstk))