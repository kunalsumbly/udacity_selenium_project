package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest {
	public static void main(String[] args) throws InterruptedException {
		WebDriver chromeDriver = null;
		
			WebDriverManager.chromedriver().setup();

			chromeDriver = new ChromeDriver();

			chromeDriver.get("http://localhost:8080/animal");
			try {
				WebElement findElement = chromeDriver.findElement(By.tagName("h1"));
				
				boolean equals = findElement.getText().equals("I think that's enough!");
				
				if (equals) {
					System.out.println("Limit reached , quit now");
					chromeDriver.quit();
				}
			} catch (Exception e) {
				System.out.println("No h1 tag exists");
			}
			
			try {
				for (int i = 1; i <= 6; i++) {
					WebElement animalText = chromeDriver.findElement(By.id("animalText"));
	
					WebElement adjective = chromeDriver.findElement(By.id("adjective"));
	
					List<WebElement> findElements = chromeDriver.findElements(By.tagName("input"));
	
					Optional<WebElement> submitButton = findElements.stream()
							.filter(element -> element.getAttribute("type").equalsIgnoreCase("submit")).findAny();
	
					animalText.sendKeys("animal" + i);
					adjective.sendKeys("adjective" + i);
					submitButton.get().click();
					Thread.sleep(1000);
				}

			
			} catch (Exception e) {
				System.out.println("in exception"+e.getMessage());
			} 
		chromeDriver.quit();
	}
}
