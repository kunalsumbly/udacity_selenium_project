package com.example.demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class represents the Selenium page object
 */
public class AnimalPage {
	
	@FindBy(tagName = "h1")
	private WebElement finalConclusionMessage;
	
	@FindBy (id = "animalText")
	private WebElement animalText;
	
	
	@FindBy (id="adjective")
	private WebElement adjectiveText;
	
	
	@FindBy (tagName = "input")
	private List<WebElement> inputElements;
	
	private boolean quitFlag  = false; 
	
	private static final String CONCLUSION_MESSAGE  = "I think that's enough!";
	
	
	// Constructor 
	public AnimalPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean quit() {
		return finalConclusionMessage.getText().equals(CONCLUSION_MESSAGE);
	}
	
	
	private WebElement findSubmitButton() {
		return inputElements.stream().filter(element -> element.getAttribute("type").equalsIgnoreCase("submit")).findFirst().get();
	}
	
	public void submitValues(WebDriver driver, int i) {
		try {
				WebDriverWait wait = new WebDriverWait(driver, 1000);
				animalText = (WebElement) wait.until(x -> x.findElement(By.id("animalText")));
				adjectiveText = (WebElement) wait.until(x -> x.findElement(By.id("adjective")));
				animalText.sendKeys("animal"+i);
				adjectiveText.sendKeys("adjective"+i);
				findSubmitButton().click();
			
		} catch(Exception ex ) {
			ex.printStackTrace();
		} 
		
	}

}
