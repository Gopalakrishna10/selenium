package com.selenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindowHandling {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
//		single window
//		String parentwindow=driver.getWindowHandle();
//		driver.findElement(By.id("newWindowBtn")).click();
//		Set<String>windowhandler=driver.getWindowHandles();
//		for(String handle:windowhandler) {
//			if(!handle.equals(parentwindow)) {
//				driver.switchTo().window(handle);
//				driver.manage().window().maximize();
//				driver.findElement(By.id("firstName")).sendKeys("Gopal");
//				Thread.sleep(3000);
//				driver.close();
//				}
//		}
//		
//		driver.switchTo().window(parentwindow);
//		driver.findElement(By.id("name")).sendKeys("gopal");
		
		
		
		String parentwindow=driver.getWindowHandle();
		driver.findElement(By.id("newTabBtn")).click();
		Set<String>windowhandler=driver.getWindowHandles();
		for(String handle:windowhandler) {
			if(!handle.equals(parentwindow)) {
				driver.switchTo().window(handle);
				driver.findElement(By.id("alertBox")).click();
				driver.switchTo().alert().accept();
				
				Thread.sleep(3000);
				driver.close();
				}
		}
		
		driver.switchTo().window(parentwindow);
		driver.findElement(By.id("name")).sendKeys("gopal");
		
		Thread.sleep(3000);
		driver.quit();
	
		
	}

}
