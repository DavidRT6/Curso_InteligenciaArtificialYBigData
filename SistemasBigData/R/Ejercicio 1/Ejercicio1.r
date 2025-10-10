## 1. Creación de la matriz
set.seed(123)
matriz <- matrix(sample(1:100, 50, replace = FALSE), nrow = 5, ncol = 10)
#print(matriz)


## 2. Cálculos estadísticos
# Media
medias <- apply(matriz, 2, mean)
#print("Media de cada columna:")
#print(medias)

# Mediana
medianas <- apply(matriz, 2, median)
#print("Mediana de cada columna:")
#print(medianas)

# Varianza
varianzas <- apply(matriz, 2, var)
#print("Varianza de cada columna:")
#print(varianzas)

# Desviación estándar
desviaciones <- apply(matriz, 2, sd)
#print("Desviación estándar de cada columna:")
#print(desviaciones)


## 3. Representación gráfica
par(mfrow=c(2,2))

# Gráfico medias
barplot(medias, 
        main = "Media por columna", 
        col = rainbow(10), 
        xlab = "Columnas", 
        ylab = "Media", 
        names.arg = 1:10)

# Gráfico medianas
barplot(medianas, 
        main = "Mediana por columna", 
        col = rainbow(10), 
        xlab = "Columnas", 
        ylab = "Mediana", 
        names.arg = 1:10)

# Gráfico varianzas
barplot(varianzas, 
        main = "Varianza por columna", 
        col = rainbow(10), 
        xlab = "Columnas", 
        ylab = "Varianza", 
        names.arg = 1:10)

# Gráfico desviaciones estándar
barplot(desviaciones, 
        main = "Desviación estándar por columna", 
        col = rainbow(10), 
        xlab = "Columnas", 
        ylab = "Desviación estándar", 
        names.arg = 1:10)

# Para restaurar el formato original y que no dé errores luego
par(mfrow = c(1, 1))


## 4. Preguntas de análisis
#which.max(medias)
#print(medias[7])

#which.min(varianzas)
#print(medias[9])

print(medianas)
print(medias)