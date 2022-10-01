package com.example.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class logintest {
	WebDriver driver;
	@BeforeClass
	public void testSetup() {
		System.setProperty("webdriver.chrome.driver", "F:\\Softwares\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@BeforeMethod
	public void openBrowser() {
		driver.get("http://localhost:8080/login");
		System.out.println("We are currently on the following URL" + driver.getCurrentUrl());
	}

	@Test(description = "This method validates the login functionality")
	public void login() {
		driver.findElement(By.id("username")).sendKeys("pooja@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456789");
		driver.switchTo().alert().dismiss();
		driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/form/div[3]/button")).click();

	}


	  @AfterMethod
	  public void afterMethod() {

			String actualUrl = "http://localhost:8080/login";
			String expectedUrl = driver.getCurrentUrl();
			Assert.assertEquals(expectedUrl, actualUrl);
		 
	  }

	  @AfterClass
	  
	  public void afterclass() {
		  driver.close();
			System.out.println("Finished Test On Chrome Browser");
	  }
}
