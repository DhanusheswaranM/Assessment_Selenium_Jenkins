package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='user-name']")
	public WebElement username ;
	
	@FindBy(xpath="//input[@id='password']")
	public WebElement password ;
	
	@FindBy(xpath="//input[@id='login-button']")
	public WebElement loginBtn ;
	
	@FindBy(xpath="//div[@id=\"login_button_container\"]/div/form/h3")
	public WebElement errormsg ;
	
	@FindBy(xpath="//div[@class='product_label']")
	public WebElement loggedinEnsure ;
	
}
