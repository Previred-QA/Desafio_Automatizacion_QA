package casoQA2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import javax.imageio.ImageIO;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class abrirPagina {

	public static void main(String[] args) throws InterruptedException, CsvValidationException, IOException {
		
		
        WebDriver driver;
        
        
        System.setProperty("webdriver.chrome.driver", "/Users/mac/eclipse-workspace/casoQA2/chromedriver");
	
        driver = new ChromeDriver();
        
        driver.get("http://opencart.abstracta.us/index.php?route=common/home");
        driver.manage().window().maximize();
        
        WebElement search1 = driver.findElement(By.name("search"));
        
        search1.sendKeys("IPOD CLASSIC");
        
        WebElement btnSearch1 = driver.findElement(By.xpath("//*[@id=\"search\"]/span/button"));
        
        btnSearch1.click();
        
        File screenshotFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile1, new File("/Users/mac/Downloads/Evidencia1.jpg"));
        
        
        WebElement btnCarrito1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[1]"));
        
        btnCarrito1.click();
        
        WebElement search2 = driver.findElement(By.name("search"));
        search2.clear();
        
        WebElement search3 = driver.findElement(By.name("search"));
        search3.sendKeys("Imac");
        
        WebElement btnSearch2 = driver.findElement(By.xpath("//*[@id=\"search\"]/span/button"));
        
        btnSearch2.click();
        File screenshotFile2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile2, new File("/Users/mac/Downloads/Evidencia2.jpg"));
      
        WebElement btnCarrito2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[1]"));
        
        btnCarrito2.click();
        
        WebElement btnComprar = driver.findElement(By.cssSelector("#top-links > ul > li:nth-child(4) > a > i"));
        
        btnComprar.click();
        
        WebElement btnProcesar = driver.findElement(By.linkText("Checkout"));
        
        btnProcesar.click();
        
        String CSV_PATH = "/Users/mac/Downloads/TestData.csv";
        
        CSVReader csvReader;
        String[] csvCell;
        

            csvReader = new CSVReader(new FileReader(CSV_PATH));
     
            while ((csvCell = csvReader.readNext()) != null) {
                String CustomerEmail = csvCell[0];
                String CustomerPassword = csvCell[1];
                
                driver.findElement(By.id("input-email")).sendKeys(CustomerEmail);
                driver.findElement(By.id("input-password")).sendKeys(CustomerPassword);
                driver.findElement(By.id("button-login")).click();
            }
            
            Thread.sleep(2000);
            File screenshotFile3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile3, new File("/Users/mac/Downloads/Evidencia3.jpg"));
            WebElement btnPagar = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div/form/div[5]/div/input"));
            btnPagar.click();
            Thread.sleep(2000);
            
            File screenshotFile4 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile4, new File("/Users/mac/Downloads/Evidencia4.jpg"));
            WebElement btnDireccion =driver.findElement(By.id("button-shipping-address"));
            btnDireccion.click();
            Thread.sleep(2000);
            
            File screenshotFile5 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile5, new File("/Users/mac/Downloads/Evidencia5.jpg"));
            WebElement btnMetodo = driver.findElement(By.id("button-shipping-method"));
            btnMetodo.click();
            Thread.sleep(2000);
            
            WebElement radio1 = driver.findElement(By.xpath("//*[@id=\"collapse-payment-method\"]/div/div[2]/div/input[1]"));
            radio1.click();
            Thread.sleep(2000);
            
            File screenshotFile6 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile6, new File("/Users/mac/Downloads/Evidencia6.jpg"));
            WebElement btnPago = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[5]/div[2]/div/div[2]/div/input[2]"));
            btnPago.click();
            Thread.sleep(2000);
            
            File screenshotFile7 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile7, new File("/Users/mac/Downloads/Evidencia7.jpg"));
            WebElement btnConfirmar = driver.findElement(By.id("button-confirm"));
            btnConfirmar.click(); 
            Thread.sleep(2000);
            
            WebElement lknHistorial = driver.findElement(By.linkText("history"));
            lknHistorial.click();
            File screenshotFile8 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile8, new File("/Users/mac/Downloads/Evidencia8.jpg"));
            
            WebElement lknVer = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr[1]/td[7]/a"));
            lknVer.click(); 
            File screenshotFile9 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile9, new File("/Users/mac/Downloads/Evidencia9.jpg"));
            
            Boolean isiMac = driver.findElements(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr[1]/td[1]")).size()>0;
            System.out.println("Existe Producto iMac: "+ isiMac);
            
            Boolean isiPod = driver.findElements(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr[2]/td[1]")).size()>0;
            System.out.println("Existe Producto iPod Classic: "+ isiPod);
            
            Boolean isPendiente = driver.findElements(By.xpath("//*[@id=\"content\"]/table[3]/tbody/tr/td[2]")).size()>0;
            System.out.println("El Estatus de la Orden es Pendiente: "+ isPendiente);
            
            WebElement drpCuenta = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a"));
            drpCuenta.click();
            
            WebElement cerrarSesion = driver.findElement(By.linkText("Logout"));
            
            cerrarSesion.click();
            
            
            WebElement drpCuenta2 = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a"));
            drpCuenta2.click();
            
            WebElement registrar = driver.findElement(By.linkText("Register"));
            
            registrar.click();
            Thread.sleep(1000);
            
            
     
        WebElement nombre = driver.findElement(By.name("firstname"));
        
        nombre.sendKeys("kris");
        
        WebElement apellido = driver.findElement(By.name("lastname"));
        
        apellido.sendKeys("lopez");
        
        WebElement correo = driver.findElement(By.name("email"));
        
        correo.sendKeys("pruebakris@gmail.com");
        
        WebElement telefono = driver.findElement(By.name("telephone"));
        
        telefono.sendKeys("920584550");
        
        WebElement clave = driver.findElement(By.name("password"));
        
        clave.sendKeys("123456789");
        
        WebElement claveConfirma = driver.findElement(By.name("confirm"));
        
        claveConfirma.sendKeys("123456789");
        
        WebElement radio2 = driver.findElement(By.name("agree"));
        
        radio2.click();
        
        Thread.sleep(1000);
        
        File screenshotFile10 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile10, new File("/Users/mac/Downloads/Evidencia10.jpg"));
        
        WebElement btnRegistrar2 = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));
        
        btnRegistrar2.submit();
        
        File screenshotFile11 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile11, new File("/Users/mac/Downloads/Evidencia11.jpg"));
        
        
        //Thread.sleep(10000);
        driver.quit();
        

	}

}
