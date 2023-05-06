Feature: To validate the login functionality of drakes application

  Scenario: To validate the login functionality with invalid credentials
    Given The user should be drakes login page
    When The user should fill the username "heerajan@gmail.com"  and password "12345"
    And The user should click the login button
    Then The user should be navigate to invalid login page
