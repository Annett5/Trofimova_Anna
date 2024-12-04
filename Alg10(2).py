def transpose(matrix):
    n = len(matrix)
    for i in range(n):
        for j in range(i + 1, n):
            matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]

input_file = "Trofimova_Anna_Y243.txt"
output_file = "Trofimova_Anna_Y243.txt"

with open(input_file, "r") as file:
    lines = file.readlines()

# Первый элемент файла — порядок матрицы
n = int(lines[0].strip())

# Считываем матрицу из файла
matrix = []
for i in range(1, n + 1):
    row = list(map(int, lines[i].strip().split()))
    matrix.append(row)

# Вывод исходной матрицы
print("Исходная матрица:")
for row in matrix:
    print(row)

# Выполняем транспонирование
transpose(matrix)

# Вывод транспонированной матрицы на экран и запись в файл
print("Транспонированная матрица:")
with open(output_file, "w") as file:
    for row in matrix:
        print(row)
        file.write(" ".join(map(str, row)) + "\n")
