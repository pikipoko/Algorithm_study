import sys
input = sys.stdin.readline
X = input()
num = 0
n16 = {'a' : 10, 'b' : 11, 'c' : 12, 'd' : 13, 'e' : 14, 'f' : 15}

if X[0] == '0':
    if X[1] == 'x':
        for i in range(len(X) - 2, 1, -1):
            if X[i] in n16:
                num += n16[X[i]] * (16 ** (len(X) - i - 2))
            else:
                num += int(X[i]) * (16 ** (len(X) - i - 2))
    else:
        for i in range(len(X) - 2, 0, -1):
            num += int(X[i]) * (8 ** (len(X) - i - 2))
else:
    num = int(X)
print(num)