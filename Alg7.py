def sumpr(numbers):
    ss = sum(numbers)
    sp = 1  
    for num in numbers:
        sp *= num  
    
    return ss, sp

numbers = [2, 3, 4]  
ss, sp = sumpr(numbers)  
print(f"Сумма элементов: {ss}")
print(f"Произведение элементов: {sp}")

def replace_zzz(cp):

    mean = sum(cp) / len(cp) if len(cp) > 0 else 0

    new_mas = [mean if x == 0 else x for x in cp]
    return new_mas


cp = [1, 0, 3, 0, 5]  
new_mas = replace_zzz(cp)
print(f"Новый массив: {new_mas}") #вариант 8

