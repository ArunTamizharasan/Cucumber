Feature: Amazon login Feature
Scenario: Verification of  login Functionality in Amazon
Given user navigates to Amazon
And user click the sign in button for Sign Page
When user entering email "arun.engineer92@gmail.com"
And user click the continue button
When user entering passwod "Good_start!7"
And user click the Sign in button
Then user close the browser