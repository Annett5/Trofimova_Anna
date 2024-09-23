import math

x = -2.235 * 10**-2 
y = 2.23 
z = 15.221 

numerator = math.exp(abs(x - y)) * abs(x - y)**(abs(x + y))

denominator = math.atan(x) + math.atan(z)

first_part = numerator / denominator

second_part = (x**6)**(1/3) + math.log(y)**2

s = first_part + second_part
print(f"{s:.4f}")