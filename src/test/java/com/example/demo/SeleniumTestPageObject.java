package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import io.github.bonigarcia.wdm.WebDriverManager;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SeleniumTestPageObject {

	@LocalServerPort
    private Integer port;
	
	private static WebDriver driver;
    
    private AnimalPage animalPage;

    @BeforeAll
    public static void beforeAll() {
    	WebDriverManager.chromedriver().setup();
    	driver = new ChromeDriver();
    }
    
    
    @AfterAll
    public static void afterAll() {
    	driver.quit();
    }
    
    @BeforeEach
    public void beforeEach() {
        driver.get("http://localhost:" + port + "/animal");
        animalPage = new AnimalPage(driver);
    }
    
    
    @Test
    public void testConclusionMessage() throws InterruptedException {
    	 for (int i =1 ; i <=6 ; i++) {
    		 animalPage.submitValues(driver, i);
    	 }
    	 
    	 assertEquals(true, animalPage.quit());
    	 
    	 // Thread.sleep(10000);
    }

}
