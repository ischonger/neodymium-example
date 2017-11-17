Feature: Register 
    
@Register
Scenario Outline: Register a new customer
  Given The browser "<browser>" is open
  And I am on the homepage of the Posters shop
  And I am not logged in
  When I click the login button
  Then I want to be on the login page
  When I click the register button
  Then I want to be on the register page
  When I fill the register form with "<firstName>", "<lastName>", "<email>", "<password>", "<password>" and send it  
  Then I want to be registered successfully 
  And I want to be on the login page
  When I fill the register form with "<email>" and "<password>" and send it
  Then I want to be logged in successfully with "<firstName>"
  
  Examples:
    | browser         | firstName | lastName | email        | password  |
    | Chrome_1024x768 | Jane      | Doe      | jane@doe.com | topsecret |