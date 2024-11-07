def chisla(num):

    for ch0 in str(num):
        ch0 = int(ch0)

        if ch0 == 0 or num % ch0 != 0:
            return False
    return True

def find_num(n):
    result = []

    for num in range(1, n + 1):
        if chisla(num):
            result.append(num)
    return result

# Пример использования
n = int(input("Введите число n: "))
numbers = find_num(n)
print("Числа, которые делятся на каждую из своих цифр:", numbers) #вариант 8
