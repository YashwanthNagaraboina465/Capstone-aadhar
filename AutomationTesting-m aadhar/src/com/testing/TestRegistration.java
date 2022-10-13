package com.testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestRegistration {
	WebDriver webdriver = null;
	String URL = "http://localhost:4200/home";
	
// By full xpath testing(Relative Testing)
	
	@Test
	public void registration() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");

		WebDriver webdriver = new ChromeDriver();
		webdriver.get(URL);
		webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		webdriver.manage().window().maximize();
		webdriver.findElement(By.xpath("//button[normalize-space()='Register New Citizen']")).click();
		webdriver.findElement(By.xpath("//ul[@class='navbar-nav mr-auto']//a[@class='nav-link']")).click();
		webdriver.findElement(By.xpath("//form[@class='ng-untouched ng-pristine ng-invalid']//input[@id='fullname']"))
				.sendKeys("Testing Name@max");
		webdriver.findElement(By.xpath("(//input[@id='dob'])[1]"))
				.sendKeys("02/01/2201");
		webdriver.findElement(By.xpath("(//input[@id='email'])[1]"))
				.sendKeys("max@Testing.com");
		webdriver.findElement(By.xpath("(//input[@id='address'])[1]"))
				.sendKeys("1-12,dollas,uk");
		webdriver.findElement(By.xpath("(//input[@id='gender'])[1]"))
				.sendKeys("Male");
		webdriver.findElement(By.xpath("(//input[@id='phone'])[1]"))
				.sendKeys("123456777");
		webdriver.findElement(By.xpath("(//input[@id='imageUrl'])[1]"))
				.sendKeys("https://static.vecteezy.com/system/resources/thumbnails/000/464/891/small/bussman1-15.jpg");
		webdriver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("Registration Tested Succesfully");
	}
}
