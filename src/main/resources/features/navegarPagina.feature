@EXTRACCION_DATOS
Feature: Navegar en la pagina Oscaro

  Navegar en Oscaro por el menu y categorias

  Rule: Navegar por Oscar Page

    @AED-4_NavBar
    Scenario: Navegar por el menu principal
      When Entrar pagina principal
      Then Navegar por los tipos de servicios
      And Cerrar pagina

