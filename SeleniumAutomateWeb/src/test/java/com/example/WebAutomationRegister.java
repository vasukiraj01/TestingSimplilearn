package com.example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class WebAutomationRegister {
  @Test
  public void register() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Softwares/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8080/register");
		
		WebElement firstname= driver.findElement(By.id("firstName"));
		Thread.sleep(1000);
		WebElement lastname= driver.findElement(By.id("lastName"));
		
		WebElement email= driver.findElement(By.id("email"));;
		WebElement password= driver.findElement(By.id("password"));
		WebElement register= driver.findElement(By.xpath("/html/body/div/div/div/div[2]/form/div[5]/button"));
		
		firstname.clear();
		firstname.click();
		firstname.sendKeys("Sasuke");
		
		lastname.clear();
		lastname.click();
		lastname.sendKeys("Ichiha");
		
		email.clear();
		email.click();
		email.sendKeys("sasuk552@gmail.com");
		
		password.clear();
		password.click();
		password.sendKeys("123456");
		
		register.click();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		String actualUrl = "http://localhost:8080/register?success";
		String expectedUrl = driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
  }
}
