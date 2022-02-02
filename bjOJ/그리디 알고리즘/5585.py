a = 1000-int(input())
b = [500, 100, 50, 10, 5, 1]
count = 0
for i in b:
    # 파이썬에서는 //는 몫을 의미
    count += a//i
    a %= i
print(count)
