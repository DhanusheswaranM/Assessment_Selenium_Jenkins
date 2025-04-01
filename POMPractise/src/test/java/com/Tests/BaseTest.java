package com.Tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BaseTest {
	public static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
  @BeforeMethod
  public void beforeMethod() {
	  driver.set(new ChromeDriver());
	  driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get().manage().window().maximize();
	  driver.get().get("https://www.saucedemo.com/v1/index.html");
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.get().quit();
	  driver.remove();
  }

}
