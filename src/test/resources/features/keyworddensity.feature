Feature: Validate Keyword Density on WordCounter

  Scenario: Validate basic keyword density
    Given the user accesses the WordCounter page
    When the user types the text
  """
  lumu lumu lumu lumu illuminates
  """
    Then the keyword densities should be:
      | lumu        | 80 |
      | illuminates | 20 |


  Scenario: Validate keyword density ignoring case
    Given the user accesses the WordCounter page
    When the user types the text
      """
      Lumu lumu LUMU illuminates
      """
    Then the keyword densities should be:
      | lumu        | 75 |
      | illuminates | 25 |


  Scenario: Validate keyword density with special characters
    Given the user accesses the WordCounter page
    When the user types the text
      """
      lumu! lumu? lumu, lumu. illuminates
      """
    Then the keyword densities should be:
      | lumu        | 80 |
      | illuminates | 20 |

  Scenario: Validate keyword density with extra spaces
    Given the user accesses the WordCounter page
    When the user types the text
      """
      lumu     lumu    lumu     lumu illuminates
      """
    Then the keyword densities should be:
      | lumu        | 80 |
      | illuminates | 20 |

  Scenario: Validate keyword density with different word order
    Given the user accesses the WordCounter page
    When the user types the text
      """
      illuminates lumu lumu lumu lumu
      """
    Then the keyword densities should be:
      | lumu        | 80 |
      | illuminates | 20 |

  Scenario: Validate keyword density with new lines
    Given the user accesses the WordCounter page
    When the user types the text
      """
      lumu lumu lumu lumu
      illuminates
      """
    Then the keyword densities should be:
      | lumu        | 80 |
      | illuminates | 20 |
