Feature: Login to the application

  Background: Landing page
    Given User is on landing page

  @Smoke
  Scenario: Validate User login is success
    When User enters uname and password
    And  Click on Login button
    Then User navigated to my orders section

  @Regression
  Scenario: Validate User navigated to Wishlist page
    When User enters uname and password
    And  Click on Login button
    Then User navigated to my orders section
    When User clicks on your wish list
    Then user should navigate to wishlist page


  @Regression
  Scenario Outline: Validate error message for invalid data
    When User type "<email>" and "<password>"
    And  Click on Login button
    Then error message should trigger

    Examples:
      | email    | password   |
      | Devopss  | AffairTEst |
      | Cucumber | BDDFORMAT  |
      | GEreal   | Cloud      |

  @RegisterTest
  Scenario: fill the registration form
    When user clicks on My Account
    When Register link is clicked
    Then validate Registration form opens and fill the form
      | fname | lname | email                | phno       | pwd     | conpwd  |
      | Peter | James | jamesPeter@gmail.com | 8329892389 | testing | testing |
    And validate your account has been created text

