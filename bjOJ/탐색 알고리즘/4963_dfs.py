
import sys
read = sys.stdin.readline
sys.setrecursionlimit(10000)


def dfs(x, y):
    dx = [1, 1, -1, -1, 1, -1, 0, 0]
    dy = [0, 1, 0, 1, -1, -1, 1, -1]

    field[x][y] = 0 #해당 점을 들어갔다고 했으므로 0으로 값을 바꿔준다
    for i in range(8):  #기준 정점 기준으로 주변을 둘러본다
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < h and 0 <= ny < w and field[nx][ny] == 1:
            #주변 정점이 2차 배열 안에 있고 해당 길 있는 경우
            dfs(nx, ny) #dfs로 또다시 순회한다
            


while True:
    w, h = map(int, read().split())
    if w == 0 and h == 0:
        break
    field = []
    count = 0
    for _ in range(h):  #2차 배열로 한줄씩 받아 온다
        field.append(list(map(int, read().split())))
    for i in range(h):
        for j in range(w):
            if field[i][j] == 1:    #길이 있는 경우 dfs로 들어간다
                dfs(i, j)
                count += 1
    print(count)
