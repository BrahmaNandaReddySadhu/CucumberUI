Feature: Account page Features 

Background: 
	Given login to the application with the Credentials
	    |Usernme| password|
		|testautomation0009@gmail.com |testautomation0009@gmail.com|
		

Scenario: Account page Title
Given user is on account page
When user get the titleof the page
Then page title should be "Login - My Store" 
		