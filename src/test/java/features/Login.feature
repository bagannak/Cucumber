Feature: Application Login

  Scenario Outline: Home page default login
    Given User is on NetBanking landing page
    When User login to the application with <arg0> and <arg1>
    Then Home page is populated
    And Cards are displayed
    Examples:
      | arg0      | arg1   |
      | "Baganna" | "1234" |

  Scenario Outline: Home page default login
    Given User is on NetBanking landing page
    When User login to the application with <arg0> and <arg1>
    Then Home page is populated
    And Cards are not displayed
    Examples:
      | arg0     | arg1    |
      | "roshan" | "12354" |