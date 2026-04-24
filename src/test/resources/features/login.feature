Feature: Autenticación de usuario

  Background:
    Given el usuario está en la página de inicio de sesión

  Scenario: Inicio de sesión exitoso con credenciales válidas
    When el usuario ingresa el correo "customer@practicesoftwaretesting.com"
    And ingresa la contraseña "welcome01"
    And hace clic en el botón 'Iniciar sesión'
    Then debe visualizar su nombre de usuario "Jane Doe" en el perfil

  Scenario Outline: Error al iniciar sesión con credenciales inválidas
    When el usuario ingresa el correo "<correo>"
    And ingresa la contraseña "<contraseña>"
    And hace clic en el botón 'Iniciar sesión'
    Then debe mostrarse el mensaje de error "Invalid email or password"

    Examples:
      | caso                        | correo                                    | contraseña          |
      | correo incorrecto           | fake@practicesoftwaretesting.com          | welcome01           |
      | contraseña incorrecta       | customer@practicesoftwaretesting.com      | nahnahnahBatman!    |












