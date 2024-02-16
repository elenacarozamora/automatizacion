@EXTRACCION_DATOS
Feature: Producto Nombre
  Producto nombres en el fichero Json

  Rule: Producto Nombres


    @AED-7_Producto
    Scenario: Producto Nombre
      When Entrar pagina principal
      Then Producto nombres
      And Cerrar pagina