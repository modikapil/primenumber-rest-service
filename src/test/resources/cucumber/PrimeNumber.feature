Feature: Positive and Negative scenario test for primeNumbers API

  Scenario Outline: A successful primeNumber response
    Given a valid "<limit>"
    And a valid prime number request
    When prime number api is called
    Then a successful response is returned

    Examples:
      |  limit  |
      |   50    |
      |   100   |
      |   1000  |

  Scenario Outline: A successful primeNumber response with multi-threaded
    Given a valid "<limit>"
    And a valid prime number request
    When prime number multithreaded api is called
    Then a successful response is returned

    Examples:
      |  limit  |
      |   50    |
      |   100   |
      |   1000  |

  Scenario Outline: An unsuccessful primeNumber response
    Given an invalid "<limit>"
    And a valid prime number request
    When prime number api is called
    Then an unsuccessful response is returned

    Examples:
      |  limit  |
      |    0    |
      |    -1   |