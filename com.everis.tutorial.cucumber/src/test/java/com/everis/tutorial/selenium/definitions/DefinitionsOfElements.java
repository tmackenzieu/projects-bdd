package com.everis.tutorial.selenium.definitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DefinitionsOfElements {
	static WebDriver driver;
	public static WebElement buttonLoginUdemy = driver.findElement(By.xpath("//a/img[@alt='Iniciar sesión']"));
	public static WebElement inputEmail = driver.findElement(By.xpath("//input[@id='CustomerEmail']"));
	public static WebElement inputPassword = driver.findElement(By.xpath("//input[@id='CustomerPassword']"));
	public static WebElement inputSubmitLogin = driver.findElement(By.xpath("//input[@value='Ingresar']"));

}