# automation

Here will be some information about the app.

The folder structure [`src`](./src)

configuration files java [`src/test/java`](src/main/java) folder. Files resources ['src/test/resource'](src/main/resources) folder. 

selenium - page object -  data Driven - Maven

versions Java version "1.8" 2024-01-16 LTS  Apache Maven 3.9.6 

Find more information on the main repo on [GitHub](https://github.com/elenacarozamora/automatizacion).

COMANDO PARA EJECUTAR- mvn clean install -Dcucumber.filter.tags=@AED-7_Producto -Dparam.categoria=1 -Dparam.subcategoria=3 -Dparam.familia=1 -Dparam.hastaPagina=4 -Dwebdriver.chrome.driver=src/test/resources/WebDrivers/chromedriver.exe

PARAMETRIZADO LA FAMILIA, LA CATEGORIA Y LA SUBCATEGORIA, ADEMÁS TAMBIÉN SE INCLUYÓ EL NUMERO DE PAGINAS QUE QUIERE IMPIRMIR

RUTA DONDE SE GUARDA EL FICHERO  ---src/test/resources/ficheroResult