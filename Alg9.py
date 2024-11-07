def diagonal(matrix, k):
    if k < 0 or k >= len(matrix):
        print("Ошибка: индекс строки вне диапазона.")
        return

    diagonal_elem = matrix[k][k]      
    # Проверка, что диагональный элемент не равен нулю, чтобы избежать деления на ноль
    if diagonal_elem == 0:
        print("Ошибка: диагональный элемент равен нулю, деление невозможно.")
        return

    # Делим каждый элемент k-й строки на диагональный элемент
    matrix[k] = [elem / diagonal_elem for elem in matrix[k]]

p = int(input("Введите порядок матрицы p: "))
k = int(input("Введите номер строки k для деления: "))

# Инициализация и ввод элементов матрицы
matrix = []
print("Введите элементы матрицы построчно:")
for i in range(p):
    lin = list(map(float, input(f"Строка {i+1}: ").split()))
    matrix.append(lin)

print("Исходная матрица:")
for lin in matrix:
    print(lin)

diagonal(matrix, k)

print("Матрица после деления элементов строки k на диагональный элемент:")
for lin in matrix:
    print(lin)
