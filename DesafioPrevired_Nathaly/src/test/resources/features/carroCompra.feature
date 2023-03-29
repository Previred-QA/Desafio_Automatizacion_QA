Feature: Agregar articulos al carro de compra

  Scenario Outline: Agregar articulos al carro de compras
    Given Ingreso a la URL del sitio web <tipoFlujo><jsonPath>
    When Valido que me encuentro en el sitio web
    And Busco el articulo Ipod Classic en el buscador de la pagina web
    And Agrego el articulo uno al carro de compras
    And Busco el articulo Imac en el buscador de la pagina web
    And Agrego el articulo dos al carro de compras
    And Ingreso al carro de compras
    And Valido los articulos agregados al carro de compras
    And Me registro en la pagina para realizar la compra ingresando mis datos
    And Valido la direccion ingresada
    And Valido el costo del despacho
    And Selecciono mi metodo de pago
    And Verifico el recibo de mi compra
    And Realizo la compra de los productos
    And Ingreso en mi perfil para validar mis datos de la cuenta
    And Ingreso en mi Order History para validar el estado de mi compra
    Then Cierro sesion


    @CarroCompras
    Examples:
      | tipoFlujo     | jsonPath                |
      | "carroCompra" | "flujoCarroCompra.json" |