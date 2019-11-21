Feature: User panel

  @wordpress @login @userprofile
  Scenario: user Login
    Given User starts on main page
    When User logs to the user panel
    Then User can modify user profile