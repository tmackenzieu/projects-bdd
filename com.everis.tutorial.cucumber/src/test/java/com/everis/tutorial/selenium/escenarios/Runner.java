package com.everis.tutorial.selenium.escenarios;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"features/busquedaGoogle.feature"}, glue = {"com.everis.tutorial.selenium.definitions"})
public class Runner {

}