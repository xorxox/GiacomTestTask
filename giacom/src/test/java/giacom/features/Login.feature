Feature: User Login
  User Login test

  Scenario: User log in with valid credentials
    Given User open login page
    When User login with valid login credentials (login: "admin", password: "bluebird")
    Then User is on landing page