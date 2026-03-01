@smoke @us01
Feature: US1001 Positive login test
  @tc01
  Scenario: TC01 Positive Login Test with Email
    Given user opens the trendyol application
    And user clicks on the my account tab
    Then user enters "ValidEmail" as email
    And user enters "ValidPassword" as password
    And user clicks on the login button
    And it is verified that the user has successfully logged in
    And user closes the application


