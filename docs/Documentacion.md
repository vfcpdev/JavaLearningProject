# Documentación del Proyecto: Aprendizaje de Java (CLI & GUI)

Este proyecto está diseñado metódicamente para enseñar de forma paralela conceptos estructurados, algoritmia y programación orientada a objetos en Java mediante ejemplos por consola (CLI) y pantallas de usuario interactivas (Swing GUI). 

A continuación se detalla cada uno de los temas y ejercicios formalmente desarrollados a lo largo del material.

## 1. Tipos de Datos (Primitivos y Complejos)
* **Nombres de Código**: `DataTypesCLI.java`, `DataTypesGUI.java`
* **Explicación**: Demuestra los tipos primitivos nativos disponibles bajo reserva de memoria estricta en Java (byte, short, int, long, float, double, boolean, char) y los tipos de referencia básicos (clase `String`).
* **Datos a usar**: El sistema utiliza variables auto-inyectadas estáticamente para visualización.
* **Resultados esperados**: Impresión descriptiva de los diferentes tamaños en memoria y ejemplos prácticos guardados en sus asignaciones primitivas (Ej. Entero de 32 bits, Decimal de doble precisión).

## 2. Operaciones Matemáticas
* **Nombres de Código**: `MathOpsCLI.java`, `MathOpsGUI.java`
* **Explicación**: Exposición elemental sobre el uso de operadores aritméticos (`+`, `-`, `*`, `/`, módulo `%`) y funciones complementarias de la librería estándar `java.lang.Math` (por ejemplo, iteraciones de `Math.sqrt` y `Math.pow`).
* **Datos a usar**: En la interfaz gráfica (GUI), el usuario debe ingresar dos números numéricos válidos en las cajas de texto (Ej. `Número 1: 15` y `Número 2: 4`).
* **Resultados esperados**: El sistema emite calculadamente y de forma visual el resultado al pulsar cada operación (Suma, Resta, Multiplicación y División). Brindando además protección ante excepciones como *divisiones computacionales por cero*.

## 3. Estructuras de Datos
* **Nombres de Código**: `DataStructuresCLI.java`, `DataStructuresGUI.java`
* **Explicación**: Introducción a los contenedores y estructuración de memoria dinámica nativos del ecosistema Java Collection Framework. Explicación y usabilidad precisa de `ArrayList` para listas extensibles en ram, y la implementación de `HashMap` para tablas y acceso rápido mediante mapas de Clave-Valor (`Key-Value`).
* **Datos a usar**: Inserción estringente. En la App de ventanas el usuario emplea un campo dinámico de texto para agregar strings seriales uno detrás de otro como: `"Concepto de Java"`.
* **Resultados esperados**: Actualización algorítmica inmediata en la Interfaz (ListModel asociado a control `JList`), exponiendo en tiempo real cómo cambia y muta internamente el contenido y la longitud del arreglo.

## 4. Estructuras Algorítmicas Básicas
* **Nombres de Código**: `AlgorithmicStructuresCLI.java`, `AlgorithmicStructuresGUI.java`
* **Explicación**: Demuestra la conjunción de las 3 ramificaciones fundamentales (Asignación, Condicionales con `if`/`else` y Repeticiones iterativas `for` / `while`). Ejemplos enfocados directamente a ámbitos prácticos para un **Ingeniero de Sistemas u Operador de Infraestructura** (gestión de carga e interpretación de Logs).
* **Datos a usar**: Por defecto, utiliza porcentajes variables de métricas y lecturas condicionalizadas (Como CPU superando el \> 80%).
* **Resultados esperados**: Impresión de Alerta en pantalla por consumo, desvío automático del flujo dependiento de la condicional, y bucles lógicos que escanean de forma exhaustiva los puertos y finalizan exitosamente cuando una IP ficticia devuelve respuesta.

## 5. Funciones y Métodos
* **Nombres de Código**: `MethodsAndFunctionsCLI.java`, `MethodsAndFunctionsGUI.java`
* **Explicación**: Aborda la programación modular de forma simple: Creación de funciones aisladas simples (`void`), manejo transaccional de Argumentos y requerimiento de Parámetros de Retorno, procesamiento robusto aplicando métodos sub-encapsulados como particiones condicionales de cadena, e inclusión sobre qué es la **Recursión**.
* **Datos a usar**: 
  - *Recursión*: Toma la entrada de un parámetro numérico `N` (entero preferiblemente máximo de 12 para evitar el rebase del buffer u "overflow" int). Ej. Input `5`.
  - *Cadenas*: Un texto que contenga arroba de tipo dominio real. Ej. `desarrollador@empresa.com`.
* **Resultados esperados**: Transforma el dato entrante utilizando las funciones (Ej factorial devuelve visualmente el valor `120`); Asimismo la función de cadena parte textualmente el correo, censurando automáticamente partes centrales de este logrando el enmascaramiento exitoso como `de****@empresa.com`.

## 6. Programación Orientada a Objetos (POO)
* **Nombres de Código**: `OOPCLI.java`, `OOPGUI.java`
* **Explicación**: Inyección de instancias relógicas en Java. Establece la diferencia entre un molde vacío (`Class`) y un ente viviente en el segmento referenciado (`Instancia`), a la vez que se explican características vitales como la **Herencia** (sub-clases que descienden desde padres lógicos) y **Polimorfismo** (clásicamente implementado refactorizando y sobrecribiendo funciones usando la notación estricta `@Override`).
* **Datos a usar**: Acciones mediadas por el usuario. Permite presionar botones que construyen en tiempo real entidades `Empleado` e `Ingeniero` (ambas interlazadas genéticamente por herencia).
* **Resultados esperados**: Distintos comportamientos mostrados y sobreescritos en vivo durante la respuesta del sistema al invocar métodos superpuestos que comparten idénticamente el mismo nombre, exponiendo en su totalidad el verdadero de diseño Polimórfico de Java.

## 7. Manejo Probabilizado de Excepciones
* **Nombres de Código**: `ExceptionsCLI.java`, `ExceptionsGUI.java`
* **Explicación**: Práctica formal sobre la prevención estandarizada del colapso (Crashes de máquina virtual). Envuelve código riesgoso y de entrada foránea en directivas estrictas de captura de control de fallos: `try {}`, con control diferencial `catch(Exception)` y garantías de liberación absoluta `finally {}`.
* **Datos a usar**: Numerador y Denominador numérico. Se incita a intentar crear un fallo catastrófico forzado metiendo un valor denominador igual a `0`, o metiendo simples caracteres como `"ABC"`.
* **Resultados esperados**: Contrario al quiebre de la App Java, la Interfaz GUI es capaz de capturar en el acto fallos sistémicos graves. Avisará con letras escarlata que ocurrió un error formal como un `ArithmeticException` para divisiones imposibles, o `NumberFormatException` en caso de letras no computables. En el plano terminal, el bloque `finally` se ejecuta indudablemente.

## 8. Arreglos de Tamaño Fijo, N Dimensionales y Utilidades
* **Nombres de Código**: `FixedSizeArraysCLI.java`, `FixedSizeArraysGUI.java`
* **Explicación**: Despliegue técnico enfocados estrictamente a la Declaración e Inicialización fija (`int[] arr = new int[5]`). Aborda formas recurrentes de navegar el interior, empleo de herramientas encapsuladas como `java.util.Arrays`, profundización matemática de extracción estadística (por ejemplo para obtener Desviaciones), y escalabilidad tridimensional hacia Matrices (`2D`) y cubos formales de datos extra-espaciales (`3D y superior`).
* **Datos a usar**: Conjunto de series de ingresos. Por ejemplo: Un formato listado y segmentado específicamente por comas de este modo: `12, 15, 20, 10, 14`.
* **Resultados esperados**: 
  - La aplicación internamente particiona, escanea y recorre algorírmicamente los dígitos para insertarlos a un `Arreglo Fijo`.
  - Emplea un Sorting ascendente sobre todos y el listado resultante se concatena ordenadamente usando `Arrays.toString`.
  - Recién transformado, se somete a una función computacional customizada que arrojará explícitamente el cálculo final de la `Desviación Estándar (σ)`.
  - Imprime demostraciones técnicas comprobando cómo Java permite el acceso de índices encadenados como `matriz[1][2]` en planos bidimensionales, e imposiciones tridimensionales de tipo `cubo[0][1][1]`.

## 9. Contenedores Estándar de Datos
* **Nombres de Código**: `StandardContainersCLI.java`, `StandardContainersGUI.java`
* **Explicación**: Ejemplificación de las estructuras dinámicas provistas por la librería estándar basadas en paradigmas teóricos. Incluye `Listas y Arreglos` (`ArrayList`), `Pilas` (Stacks basadas en LIFO - Last-In-First-Out), `Colas Clásicas` (Queues FIFO - First-In-First-Out) instanciadas mediante `LinkedList()`, y `Colas de Prioridad` (`PriorityQueue`) ordenadas nativamente.
* **Datos a usar**: Interacción manual apilando y formacionando elementos, o insertando valores enteros de prioridad customizada.
* **Resultados esperados**: Los contenedores revelarán en todo momento la agrupación de sus datos, permitiendo comprobar que el Stack saca al último en llegar (`pop`), la Cola atiende al más antiguo (`poll`), y la Priority Queue extrae invariablemente al elemento de menor valor absoluto (prioridad ascendente).

## 10. Modificadores Gráficos y Estéticos de GUI
* **Nombres de Código**: `GraphicalCustomizationGUI.java`
* **Explicación**: Demuestra cómo alterar programáticamente clases de la librería gráfica visual.
* **Datos a usar**: Interacciones de Hardware del usuario mediante clics sobre el JPanel general.
* **Resultados esperados**: Alteración estética masiva que transmuta el esquema Color.WHITE al clásico modo oscuro usando inyección RGB hexadecimal y reemplazos de ComponentFont.

## 11. Contenedores de Datos No Lineales
* **Nombres de Código**: `NonLinearContainersCLI.java`, `NonLinearContainersGUI.java`
* **Explicación**: Colecciones profundas nativas para filtrado (como los Blacklists con Colecciones Set / `HashSet`) e Indexado o emparejamiento usando Modelos Entidad-Relación lógicos (A través del uso de un Mapa/Diccionario en formato `HashMap`).
* **Datos a usar**: Simulaciones de Firewalls ingresando Listas de IPv4 y Direcciones MAC exclusivas. Y emparejamientos de Domain Name Systems (A (Dominio Web) -> Valor (IP referenciada)).
* **Resultados esperados**: El objeto `Set` rebotará y descartará automáticamente las MAC/IPs duplicadas respondiendo el comando reservado con bandera falsa (`false`). Todo el Mapa indexará un árbol de Enrutamiento donde si consultas mediante GUI el dominio en modo Get `.get(LLAVE_DOMINIO)`, el compilador destapará en tiempo O(1) la IP almacenada.

## 12. Java Moderno: Records, Pattern Matching y Streams (dev.java/learn)
* **Nombres de Código**: `ModernJavaCLI.java`, `ModernJavaGUI.java`
* **Explicación**: Introducción definitiva a las directrices contemporáneas del ecosistema documentado en [dev.java/learn](https://dev.java/learn/). Re-educa al usuario implementando constructores tipo **`Record`** para instanciar clústeres de servidores y portadores de datos netamente inmutables (sin la redundancia de los Getters/Setters visuales). Aplica también el uso del robusto **Pattern Matching (`instanceof` seguro)** inyectando variables formales evadiendo casteos abstractos de `Object`. Finaliza procesando secuencias de datos mediante Tuberías Funcionales de the **Stream API** e inyecciones algorítmicas Lambda.
* **Datos a usar**: (Modo de Ejercicios Ejecutables en Terminal) Se le requiere al usuario teclear por sí mismo en consola variables constructivas como _ID, IPS_, validaciones manuales interactivas, y sentencias condicionales prefabricadas.
* **Resultados esperados**: La aplicación demostrará una madurez sintáctica rotunda al modelar el clúster entero, identificando satisfactoriamente a las variables polimórficas (Pattern Match) y descartará por la tubería a todos los servidores con status `OFFLINE` aplicando `stream().filter(Λ).forEach()`.
