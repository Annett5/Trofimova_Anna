def transpose(matrix):
    n = len(matrix)
    
    for i in range(n):
        for j in range(i + 1, n):
            matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]

n = int(input("Введите порядок квадратной матрицы n: "))

matrix = []
print("Введите элементы матрицы построчно:")
for i in range(n):
    linya = list(map(int, input(f"Строка {i+1}: ").split()))
    matrix.append(linya)

print("Исходная матрица:")
for linya in matrix:
    print(linya)

transpose(matrix)

print("Транспонированная матрица:")
for linya in matrix:
    print(linya)
