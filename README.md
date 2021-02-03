# Gestor de Empleados

**Para la Gestión de Empleados de Diversos Sectores se desarrolló una aplicación tipo GUI-CRUD empleando Analytics y Gráficos en JAVA SE Swing con Maven aplicando JDBC con Mysql.**

</br>

## Vista de Inicio de la Desktop App 1/6
*Este es el Menú Inicial de la Aplicación, consta de 5 áreas(Empleados, Soporte Técnico, etc), 1 sección de Ayuda y una sección de Acerca de..
Cabe destacar que, de las 5 áreas, solamente desarrollé la de Empleados, ya que al no implementar algún Framework para agilizar el desarrollo, me parece una pérdida de tiempo y redundancia de código.*

![Index app](https://github.com/andresWeitzel/Graphics/blob/main/Proyectos/GestorEmpleados_app/Captura%20de%20pantalla%20(335).png)

</br>

## Vista de Inicio de la Desktop App 2/6
*Una vez seleccionada el área, aparecera un formulario de validación de Ingreso para poder gestionar la misma. Los Usuarios y Contraseñas se Listan mas abajo*

</br>

![Index app](https://github.com/andresWeitzel/Graphics/blob/main/Proyectos/GestorEmpleados_app/Captura%20de%20pantalla%20(337).png)


## Vista de Inicio de la Desktop App 3/6
*Este es el Menú de Empleados, se puede Ingresar un Empleado a la Base de Datos, o Listarlos .*

![Index app](https://github.com/andresWeitzel/Graphics/blob/main/Proyectos/GestorEmpleados_app/Captura%20de%20pantalla%20(338).png)

## Vista de Inicio de la Desktop App 4/6
*Esta es la vista del Listado de Empleados. Desarrollé un filtro de búsqueda especifico en relación al campo deseado. Dentro de los filters de Java8 se especificó funciones en las cuáles busquen el comienzo o que contengan al menos lo deseado en los registros.
Para ACTUALIZAR o ELIMINAR algún registro se deberá seleccionar el deseado o mismo la aplicación te avisará con un mensaje de alerta (también posee un control de seleccion). `En el Borde Inferior Izquierdo se puede acceder a la sección de Analytics.`*

![Index app](https://github.com/andresWeitzel/Graphics/blob/main/Proyectos/GestorEmpleados_app/Captura%20de%20pantalla%20(339).png)

## Vista de Inicio de la Desktop App 5/6
*Esta es la vista de Analytics. Seleccioné solo 3 columnas de la db ya que estos registros son de tipo numerico.
Para este sección le di enfoque  estadístico a:
* Cantidad de Valores
* Valores Máximos y Mínimos
* Promedio/Media de Valores 
* Valores que más se Repiten(MonoModa). Se aplica MonoModa ya que podrían exister varios campos con varios valores iguales diferentes
* Frecuencia de la MonoModa (Osea la cantidad de veces que se repite dicho valor(Moda) encontrado)
* Varianza (Variabilidad respecto de la Media)
* Desvío Estandar (Qué tan dispersos están los datos respecto de la Media)*
**Cabe destacar que los campos del registro sueldo son de tipo decimales, todo funcione bien hasta la parte del calculo de la Moda. Realmente no pude seleccionar esto. **

![Index app](https://github.com/andresWeitzel/Graphics/blob/main/Proyectos/GestorEmpleados_app/Captura%20de%20pantalla%20(340).png)


## Vista de Inicio de la Desktop App 6/6
*Dentro de la Vista de Analytics implemente las librerías Gráficas para una visualización diferente de los datos obtenidos. Se puede utilizar gráficos de torta, curvas, etc.*

![Index app](https://github.com/andresWeitzel/Graphics/blob/main/Proyectos/GestorEmpleados_app/Captura%20de%20pantalla%20(341).png)

 </br>

</br>

| **Tecnologías** | **Versión** |               
| ------------- | ------------- |
| Java |   12.0.2 |
| Apache NetBeans IDE |  12.0 |
| Cygwin | 3.1.6-1  | -> Terminal en Windows integrada al IDE Netbeans
| Git | 2.29.1.windows.1  |
| XAMPP | 3.2.2  |
| Mysql Workbench | 8.0.20  |


</br>

| **Dependencia Maven** | **Finalidad** |               
| ------------- | ------------- |
| mysql-connector-8.0.21|  Conexion e implementación de queries a la db con mysql |
| JFreeChart 1.0.131|  Generación de Gráficos |
| JCommon  1.0.16|  Biblioteca de Clases para JFreeChart |

* Repositorio dependencia mysql-connector: https://mvnrepository.com/artifact/mysql/mysql-connector-java/8.0.21
* Repositorio dependencia JFreeChart: https://mvnrepository.com/artifact/jfree/jfreechart/1.0.13
* Repositorio dependencia JCommon: https://mvnrepository.com/artifact/jfree/jcommon/1.0.16

</br>

 ## Patrones de Diseño
 * **Singleton** 
 * **Dao** 
 
 ## Java8
* **Streams**
* **Lambdas**
* **Filters**
* **Collections**
* **Etc..**

</br>

## Descarga y documentacion de las Tecnologías empleadas:
#### Java-JDK 12:                     https://www.oracle.com/java/technologies/javase/jdk12-archive-downloads.html
#### Maven Repositories:              https://mvnrepository.com/
#### Creación de Gráficos:            http://panamahitek.com/graficando-en-java-con-jfreechart/
#### Apache Netbeans IDE:             https://netbeans.apache.org/download/index.html
#### Cygwin:                           https://cygwin.com/install.html
#### Git:                              https://git-scm.com/docs
#### XAMPP:                            https://www.apachefriends.org/download.html
#### Mysql Workbench:                 https://www.mysql.com/products/workbench/


</br>

## Más Información

<hr>

## Uso de Cygwin

#### 1)Descargar la herramienta en https://cygwin.com/install.html dependiendo la arquitectura que se tenga (32-64 bits), como toda aplicacion siguiente.... siguiente....
````(IMPORTANTE:NO TENER ABIERTO EL IDE DURANTE LA INSTALACION, SINO NO RECONOCE EL PATH)````

#### 2)Abrir el IDE Netbeans, seguidamente seleccionar el proyecto para implementar git, ir a la barra del ide y clickear```Tools->Open in terminal```

#### 3)Te debería aparecer algo parecido a esto(Ruta Absoluta de tu proyecto)...
````andre@DESKTOP-7BN69K1/cygdrive/c/Users/andre/OneDrive/Escritorio/LenguajesProgramacion/JAVASE/Proyectos/GestorGastos_app````

#### 4)Crear un nuevo repositorio y comenzar con git
````Debajo de esta sección, explico como usar git de forma detallada.````

#### 5) Más Información en https://ourcodeworld.com/articles/read/680/how-to-configure-an-integrated-terminal-command-prompt-in-netbeans-for-windows

</br>

## Subir el proyecto al repositorio con la terminal a traves de Cygwin en Netbeans

#### 1)Creamos un nuevo repositorio en GitHub

#### 2)Inicializamos nuestro repositorio local .git
* git init

#### 3)Agregamos lo desarrollado a nuestro repo local
* git add *

#### 4)Agregamos lo que tenemos en nuestro repo local al área de Trabajo.
* git commit -m "agrega un comentario entre comillas"

#### 5)Le indicamos a git donde se va a almacenar nuestro proyecto(fijate en tu repositorio de github cual es el enlace de tu proyecto(esta en code)).
* git remote add origin https://github.com/andresWeitzel/Gestor_de_Empleados.git

#### 6)Subimos nuestro proyecto.
* git push -u origin master


</br>


## Actualización de el proyecto al repositorio con la terminal a traves de Cygwin en Netbeans

#### 1)Visualizamos las modificaciones realizadas en local
* git status

#### 2)Agregamos lo modificado al area de trabajo
* git add *

#### 3)Confirmamos las modificaciones realizadas
* git commit -m "tu commit entre comillas"

#### 4)Sincronizamos y traemos todos los cambios del repositorio remoto a la rama en la que estemos trabajando actualmente.
##### (Desconozco porqué tengo que ejecutar este comando, supongo que será porque no estoy trabajando con branchs en mi proyecto, el main por defecto de gitHub ahora es mi master(Yo realicé esa modificación para mejor visualización)).
* git pull https://github.com/andresWeitzel/Gestor_de_Empleados.git

#### 5)Enviamos todos los cambios al repo en github
* git push https://github.com/andresWeitzel/Gestor_de_Empleados.git

</br>
