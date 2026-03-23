@echo off
echo ==============================================
echo Compilando el proyecto Java Learning...
echo ==============================================
if not exist bin mkdir bin

dir /s /B src\*.java > sources.txt
javac -d bin @sources.txt
del sources.txt

if %errorlevel% neq 0 (
    echo.
    echo [ERROR] Hubo un problema durante la compilacion.
    pause
    exit /b %errorlevel%
)

echo.
echo Compilacion Exitosa. Iniciando Modo GUI...
echo ==============================================
echo.
java -cp bin com.javalearning.Main --gui
