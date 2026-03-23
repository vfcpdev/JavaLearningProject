# Guía Práctica: Paso a paso para Programar Java en IntelliJ IDEA
*Basado en la currícula oficial técnica de [dev.java/learn](https://dev.java/learn/intellij-idea/)*

## 1. Visión General e Instalación de IntelliJ
**IntelliJ IDEA** (construido por JetBrains) es considerado abrumadoramente como el IDE de mayor eficiencia en la industria moderna de desarrollo Java debido a su editor hiperconectado.
Te otorga poderes automatizados como compilar, testear, auto-completar sintaxis, acceder a herramientas de Git y manipular árboles del proyecto que tu sistema de archivos normal o cmd no podrían analizar sin romper vínculos.

**Pasos de Instalación**:
1. Accede a la página central de [JetBrains](https://www.jetbrains.com/idea/) y descarga IntelliJ IDEA.
2. Tras instalarlo, recibirás una prueba Ultimate (Profesional), pero puedes escoger la capa "Community" que será **ilimitada y gratuita**, bastando perfectamente para cubrir el lado algorítmico y de micro-servicios en Java.
3. El editor te va a autoconfigurar todo el motor JDK (Java Development Kit) sin tener que instalarlo tú manualmente en Windows.

## 2. Creando un Nuevo Proyecto Limpio
1. Tras abrirlo por primera vez verás un **Welcome screen** (pantalla de bienvenida), haz clic derecho sobre **New Project**.
2. Verifica solemnemente que el filtro izquierdo resalte **"Java"**, y especifica el nombre en el sistema superior, por ejemplo: `mi-app-financiera`.
3. Es imperativo seleccionar un sistema de constucción de Paquetes. La directiva prefiere marcar **Maven**. Esto instalará el core del Build System alojando dependencias dentro del clásico archivo maestro `<pom.xml>`.
4. Cerciora o selecciona un motor JDK (Sugerido > JDK 17, 21 o superior). Da clic al recuadro de **Create**.

## 3. Escritura Inmersiva y Edición
Dentro del editor, debes fijarte en la caja izquierda (*Project Tool Window*), la carpeta primordial siempre debe ser `src/main/java`.

* Puedes crear un código pulsando `Click Derecho -> New Java Class`.
* IntelliJ posee características revolucionarias de auto-completado que aceleran un 90% tu velocidad. Para generar nuestra función estándar tan solo debes presionar la sintaxis:
  ```java
  public class HelloWorld {
      public static void main(String[] args) {
          System.out.println("Hello World!");
      }
  }
  ```
* **Atajos Dinámicos**:
  - `Alt + Insert`: Despliega un menú flotante para inyectar inteligentemente constructores repetitivos, Getters/Setters, `.toString()` o HashCodes sin que tipezes una sola letra extra.
  - `Ctrl + Alt + L`: Pre-formatea tu clase indetando márgenes en milisegundos.
  - Escribir `sout` y dar tecla TAB despliega un `System.out.println()` vacío y precentrado.

## 4. Ejecución Inmediata de la Aplicación
Con IntelliJ te liberas absolutamente de abrir la consola de comandos de Windows para estar tecleando largas matrices de instrucción tipo `javac Clase.java && java Clase`.
* Todo lo que debes hacer es presionar el **Botón Verde de Play (▶️ Run)** alogajo justo al lado del número de línea en la directiva `main`.
* Se levantará una sub-ventana limpia con tu terminal integrada exhibiendo las secuencias de prints sin obstruir el flujo.

## 5. Depuración Científica de Anomalías (Debugging)
Una práctica de las grandes ligas para solucionar pantallas negras o colapsos de variables mal instanciadas donde un bucle detiene todo el servidor:

1. **Inyección de Breakpoints**: Sitúa tu mouse sobre los marcadores grises (junto al número de la línea afectada) y da click. Verás aparecer un círculo escarlata intenso (🔴).
2. Lanza el código pero no hundas el Play Verde, selecciona su vecino contiguo: el **Bicho Insecto 🐞 (Start Debugging)**.
3. El reloj del sistema **Se congelará en tiempo y el espacio** exactamente cuándo tu aplicación vaya cruzando esa instrucción.
4. **Análisis Computacional**: Podrás pasar tu mouse sobre las variables o abrir la pestaña *Evaluate Expression* para inyectar condiciones "Y qué pasaría sí yo cambio su valor aquí?". Con esto evitas adivinar cómo y cuándo ocurrió una `AritmethicException` u `OutOfMemory` observándolo pasar y detenerse a 2 centímetros de tus ojos.
