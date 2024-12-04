def is_prime(n):
    if n <= 1:
        return False
    for i in range(2, int(n ** 0.5) + 1):
        if n % i == 0:
            return False
    return True

n = int(input("Введите натуральное число n > 1: "))
if is_prime(n):
    print("yes")
else:
    print("No")

def find_max():
    num = int(input("Введите число: "))
    if num == 0:
        return float('-inf')  # Минимальное значение для начальной проверки
    else:
        next_max = find_max()
        return max(num, next_max)

print("Введите последовательность чисел, оканчивающуюся на 0:")
max_value = find_max()
print("Максимум в последовательности:", max_value)
