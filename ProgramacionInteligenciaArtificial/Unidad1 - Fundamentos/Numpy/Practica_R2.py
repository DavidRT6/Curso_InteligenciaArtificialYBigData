import numpy as np

# R2 = coeficiente de determinación
def calcularR2(y_real, y_predicho):
    numerador = np.sum((y_real - y_predicho) ** 2)
    denominador = np.sum((y_real - np.mean(y_real)) ** 2)

    r2 = 1 - (numerador / denominador)
    return r2


y_real = np.array([3, -0.5, 2, 7, 4.2])
y_predicho = np.array([2.5, 0.0, 2, 8, 4.1])

# Manera 1
resultado = np.round(calcularR2(y_real, y_predicho), 2)
print(f"Manera 1:\nEl coeficiente de determinación es: {resultado}")

# Manera 2
resultado = calcularR2(y_real, y_predicho)
print(f"Manera 2:\nEl coeficiente de determinación es: {resultado:.2f}")

print()