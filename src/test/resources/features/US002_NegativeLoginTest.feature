@smoke @us02
Feature: US1002 Negative login test
  @tc02
  Scenario: TC02 Negative login test with correct email and wrong password
    Given user opens the trendyol application
    And user clicks on the my account tab
    Then user enters "ValidEmail" as email
    And user enters "InvalidPassword" as password
    And user clicks on the login button
    And it is verified that the user could not log in
    And user closes the application
  @tc03
  Scenario: TC03 Negative login test with wrong email and correct password
    Given user opens the trendyol application
    And user clicks on the my account tab
    Then user enters "InvalidEmail" as email
    And user enters "ValidPassword" as password
    And user clicks on the login button
    And it is verified that the user could not log in
    And user closes the application
  @tc04
  Scenario: TC04 Negative login test with wrong email and wrong password
    Given user opens the trendyol application
    And user clicks on the my account tab
    Then user enters "InvalidEmail" as email
    And user enters "InvalidPassword" as password
    And user clicks on the login button
    And it is verified that the user could not log in
    And user closes the application
