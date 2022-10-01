package com.example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebAutomationLogin {
@Test
	public void login() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Softwares/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8080/login");
		
		WebElement username = driver.findElement(By.id("username"));
		Thread.sleep(3000);
		WebElement password = driver.findElement(By.id("password"));
		WebElement login = driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/form/div[3]/button"));
		
		username.clear();
		username.click();
		username.sendKeys("sasuk552@gmail.com");
		
		password.clear();
		password.click();
		password.sendKeys("123456");
		//driver.switchTo().alert().dismiss();
		login.click();
		

		String actualUrl = "http://localhost:8080/users";
		String expectedUrl = driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	}

}