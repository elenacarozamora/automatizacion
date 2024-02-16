@EXTRACCION_DATOS
Feature: Almacenar Nombre
  Guardar nombres en el fichero Json

  Rule: Guardar Nombres


    @AED-4_Categoria
    Scenario: Almacenar Categoria
      When Entrar pagina principal
      Then Guardar nombres
      And Cerrar pagina