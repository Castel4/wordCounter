Feature: WordCounter functionality

  Scenario Outline: User enters different types of text into the word counter
    Given the user is on the WordCounter page
    When the user types the text <word>
    Then it must have the number of words <words> and characters <characters>

    Examples:
      | word                                    | words | characters |
      | Test                                    | 1     | 4          |
      | T e s t                                 | 4     | 7          |
      |                                         | 0     | 1          |
      | line 1-line 2-line 3                    | 6     | 18         |
      | test    with    multiple    spaces      | 4     | 34         |
      | !@#$%^&*()_+=[]{}\| ;:'\",.<>?/`~       | 1     | 32         |
      | The year is 2024 and the price is 10.50 | 9     | 39         |



