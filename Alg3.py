n = int(input())
m = int(input())
l = int(input())
if n == m == l:
    print("3")
if (n == m and m != l) or (l == m and m != n) or (l == n and m != n):
    print("2")
if n != l and l != m:
    print("1") ##во всех заданиях вариант 8##
