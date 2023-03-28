package utilFunction;

import driver.driverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static utilFunction.readProperties.propertiesRead;

public class utilFunctions extends driverConfig {

    public void ingresarUrl(String tipoUrl) throws Exception {
        driver.manage().deleteAllCookies();
        driver.get(tipoUrl);
    }

    public WebElement esperarElementoClickable(By byElement, int tiempo) {
        WebElement elemento = null;
        elemento = new WebDriverWait(driver, tiempo).until(ExpectedConditions.elementToBeClickable(byElement));
        return elemento;
    }

    public WebElement esperarElementoVisible(By byElement, int tiempo) {
        WebElement elemento = null;
        elemento = new WebDriverWait(driver, tiempo).until(ExpectedConditions.visibilityOfElementLocated(byElement));
        return elemento;
    }

    public boolean waitElementoVisible(WebElement elemento, int timeout) {
        Boolean isElementPresent = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver,timeout);
            wait.until(ExpectedConditions.visibilityOf(elemento));
            isElementPresent = elemento.isDisplayed();
            return isElementPresent ;
        }catch (TimeoutException e) {
            System.out.println("No esta visible o no existe el elemento: " + elemento);
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean waitElementoClickable(WebElement elemento, int timeout) {
        Boolean isElementClicleable = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver,timeout);
            wait.until(ExpectedConditions.elementToBeClickable(elemento));
            isElementClicleable = elemento.isDisplayed();
            return isElementClicleable ;
        }catch (TimeoutException e) {
            System.out.println("No elemento no clicleable: " + elemento);
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean existWebElemento(WebElement elemento) {
        Boolean isElementPresent = false;
        try {

            isElementPresent = elemento.isDisplayed();
            return isElementPresent;
        }catch (TimeoutException e) {
            System.out.println("No elemento no existe");
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void waitSeconds(int segundos) {
        synchronized (driver) {
            try {
                driver.wait(segundos * 1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                System.out.println(e.getMessage());
            }
        }
    }

    public void ingresarTexto(WebElement elemento, String valor) {
        elemento.sendKeys(valor);
    }

    public void hacerClicElemento(WebElement elemento) {
        elemento.click();
    }

    public void moverHastaElemento(WebElement elemento){
        Actions builder = new Actions(driver);
        builder.moveToElement(elemento).build().perform();
    }

    public String textoDelElemento(WebElement elemento){
        return elemento.getText();
    }

    public void cambioDeIframe(WebElement elemento){
        driver.switchTo().frame(elemento);
    }

    public void defaultIframe(){
        driver.switchTo().defaultContent();
    }

    public void seleccionar(WebElement selectelement, String valor){
        Select select = new Select(selectelement);
        select.selectByVisibleText(valor);
    }

    public void seleccionar(By byElement, String valor){
        Select select = new Select(driver.findElement(byElement));
        select.selectByVisibleText(valor);
    }

    public void seleccionar(By byElement, int valor){
        Select selectSize = new Select(driver.findElement(byElement));
        selectSize.selectByIndex(valor);
    }

    public  void highlightRedElement(WebElement elemento){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].setAttribute('style', 'border: 3px solid red;')", elemento);
    }

    public  void highlightGreenElement(WebElement elemento){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].setAttribute('style', 'border: 3px solid green;')", elemento);
    }

    public static void scrollElement(WebElement elemento){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", elemento);
    }

    // **** FUNCIONES PROPIAS DE SITIO WEB AGU ***
    public String validarListaSelectRol(WebElement contLista, String opcionList) {
        Boolean resp = true;
        String mensaje = "";
        int numOption = 0;
        List<WebElement> listaDinamica = null;
        listaDinamica = contLista.findElements(By.className("pf-c-select__menu-item"));
        if (listaDinamica.size() > 0) {
            List<String> dateListString = new ArrayList<String>();
            for (WebElement nombre : listaDinamica) {
                dateListString.add(nombre.getText());
            }

            //*** CLICK EN LA OPCION INDICADA ***
            if (resp == true) {
                for (int j = 0; j < dateListString.size(); j++) {
                    if (dateListString.get(j).equalsIgnoreCase(opcionList)) {
                        numOption = j;
                        break;
                    }
                }
                listaDinamica.get(numOption).click();
            }
        }else {
            mensaje = "No se logra visualizar lista con contenido";
        }
        return mensaje;
    }

    public String validarListaSeleccionGrupo(List<WebElement> listGrupoWeb, String opcGrupo) {
        String mensaje = "";
        String textoGrupoWeb = "";
        int contadorGruposValidos = 0;
        if (listGrupoWeb.size() > 0) {
            //*** VALIDACION LISTAS DE LOS GRUPOS SELECCIONADOS ***
            String[] arrayGrupos = opcGrupo.split(":");
            if (listGrupoWeb.size() == arrayGrupos.length){
                for (int j = 0; j < listGrupoWeb.size(); j++) {
                    if (contadorGruposValidos == j){
                        textoGrupoWeb = listGrupoWeb.get(j).getAttribute("innerText").toString();
                        for (String nomGrupo : arrayGrupos) {
                            if (textoGrupoWeb.equalsIgnoreCase(nomGrupo)) {
                                highlightGreenElement(listGrupoWeb.get(j));
                                contadorGruposValidos ++;
                                break;
                            }
                        }
                    }else {
                        highlightRedElement(listGrupoWeb.get(contadorGruposValidos));
                        mensaje = "Texto del grupo no corresponde con el ingresado :" + listGrupoWeb.get(contadorGruposValidos);
                        break;
                    }
                }
            }else {
                mensaje = "Las opciones de grupos ingresadas no son las mismas visualizadas en la web";
            }
        }else {
            mensaje = "No se logra visualizar grupos del usuario seleccionado";
        }
        return mensaje;
    }

    public String validarUsuarioLista(WebElement contLista, String opcionList) {
        String mensaje = "";
        String textEmail = "";
        int numOption = -1;
        List<WebElement> listaDinamica = null;
        listaDinamica = contLista.findElements(By.xpath("//*[@data-ouia-component-type=\"PF4/TableRow\"]"));
        if (listaDinamica.size() > 1) {
            for (int j = 1; j < listaDinamica.size(); j++) {
                textEmail = listaDinamica.get(j).findElement(By.id("email")).getAttribute("innerText").toString();
                if (textEmail.equalsIgnoreCase(opcionList)) {
                    numOption = j;
                    break;
                }
            }
            if (numOption == -1) {
                mensaje = "No se logra visualizar usuario con correo " + opcionList + " en la lista de usuarios";
            }else {
                highlightGreenElement(listaDinamica.get(numOption));
            }
        }else {
            mensaje = "No se logra visualizar lista de usuarios con contenido";
        }
        return mensaje;
    }

    public String validarUsuarioListaEstado(WebElement contLista, String opcionList, String opcEstado) {
        String mensaje = "";
        String textEmail = "";
        String textEstado = "";
        Boolean resp = false;
        List<WebElement> listaDinamica = null;
        listaDinamica = contLista.findElements(By.xpath("//*[@data-ouia-component-type=\"PF4/TableRow\"]"));
        if (listaDinamica.size() > 1) {
            for (int j = 1; j < listaDinamica.size(); j++) {
                textEmail = listaDinamica.get(j).findElement(By.id("email")).getAttribute("innerText").toString();
                textEstado = listaDinamica.get(j).findElement(By.id("estado")).getAttribute("innerText").toString();
                if (textEmail.equalsIgnoreCase(opcionList)) {
                    if (textEstado.equalsIgnoreCase(opcEstado)) {
                        highlightGreenElement(listaDinamica.get(j));
                        highlightGreenElement(listaDinamica.get(j).findElement(By.id("estado")));
                        resp = true;
                        break;
                    }
                }
            }
            if (resp == false) {
                mensaje = "No se logra visualizar usuario con correo " + opcionList + " en la lista de usuarios";
            }
        }else {
            mensaje = "No se logra visualizar lista de usuarios con contenido";
        }
        return mensaje;
    }

    public String clickMenuUsuario(WebElement contLista, String opcionList) {
        String mensaje = "";
        String textEmail = "";
        int numOption = -1;
        List<WebElement> listaDinamica = null;
        listaDinamica = contLista.findElements(By.xpath("//*[@data-ouia-component-type=\"PF4/TableRow\"]"));
        if (listaDinamica.size() > 1) {
            for (int j = 1; j < listaDinamica.size(); j++) {
                textEmail = listaDinamica.get(j).findElement(By.id("email")).getAttribute("innerText").toString();
                if (textEmail.equalsIgnoreCase(opcionList)) {
                    numOption = j;
                    break;
                }
            }
            if (numOption == -1) {
                mensaje = "No se logra visualizar usuario con correo " + opcionList + " en la lista de usuarios";
            }else {
                highlightGreenElement(listaDinamica.get(numOption));
                listaDinamica.get(numOption).findElement(By.id("acciones")).click();
            }
        }else {
            mensaje = "No se logra visualizar lista de usuarios con contenido";
        }
        return mensaje;
    }

}
