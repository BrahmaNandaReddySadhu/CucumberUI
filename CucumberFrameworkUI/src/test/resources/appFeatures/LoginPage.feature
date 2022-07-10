Feature: Login page Features

# http://automationpractice.com/index.php?controller=my-account

Scenario: Login Page Title
Given user is on Login page 
When user get the titleof the page
Then page title should be "Login - My Store"


Scenario: Forget Password link
Given user is on Login page
Then forgot your password link should display


Scenario: Login with Correct Details 
Given user is on Login page
When user enter the username "testautomation0009@gmail.com"
And user enter the password "testautomation0009@gmail.com"
And user click on the login button
When user get the titleof the page
And page title should be "My account - My Store"