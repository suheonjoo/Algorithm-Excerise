dx = [1, -1, 0, 0, 1, -1, 1, -1]
dy = [0, 0, -1, 1, -1, -1, 1, 1]


def bfs(i, j):
    s[i][j] = 0
    queue = [[i, j]]
    while queue:  # 큐가 빌때까지 while문
        a, b = queue[0][0], queue[0][1]  # 큐에 들어간 제일 최근꺼에서 x,y 좌표 꺼내옴
        del queue[0]  # 꺼내온 큐를 빼내고
        for k in range(8):  # 해당 점 중심을 주변 점들 탐색함
            x = a+dx[k]
            y = b+dy[k]
            # 주변 점이 map 안에 있어야 하고, 방문가능한 길이어야함
            if 0 <= x < h and 0 <= y < w and s[x][y] == 1:
                s[x][y] = 0  # 해당길을 만족하면 이제는 길이 아닌 것으로 만들어주고
                queue.append([x, y])  # 큐에 넣어준다


while True:
    w, h = map(int, input().split())
    if w == 0 and h == 0:
        break
    s = []
    cnt = 0
    for i in range(h):
        s.append(list(map(int, input().split())))
    for i in range(h):
        for j in range(w):
            if s[i][j] == 1:
                bfs(i, j)
                cnt += 1
    print(cnt)
