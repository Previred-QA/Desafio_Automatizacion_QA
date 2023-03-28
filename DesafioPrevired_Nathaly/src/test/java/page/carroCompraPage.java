package page;

import driver.driverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilFunction.utilFunctions;

public class carroCompraPage extends utilFunctions {

    public String validarHome() {
        String mensaje = "";
        if (!waitElementoVisible(driverConfig.driver.findElement(By.id("search")), 20)){
            mensaje = "No se logra visualizar el campo del buscador de productos";
        }
        return mensaje;
    }

    public String buscarProductoUno() {
        String mensaje = "";
        if (waitElementoVisible(driverConfig.driver.findElement(By.name("search")), 20)){
            WebElement inputSearch = driverConfig.driver.findElement(By.name("search"));
            inputSearch.sendKeys(driverConfig.DataCarroCompra.getArticuloUno());
        }else{
            mensaje = "No se logra visualizar el campo del buscador de productos";
        }

        if (mensaje.equalsIgnoreCase("")) {
            if (waitElementoVisible(driverConfig.driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")), 20)) {
                WebElement botonSearch = driverConfig.driver.findElement(By.xpath("//*[@id=\"search\"]/span/button"));
                botonSearch.click();
            } else {
                mensaje = "No se logra visualizar el boton Buscar";
            }
        }
        return mensaje;
    }

    public String limpiarBuscador(){
        String mensaje = "";
        if (waitElementoVisible(driverConfig.driver.findElement(By.name("search")), 20)){
            WebElement campoBuscador = driverConfig.driver.findElement(By.name("search"));
            campoBuscador.clear();
        }else {
            mensaje = "No se logra visualizar el campo del buscador de productos";
        }
        return mensaje;
    }

    public String agregarProductoUno() {
        String mensaje = "";
        if (waitElementoVisible(driverConfig.driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[1]/h4/a")), 20)){
            WebElement linkProductoUno = driverConfig.driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[1]/h4/a"));
            linkProductoUno.click();
            if (waitElementoVisible(driverConfig.driver.findElement(By.id("button-cart")), 20)){
                WebElement botonAgregarCarro = driverConfig.driver.findElement(By.id("button-cart"));
                botonAgregarCarro.click();
            }else{
                mensaje = "No se logra visualizar el producto Ipod Classic";
            }

        }else{
            mensaje = "No se logra visualizar link del producto Ipod Classic";
        }
        return mensaje;
    }

    public String buscarProductoDos() {
        String mensaje = "";
        if (waitElementoVisible(driverConfig.driver.findElement(By.name("search")), 20)){
            WebElement inputSearch = driverConfig.driver.findElement(By.name("search"));
            inputSearch.sendKeys(driverConfig.DataCarroCompra.getArticuloDos());
        }else{
            mensaje = "No se logra visualizar el campo del buscador de productos";
        }

        if (mensaje.equalsIgnoreCase("")) {
            if (waitElementoVisible(driverConfig.driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")), 20)) {
                WebElement botonSearch = driverConfig.driver.findElement(By.xpath("//*[@id=\"search\"]/span/button"));
                botonSearch.click();
            } else {
                mensaje = "No se logra visualizar el boton Buscar";
            }
        }
        return mensaje;
    }

    public String agregarProductoDos() {
        String mensaje = "";
        if (waitElementoVisible(driverConfig.driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[1]/h4/a")), 20)){
            WebElement linkProductoDos = driverConfig.driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[1]/h4/a"));
            linkProductoDos.click();
            if (waitElementoVisible(driverConfig.driver.findElement(By.id("button-cart")), 20)){
                WebElement botonAgregarCarro = driverConfig.driver.findElement(By.id("button-cart"));
                botonAgregarCarro.click();
            }else{
                mensaje = "No se logra visualizar el producto IMac";
            }

        }else{
            mensaje = "No se logra visualizar link del producto IMac";
        }
        return mensaje;
    }

    public String verResumenCarroCompras() {
        String mensaje = "";
        if (waitElementoVisible(driverConfig.driver.findElement(By.xpath("//*[@id=\"cart\"]/button")), 20)){
            waitSeconds(2);
            WebElement ResumenCarroCompras = driverConfig.driver.findElement(By.xpath("//*[@id=\"cart\"]/button"));
            ResumenCarroCompras.click();
        }else {
            mensaje = "No se logra visualizar el resumen del carro de compras";
        }
        return mensaje;
    }

    public String ingresarCarroCompras() {
        String mensaje = "";
        if (waitElementoVisible(driverConfig.driver.findElement(By.xpath("//*[@id=\"cart\"]/ul/li[2]/div/p/a[1]/strong")), 20)){
            waitSeconds(3);
            WebElement carroCompras = driverConfig.driver.findElement(By.xpath("//*[@id=\"cart\"]/ul/li[2]/div/p/a[1]/strong"));
            carroCompras.click();
        }else {
            mensaje = "No se logra ingresar al carro de compras";
        }
        return mensaje;
    }

    public String validarProductosCarro() {
        String mensaje = "";
        if (waitElementoVisible(driverConfig.driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr[1]/td[2]/a")), 20)){
            WebElement productoIMac = driverConfig.driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr[1]/td[2]/a"));
            String textoIMAC = productoIMac.getAttribute("innerText");
            if (!textoIMAC.equalsIgnoreCase(driverConfig.DataCarroCompra.getArticuloDos())){
                mensaje = "No se logra visualizar el texto IMac en carro de compra";
            }
        }else {
            mensaje = "No se logra visualizar el objeto IMac en carro de compra";
        }

        if (mensaje.equalsIgnoreCase("")){
            if (waitElementoVisible(driverConfig.driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr[2]/td[2]/a")), 20)){
                WebElement productoIpodClassic = driverConfig.driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr[2]/td[2]/a"));
                String textoIpodClassic = productoIpodClassic.getAttribute("innerText");
                if (!textoIpodClassic.equalsIgnoreCase(driverConfig.DataCarroCompra.getArticuloUno())){
                    mensaje = "No se logra visualizar el texto iPod Classic en carro de compra";
                }
            }else {
                mensaje = "No se logra visualizar el objeto iPod Classic en carro de compra";
            }
        }

        return mensaje;
    }

    public String irACheckout() {
        String mensaje = "";
        if (waitElementoVisible(driverConfig.driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]/a")), 20)){
            WebElement botonCheckout = driverConfig.driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]/a"));
            botonCheckout.click();
        }else{
            mensaje = "No se logra visualizar el boton Checkout";
        }
        return mensaje;
    }

    public String irARegistroComprador() {
        String mensaje = "";
        if (waitElementoVisible(driverConfig.driver.findElement(By.xpath("//*[@id=\"button-account\"]")), 20)) {
            WebElement botonContinuar = driverConfig.driver.findElement(By.xpath("//*[@id=\"button-account\"]"));
            botonContinuar.click();
        } else {
            mensaje = "No se logra visualizar el boton para ir a registrar comprador";
        }
        return mensaje;
    }

    public String registarComprador() {
        String mensaje = "";
        if (waitElementoVisible(driverConfig.driver.findElement(By.id("input-payment-firstname")), 20)) {
            WebElement campoNombre = driverConfig.driver.findElement(By.id("input-payment-firstname"));
            campoNombre.sendKeys(driverConfig.DataCarroCompra.getNombre());
        } else {
            mensaje = "No se logra visualizar el campo Nombre del formulario de registro";

        }

        if (mensaje.equalsIgnoreCase("")) {
            if (waitElementoVisible(driverConfig.driver.findElement(By.id("input-payment-lastname")), 20)) {
                WebElement campoApellido = driverConfig.driver.findElement(By.id("input-payment-lastname"));
                campoApellido.sendKeys(driverConfig.DataCarroCompra.getApellido());
            } else {
                mensaje = "No se logra visualizar el campo Apellido del formulario de registro";
            }
        }

        if (mensaje.equalsIgnoreCase("")) {
            if (waitElementoVisible(driverConfig.driver.findElement(By.id("input-payment-email")), 20)) {
                WebElement campoCorreo = driverConfig.driver.findElement(By.id("input-payment-email"));
                campoCorreo.sendKeys(driverConfig.DataCarroCompra.getCorreo());
            } else {
                mensaje = "No se logra visualizar el campo Correo del formulario de registro";
            }
        }

        if (mensaje.equalsIgnoreCase("")) {
            if (waitElementoVisible(driverConfig.driver.findElement(By.id("input-payment-telephone")), 20)) {
                WebElement campoTelefono = driverConfig.driver.findElement(By.id("input-payment-telephone"));
                campoTelefono.sendKeys(driverConfig.DataCarroCompra.getTelefono());
            } else {
                mensaje = "No se logra visualizar el campo Correo del formulario de registro";
            }
        }

        if (mensaje.equalsIgnoreCase("")) {
            if (waitElementoVisible(driverConfig.driver.findElement(By.id("input-payment-password")), 20)) {
                WebElement campoClave = driverConfig.driver.findElement(By.id("input-payment-password"));
                campoClave.sendKeys(driverConfig.DataCarroCompra.getClave());
            } else {
                mensaje = "No se logra visualizar el campo Clave del formulario de registro";
            }
        }

        if (mensaje.equalsIgnoreCase("")) {
            if (waitElementoVisible(driverConfig.driver.findElement(By.id("input-payment-confirm")), 20)) {
                WebElement campoConfirmaClave = driverConfig.driver.findElement(By.id("input-payment-confirm"));
                campoConfirmaClave.sendKeys(driverConfig.DataCarroCompra.getConfirmaClave());
            } else {
                mensaje = "No se logra visualizar el campo Confirmar Clave del formulario de registro";
            }
        }

        if (mensaje.equalsIgnoreCase("")) {
            if (waitElementoVisible(driverConfig.driver.findElement(By.id("input-payment-address-1")), 20)) {
                WebElement campoDireccion = driverConfig.driver.findElement(By.id("input-payment-address-1"));
                campoDireccion.sendKeys(driverConfig.DataCarroCompra.getDireccion());
            } else {
                mensaje = "No se logra visualizar el campo Direccion del formulario de registro";
            }
        }

        if (mensaje.equalsIgnoreCase("")) {
            if (waitElementoVisible(driverConfig.driver.findElement(By.id("input-payment-city")), 20)) {
                WebElement campoCiudad = driverConfig.driver.findElement(By.id("input-payment-city"));
                campoCiudad.sendKeys(driverConfig.DataCarroCompra.getCiudad());
            } else {
                mensaje = "No se logra visualizar el campo Ciudad del formulario de registro";
            }
        }

        if (mensaje.equalsIgnoreCase("")) {
            if (waitElementoVisible(driverConfig.driver.findElement(By.id("input-payment-postcode")), 20)) {
                WebElement campoCodPostal = driverConfig.driver.findElement(By.id("input-payment-postcode"));
                campoCodPostal.sendKeys(driverConfig.DataCarroCompra.getCodigoPostal());
            } else {
                mensaje = "No se logra visualizar el campo Codigo Postal del formulario de registro";
            }
        }

        if (mensaje.equalsIgnoreCase("")) {
            if (waitElementoVisible(driverConfig.driver.findElement(By.name("country_id")), 20)) {
                WebElement selectPaises = driverConfig.driver.findElement(By.name("country_id"));
                Select selectPais = new Select (selectPaises);
                selectPais.selectByVisibleText(driverConfig.DataCarroCompra.getPais());
            } else {
                mensaje = "No se logra visualizar el selector de paises del formulario de registro";
            }
        }

        if (mensaje.equalsIgnoreCase("")) {
            if (waitElementoVisible(driverConfig.driver.findElement(By.name("zone_id")), 20)) {
                WebElement selectRegiones = driverConfig.driver.findElement(By.name("zone_id"));
                Select selectRegion = new Select (selectRegiones);
                selectRegion.selectByVisibleText(driverConfig.DataCarroCompra.getRegion());
            } else {
                mensaje = "No se logra visualizar el selector de regiones del formulario de registro";
            }
        }
        return mensaje;
    }

    public String terminosYCondiciones() {
        String mensaje = "";
        waitSeconds(2);
        if (waitElementoVisible(driverConfig.driver.findElement(By.name("agree")), 20)) {
            WebElement checkTerminoCondiciones = driverConfig.driver.findElement(By.name("agree"));
            checkTerminoCondiciones.click();
        } else {
            mensaje = "No se logra visualizar el ckeck de Terminos y Condiciones del formulario de registro";
        }
        return mensaje;
    }

    public String irAContinuarRegistro() {
        String mensaje = "";
        if (waitElementoVisible(driverConfig.driver.findElement(By.id("button-register")), 20)) {
            WebElement botonContinuarRegistro = driverConfig.driver.findElement(By.id("button-register"));
            botonContinuarRegistro.click();
        } else {
            mensaje = "No se logra visualizar el boton para ir a registrar comprador";
        }
        return mensaje;
    }

    public String validarDireccion() {
        String mensaje = "";
        waitSeconds(2);
        if (waitElementoVisible(driverConfig.driver.findElement(By.xpath("//*[@id=\"shipping-existing\"]/select")), 20)) {
            WebElement datosDireccion = driverConfig.driver.findElement(By.xpath("//*[@id=\"shipping-existing\"]/select"));
            String textoDireccion = datosDireccion.getAttribute("innerText");
            String textoDireccionIngresada = driverConfig.DataCarroCompra.getNombre() + " " + driverConfig.DataCarroCompra.getApellido() + ", " +
                    driverConfig.DataCarroCompra.getDireccion() + ", " + driverConfig.DataCarroCompra.getCiudad() + ", " + driverConfig.DataCarroCompra.getRegion() + ", " +
                    driverConfig.DataCarroCompra.getPais();
            if (textoDireccion.equalsIgnoreCase(textoDireccionIngresada)){
                if (waitElementoVisible(driverConfig.driver.findElement(By.id("button-shipping-address")), 20)) {
                    WebElement botonContinuarDireccion = driverConfig.driver.findElement(By.id("button-shipping-address"));
                    botonContinuarDireccion.click();
                } else {
                    mensaje = "No se logra visualizar el boton para ir a registrar comprador";
                }

            }else {
                mensaje = "La direccion que se muestra no coincide con la ingresada";
            }
        } else {
            mensaje = "No se logra visualizar el boton Continuar luego de la direccion";
        }
        return mensaje;
    }

    public String validarCostoDespacho() {
        String mensaje = "";
        waitSeconds(2);
        if (waitElementoVisible(driverConfig.driver.findElement(By.xpath("//*[@id=\"collapse-shipping-method\"]/div/div[1]/label")), 20)) {
            WebElement valorDespacho = driverConfig.driver.findElement(By.xpath("//*[@id=\"collapse-shipping-method\"]/div/div[1]/label"));
            String textoDespacho = valorDespacho.getAttribute("innerText");
            if (!textoDespacho.equalsIgnoreCase(DataCarroCompra.getShipping())){
                mensaje = "El valor de despacho es diferente a 5$";
            }
        } else {
            mensaje = "El valor de despacho no fue encontrado";
        }
        if (mensaje.equalsIgnoreCase("")) {
            if (waitElementoVisible(driverConfig.driver.findElement(By.id("button-shipping-method")), 20)) {
                WebElement botonContinuarDespacho = driverConfig.driver.findElement(By.id("button-shipping-method"));
                botonContinuarDespacho.click();
            } else {
                mensaje = "No se logra visualizar el boton Continuar luego del valor de despacho";
            }
        }
        return mensaje;
    }

    public String seleccionarMetodoPago() {
        String mensaje = "";
        waitSeconds(2);
        if (waitElementoVisible(driverConfig.driver.findElement(By.xpath("//*[@id=\"collapse-payment-method\"]/div/div[2]/label/input")), 20)) {
            WebElement metodoPago = driverConfig.driver.findElement(By.xpath("//*[@id=\"collapse-payment-method\"]/div/div[2]/label/input"));
            metodoPago.click();
        } else {
            mensaje = "No se logra visualizar el metodo de pago";
        }
        return mensaje;
    }

    public String irAContinuarPago() {
        String mensaje = "";
        if (waitElementoVisible(driverConfig.driver.findElement(By.id("button-payment-method")), 20)) {
            WebElement botonContinuarPago = driverConfig.driver.findElement(By.id("button-payment-method"));
            botonContinuarPago.click();
        } else {
            mensaje = "No se logra visualizar el boton Continuar luego del metodo de pago";
        }
        return mensaje;
    }

    public String validarMontoTotal() {
        String mensaje = "";
        if (waitElementoVisible(driverConfig.driver.findElement(By.xpath("//*[@id=\"collapse-checkout-confirm\"]/div/div[1]/table/tfoot/tr[3]/td[2]")), 20)) {
            WebElement montoTotal = driverConfig.driver.findElement(By.xpath("//*[@id=\"collapse-checkout-confirm\"]/div/div[1]/table/tfoot/tr[3]/td[2]"));
            waitSeconds(2);
            String valorMonto = montoTotal.getAttribute("innerText");
//            if (!valorMonto.equalsIgnoreCase("$205.00")){
//                mensaje = "El valor del monto total de la compra no coincide";
//            }
        }else {
            mensaje = "No se logra visualizar el monto total de la compra";
        }
        return mensaje;
    }

    public String realizarCompra() {
        String mensaje = "";
        if (waitElementoVisible(driverConfig.driver.findElement(By.id("button-confirm")), 30)) {
            WebElement confirmarOrden = driverConfig.driver.findElement(By.id("button-confirm"));
            confirmarOrden.click();
        } else {
            mensaje = "No se logra visualizar el boton para confirmar la compra";
        }
        return mensaje;
    }

    public String finalizarCompra() {
        String mensaje = "";
        waitSeconds(2);
        if (waitElementoVisible(driverConfig.driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")), 30)) {
            WebElement terminarCompra = driverConfig.driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a"));
            terminarCompra.click();
        } else {
            mensaje = "No se logra visualizar el boton para finalizar la compra";
        }
        return mensaje;
    }

    public String presionarMiCuenta() {
        String mensaje = "";
        waitSeconds(2);
        if (waitElementoVisible(driverConfig.driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")), 20)) {
            WebElement presionarMiCuenta = driverConfig.driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a"));
            presionarMiCuenta.click();
        } else {
            mensaje = "No se logra visualizar el icono de mi sesion de usuario";
        }
        return mensaje;
    }

    public String seleccionarMyAccount() {
        String mensaje = "";
        waitSeconds(2);
        if (waitElementoVisible(driverConfig.driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")), 20)) {
            WebElement myAccount = driverConfig.driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a"));
            myAccount.click();
        } else {
            mensaje = "No se logra visualizar la opcion My Account";
        }
        return mensaje;
    }


    public String verDatosDireccion() {
        String mensaje = "";
        waitSeconds(2);
        if (waitElementoVisible(driverConfig.driver.findElement(By.xpath("//*[@id=\"content\"]/ul[1]/li[3]/a")), 20)) {
            WebElement datosDireccion = driverConfig.driver.findElement(By.xpath("//*[@id=\"content\"]/ul[1]/li[3]/a"));
            datosDireccion.click();
        } else {
            mensaje = "No se logra visualizar los datos de direccion";
        }
        return mensaje;
    }

    public String verOrderHistory() {
        String mensaje = "";
        waitSeconds(2);
        if (waitElementoVisible(driverConfig.driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]")), 20)) {
            WebElement orderHistory = driverConfig.driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]"));
            orderHistory.click();
        } else {
            mensaje = "No se logra visualizar la opcion Order History";
        }
        return mensaje;

    }

    public String validarEstadoCompra() {
        String mensaje = "";
        waitSeconds(2);
        if (waitElementoVisible(driverConfig.driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr/td[4]")), 20)) {
            WebElement estadoCompra = driverConfig.driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr/td[4]"));
            String textoCompra = estadoCompra.getAttribute("innerText");
            if (!textoCompra.equalsIgnoreCase(driverConfig.DataCarroCompra.getEstadoCompra())){
                mensaje = "No se logra visualizar el texto del estado de compra";
            }
        }else {
            mensaje = "No se logra visualizar el objeto estado de compra";
        }return mensaje;
    }

    public String cierroSesion() {
        String mensaje = "";
        waitSeconds(2);
        if (waitElementoVisible(driverConfig.driver.findElement(By.xpath("//*[@id=\"column-right\"]/div/a[13]")), 20)) {
            WebElement cerrarSesion = driverConfig.driver.findElement(By.xpath("//*[@id=\"column-right\"]/div/a[13]"));
            cerrarSesion.click();
        } else {
            mensaje = "No se logra visualizar el boton Cerrar sesion";
        }
        return mensaje;
    }

}
