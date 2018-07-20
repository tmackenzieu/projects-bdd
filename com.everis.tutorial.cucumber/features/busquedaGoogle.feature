Feature: Sign up new customer into the platform 
	In order to fidelize customers
As a cashier
I want to sign up new customers
		
Scenario: hacer clic en el primer elemento que encuentre de la busqueda 
	Given Navegar en la url "http://www.google.com" 
	When Ingresar en el campo de busqueda el texto "Hola mundo" 
	And Presionar enter en el campo 
	And Traer todos las urls de la busqueda 
	Then se carga la pagina 
	
Scenario Outline: login en spdigital 
	Given Navegar en la url "http://www.spdigital.cl" 
	When Seleccionar en el menú Iniciar Sesion 
	And  Ingrese <username> y <password> 
	Then Debe mostrarse un mensaje "Sesión iniciada exitosamente" 
	
	Examples: 
		|username|password|
		|tmackenzieu@gmail.com|h0laquetal|