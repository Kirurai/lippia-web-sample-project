Feature: Como cliente quiero ingresar las credenciales de mi cuenta, para ingresar al sitio de compra

  #zxc@gmail.com : 12345
  @Logi
  Scenario: El cliente inicia sesión en el sitio de compras
    Given el cliente se encuentra en la página Home
    When el cliente hace click en el botón Sign In del Home
    Then el cliente verifica que fue redireccionado a la pantalla de Login

    When el cliente ingresa su email: zxc@gmail.com
    And el cliente ingresa su password: 12345
    And el cliente hace click en el botón Sign In del Login
    Then el cliente verifica que fue redireccionado a la pantalla de My Account