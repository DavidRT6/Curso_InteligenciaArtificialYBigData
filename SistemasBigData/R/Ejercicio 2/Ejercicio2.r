## 1. Creación de la matriz
crear_matriz <- function(seed = 123, nrow = 5, ncol = 10, rango = 1:100) {
  set.seed(seed)
  matrix(sample(rango, nrow * ncol, replace = FALSE), nrow = nrow, ncol = ncol)
}


## 2. Cálculos estadísticos
# Media
calcular_medias <- function(matriz) {
  apply(matriz, 2, mean)
}

# Mediana
calcular_medianas <- function(matriz) {
  apply(matriz, 2, median)
}

# Varianza
calcular_varianzas <- function(matriz) {
  apply(matriz, 2, var)
}

# Desviación estándar
calcular_desviaciones <- function(matriz) {
  apply(matriz, 2, sd)
}


## 3. Representación gráfica
generar_graficos <- function(estadisticas) {
  par(mfrow = c(2, 2))

  # Gráfico medias
  barplot(estadisticas$medias, 
          main = "Media por columna", 
          col = rainbow(10), 
          xlab = "Columnas", 
          ylab = "Media", 
          names.arg = 1:10)

  # Gráfico medianas
  barplot(estadisticas$medianas, 
          main = "Mediana por columna", 
          col = rainbow(10), 
          xlab = "Columnas", 
          ylab = "Mediana", 
          names.arg = 1:10)

  # Gráfico varianzas
  barplot(estadisticas$varianzas, 
          main = "Varianza por columna", 
          col = rainbow(10), 
          xlab = "Columnas", 
          ylab = "Varianza", 
          names.arg = 1:10)

  # Gráfico desviaciones estándar
  barplot(estadisticas$desviaciones, 
          main = "Desviación estándar por columna", 
          col = rainbow(10), 
          xlab = "Columnas", 
          ylab = "Desviación estándar", 
          names.arg = 1:10)
  
  par(mfrow = c(1, 1))  # Para restaurar el formato original
}


## 4. Preguntas de análisis
analizar_estadisticas <- function(estadisticas) {
  # Pregunta 1
  media_maxima <- which.max(medias)
  print(media_maxima)
  print(medias[media_maxima])

  # Pregunta 2
  varianza_minima <- which.min(varianzas)
  print(varianza_minima)
  print(varianzas[varianza_minima])

  # Pregunta 3
  print(medianas)
  print(medias)

  # Estos prints sirven para conocer en qué casos la diferencia entre la media y la mediana es mayor o igual de 10.
  print((medianas - medias) >= 10)
  print((medias - medianas) >= 10)
}


### Ejecución del código.
## Paso 1
matriz <- crear_matriz()
print("Matriz creada:")
print(matriz)

## Paso 2
medias <- calcular_medias(matriz)
print("Media de cada columna:")
print(medias)

medianas <- calcular_medianas(matriz)
print("Mediana de cada columna:")
print(medianas)

varianzas <- calcular_varianzas(matriz)
print("Varianza de cada columna:")
print(varianzas)

desviaciones <- calcular_medias(matriz)
print("Desviacion estandar de cada columna:")
print(desviaciones)

estadisticas <- list(
  medias = medias,
  medianas = medianas,
  varianzas = varianzas,
  desviaciones = desviaciones
)

## Paso 3
generar_graficos(estadisticas)

## Paso 4
print("Estadisticas:")
analizar_estadisticas(estadisticas)