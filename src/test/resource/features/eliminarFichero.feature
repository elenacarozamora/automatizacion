Feature: Eliminar fichero

  # Eliminar fichero
  Scenario: Eliminar fichero


  @AED-4_DeleteFile
  Scenario: Eliminar Fichero
    When Entrar pagina principal
    Then Eliminar ficheros
    And Cerrar pagina