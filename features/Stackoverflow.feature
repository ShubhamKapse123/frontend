Feature: Stackoverflow 

  Scenario: Test the user function
  	Given I lauch chrom browser
    And I open the stackoverflow page
    When Page is open i want to go  browser question section
    And Click on the users in the left section
    Then Click on editors
    And Get the user name which has the max number of edits count
    And Get the user name location edits count in next page
    

