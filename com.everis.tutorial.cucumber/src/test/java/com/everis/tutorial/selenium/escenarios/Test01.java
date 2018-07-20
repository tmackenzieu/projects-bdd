package com.everis.tutorial.selenium.escenarios;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class Test01 {
	static WebDriver driver;

	@Before
	public void before() {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After
	public void after() {
		driver.close();
	}
}
