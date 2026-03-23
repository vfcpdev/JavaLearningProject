# 📚 Proyecto de Aprendizaje de Java (Java Learning Project)

¡Bienvenido al repositorio interactivo para aprender Java! 🚀 Este proyecto está diseñado para enseñarte los fundamentos, conceptos orientados a objetos y aspectos avanzados del lenguaje de programación Java, organizados progresivamente.

## 🎯 Objetivos del Proyecto

1. **Facilitar el aprendizaje:** Proveer un recurso centralizado con código fácil de entender y ejecutar.
2. **Progresión natural:** Ir desde las estructuras más básicas hasta características avanzadas de Java moderno.
3. **Práctica constante:** A través de ejemplos comentados y proyectos modulares integradores.

## 📂 Estructura de Contenido

El código ha sido organizado temáticamente dentro de `src/com/javalearning`:

* **`lesson01_basics`**: Variables, tipos de datos, operadores y sintaxis fundamental.
* **`lesson02_controlflow`**: Ciclos (`for`, `while`), estructuras condicionales (`if/else`) y `switch`.
* **`lesson03_oop`**: Clases, herencia, polimorfismo, interfaces y encapsulamiento.
* **`lesson04_collections`**: Listas (`List`), Mapas (`Map`), Conjuntos (`Set`).
* **`lesson05_advanced`**: Excepciones, Streams API, Expresiones Lambda y Generics.
* **`lesson06_projects`**: Pequeños proyectos prácticos integradores (ej. calculadoras, gestores simples).

>(*Nota: Los nombres de los paquetes adoptan el formato `lessonXX_nombre` ya que Java no permite que los nombres de los directorios de paquetes comiencen con números.*)

## ⚡ Requisitos Previos

* **Java Development Kit (JDK):** Versión 17 o superior instalada.
* **Editor/IDE:** Visual Studio Code, IntelliJ IDEA, o Eclipse.
* *(Opcional)* **Maven:** Para gestión de dependencias y pruebas unitarias (JUnit).

## 🚀 Instrucciones de Configuración y Ejecución

Puedes compilar y ejecutar el proyecto de diversas maneras:

### 1. Usando los Scripts proporcionados (Windows)
Si estás en Windows y no utilizas Maven temporalmente, tienes dos scripts batch preparados:
* Para compilar y ejecutar la Consola (CLI):
  ```bat
  compile_and_run_cli.bat
  ```
* Para compilar y ejecutar la Interfaz Gráfica (GUI):
  ```bat
  compile_and_run_gui.bat
  ```

### 2. Usando Maven (Recomendado)
El proyecto incluye un archivo `pom.xml` preconfigurado.
* Para compilar el proyecto:
  ```bash
  mvn clean compile
  ```
* Para ejecutar los tests (JUnit):
  ```bash
  mvn test
  ```
* Para correr la clase Principal (una vez compilado):
  ```bash
  mvn exec:java -Dexec.mainClass="com.javalearning.Main"
  ```

## 🤝 Colaboración y Comunidad
* Usa **GitHub Discussions** si tienes dudas o quieres debatir un concepto.
* ¿Tienes un ejemplo interesante? Envía un **Pull Request** para enriquecer las lecciones.

¡Feliz aprendizaje programando en Java! ☕
