def swap_first_last(a):
    if len(a) > 1:
        a[0], a[-1] = a[-1], a[0]
m = int(input("Введите длину массива m: "))

A = []
print("Введите элементы массива:")
for i in range(m):
    element = int(input(f"Элемент {i+1}: "))
    A.append(element)

print("Исходный массив:", A)

swap_first_last(A)

print("Массив после замены первого и последнего элемента:", A)
