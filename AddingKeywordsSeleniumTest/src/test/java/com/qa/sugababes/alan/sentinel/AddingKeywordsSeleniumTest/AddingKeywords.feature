Feature: Adding a keyword to the existing threat words list
As a NS Advisor 
I want to add a new keyword to the threat words list
So that I can keep up with emerging threats

Scenario: Add a keyword of valid length
Given the correct web address
When I click submit with a valid keyword
Then a message stating the keyword has been added is displayed

Scenario: Click submit with a word that is already in the threat word list
Given the correct web address
When I click submit and the word already exists
Then an error message is displayed

Scenario: Click submit without an entered keyword
Given the correct web address
When I click submit with no keyword entered
Then an error messaged is displayed