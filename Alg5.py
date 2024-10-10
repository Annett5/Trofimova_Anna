pred = -1
dlin = 1
maxs = 1
while True:
    n = int(input())
    if n == 0:
        break
    if n == pred:
        dlin += 1
    else:
        dlin = 1
    if dlin > maxs:
        maxs = dlin
    pred = n
print(maxs)
    


    
