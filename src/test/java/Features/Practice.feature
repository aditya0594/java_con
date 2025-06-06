Feature: Practicing the all the functions of selenium
#  @radio
#  Scenario: To perform the concept of selenium
#    Given Open the url
#    When Click on the Radio Button Example first button
#    Then Verify the radio button is click
#
#  @DynamicDropdown
#  Scenario Outline: To perform the dynamic dropdown
#    Given Open the url
#    When Click on the Suggession Class Example field and enter intiails of "<Countries>"
#    Then Verify that selected country is in dropdown "<options>"
#
#    Examples:
#      |Countries|options|
#      |Ind    |India  |
#      |sin    |Singapore|
#
#  @dropdown
#  Scenario Outline: To perform the value from the dropdown
#    Given Open the url
#    When Select the "<option>" from the dropdown
#    Then Verify that selected value "<option>"
#
#    Examples:
#      |option|
#      |Option1|
#      |Option2|
#      |Option3|
#
#  @dropdown
#  Scenario: To perform new window and switch to the original
#    Given Open the url
#    When Click on the Open window button
#    And Switch to the original window
#  @dropdown
#  Scenario: To perform mouser hover and click on the option
#    Given Open the url
#    When Hover the mouse on the button
#    And Select the Top
#    Then Verify the Home button visibility
#  @dropdown
#  Scenario: Get all the course list
#    Given Open the url
#    When go the table
#    And Get list of course
#    Then Verify that list contains "REST API Testing with SoapUI"
#  @dropdown
#  Scenario: Open the new tab and and again click on the new tab
#    Given Open the url
#    When Click on the new tab
#    And Switch back to the parent window
#    And Click on the new window
#    And Switch on the parent Window
#    Then Verify we are on the parent window

#    @jquery
#  Scenario: Get all the course list
#    Given Open the url "https://the-internet.herokuapp.com/jqueryui/menu#"
#    When Hover to Enable
#    And Hover to Download
#    And Click on Pdf

  @dropdownWithDatatable
  Scenario: To perform the value from the dropdown
    Given Open the url
    When Select the option from the dropdown
      |option|
      |Option1|
      |Option2|
      |Option3|
    Then Verify that selected value option
      |option|
      |Option1|
      |Option2|
      |Option3|