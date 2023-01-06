import sys
input = sys.stdin.readline

word_num = int(input())
numbers = ['1', '2', '3', '4', '5', '6', '7', '8', '9', '0']

strs = input()
result = 0
temp_num = ''

for i in range(word_num):
    if strs[i] in numbers:
        temp_num += strs[i]
    else:
        if temp_num != '':
            result += int(temp_num)
        temp_num = ''
if temp_num != '':
    result += int(temp_num)
print(result)