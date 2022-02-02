n = list(input())
n.sort(reverse=True)
sum = 0
for i in n:
    sum += int(i)
if sum % 3 != 0 or "0" not in n:  # 파이썬에서는 ' 와 " 구분 없음
    print(-1)
else:
    print(''.join(n))  # 공백으로 리스트를 연결해라
