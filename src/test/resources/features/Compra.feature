Feature: Como cliente quiero seleccionar un objeto y comprarlo

  @Smoke @Compra @ConLoginInicial
  Scenario: El cliente inicia sesión en el sitio de compras
    Given el cliente se encuentra en la página Home
    When el cliente hace click en el botón Sign In del Home
    Then el cliente verifica que fue redireccionado a la pantalla de Login

    When el cliente ingresa su email: zxc@gmail.com
    And el cliente ingresa su password: 12345
    And el cliente hacclick en el botón Sign In del Login
    Then el cliente verifica que fue redireccionado a la pantalla de My Account

    When el cliente hace click en el botón T-Shirts desde My Account
    Then el cliente verifica que fue redireccionado a la pantalla de T-Shirts

    When el cliente hace click en el botón Add To Cart
    Then el cliente verifica que fue redireccionado a la pantalla de Producto

    When el cliente ingresa 3 en cantidad
    And el cliente hace click en el botón Add To Cart desde la página del producto
    And el cliente hace click en el botón Proceed to checkout desde la página del producto
    Then el cliente verifica que fue redireccionado a la pantalla de Order

    When el cliente hace click en el botón Proceed To Checkout de Summary
    And el cliente hace click en el botón Proceed To Checkout de Address
    And el cliente hace click en el botón Terms of service
    And el cliente hace click en el botón Proceed To Checkout de Shipping
    And el cliente hace click en el botón Pay by bank wire
    And el cliente hace click en el botón I Confirm My Order
    Then el cliente verifica que fue redireccionado a la pantalla de Order Confirmation
