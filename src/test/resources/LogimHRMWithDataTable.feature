Feature: This is the Login feature for Orange HRM
Scenario: This is login scenario with Data table 
Given the user is on login page
When the user enter the below credentials
|Admin|admin123|
And the user click the login button 
Then the user should be navigated to home page