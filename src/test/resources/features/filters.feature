Feature: Filtrado y ordenamiento de productos

  Scenario: Filtrar por categoría y ordenar por precio descendente
    Given el usuario está en la página principal
    When selecciona la categoría Hand Tools
    And aplica el ordenamiento por precio de mayor a menor
    Then los productos se muestran ordenados de mayor a menor precio


