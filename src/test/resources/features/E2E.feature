Feature: Validación del flujo de compra

  Scenario Outline: Compra exitosa con usuario registrado
    Given el usuario está en la página principal
    When busca el producto "<producto>"
    And selecciona el primer resultado
    Then se muestra la página de detalle del producto
    When agrega el producto al carrito
    Then navega al carrito de compras
    And procede al checkout
    And ha iniciado sesión con credenciales válidas "<correo>" y "<contraseña>"
    Then se muestra el formulario de datos de envío
    When completa los datos de envío con información válida "<state>","<postalCode>" y "<numberHouse>"
    And selecciona el método de pago "<metodoPago>"
    And confirma el pedido
    Then visualiza el mensaje "Payment was successful"

    Examples:
      | producto | correo                               | contraseña |state|postalCode| numberHouse| metodoPago       |
      | plier   | customer@practicesoftwaretesting.com | welcome01  |Cabildo|2000| 72 | Cash on Delivery |