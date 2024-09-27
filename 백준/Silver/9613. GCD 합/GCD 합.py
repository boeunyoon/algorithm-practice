import sys
n = int(input())
def gcd(n1, n2):
    while n2 > 0:
        n1, n2 = n2, n1 % n2
    return n1
for _ in range(n):
    s = list(map(int, sys.stdin.readline().split()))
    answer = 0
    for i in range(1, len(s)):
        for j in range(i + 1, len(s)):
            answer += gcd(max(s[i], s[j]), min(s[i], s[j]))
    print(answer)