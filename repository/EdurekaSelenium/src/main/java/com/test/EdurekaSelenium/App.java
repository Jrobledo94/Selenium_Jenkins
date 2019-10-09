package com.test.EdurekaSelenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
        System.out.println( "Hello World!" );

        WebDriverManager.chromedriver().setup();

   	 	WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize() ;

        driver.get("http://wls33.tgc.mx:8080/re_login/faces/infraestructura/login.jspx?_adf.ctrl-state=s7xuq5fq7_3");
        
        
        WebElement usuTxt = driver.findElement(By.name("txtUsuario"));
        usuTxt.sendKeys("RECAUDADOR");

        WebElement passTxt = driver.findElement(By.name("txtPass"));
        passTxt.sendKeys("THEBIGONE");
        
        WebElement loginButton = driver.findElement(By.id("cb1"));
        loginButton.click();
        
        
        // para estas acciones se necesita crear una clase aparte para usar Page Object porque es una pagina diferente
        WebElement realizarCorteButton = driver.findElement(By.id("cl2"));
        realizarCorteButton.click();
        
        
        // para estas acciones se necesita crear una clase aparte para usar Page Object porque es una pagina diferente
        Select selectOneInstrumentoPago = new Select(driver.findElement(By.id("j_id_id5:cxI")));
        selectOneInstrumentoPago.selectByVisibleText("MONEDA NACIONAL"); //a recorrer las opciones
        Thread.sleep(2000);
        WebElement billetes200TxtBox = 	driver.findElement(By.xpath("//td[text()='200.0']//following::td//child::input"));
        billetes200TxtBox.click();
        billetes200TxtBox.clear();
        billetes200TxtBox.sendKeys("3");
        
        
        System.out.println( "moneda" );
        WebElement moneda10TxtBox = 	driver.findElement(By.xpath("//td[text()=\"10.0\"]//following-sibling::td//child::input"));
        moneda10TxtBox.click();
        moneda10TxtBox.clear();
        moneda10TxtBox.sendKeys("3");
        
        WebElement recalcularButton = driver.findElement(By.xpath("//button[text()='Limpiar corte']"));
        recalcularButton.click();
        System.out.println(driver.switchTo().alert().getText());
        
        driver.switchTo().alert().accept();
        
        WebElement corteButton = driver.findElement(By.xpath("//button[text()='Realizar corte']"));
        corteButton.click();
        System.out.println(driver.switchTo().alert().getText());
        
        driver.switchTo().alert().accept();
        
        
        
        //------------------------------------------------
//        WebElement SearchBox = driver.findElement(By.id("twotabsearchtextbox"));
//        SearchBox.sendKeys("iPhone");

//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.get("http://wls33.tgc.mx:8080/re_login/faces/infraestructura/login.jspx?_adf.ctrl-state=s7xuq5fq7_3");

//        
//        
//        WebElement usuTxt = driver.findElement(By.name("txtUsuario"));
//        usuTxt.sendKeys("RECAUDADOR");
//
//        WebElement passTxt = driver.findElement(By.name("txtPass"));
//        passTxt.sendKeys("THEBIGONE");
//        
//        WebElement loginButton = driver.findElement(By.id("cb1"));
//        loginButton.click();
//        
//        
//        // para estas acciones se necesita crear una clase aparte para usar Page Object porque es una pagina diferente
//        WebElement realizarCorteButton = driver.findElement(By.id("cl2"));
//        realizarCorteButton.click();
//        
//        
//        // para estas acciones se necesita crear una clase aparte para usar Page Object porque es una pagina diferente
//        Select selectOneInstrumentoPago = new Select(driver.findElement(By.id("j_id_id5:cxI")));
//        selectOneInstrumentoPago.selectByVisibleText("MONEDA NACIONAL"); //a recorrer las opciones
//        Thread.sleep(2000);
//        WebElement billetes200TxtBox = 	driver.findElement(By.xpath("//td[text()='200.0']//following::td//child::input"));
//        billetes200TxtBox.click();
//        billetes200TxtBox.clear();
//        billetes200TxtBox.sendKeys("3");
//        
//        System.out.println( "moneda" );
//        WebElement moneda10TxtBox = 	driver.findElement(By.xpath("//td[text()=\"10.0\"]//following-sibling::td//child::input"));
//        moneda10TxtBox.click();
//        moneda10TxtBox.clear();
//        moneda10TxtBox.sendKeys("3");
//        
//        
//        WebElement recalcularButton = driver.findElement(By.xpath("//button[text()='Recalcular']"));
//        recalcularButton.click();
//        
//                
//        WebElement corteButton = driver.findElement(By.xpath("//button[text()='Realizar corte']"));
//        corteButton.click();
//        System.out.println(driver.switchTo().alert().getText());
//
//        
//        driver.switchTo().alert().accept();
//
//        
//        System.out.println( "Fin" );
        
        //driver.quit();
    }
}
