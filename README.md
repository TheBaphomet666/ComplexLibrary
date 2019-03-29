# ComplexLibrary

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/e57bb410a9e544b5bed5bf26795b9571)](https://app.codacy.com/app/TheBaphomet666/ComplexLibrary?utm_source=github.com&utm_medium=referral&utm_content=TheBaphomet666/ComplexLibrary&utm_campaign=Badge_Grade_Dashboard)

## This library is a calculator for Complex Numbers and Complex Matrices, that calcules and simulates Quantum Complex Systems.

# Allowed operations

## Complex Numbers

-  Addition
-  Substraction
-  Conjugation
-  Inverse
-  Multiplication
-  Divide
-  Modulus
-  Phase
-  Scalar Product
-  Showing as polar and as cartesian representation

## Complex Matrices

-  Addition
-  Substraction
-  Conjugation
-  Multiplication
-  Adjoint
-  Inverse
-  Tensor Product
-  Scalar Product
-  Hermitian
-  Unitary
-  Inner Product
-  Norm
-  Distance
-  Tensor Product
-  Transition Amplitude
-  MeanValue
-  Variance
-  Dinamic of a Sistem

## Simulations

-  Marble Experiment binary matriz
-  Marble Experiment weighted
-  Marble Experiment With Complex Numbers
-  Multiple Slits Experiment Probailistic
-  Multiple Slits Quantum
-  Probability of a found a particle in a certain position
-  Transition between two vectors



#### Experimento:
1. Utilizamos los siguientes elementos : Un laser , Una hoja de papel, un marcador negro y un bisturi
![elementos](https://github.com/Martin9958/CalculadoraDeComplejos/blob/master/imagenes/elementos.jpeg)
2. En la hoja blanca marcamos dos lineas paralelas negras y realizamos dos cortes paralelos (las cuales seran las renjillas)
![hoja](https://github.com/Martin9958/CalculadoraDeComplejos/blob/master/imagenes/rendijas.jpeg)
3. Apuntamos el laser a la hoja anterior y esta nos resultara con el siguiente patron (OJO! la idea para visualizar esto es estando en un cuarto con poca luz):
![resultado](https://github.com/Martin9958/CalculadoraDeComplejos/blob/master/imagenes/resultado.jpeg)


Cuando la luz llega a la doble rendija, cada una de estas rendijas actuará como un foco emisor secundiaro. Por lo tanto se crearán dos ondas que interferirán, veremos como hay regiones con mucha intensidad (interferencia constructiva de la ondas) y otras regiones con poca intensidad (interferencia destructiva de las ondas). Esto es lo que llamamos patrón de interferencia.
![patronOndas](https://github.com/Martin9958/CalculadoraDeComplejos/blob/master/imagenes/Double-slit.png)

Ahora al repetir este experimento pero lanzando electrones. Los electrones son partículas elementales que se han de describir según las leyes de la mecánica cuántica. Para realizar el experimento seguiremos las siguientes pautas:
- Lanzaremos un electrón y esperaremos a que llegue a la pantalla detectora.
- Seremos cuidadosos de no tener nunca más de un electrón en vuelo.
Siguiendo estas reglas se obtiene el siguiente patron:

![DobleRendijaCuantica](https://github.com/Martin9958/CalculadoraDeComplejos/blob/master/imagenes/dobleexperiment.jpg)

Lo primero que se observa es que los electrones llegan a la pantalla y colisionan con ella en regiones localizadas. Esto nos lleva a pensar que se comportan como electrones.
Si dejamos que el experimento avance, conforme se van acumulando tales colisiones vemos algo asomboroso. Se comienza a formar un patrón de franjas con áreas de mucha intensidad y areas de poca intensidad. Estamos recostruyendo un patrón de interferencias. Parece lógico que el electrón, cuando ha estado en vuelo desde las rendijas hasta la pantalla, se ha comportado como una onda.


## Running tests
To run automated tests just type:
```
mvn test
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* Java

## Authors
-  [Oscar Pinto](https://github.com/TheBaphomet666)
