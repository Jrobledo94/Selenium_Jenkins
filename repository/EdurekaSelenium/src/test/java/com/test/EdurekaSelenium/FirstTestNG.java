package com.test.EdurekaSelenium;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTestNG {
	
	
		WebDriver driver;
	
	//variables for Winium Driver
		WiniumDriverService service;
		WiniumDriver driverWinium;
		DesktopOptions options;
	
	LoginPage objLoginPage;
	
	MenuPrincipal objMenuPrincipal;
	
	RealizarCorte objRealizarCorte;
	
	DesktopAppController objDesktopAppController;
	
	
	
	
	@BeforeTest
	public void setup() {
		
		//Set up for the selenium Driver
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.get("http://wls33.tgc.mx:8080/re_login/faces/infraestructura/login.jspx?_adf.ctrl-state=s7xuq5fq7_3");		
		
		
	}
	
	
	@Test
	public void test_recalcularcorte() {
		
		//Create new logIn page object
		objLoginPage = new LoginPage(driver);
		
		objLoginPage.loginRecaudador("RECAUDADOR", "THEBIGONE");
		
		//Create new menuPrincipal page object
		objMenuPrincipal = new MenuPrincipal(driver);
		
		objMenuPrincipal.clickRealizarCorte();
		
		//Create new RealizarCorte page Object
		objRealizarCorte = new RealizarCorte(driver);
		
		objRealizarCorte.setInstrumentoDePago(1);
		
		objRealizarCorte.setBillete200("3");
		
		objRealizarCorte.setMoneda10("3");
		
		objRealizarCorte.clickRecalcular();
		
		objRealizarCorte.clickRealizarCorte();
		
		
	}
	
	@AfterTest
	public void tearDown(){
		objDesktopAppController.StopService(service);
	}

}
