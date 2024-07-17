n = int(input())
arr = sorted(list(map(int, input().split())))
x = int(input())

check = [0] * 2000000
cnt = 0
for i in arr:
    if check[x - i] == 1:
        cnt += 1
    check[i] = 1

print(cnt)