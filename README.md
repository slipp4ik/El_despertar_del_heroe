# El despertar del héroe

## 1. Descripción

*El despertar del héroe* es un juego de aventura por turnos desarrollado en Java. El jugador crea un usuario y un héroe, se enfrenta a tres villanos y puede atacar, defenderse, utilizar pociones y consultar las puntuaciones. La historia avanza después de cada combate superado.

El proyecto utiliza archivos **XML** para almacenar las partidas, **DTD** para definir la estructura de los datos, **XPath** para consultar el ranking y **XSLT + CSS** para generar una presentación del ranking en HTML.

## 2. Versiones y tecnologías

| Tecnología | Versión / uso |
| --- | --- |
| Java | JDK 21 recomendado; el código utiliza `Random.nextInt(origen, límite)`, disponible desde Java 17 |
| XML | 1.0; almacenamiento del ranking |
| DTD | Definición de elementos y atributos de `Ranking.xml` |
| XPath | Consultas sobre jugadores, puntuaciones e identificadores |
| XSLT | 1.0; transformación del XML a HTML |
| HTML y CSS | Visualización del ranking |


## 3. Requisitos previos

- Tener instalado **JDK 21** (o al menos JDK 17).
- Disponer de una terminal: PowerShell, CMD o terminal de Linux/macOS.
- Tener un navegador para abrir `Ranking.html`.
- Para la validación DTD y las consultas XPath, disponer de una herramienta XML compatible, por ejemplo **XML Copy Editor** o `xmllint` (libxml2).
- Para la transformación XSLT, disponer de un procesador XSLT 1.0, por ejemplo `xsltproc` (libxslt).

Comprobar la instalación de Java:

```bash
java -version
javac -version
```

Herramientas y procedencia: [OpenJDK](https://openjdk.org/), [XML Copy Editor](https://xml-copy-editor.sourceforge.io/), [libxml2/xmllint](https://gitlab.gnome.org/GNOME/libxml2) y [libxslt/xsltproc](https://gitlab.gnome.org/GNOME/libxslt).

## 4. Estructura de carpetas

```text
El-despertar-del-heroe/
├── README.md
├── src/
│   ├── Despertar_heroe.java
│   ├── Personajes.java
│   ├── Heroe.java
│   ├── Villano.java
│   ├── CrearRankingXML.java
│   ├── LeerRankingXML.java
│   └── ModificarXML.java
├── Ranking.xml
├── Ranking.dtd
├── Ranking.xslt
├── Ranking.html
├── styles.css
└── XPath.txt
```

## 5. Compilación y ejecución

### Windows (PowerShell)

```powershell
New-Item -ItemType Directory -Force build | Out-Null
javac -encoding UTF-8 -d build src\*.java
java -cp build Despertar_heroe
```

### Linux / macOS

```bash
mkdir -p build
javac -encoding UTF-8 -d build src/*.java
java -cp build Despertar_heroe
```

A continuación, ejecutar los comandos correspondientes al sistema operativo. Es importante que el **directorio de trabajo sea la raíz del proyecto**, ya que el programa abre `Ranking.xml` mediante una ruta relativa (`new File("Ranking.xml")`).

Al iniciarse, `CrearRankingXML` genera un `Ranking.xml` vacío si el archivo todavía no existe.

## 6. Guía de uso y reglas

El menú principal permite:

1. **Nueva partida:** introducir un nombre de usuario y crear el héroe.
2. **Consultar ranking:** mostrar los jugadores y sus puntos guardados en el XML.
3. **Ayuda:** consultar las reglas del juego.
4. **Salir:** cerrar el programa.

El héroe empieza con **100 puntos de vida** y un inventario de **tres pociones**, cada una de las cuales recupera hasta 25 puntos de vida sin superar el máximo de 100. El daño de los ataques se genera aleatoriamente. En el código actual, `nextInt(10,20)` produce valores entre **10 y 19**, y `nextInt(5,15)` entre **5 y 14**.

Los enemigos son:

| Enemigo | Vida inicial |
| --- | ---: |
| Grimdal el Encadenado | 40 |
| Vessa la Susurrante | 60 |
| El Señor de las Sombras | 80 |

Durante los combates se puede **atacar, defender, usar una poción, consultar el inventario o abandonar**. No se puede atacar dos veces seguidas; la defensa tiene una probabilidad de éxito que depende del enemigo. El programa otorga **100 puntos por enemigo derrotado** y, al completar la aventura, suma como bonificación la vida restante.

Al morir el héroe o terminar la aventura, el programa intenta registrar la puntuación en `Ranking.xml`. La opción de abandonar cierra actualmente el programa directamente.

## 7. Ranking XML

El archivo **`Ranking.xml`**, situado en la raíz del proyecto, contiene registros con esta estructura:

```xml
<ranking>
    <jugador id="1">
        <usuario>Albert</usuario>
        <puntos>300</puntos>
    </jugador>
</ranking>
```

- `CrearRankingXML.java`: crea el archivo si no existe.
- `LeerRankingXML.java`: lee y muestra los registros por consola.
- `ModificarXML.java`: añade un jugador, calcula un nuevo identificador y guarda el documento.
- `Ranking.dtd`: define los elementos `ranking`, `jugador`, `usuario`, `puntos` y el atributo obligatorio `id`.


## 8. Validación XML con DTD

El archivo `Ranking.xml` declara su DTD mediante:

```xml
<!DOCTYPE ranking SYSTEM "Ranking.dtd">
```

## 9. Consultas XPath

Las consultas incluidas en `XPath.txt` se aplican a `Ranking.xml`. Se pueden ejecutar en un editor XML compatible con XPath o mediante `xmllint`.

Ejemplos desde la raíz del proyecto:

**Mostrar todos los nombres de usuario:**

```bash
xmllint --xpath '//jugador/usuario/text()' Ranking.xml
```

**Seleccionar jugadores con más de 300 puntos:**

```bash
xmllint --xpath '/ranking/jugador[puntos>300]' Ranking.xml
```

- **Entrada:** `Ranking.xml`.
- **Salida:** resultados mostrados en la terminal.

## 10. Transformación XSLT a HTML

El archivo **`Ranking.xslt`** transforma los jugadores de `Ranking.xml` en una tabla HTML. Ordena los registros de mayor a menor puntuación y asigna clases especiales a las tres primeras posiciones. El archivo **`styles.css`** contiene el diseño visual en tonos azules y morados.

Desde la raíz del proyecto, ejecutar:

```bash
xsltproc -o Ranking.html Ranking.xslt Ranking.xml
```

- **Entrada de datos:** `Ranking.xml`.
- **Hoja de transformación:** `Ranking.xslt`.
- **Archivo generado:** `Ranking.html`.
- **Hoja de estilos:** `styles.css` 

Después, abrir `Ranking.html` con un navegador. La transformación se debe repetir cuando cambien las puntuaciones, porque **el HTML no se actualiza automáticamente al guardar el XML**.

El procesador XSLT usa el DTD referenciado por el XML cuando corresponde; para esta transformación no es necesario modificar el archivo de entrada.


