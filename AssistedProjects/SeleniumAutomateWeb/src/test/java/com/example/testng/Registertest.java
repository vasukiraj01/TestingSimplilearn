package com.example.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Registertest {

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
		driver.get("http://localhost:8080/register");
		System.out.println("We are currently on the following URL" + driver.getCurrentUrl());
	}

	@Test(description = "This method validates the sign up functionality")
	public void signUp() {
		driver.findElement(By.id("firstName")).sendKeys("Pooja");
		driver.findElement(By.id("lastName")).sendKeys("V");
		driver.findElement(By.id("email")).sendKeys("pooja@gmail.com");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/form/div[5]/button")).click();

	}

	@AfterMethod
	public void postSignUp() {
		System.out.println(driver.getCurrentUrl());

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}