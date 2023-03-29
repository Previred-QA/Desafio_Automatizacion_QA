package steps;

import driver.driverConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.carroCompraPage;
import utilFunction.utilFunctions;

import static org.junit.Assert.assertTrue;

public class carroCompraSteps {
    carroCompraPage CarroCompraPage = new carroCompraPage();
    @When("^Valido que me encuentro en el sitio web$")
    public void valido_que_me_encuentro_en_el_sitio_web() throws Throwable {
        String mensaje = "";
        Boolean resp = true;
        try {
            mensaje = CarroCompraPage.validarHome();
            if (!mensaje.equalsIgnoreCase("")) resp = false;
            assertTrue(mensaje,resp);
        } catch(AssertionError e) {
            throw new Exception("Falló el inicio de la página");
        }
    }

    @And("^Busco el articulo Ipod Classic en el buscador de la pagina web$")
    public void busco_el_articulo_ipod_classic_en_el_buscador_de_la_pagina_web() throws Throwable {
        String mensaje = "";
        Boolean resp = true;
        try {
            mensaje = CarroCompraPage.buscarProductoUno();
            if (!mensaje.equalsIgnoreCase("")) resp = false;
            assertTrue(mensaje,resp);
        } catch(AssertionError e) {
            throw new Exception("Falló la busqueda del producto");
        }
    }

    @And("^Agrego el articulo uno al carro de compras$")
    public void agrego_el_articulo_uno_al_carro_de_compras() throws Throwable {
        String mensaje = "";
        Boolean resp = true;
        try {
            mensaje = CarroCompraPage.agregarProductoUno();
            if (!mensaje.equalsIgnoreCase("")) resp = false;
            assertTrue(mensaje,resp);
        } catch(AssertionError e) {
            throw new Exception("No se agrego el producto Ipod Classic");
        }
    }

    @And("^Busco el articulo Imac en el buscador de la pagina web$")
    public void busco_el_articulo_Imac_en_el_buscador_de_la_pagina_web() throws Throwable {
        String mensaje = "";
        Boolean resp = true;
        try {
            mensaje = CarroCompraPage.limpiarBuscador();
            if (mensaje.equalsIgnoreCase("")){
                mensaje = CarroCompraPage.buscarProductoDos();
                if (!mensaje.equalsIgnoreCase("")) resp = false;
            } else {
                resp = false;
            }
            assertTrue(mensaje,resp);
        } catch(AssertionError e) {
            throw new Exception("Falló la busqueda del producto");
        }
    }

    @And("^Agrego el articulo dos al carro de compras$")
    public void agrego_el_articulo_dos_al_carro_de_compras() throws Throwable {
        String mensaje = "";
        Boolean resp = true;
        try {
            mensaje = CarroCompraPage.agregarProductoDos();
            if (!mensaje.equalsIgnoreCase("")) resp = false;
            assertTrue(mensaje,resp);
        } catch(AssertionError e) {
            throw new Exception("No se agrego el producto Imac");
        }
    }

    @And("^Ingreso al carro de compras$")
    public void ingreso_al_carro_de_compras() throws Throwable {
        String mensaje = "";
        Boolean resp = true;
        try {
            mensaje = CarroCompraPage.verResumenCarroCompras();
            if (mensaje.equalsIgnoreCase("")) {
                mensaje = CarroCompraPage.ingresarCarroCompras();
                if (!mensaje.equalsIgnoreCase("")) resp = false;
            } else {
                resp = false;
            }
            assertTrue(mensaje, resp);
        } catch (AssertionError e) {
            throw new Exception("Falló el ingreso al carro de compras");
        }
    }

    @And("^Valido los articulos agregados al carro de compras$")
    public void valido_los_articulos_agregados_al_carro_de_compras() throws Throwable {
        String mensaje = "";
        Boolean resp = true;
        try {
            mensaje = CarroCompraPage.validarProductosCarro();
            if (!mensaje.equalsIgnoreCase("")) resp = false;
            assertTrue(mensaje,resp);
        } catch(AssertionError e) {
            throw new Exception("No se logro validar los productos agregados al carro");
        }
    }

    @And("^Me registro en la pagina para realizar la compra ingresando mis datos$")
    public void me_registro_en_la_pagina_para_realizar_la_compra_ingresando_mis_datos() throws Throwable {
        String mensaje = "";
        Boolean resp = true;
        try {
            mensaje = CarroCompraPage.irACheckout();
            if (mensaje.equalsIgnoreCase("")){
                mensaje = CarroCompraPage.irARegistroComprador();
                if (mensaje.equalsIgnoreCase("")){
                    mensaje = CarroCompraPage.registarComprador();
                    if (mensaje.equalsIgnoreCase("")){
                        mensaje = CarroCompraPage.terminosYCondiciones();
                        if (mensaje.equalsIgnoreCase("")){
                            mensaje = CarroCompraPage.irAContinuarRegistro();
                        }else {
                            resp =false;
                        }
                    }else {
                        resp = false;
                    }
                }else {
                    resp = false;
                }
            }else {
                resp = false;
            }
            assertTrue(mensaje,resp);
        } catch(AssertionError e) {
            throw new Exception("No se logro validar los productos agregados al carro");
        }
    }

    @And("^Valido la direccion ingresada$")
    public void valido_la_direccion_ingresada() throws Throwable {
        String mensaje = "";
        Boolean resp = true;
        try {
            mensaje = CarroCompraPage.validarDireccion();
            if (!mensaje.equalsIgnoreCase("")) resp = false;
            assertTrue(mensaje,resp);
        } catch(AssertionError e) {
            throw new Exception("No se logro validar la direccion que se muestra con la ingresada en el registro");
        }
    }

    @And("^Valido el costo del despacho$")
    public void valido_el_costo_del_despacho() throws Throwable {
        String mensaje = "";
        Boolean resp = true;
        try {
            mensaje = CarroCompraPage.validarCostoDespacho();
            if (!mensaje.equalsIgnoreCase("")) resp = false;
            assertTrue(mensaje,resp);
        } catch(AssertionError e) {
            throw new Exception("No se logro validar el despacho menor a 5$");
        }
    }

    @And("^Selecciono mi metodo de pago$")
    public void selecciono_mi_metodo_de_pago() throws Throwable {
        String mensaje = "";
        Boolean resp = true;
        try {
            mensaje = CarroCompraPage.seleccionarMetodoPago();
            if (mensaje.equalsIgnoreCase("")) {
                mensaje = CarroCompraPage.terminosYCondiciones();
                if (mensaje.equalsIgnoreCase("")){
                    mensaje = CarroCompraPage.irAContinuarPago();
                }else {
                    resp = false;
                }
            }else {
                resp = false;
            }
        assertTrue(mensaje,resp);
        } catch(AssertionError e) {
            throw new Exception("No se logro seleccionar el metodo de pago");
        }
    }

    @And("^Verifico el recibo de mi compra$")
    public void verifico_el_recibo_de_mi_compra() throws Throwable {
        String mensaje = "";
        Boolean resp = true;
        try {
            mensaje = CarroCompraPage.validarMontoTotal();
            if (!mensaje.equalsIgnoreCase("")) resp = false;
            assertTrue(mensaje,resp);
        } catch(AssertionError e) {
            throw new Exception("No se puede validar el monto total");
        }
    }

    @And("^Realizo la compra de los productos$")
    public void realizo_la_compra_de_los_productos() throws Throwable {
        String mensaje = "";
        Boolean resp = true;
        try {
            mensaje = CarroCompraPage.realizarCompra();
            if (!mensaje.equalsIgnoreCase("")) resp = false;
            assertTrue(mensaje,resp);
        } catch(AssertionError e) {
            throw new Exception("No se puede realizar la compra");
        }
    }

    @And("^Ingreso en mi perfil para validar mis datos de la cuenta$")
    public void ingreso_en_mi_perfil_para_validar_mis_datos_de_la_cuenta() throws Throwable {
        String mensaje = "";
        Boolean resp = true;
        try {
            mensaje = CarroCompraPage.finalizarCompra();
            if (mensaje.equalsIgnoreCase("")) {
                mensaje = CarroCompraPage.presionarMiCuenta();
                if (mensaje.equalsIgnoreCase("")) {
                    mensaje = CarroCompraPage.seleccionarMyAccount();
                    if (mensaje.equalsIgnoreCase("")) {
                        mensaje = CarroCompraPage.verDatosDireccion();
                    } else {
                        resp = false;
                    }
                }else{
                    resp = false;
                }
            }else {
                resp = false;
            }
                assertTrue(mensaje, resp);
            }catch(AssertionError e){
                throw new Exception("No se puede finalizar la compra");
        }
    }

    @And("^Ingreso en mi Order History para validar el estado de mi compra$")
    public void ingreso_en_mi_order_history_para_validar_el_estado_de_mi_compra() throws Throwable {
        String mensaje = "";
        Boolean resp = true;
        try {
            mensaje = CarroCompraPage.presionarMiCuenta();
            if (mensaje.equalsIgnoreCase("")) {
                mensaje = CarroCompraPage.verOrderHistory();
                if (mensaje.equalsIgnoreCase("")){
                    mensaje = CarroCompraPage.validarEstadoCompra();
                }else {
                    resp = false;
                }
            }else {
                resp = false;
            }
            assertTrue(mensaje,resp);
        } catch(AssertionError e) {
            throw new Exception("No se puede realizar la compra");
        }
    }
    @And("^Cierro sesion$")
    public void cierro_sesion() throws Throwable {
        String mensaje = "";
        Boolean resp = true;
        try {
            mensaje = CarroCompraPage.cierroSesion();
            if (!mensaje.equalsIgnoreCase("")) resp = false;
            assertTrue(mensaje,resp);
        } catch(AssertionError e) {
            throw new Exception("No se puede cerrar sesion");
        }
    }

}


