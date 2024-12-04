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

input_file = "Trofimova_Anna_Y243.txt"
output_file = "Trofimova_Anna_Y243.txt"

with open(input_file, "r") as file:
    lines = file.readlines()

p = int(lines[0].strip())  # Первый элемент файла — порядок матрицы
k = int(lines[1].strip())  # Второй элемент файла — номер строки для деления
matrix = []

# Считываем матрицу из файла
for i in range(2, 2 + p):
    row = list(map(float, lines[i].strip().split()))
    matrix.append(row)


print("Исходная матрица:")
for lin in matrix:
    print(lin)

# Применяем деление строки
diagonal(matrix, k)

print("Матрица после деления элементов строки k на диагональный элемент:")
with open(output_file, "w") as file:
    for lin in matrix:
        print(lin)
        file.write(" ".join(map(str, lin)) + "\n")
