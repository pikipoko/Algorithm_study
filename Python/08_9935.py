import sys
input = sys.stdin.readline

original_str = list(input().rstrip())
boom = list(input().rstrip())

org_i = 0
while org_i < len(original_str) and len(original_str) > 0:
    pre_str = original_str[org_i:org_i+len(boom)]
    if pre_str == boom:
        original_str = original_str[:org_i] + original_str[org_i+len(boom):]
        org_i -= 1
    else:
        org_i += 1

if(len(original_str) == 0):
    print("FRULA")
else:
    print(''.join(s for s in original_str))