@HomePage

Feature: Home page

  Scenario: Search on home page
    Given User is on home page
    When User search for: "some text"
    Then User is redirected to "http://automationpractice.com/index.php?controller=search"