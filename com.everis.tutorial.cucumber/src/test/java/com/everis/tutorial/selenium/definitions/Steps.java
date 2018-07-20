package com.everis.tutorial.selenium.definitions;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import com.everis.tutorial.selenium.domain.User;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.Utils;

public class Steps {
	static WebDriver driver;
	List<WebElement> listElementsFinder;
	List<List<String>> myList = new ArrayList<List<String>>();

	@Before
	public void before() {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "driver/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Given("^Navegar en la url \"([^\"]*)\"$")
	public void navegar_en_la_url(String arg1) throws Throwable {
		driver.get(arg1);
	}

	@When("^Ingresar en el campo de busqueda el texto \"([^\"]*)\"$")
	public void ingresar_en_el_campo_de_busqueda_el_texto(String arg1) throws Throwable {
		driver.findElement(By.xpath("//input[@id='lst-ib']")).sendKeys(arg1);
	}

	@When("^Presionar enter en el campo$")
	public void presionar_enter_en_el_campo() throws Throwable {
		driver.findElement(By.xpath("//input[@id='lst-ib']")).sendKeys(Keys.ENTER);
	}

	@When("^Traer todos las urls de la busqueda$")
	public void traer_todas_las_urls_de_la_lista() throws Throwable {
		listElementsFinder = driver.findElements(By.xpath("//div[@id='rso']//h3/a"));
		for (WebElement elementAofList : listElementsFinder) {
			String element = elementAofList.getAttribute("href");
			System.out.println(element);
		}
	}
	@Then("^se carga la pagina$")
	public void se_carga_la_pagina() throws Throwable {
		Thread.sleep(5000);
		Utils.takeEvidence(driver, null);
		String value = driver.findElement(By.xpath("//input[@id='lst-ib']")).getAttribute("value");
		Assert.assertEquals("Hola mundo", value);
	}

	@When("^Seleccionar en el menú Iniciar Sesion$")
	public void seleccione_en_el_menú_Iniciar_Sesión() throws Throwable {
		driver.findElement(By.xpath("//a/img[@alt='Iniciar sesión']")).click();
	}

	@When("^Ingrese <username> y <password>$")
	public void ingrese_usuario_y_contraseña(DataTable table) throws Throwable {
		List<User> users = new ArrayList<User>();
		users = table.asList(User.class);

		driver.findElement(By.xpath("//input[@id='CustomerEmail']")).sendKeys(users.get(0).username.toString());
		driver.findElement(By.xpath("//input[@id='CustomerPassword']")).sendKeys(users.get(0).password.toString());

		for (User user : users) {
			System.out.println("This username is : " + user.username);
			System.out.println("This password is : " + user.password);
		}
	}

	@When("^haga clic en iniciar sesion$")
	public void haga_clic_en_iniciar_sesion() throws Throwable {
		driver.findElement(By.xpath("//input[@value='Ingresar']")).click();
	}

	@Then("^^Debe mostrarse un mensaje \\\"([^\\\"]*)\\\"$")
	public void se_mostratra_un_mensaje_de_login_exitoso(String expectedMessage) throws Throwable {
		String messageResultOfLogin = driver.findElement(By.xpath("//div[@id=\"system-messages\"]/div")).getText();
		messageResultOfLogin =  messageResultOfLogin.replace("×\n", "");
		if(!expectedMessage.contains(messageResultOfLogin)) {
			throw  new Exception("Mensaje esperado " + expectedMessage + " no se encontró");
		}
	}

	@After
	public void after() {
		driver.close();
	}
}
