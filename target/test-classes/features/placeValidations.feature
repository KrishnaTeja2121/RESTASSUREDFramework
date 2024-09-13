Feature: Validating Place API

  Scenario: Verify if Place has been successfully added using AddPlaceAPI
    Given Add place payload
    When use calls "AddPlaceAPI" with Post HTTP request
    Then the API call is success with status code 200
    And "status" response body is "OK"
    And "scope" response body is "APP"

  Scenario: Verify if Place has been successfully added using AddPlaceAPI
    Given Add place payload
