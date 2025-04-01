package com.Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Pages.HomePage;
import com.utilities.LoginData;
@Listeners(com.utilities.Listener.class)

public class LoginTest extends BaseTest {
	HomePage objHP ;
  @Test(dataProvider = "LoginCredentials" , dataProviderClass = LoginData.class)
  public void Login(String name , String pwd) {
	  Assert.assertTrue(driver.get().getTitle().contains("Swag Labs"));
	  objHP = new HomePage(driver.get());
	  
	  objHP.username.sendKeys(name);
	  objHP.password.sendKeys(pwd);
	  objHP.loginBtn.click();
	  
	  try {
		  if(objHP.loggedinEnsure.isDisplayed()) {
			  System.out.println("Logged in successfully");
		  }
//		  else if(objHP.errormsg.getText().contains("Username is required")) {
//			  System.out.println(objHP.errormsg.getText());
//		  }
//		  else if(objHP.errormsg.getText().contains("Password is required")) {
//			  System.out.println(objHP.errormsg.getText());
//		  }
		  else {
			  System.out.println(objHP.errormsg.getText());
		  }
	  }catch(Exception e) {
		  System.out.println(objHP.errormsg.getText());
	  }
	  
  }
}
