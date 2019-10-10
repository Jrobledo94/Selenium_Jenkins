package com.test.EdurekaSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPrincipal {

	WebDriver driver;
	
	/**

     * All WebElements are identified by @FindBy annotation

     */
	
	@FindBy(id="cl2")

    WebElement realizarCorteButton;
	

	public MenuPrincipal(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
	}

    //Click on RealizarCorte button
    public void clickRealizarCorte(){

    	realizarCorteButton.click();
    } 
	
}
