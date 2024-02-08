Feature: Recuperar todas los nombres de las categorías

  # Recuperar los nombres de las categorias
  Rule: Recuperar fichero

  @AED-4_RecupName
  Scenario: Recuperar los nombres de las categorias
    When Entrar pagina principal
    Then Recuperar nombres